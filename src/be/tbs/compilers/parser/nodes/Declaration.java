package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;

/**
 * Declaration Representation
 * @author Gino
 */
public class Declaration extends Statement {
	
	private Type fType;
	private DeclarationVariables fVariables;
	
	public Declaration(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.DECLARATION);
		
		// A Declaration contains a type and a list of variables, possibly initializations.
		fType = new Type(tree.getChild(0));
		if (fType.equals(new Type(Types.VOID))) {
			tree.addError(new SemanticError(tree.getLocation() + "No declaration of type 'void' allowed"));
		}
		fVariables = new DeclarationVariables(this, tree.getChild(1), fType);
	}
	
	public Type getDeclaringType() {
		return fType;
	}

	public DeclarationVariables getVariables() {
		return fVariables;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		fVariables.generateCode(o);
		o.flush();
	}

}
