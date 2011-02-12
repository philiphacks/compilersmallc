package be.tbs.compilers.parser.nodes;

import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * Include Representation
 * @author Gino
 */
public class Include extends ASTNode {
	
	private String fInclude;

	public Include(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.INCLUDE);
		
		// Only child of 'Include' is the name of the argument.
		fInclude = tree.getChild(0).toString();
		Log.info("\tHeader file: " + fInclude);
		
		if (fInclude.equals("stdio.h")) {
			try {
				tree.getSymbolTable().includeStd();
			} catch (SymbolError e) {
				tree.addError(e);
			}
		} else {
			throw new SemanticError(tree.getLocation() + "Include: Only stdio.h supported!");
		}
	}
	
	@Override
	public void generateCode(OutputStream o) {}

}
