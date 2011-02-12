package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * ArrayInit Representation
 * @author Gino
 */
public class ArrayInit extends SimpleExpression {
	
	private List<Expression> fExpressions = new ArrayList<Expression>();
	private Type fType = null;
	
	public ArrayInit(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.ARRAY_INIT);

		// A (one dimensional) array initializer contains zero or more expressions.
		if (tree.getChildren()!=null) {
			for (AST child : tree.getChildren()) {
			    Expression expr = new Expression(this, child);
				fExpressions.add(expr);
				Type type = expr.evalType();
				Log.info("Array Init Element evaluated to type: " + type);
				if (fType == null) {
				    fType = type;
				} else {
				    fType = Type.getResultType(fType, type);
				}
			}
		}
	}
	
	public void setType(Type type) {
		fType = type;
	}
	
	public Type evalType() {
	    return fType;
	}
	
	public int getInitSize() {
		return fExpressions.size();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		for (Expression e : fExpressions) {
			e.generateCode(o);
		}
		o.flush();
	}

}
