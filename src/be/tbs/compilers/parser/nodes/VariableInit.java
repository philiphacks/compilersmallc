package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;
import be.tbs.compilers.parser.nodes.parser.ExpressionParser;
import be.tbs.compilers.stackmachine.AddressSpace;
import be.tbs.compilers.symboltable.ArraySymbol;
import be.tbs.compilers.symboltable.ConstVarSymbol;
import be.tbs.compilers.symboltable.VarSymbol;
import be.tbs.compilers.utility.Pair;

/**
 * VariableInit Representation
 * @author Gino
 */
public class VariableInit extends ASTNode {
	
	private String fName;
	private Expression fInitializer;
	private ArrayIndex fArrayIndex;
	private String fInitValue = "0";
	private String fArrayLength = "0";
	private boolean fIsArray = false;
	private Type fType;
	private VariableID fVariableID;
	
	public VariableInit(ASTNode parent, AST tree, Type myType) throws SemanticError {
		super(parent, tree, smallcParser.VARIABLE_INIT);
		
		fType = myType;
		// This contains a variable id and possibly an array index and a simple expression
		fVariableID = new VariableID(this, tree.getChild(0), true);
		fName = tree.getChild(0).toString();
		
		Log.info("Declared variable: " + fName);
		int exprIndex = 1;
		if ((fArrayIndex = fVariableID.getArrayIndex()) != null) {
			fIsArray = true;
			exprIndex++;
			Log.info("Variable contains array index");
			fArrayLength = ExpressionParser.parseValue(fArrayIndex.getExpression().getCondition(), new Type(Types.INT));
			try {
				tree.getSymbolTable().addSymbol(new ArraySymbol(fName, fType, fArrayLength, null));
			} catch (SymbolError e) {
				tree.addError(e);
			}
		}
		
		AST exprChild = tree.getChild(exprIndex);
		
		if (exprChild != null && exprChild.getType() == smallcParser.EXPRESSION) {
			Log.info("Declaration contains initializer");
			fInitializer = new Expression(this, exprChild);
			int type = exprChild.getChild(0).getType();
			if (type == smallcParser.ARRAY_INIT) {
				// Array init but no array declared?
				if (!fIsArray) {
					throw new SemanticError(tree.getLocation() + "Array initializer found, but declared variable is not an array.");
				}
				
				// Array init presence does not determine the type of this variable
				ArrayInit arrInit = fInitializer.getSimpleExpression().getArrayInit();
				Type initType = arrInit.evalType();
				if (!initType.equals(fType)) {
					throw new SemanticError(tree.getLocation() + "Type of array initializer (" + initType + ") does not match type of array elements (" + fType + ")");
				}
				
				// Check size of array init with size of declared array
				if (fIsArray) {
					int intSize = Integer.valueOf(fArrayLength);
					if (arrInit.getInitSize() > intSize)
						tree.addWarning(new CompileWarning(tree.getLocation() + "Array initializer has size " + arrInit.getInitSize() + ", which is larger than the declared array." ));
					else if (arrInit.getInitSize() < intSize)
						tree.addWarning(new CompileWarning(tree.getLocation() + "Array initializer has size " + arrInit.getInitSize() + ", which is smaller than the declared array." ));
				}
				
				ArrayList<String> fValues = new ArrayList<String>();
				try {
					ArraySymbol sym = (ArraySymbol) tree.getSymbolTable().getSymbol(fName);
					sym.setValues(fValues);
				} catch (SymbolError e) {
					tree.addError(e);
				}
			} else {
				// Array could be initialized by another array (full assignment..)
//				if (fIsArray) {
//					throw new SemanticError(tree.getLocation() + "Can only initialize an array with an array initializer.");
//				}
			}
		}
	
		if (!fIsArray) {
			try {
				if (fType.isConst()) {
					tree.getSymbolTable().addSymbol(new ConstVarSymbol(fName, fType, fInitValue));
				} else {
					tree.getSymbolTable().addSymbol(new VarSymbol(fName, fType, fInitValue));
				}
			} catch (SymbolError e) {
				tree.addError(e);
			}
		}
	}
	
	public String getName() {
		return fName;
	}
	
	public String getArrayLength() {
		return fArrayLength;	
	}
	
	public boolean isArray() {
		return fIsArray;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		if (fIsArray) {
			generateCodeArray(o);
		} else {
			generateCodeVariable(o);
		}
	}

	private void generateCodeArray(OutputStream o) throws IOException {
		Pair p = fAST.getStackSpace().getName(fName);
		int depth = fAST.getStackSpace().getNestingDepth() - (Integer)p.getY();
		int address = (Integer)p.getX()+AddressSpace.STACK_RESERVED_WORDS;
		
		int length = Integer.valueOf(fArrayLength);
		if (fInitializer != null) {
			fInitializer.generateCode(o);
		} else {
			for (int i = 0; i < length; ++i) {
				if (fType.baseString().equals("float")) {
					write(o, "ldc " + fType.PMachineType() + " 0.0");
				} else {
					write(o, "ldc " + fType.PMachineType() + " 0");
				}
			}
		}
		for (int i = length-1; i >= 0; i--) {
			int array_address = address + i;
			write(o, "str " + fType.PMachineType() + " " + depth + " " + array_address);
		}
	}
	
	private void generateCodeVariable(OutputStream o) throws IOException {
		Pair p = fAST.getStackSpace().getName(fName);
		int depth = fAST.getStackSpace().getNestingDepth() - (Integer)p.getY();
		int address = (Integer)p.getX()+AddressSpace.STACK_RESERVED_WORDS;
		
		// determine initializer values at run time
		if (fInitializer != null) {
			fInitializer.generateCode(o);
			// Implicit cast if needed
			try {
				TypeCast.generateCode(o, fInitializer.evalType(), fType, fAST);
			} catch (CompileWarning w) {
				fAST.addWarning(w, true);
			}
		} else {
			// no initializer found
			//if (fType.equals(new Type(Types.FLOAT))) { does not work.. ?
			if (fType.baseString().equals("float")) {
				write(o, "ldc " + fType.PMachineType() + " 0.0");
			} else {
				write(o, "ldc " + fType.PMachineType() + " 0");
			}
		}
			
		// store the value (need nesting depth and address)
		write(o, "str " + fType.PMachineType() + " " + depth + " " + address);
	}
}
