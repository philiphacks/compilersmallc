package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;

/**
 * Comparison Representation
 * @author Gino
 */
public class Comparison extends ASTNode {
	
	private Relation fLeft;
	private Relation fRight = null;
	private boolean fEqual;
	
	public Comparison(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.COMPARISON);
		
		Log.info("Relation: " + smallcParser.RELATION);
		// A comparison is a relation and possibly a symbol and another relation too.
		fLeft = new Relation(this, tree.getChild(0));
		if (tree.getChildCount() > 1) {
			Log.info("Relation: " + smallcParser.RELATION);
			fRight = new Relation(this, tree.getChild(2));
			fEqual = (smallcParser.EQUAL == tree.getChild(1).getType());
			Log.info((fEqual)?"Operator: ==":"Operator: !=");
		}
	}

	public Relation getLeftRelation() {
		return fLeft;
	}
	
	public Relation getRightRelation() {
		return fRight;
	}
	
	public Type evalType() {
	    // A Comparison evaluates to an int when both LHS and RHS are present
	    return (fLeft!=null && fRight!=null)?new Type(Types.INT):fLeft.evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		Log.info("Generate code comparison..");
		fLeft.generateCode(o);
		
		if (fRight != null) {
			// Level the playing field first (convert to equal types)
			Type leftType = fLeft.evalType();
			Type rightType = fRight.evalType();
			Type resultType = Type.getResultType(leftType, rightType);
			try {
                TypeCast.generateCode(o, leftType, resultType, fAST);
            } catch (CompileWarning w) {
                fAST.addWarning(w);
            }
			
			fRight.generateCode(o);
			try {
                TypeCast.generateCode(o, rightType, resultType, fAST);
            } catch (CompileWarning w) {
                fAST.addWarning(w);
            }
			
			// Now we can compare the two sides
			write(o, "equ " + resultType.PMachineType());
			if (!fEqual) // if operator was '!=', not the result
				write(o, "not");
			
			// Convert boolean to integer
			write(o, "conv b i");
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
		if (fRight == null)
			return fLeft.compileTimeEval(o);
		else return false;
	}

}
