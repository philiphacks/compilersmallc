package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;

/**
 * Relation Representation
 * @author Gino
 */
public class Relation extends ASTNode {

	private Sum fSum;
	private Relation fRelation = null;
	private String fRelOperation;
	
	public Relation(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.RELATION);
		
		// A relation is a sum, and possibly a symbol and another relation too
		Log.info("Sum: " + smallcParser.SUM);
		try {
			fSum = new Sum(this, tree.getChild(0));
		} catch (SemanticError e) {
			tree.addError(e);
		}
		if (tree.getChildCount()>1) {
			Log.info("Relation: " + smallcParser.RELATION);
			fRelation = new Relation(this, tree.getChild(2));
			fRelOperation = tree.getChild(1).toString();
			Log.info("Relational Operator: " + fRelOperation);
		}
	}
	
	public Relation getRelation() {
		return fRelation;
	}
	
	public Sum getSum() {
		return fSum;
	}
	
	public Type evalType() {
	    return (fRelation!=null && fSum!=null)?new Type(Types.INT):fSum.evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		fSum.generateCode(o);
		
		if (fRelation != null) {
			// As in the rules higher in the grammar than this one, fetch resultType
			Type resultType = Type.getResultType(fSum.evalType(), fRelation.evalType());
			
			// Convert sides when needed
			try {
                TypeCast.generateCode(o, fSum.evalType(), resultType, fAST);
            } catch (CompileWarning w) {
                fAST.addWarning(w);
            }
			
			fRelation.generateCode(o);
			try {
                TypeCast.generateCode(o, fRelation.evalType(), resultType, fAST);
            } catch (CompileWarning w) {
                fAST.addWarning(w);
            }
			
			// PMachine type for the result type, needed in all pmachine ops below
			String t = resultType.PMachineType();
			
			// perform the actual relation operation!
			if (fRelOperation.equals(">")) {
				write(o, "grt " + t);
			} else if (fRelOperation.equals("<")) {
				write(o, "les " + t);
			} else if (fRelOperation.equals("<=")) {
				write(o, "leq " + t);
			} else {
				write(o, "geq " + t);
			}
			
			// conversion of boolean to int
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
		// Only works if there is no RHS
		if (fRelation == null)
			return fSum.compileTimeEval(o);
		else return false;
	}

}
