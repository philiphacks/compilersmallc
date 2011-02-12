package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * Expression Representation
 * @author Gino
 */
public class Expression extends Statement {
	
	private SimpleExpression fSimple = null;
	private Declaration fDeclaration = null;
	private Assignment fAssign = null;
	private int fASTType;
	
	public Expression(ASTNode parent, AST tree, int type) {
		super(parent, tree, type);
	}
	
	public Expression(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.EXPRESSION);
		
		fASTType = tree.getChild(0).getType();
		// An expression is a simple expression, an assignment, or a declaration
		if (fASTType == smallcParser.DECLARATION) {
			Log.info("Declaration: " + smallcParser.DECLARATION);
			fDeclaration = new Declaration(this, tree.getChild(0));
		} else if (fASTType == smallcParser.ASSIGNMENT) {
			Log.info("Assignment: " + smallcParser.ASSIGNMENT);
			try {
				fAssign = new Assignment(this, tree);
			} catch (SemanticError e) {
				tree.addError(e);
			}
		} else {
			Log.info("Simple Expression");
			fSimple = new SimpleExpression(this, tree.getChild(0));
		}
		
	}
	
	public Type evalType() {
	    if (fDeclaration!=null) {
	        return fDeclaration.getDeclaringType();
	    } else if (fAssign!=null) {
	        return fAssign.evalType();
	    } else {
	        return fSimple.evalType();
	    }
	}

	public SimpleExpression getSimpleExpression() {
		return fSimple;
	}
	
	public Assignment getAssignment() {
		return fAssign;
	}
	
	public Declaration getDeclaration() {
		return fDeclaration;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		switch (fASTType) {
		case smallcParser.DECLARATION:
			fDeclaration.generateCode(o);
			break;
		case smallcParser.ASSIGNMENT:
			fAssign.generateCode(o);
			break;
		default:
			fSimple.generateCode(o);
			break;
		}
	}

}
