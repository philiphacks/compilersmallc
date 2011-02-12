package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;

/**
 * Atom Representation
 * @author Gino
 */
public class Atom extends ASTNode {

	private Double fFloat = null;
	private Integer fInt = null;
	private String fChar = null;
	private String fArrayValue = null;
	private VariableID fVariable = null;
	private FunctionCall fFunctionCall;
	private Expression fExpression;
	
	private Type fType;
	
	public Atom(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.ATOM);
		
		AST child = tree.getChild(0);
		
		// An atom is one of: integer, float, function call, expression or variable id

		switch (child.getType()) {
		case smallcParser.INTEGER:
			fInt = Integer.valueOf(child.toString());
			fType = new Type(Types.CONST_INT);
			Log.info("Integer: " + smallcParser.INTEGER + " Value: " + fInt);
			break;
		case smallcParser.DECIMAL:
			fFloat = Double.valueOf(child.toString());
			fType = new Type(Types.CONST_FLOAT);
			Log.info("Float: " + smallcParser.DECIMAL + " Value: " + fFloat);
			break;
		case smallcParser.CHARLITERAL:
			fChar = child.toString();
			fType = new Type(Types.CONST_CHAR);
			Log.info("Character: " + smallcParser.CHARLITERAL + " Value: " + fChar);
			break;
		case smallcParser.FUNCTION_CALL:
			Log.info("FunctionCall: " + smallcParser.FUNCTION_CALL);
			try {
				fFunctionCall = new FunctionCall(this, child);
				fType = fFunctionCall.evalType();
			} catch (SemanticError e) {
				tree.addError(e);
			}
			break;
		case smallcParser.EXPRESSION:
			Log.info("Expression: " + smallcParser.EXPRESSION);
			fExpression = new Expression(this, child);
			fType = fExpression.evalType();
			break;
		default:
			try {
				fVariable = new VariableID(this, child, false);
				fType = fVariable.evalType();
			} catch (SemanticError e) {
				tree.addError(e);
			}
			break;
		}
	}

	public Integer getInt() {
		if (fInt != null) {
			return fInt;
		}
		return null;
	}
	
	public Double getFloat() {
		if (fFloat != null) {
			return fFloat;
		}
		return null;
	}
	
	public String getChar() {
		return fChar;
	}
	
	public String getArrayValue() {
		return fArrayValue;
	}
	
	public Expression getExpression() {
		return fExpression;
	}
	
	public FunctionCall getFunctionCall() {
		return fFunctionCall;
	}
	
	public VariableID getVariable() {
		return fVariable;
	}
	
	public Type evalType() {
	    return fType;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		Log.info("Generate code atom..");
		if (fInt != null) {
			Log.info("Generate code int..");
			write(o, "ldc i " + fInt.toString());
		} else if (fFloat != null) {
			Log.info("Generate code float..");
			write(o, "ldc r " + fFloat.toString());
		} else if (fChar != null) {
			Log.info("Generate code char...");
			write(o,"ldc c " + ((int)fChar.charAt(1)));
		} else if (fVariable != null) {
			Log.info("Generate code variable..");
			fVariable.generateCode(o);
		} else if (fExpression != null) {
			Log.info("Generate code expression...");
			fExpression.generateCode(o);
		} else if (fFunctionCall != null) {
			Log.info("Generate code function call");
			fFunctionCall.generateCode(o);
		}
		o.flush();
	}

	public Object compileTimeEval() {
		Log.info("Generate code atom compile time..");
		if (fInt != null) {
			return fInt;
		} else if (fFloat != null) {
			return fFloat;
		} /*
		Below code not yet supported
		
		else if (fChar != null) {
			return fChar;
		} else if (fVariable != null) {
			Log.info("Generate code variable..");
			fVariable.generateCode(o);
		} else if (fExpression != null) {
			Log.info("Generate code expression...");
			fExpression.generateCode(o);
		} else if (fFunctionCall != null) {
			Log.info("Generate code function call");
			fFunctionCall.generateCode(o);
		}
		
		*/
		return null;
	}

}
