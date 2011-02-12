package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.utility.LabelGenerator;
import be.tbs.compilers.utility.LabelGenerator.LabelTypes;

/**
 * WhileStatement Representation
 * @author Gino
 */
public class WhileStatement extends Statement {
	
	private Expression fCondition;
	private Statement fStatement;
	private String fLabel;

	public WhileStatement(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.WHILE);
		
		Log.info("While statement: " + smallcParser.WHILE);
		// A while statement contains an expression (the loop condition) and a statement
		Log.info("Start of While Condition");
		fCondition = new Expression(this, tree.getChild(0));
		Log.info("Start of While Statement");
		fStatement = new Statement(this, tree.getChild(1));
	}
	
	/**
	 * Checks if all paths in this whilestatement contain a return statement
	 * @return True if yes, false if no. (duh)
	 */
	public boolean returnForAllPaths(Type specifiedType) {
		boolean hasReturn = false;
		
		if (fStatement != null) {
			if (fStatement.getType() == smallcParser.COMPOUND_STATEMENT)
				hasReturn = ((CompoundStatement) fStatement).returnForAllPaths(specifiedType);
			else {
				hasReturn = (fStatement.getType() == smallcParser.RETURN);
				if (hasReturn)
					((ReturnStatement) fStatement.getStatement()).checkType(specifiedType);
			}
		} else {
			// While does not contain anything, this should be impossible.
			return false;
		}
		
		return hasReturn;
	}
	
	public String getLabel() {
		return fLabel;
	}

	@Override
	public void generateCode(OutputStream o) throws IOException {
		fLabel = LabelGenerator.generate(LabelTypes.WHILE);
		// Condition check label
		if (fCondition != null) {
			write(o, fLabel+"check:");
			fCondition.generateCode(o);
			String type = fCondition.evalType().PMachineType();
			// If the condition equals zero (in other words is true), then jump to true label
			// Else jump to endlabel and continue program execution
			write(o, "ldc " + type + " 0");
			write(o, "equ " + type);
			write(o, "fjp " + fLabel+"true");
			write(o, "ujp " + fLabel+"end");
		}
		if (fStatement != null) {
			write(o, fLabel+"true:");
			fStatement.generateCode(o);
			write(o, "ujp " + fLabel+"check");
		}
		write(o, fLabel+"end:");
		o.flush();
	}

}
