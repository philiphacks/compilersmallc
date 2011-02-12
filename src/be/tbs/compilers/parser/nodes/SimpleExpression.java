package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * SimpleExpression Representation
 * @author Gino
 */
public class SimpleExpression extends Expression {
	
	private TypeCast fCast;
	private Condition fCondition;
	private VariableID fVariable;
	private ArrayInit fArrayInit;
	private int fTreeType;
	
	public SimpleExpression(ASTNode parent, AST tree) {
		super(parent, tree, -1);
	
		// A simple expression can be one of: assignment, type_cast, condition, variable_id or array_init;
		fTreeType = tree.getType();
		switch (tree.getType()) {
			case smallcParser.CAST:
				Log.info("Typecast: " + smallcParser.CAST);
				fCast = new TypeCast(this, tree);
				break;
			case smallcParser.CONDITION:
				Log.info("Condition: " + smallcParser.CONDITION);
				fCondition = new Condition(this, tree);
				break;
			case smallcParser.ARRAY_INIT:
				Log.info("Array Initializer: " + smallcParser.ARRAY_INIT);
				try {
					fArrayInit = new ArrayInit(this, tree);
				} catch (SemanticError e1) {
					tree.addError(e1);
				}
				break;
			default: //Variable ID
				try {
					fVariable = new VariableID(this, tree, false);
				} catch (SemanticError e) {
					tree.addError(e);
				}
				break;
		}
	}
	
	public SimpleExpression(ASTNode parent, AST tree, int type) {
		super(parent, tree, type);
	}

	public VariableID getVariableID() {
		return fVariable;
	}
	
	public Condition getCondition() {
		return fCondition;
	}

	public TypeCast getCast() {
		return fCast;
	}
	
	public ArrayInit getArrayInit() {
		return fArrayInit;
	}
	
	public Type evalType() {
	    if (fCondition!=null) {
	        return fCondition.evalType();
	    } else if (fArrayInit!=null) {
	        return fArrayInit.evalType();
	    } else if (fCast!=null) {
	        return fCast.getNewType();
	    } else {
	        return fVariable.evalType();
	    }
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		switch (fTreeType) {
		case smallcParser.CAST:
			fCast.generateCode(o);
			break;
		case smallcParser.CONDITION:
			Log.info("Generate code condition..");
			fCondition.generateCode(o);
			break;
		case smallcParser.ARRAY_INIT:
			fArrayInit.generateCode(o);
			break;
		default:
			fVariable.generateCode(o);
		}
	}

}
