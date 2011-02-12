package be.tbs.compilers.parser.nodes;

import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.symboltable.TypedefSymbol;

/**
 * Typedef Representation
 * @author Gino
 */
public class Typedef extends Statement {
	
	public Typedef(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.TYPEDEF);
		
		// First child of this node is a Type or an Id, second child is Id
		AST typeSpec = tree.getChild(0);
		Type oldType = new Type(typeSpec);
		
		AST newName = tree.getChild(1);
		
		try {
            tree.getSymbolTable()
                    .addSymbol(new TypedefSymbol(newName.toString(), oldType));
        } catch (SymbolError e) {
            tree.addError(e);
        }

		Log.info("Declaring '" + typeSpec.getChild(0).toString() + "' as '" + newName.toString() + "'");
	}

	@Override
	public void generateCode(OutputStream o) {
	    // None needed (since we add the aliases to the symbol table)
	}

}
