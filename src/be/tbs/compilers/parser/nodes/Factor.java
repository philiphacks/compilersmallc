package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * Factor Representation
 * @author Gino
 */
public class Factor extends ASTNode {

	private Factor fFactor;
	private Integer fOperator = null;
	private Atom fAtom;
	
	public Factor(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.FACTOR);
		
		// A factor is an operator followed by another factor, or an atom
		for (AST child : tree.getChildren()) {
			switch (child.getType()) {
			case smallcParser.FACTOR:
				Log.info("Factor: " + smallcParser.FACTOR);
				fFactor = new Factor(this, child);
				break;
			case smallcParser.ATOM:
				Log.info("Atom: " + smallcParser.ATOM);
				fAtom = new Atom(this, child);
				break;
			default:
				switch (child.getType()) {
					case smallcParser.MINUS:
						fOperator = smallcParser.MINUS;
						break;
					case smallcParser.NOT:
						fOperator = smallcParser.NOT;
						break;
					default:
						throw new SemanticError(tree.getLocation() + "Invalid operator token.");
				}
				Log.info("Factor Operator: " + fOperator);
				break;
			}
		}
	}

	public Atom getAtom() {
		return fAtom;
	}
	
	public Integer getFactorOperator() {
		return fOperator;
	}
	
	public Factor getFactor() {
		return fFactor;
	}
	
	public Type evalType() {
	    if (fFactor!=null)
	        return fFactor.evalType();
	    else
	        return fAtom.evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		Log.info("Generate code factor..");
		
		if (fAtom != null)
			fAtom.generateCode(o);
		else {
			fFactor.generateCode(o);
			String pType = fFactor.evalType().PMachineType();
			switch (fOperator) {
			case smallcParser.MINUS:
				write(o,"neg " + pType);
				break;
			default: // Operand is NOT
				// Convert numeric type to boolean, not it, convert back
				write(o, "conv " + pType + " b");
				write(o, "not");
				write(o, "conv b " + pType);
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
		Object obj = calculate();
		if (obj instanceof Integer)
			write(o, "ldc i " + ((Integer)obj).toString());
		else if (obj instanceof Double)
			write(o, "ldc r " + ((Double)obj).toString());
		else 
			return false;
		return true;
	}
	
	protected Object calculate() {
		// Two situations:
		//		This is an operator plus a factor, meaning we must do some basic calculations
		//		This is just an atom
		
		if (fAtom == null) {
			// This is an operator plus a factor
			fFactor.calculate();
			switch (fOperator) {
			case smallcParser.MINUS:
				return -((Number)fFactor.calculate()).doubleValue();
			default: // Operand is NOT
				// Convert numeric type to boolean, not it, convert back
				if (((Number)fFactor.calculate()).doubleValue() != 0.0)
					return 0;
				else
					return 1;
			}
		} else {
			return fAtom.compileTimeEval();
		}
		
	}

}
