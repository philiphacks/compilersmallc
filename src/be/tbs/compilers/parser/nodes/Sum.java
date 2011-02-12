package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * Sum Representation
 * @author Gino
 */
public class Sum extends ASTNode {

	private Term fTerm;
	private Sum fSum = null;
	private int fOperator;
	
	public Sum(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.SUM);
		
		Log.info("Term: " + smallcParser.TERM);
		// A sum is a term and possibly a symbol and another sum
		fTerm = new Term(this, tree.getChild(0));
		if (tree.getChildCount()>1) {
			Log.info("Sum: " + smallcParser.RELATION);
			fSum = new Sum(this, tree.getChild(2));
			switch(tree.getChild(1).getType()) {
				case smallcParser.PLUS:
					fOperator = smallcParser.PLUS;
					break;
				case smallcParser.MINUS:
					fOperator = smallcParser.MINUS;
					break;
				default:
					throw new SemanticError(tree.getLocation() + "Invalid operator token.");
			}
			Log.info("Sum Operator: " + fOperator);
		}
	}

	public Term getTerm() {
		return fTerm;
	}
	
	public Sum getSum() {
		return fSum;
	}
	
	public Integer getOperator() {
		return fOperator;
	}
	
	public Type evalType() {
	    if (fTerm!=null && fSum!=null)
	        return Type.getResultType(fTerm.evalType(), fSum.evalType());
	    else
	        return fTerm.evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		Log.info("Generate code sum..");
		fTerm.generateCode(o);
		// c type handling, convert term to type of this sum
		try {
            TypeCast.generateCode(o, fTerm.evalType(), evalType(), fAST);
        } catch (CompileWarning w) {
            fAST.addWarning(w);
        }
		
		if (fSum != null) {
			fSum.generateCode(o);
			try {
                TypeCast.generateCode(o, fSum.evalType(), evalType(), fAST);
            } catch (CompileWarning w) {
                fAST.addWarning(w);
            }
			
			// Check what operation we need to perform
			if (fOperator == smallcParser.PLUS)
				write(o, "add " + evalType().PMachineType());
			else
				write(o, "sub " + evalType().PMachineType());			
			
		}
		
		o.flush();
	}

	/**
	 * Generates code for an expression that can be evaluated at compile time.
	 * @param o
	 * @throws IOException 
	 */
	public boolean compileTimeEval(OutputStream o) throws IOException {
		// Only works when there is no RHS
		if (fSum == null)
			return fTerm.compileTimeEval(o);
		else return false;
	}

}
