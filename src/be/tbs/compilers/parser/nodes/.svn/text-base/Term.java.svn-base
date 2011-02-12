package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * Term Representation
 * @author Gino
 */
public class Term extends ASTNode {

	private Integer fOperator;
	private Term fTerm = null;
	private Factor fFactor;
	
	public Term(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.TERM);
		
		// A term is a factor and possibly a symbol and another term too.
		Log.info("Factor: " + smallcParser.FACTOR);
		fFactor = new Factor(this, tree.getChild(0));
		if (tree.getChildCount() > 1) {
			Log.info("Term: " + smallcParser.TERM);
			fTerm = new Term(this, tree.getChild(2));
			switch(tree.getChild(1).getType()) {
				case smallcParser.MULT:
					fOperator = smallcParser.MULT;
					break;
				case smallcParser.DIV:
					fOperator = smallcParser.DIV;
					break;
				case smallcParser.MOD:
					fOperator = smallcParser.MOD;
					break;
				default:
					throw new SemanticError(tree.getLocation() + "Invalid operator token.");
			}
			Log.info("Term Operator: " + fOperator);
		}
	}

	public Term getTerm() {
		return fTerm;
	}
	
	public Factor getFactor() {
		return fFactor;
	}
	
	public Integer getOperation() {
		return fOperator;
	}
	
	public Type evalType() {
	    if (fTerm!=null & fFactor!=null)
	        return Type.getResultType(fTerm.evalType(), fFactor.evalType());
	    else
	        return fFactor.evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		Log.info("Generate code term..");
		fFactor.generateCode(o);
		Type thisType = evalType();
		try {
            TypeCast.generateCode(o, fFactor.evalType(), thisType, fAST);
        } catch (CompileWarning w) {
            fAST.addWarning(w);
        }
		
		if (fTerm != null) {
			fTerm.generateCode(o);
			try {
                TypeCast.generateCode(o, fTerm.evalType(), thisType, fAST);
            } catch (CompileWarning w) {
                fAST.addWarning(w);
            }
			
			switch (fOperator) {
			case smallcParser.MULT:
				write(o, "mul " + thisType.PMachineType());
				break;
			case smallcParser.DIV:
				write(o, "div " + thisType.PMachineType());
				break;
			default: // MODULO operation ||| factor % term = remainder
				write(o, "div " + thisType.PMachineType());
				fTerm.generateCode(o);
				try {
                    TypeCast.generateCode(o, fTerm.evalType(), thisType, fAST);
                } catch (CompileWarning w) {
                    fAST.addWarning(w);
                }
				write(o, "mul " + thisType.PMachineType());
				fFactor.generateCode(o);
				try {
                    TypeCast.generateCode(o, fFactor.evalType(), thisType, fAST);
                } catch (CompileWarning w) {
                    fAST.addWarning(w);
                }
				write(o, "sub " + thisType.PMachineType());
				break;
			}
		}
		
		o.flush();
		
	}

	/**
	 * Generates code for an expression that can be evaluated at compile time.
	 * @param o
	 * @throws IOException 
	 */
	public boolean compileTimeEval(OutputStream o) throws IOException {
		// Only works if there is no RHS
		if (fTerm == null)
			return fFactor.compileTimeEval(o);
		else return false;
	}

}
