package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.utility.LabelGenerator;
import be.tbs.compilers.utility.LabelGenerator.LabelTypes;

/**
 * IfStatement Representation
 * @author Gino
 */
public class IfStatement extends Statement {
	
	private Expression fCondition;
	private Statement fIfStatement;
	private Statement fElseStatement;

	public IfStatement(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.IF);
		
		Log.info("If statement: " + smallcParser.IF);
		// An if statement contains an expression and one or two statements
		fCondition = new Expression(this, tree.getChild(0));
		
		fIfStatement = new Statement(this, tree.getChild(1));
		fElseStatement = (tree.getChild(2)!=null)?new Statement(this, tree.getChild(2)):null;
	}
	
	/**
	 * Checks if all paths in this ifstatement contain a return statement
	 * @return True if yes, false if no. (duh)
	 */
	public boolean returnForAllPaths(Type specifiedType) {
		boolean ifHasReturn = false;
		boolean elseHasReturn = false;
		
		if (fIfStatement != null) {
			if (fIfStatement.getType() == smallcParser.COMPOUND_STATEMENT)
				ifHasReturn = ((CompoundStatement) fIfStatement).returnForAllPaths(specifiedType);
			else {
				ifHasReturn = (fIfStatement.getType() == smallcParser.RETURN);
				if (ifHasReturn)
					((ReturnStatement) fIfStatement.getStatement()).checkType(specifiedType);
			}
		} else {
			// If does not contain anything, this should be impossible.
			return false;
		}
		
		if (fElseStatement != null) {
			if (fElseStatement.getType() == smallcParser.COMPOUND_STATEMENT)
				elseHasReturn = ((CompoundStatement) fElseStatement).returnForAllPaths(specifiedType);
			else {
				elseHasReturn = (fElseStatement.getType() == smallcParser.RETURN);
				if (elseHasReturn)
					((ReturnStatement) fElseStatement.getStatement()).checkType(specifiedType);
			}
		}
		
		return ifHasReturn && elseHasReturn;
	}

	@Override
	public void generateCode(OutputStream o) throws IOException {
		String label = LabelGenerator.generate(LabelTypes.IF);
		
		fCondition.generateCode(o);
		String type = fCondition.evalType().PMachineType();
		write(o, "ldc " + type + " 0");
		write(o, "equ " + type);
		write(o, "fjp " + label+"true");
		write(o, label+"false:");
		if (fElseStatement != null) {
			fElseStatement.generateCode(o);
		}
		write(o, "ujp " + label+"end");
		write(o, label+"true:");
		fIfStatement.generateCode(o);
		
		write(o, label+"end:");
		o.flush();
	}

}
