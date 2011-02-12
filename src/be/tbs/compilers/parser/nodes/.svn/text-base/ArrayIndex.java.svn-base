package be.tbs.compilers.parser.nodes;

import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;
import be.tbs.compilers.symboltable.ArraySymbol;
import be.tbs.compilers.symboltable.Symbol;

/**
 * ArrayIndex Representation
 * @author Gino
 */
public class ArrayIndex extends ASTNode {
	
	private SimpleExpression fExpression;
	private VariableID fVar;

	public ArrayIndex(ASTNode parent, AST tree, VariableID variable) throws SemanticError {
		super(parent, tree, smallcParser.ARRAY_INDEX);
		fVar = variable;
		
		if (fVar.isDeclared()) {
			// First, check that the variable concerned actually is an array
			Symbol varSym = tree.getSymbolTable().getSymbol(fVar.getVariableName());
			if (!(varSym instanceof ArraySymbol))
				throw new SymbolError(tree.getLocation() + "Variable " + fVar.getVariableName() + " is not an array.");
		}
		
	    // An arrayindex contains only one child, a simple expression
	    fExpression = new SimpleExpression(this, tree.getChild(0));
	    if (!fExpression.evalType().equals(new Type(Types.INT))) {
	    	tree.addError(new SemanticError(tree.getChild(0).getLocation() + "An array index must always be of type 'int' or a castable type."));
	    }
	}

	public ArrayIndex(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.ARRAY_INDEX);
		
		// An arrayindex contains only one child, a simple expression
	    fExpression = new SimpleExpression(this, tree.getChild(0));
	    if (!fExpression.evalType().equals(new Type(Types.INT))) {
	    	tree.addError(new SemanticError(tree.getChild(0).getLocation() + "An array index must always be of type 'int' or a castable type."));
	    }
	}
	
	public SimpleExpression getExpression() {
		return fExpression;
	}
	
	@Override
	public void generateCode(OutputStream o) {}

}
