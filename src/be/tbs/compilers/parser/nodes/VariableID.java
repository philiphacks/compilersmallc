package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;
import be.tbs.compilers.parser.nodes.parser.ExpressionParser;
import be.tbs.compilers.stackmachine.AddressSpace;
import be.tbs.compilers.symboltable.ArraySymbol;
import be.tbs.compilers.symboltable.Symbol;
import be.tbs.compilers.symboltable.VarSymbol;
import be.tbs.compilers.utility.Pair;

/**
 * VariableID Representation
 * @author Gino
 */
public class VariableID extends SimpleExpression {
	
	private Type fType;
	private String fVariable;
	private String fValue;
	private String fArrayLength = "0";
	private ArrayIndex fArrayIndex;
	private String fArrayElementIndex;
	private boolean fInDeclaration;
	private boolean fIsArray = false;
	private boolean fIsArrayAssignment = false;
	
	public VariableID(ASTNode parent, AST tree, boolean inDeclaration) throws SemanticError {
		super(parent, tree, -1);
		fInDeclaration = inDeclaration;
		
		// A variable id is simply a string, it should be checked for existence in the symboltable
		if (tree.getType() == smallcParser.ASSIGNMENT) {
			fVariable = tree.getChild(0).toString();
		} else {
			fVariable = tree.toString();
		}
		
		if (!inDeclaration) {
			Log.info("Variable Id: " + fVariable);
			if (!tree.getSymbolTable().isSymbol(fVariable)) {
				throw new SymbolError(tree.getLocation() + "Symbol '" + fVariable + "' not found.");
			}
			Symbol sym = tree.getSymbolTable().getSymbol(fVariable);
			fType = sym.getType();
			if (sym instanceof VarSymbol) {
				fValue = ((VarSymbol) sym).getValue();
			} else if (sym instanceof ArraySymbol) {
				// If child 1 is not null, we have an array index
				AST child = parent.getAST().getChild(1);
				if (child != null && child.getType() == smallcParser.ARRAY_INDEX) {
					fIsArray = true;
					fArrayIndex = new ArrayIndex(this, child, this);
					fArrayElementIndex = ExpressionParser.parseValue
						(fArrayIndex.getExpression().getCondition(), new Type(Types.INT));
				} else {
					fIsArrayAssignment = true;
					fArrayLength = ((ArraySymbol) sym).getLength();
					//TODO Array Length Control.. and other error controls..
					fType.setSize(Integer.valueOf(fArrayLength));
				}
			}		
		} else {
			AST array_index = parent.getAST().getChild(1);
			if (array_index != null && array_index.getType() == smallcParser.ARRAY_INDEX) {
				fArrayIndex = new ArrayIndex(this, array_index, this);
			}
		}
	}
	
	public String getVariableName() {
		return fVariable;
	}
	
	public String getValue() {
		return fValue;
	}
	
	public Type evalType() {
        return fType;
	}
	
	public ArrayIndex getArrayIndex() {
		return fArrayIndex;
	}
	
	public boolean isDeclared() {
		return !fInDeclaration;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		boolean global = false;
		Pair p = fAST.getStackSpace().getName(fVariable);
		// Calculate the address and the nesting depth
		int address = (Integer)p.getX()+AddressSpace.STACK_RESERVED_WORDS;
		int depth = fAST.getStackSpace().getNestingDepth()-(Integer)p.getY();
		// Get the global variables
		Vector<Pair> globals = fAST.getSymbolTable().getGlobals();
		for (Pair pair : globals) {
			if (pair.getX().equals(fVariable))
				global = true;
		}
		
		if (fIsArray) {
			//fArrayIndex.getExpression().generateCode(o);
			address += Integer.valueOf(fArrayElementIndex);
			if (global) {
				write(o, "ldo " + fType.PMachineType() + " " + address);
			} else {
				write(o, "lod " + fType.PMachineType() + " " + depth + " " + address);
			}
		} else if (fIsArrayAssignment) {
			generateCodeArrayAssignment(o);
		} else {
			// Different instructions for when we found a global variable or when we did not
			if (global) {
				write(o, "ldo " + fType.PMachineType() + " " + address);
			} else {
				write(o, "lod " + fType.PMachineType() + " " + depth + " " + address);
			}
		}
	}
	
	private void generateCodeArrayAssignment(OutputStream o) throws IOException {
		boolean global = false;
		Pair p = fAST.getStackSpace().getName(fVariable);
		// Calculate the address and the nesting depth
		int address = (Integer)p.getX()+AddressSpace.STACK_RESERVED_WORDS;
		int depth = fAST.getStackSpace().getNestingDepth()-(Integer)p.getY();
		int length = Integer.valueOf(fArrayLength);
		
		// Get the global variables
		Vector<Pair> globals = fAST.getSymbolTable().getGlobals();
		for (Pair pair : globals) {
			if (pair.getX().equals(fVariable))
				global = true;
		}
		
		if (global) {
			write(o, "ldc a " + address);
			write(o, "movs " + length);
		} else {
			write(o, "lda " + depth + " " + address);
			write(o, "movs " + length);
		}
	}

}
