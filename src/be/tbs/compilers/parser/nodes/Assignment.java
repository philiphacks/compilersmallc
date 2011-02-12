package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

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
import be.tbs.compilers.symboltable.Symbol;
import be.tbs.compilers.symboltable.VarSymbol;
import be.tbs.compilers.utility.Pair;

/**
 * Assignment Representation
 * @author Gino
 */
public class Assignment extends Expression {
	
	private AST fTree;
	private VariableID fVariable;
	private Expression fExpression;
	private Expression fArrayExpression;
	private String fArrayElementIndex;
	private static Symbol fSym;
	private Type fType;
	private boolean fAssignArrayElement = false;
	
	public Assignment(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.ASSIGNMENT);
		
		fTree = tree;
		String name = null;
		// An assignment contains a variable id and an expression or a function call
		try {
			fVariable = new VariableID(this, tree.getChild(0), false);
			name = fVariable.getVariableName();
		} catch (SymbolError e) {
		    tree.addError(e);
		    return;
		} catch (SemanticError e) {
			tree.addError(e);
		}
		
		AST child = tree.getChild(0).getChild(1);
		fExpression = new Expression(this, child);
		
		AST child2 = null;
		if (tree.getChild(0).getChild(2) != null) {
			// This is the expression AFTER the ArrayIndex!
			// In other words, the value of the new array element..
			// fExpression contains the expression for the ArrayIndex.
			// fArrayExpression contains the new array element value.
			child2 = tree.getChild(0).getChild(2);
			fArrayExpression = new Expression(this, child2);
		}
		
		try {
			fSym = tree.getSymbolTable().getSymbol(name);
			fType = fSym.getType();
			
			if (fSym instanceof ConstVarSymbol) {
				throw new SemanticError(tree.getLocation() + "Cannot assign a value to const variable " + name);
			} else if (fSym instanceof ArraySymbol) {
				// can only assign an array element assignment to this.
				if (child2 == null) {
					throw new SemanticError(tree.getLocation() + "Can only assign an array initializer to an array.");
				}
				if (child.getType() == smallcParser.ARRAY_INDEX && child2.getType() == smallcParser.EXPRESSION) {
					Type exprType = fExpression.evalType();
					if (!exprType.equals(new Type(Types.INT))) {
						throw new SemanticError(tree.getLocation() + "An array index must always be of type 'int' or a castable type.");
					}
					exprType = fArrayExpression.evalType();
					if (!exprType.equals(fType)) {
						throw new SemanticError(tree.getLocation() + "Cannot assign value of type " + exprType + " to variable " + name + " of type " + fType);
					}
					fAssignArrayElement = true;
					Condition c = fExpression.getSimpleExpression().getCondition();
					fArrayElementIndex = ExpressionParser.parseValue(c, new Type(Types.INT));
				} else {
					throw new SemanticError(tree.getLocation() + "1Can only assign an array initializer to an array.");
				}
			} else if (fSym instanceof VarSymbol) {
				// Check if type is correct
				Type exprType = fExpression.evalType();
				if (!exprType.equals(fType)) {
					throw new SemanticError(tree.getLocation() + "Cannot assign value of type " + exprType + " to variable " + name + " of type " + fType);
				}
			}
			
			
		} catch (SymbolError e) {
			tree.addError(new SymbolError(tree.getLocation() + "Variable '" + name + "' cannot be resolved."));
		}
		
	}

	public VariableID getVariable() {
		return fVariable;
	}
	
	public Expression getExpression() {
		return fExpression;
	}
	
	/**
	 * Evaluates the type of the variable concerned by this assignment.
	 * @return A Type object or null
	 */
	public Type evalType() {
        return fVariable.evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		boolean global = false;
		Pair p = fTree.getStackSpace().getName(fVariable.getVariableName());
		int address = (Integer)p.getX()+AddressSpace.STACK_RESERVED_WORDS;
		int depth = fTree.getStackSpace().getNestingDepth()-(Integer)p.getY();
		Vector<Pair> globals = fTree.getSymbolTable().getGlobals();
		for (Pair pair : globals) {
			if (pair.getX().equals(fVariable.getVariableName()))
				global = true;
		}
		
		if (fAssignArrayElement) {
			address += Integer.valueOf(fArrayElementIndex);
			fArrayExpression.generateCode(o);
			// Implicit cast (code only generated when needed)
			try {
				Log.info("Assignment type is: " + fType + " expr type is: " + fExpression.evalType());
				TypeCast.generateCode(o, fExpression.evalType(), fType, fAST);
			} catch (CompileWarning w) {
				fAST.addWarning(w, true);
			}
			if (global) {
				write(o, "sro " + fType.PMachineType() + " " + address);
			} else {
				write(o, "str " + fType.PMachineType() + " " + depth + " " + address);
			}
		} else {
			fExpression.generateCode(o);
			// Implicit cast (code only generated when needed)
			try {
				Log.info("Assignment type is: " + fType + " expr type is: " + fExpression.evalType());
				TypeCast.generateCode(o, fExpression.evalType(), fType, fAST);
			} catch (CompileWarning w) {
				fAST.addWarning(w, true);
			}

			if (global) {
				write(o, "sro " + fType.PMachineType() + " " + address);
			} else {
				write(o, "str " + fType.PMachineType() + " " + depth + " " + address);
			}
		}
	}

}
