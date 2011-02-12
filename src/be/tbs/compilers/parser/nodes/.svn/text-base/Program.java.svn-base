package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.utility.Pair;

/**
 * Program Representation
 * @author Gino
 */
public class Program extends ASTNode {
	
	private AST fTree;
	private List<Include> fIncludes = new ArrayList<Include>();
	private List<Typedef> fTypedefs = new ArrayList<Typedef>();
	private List<Function> fFunctions = new ArrayList<Function>();
	private List<Declaration> fDeclarations = new ArrayList<Declaration>();
	
	public Program(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.PROGRAM);
		fTree = tree;
		Log.info("Program has " + getAST().getChildCount() + " children"); 
		List<AST> children = getAST().getChildren();
		if (children!=null) {
			for (AST ast : children) {
				// All children of Program are of type Element, which always only has 1 child.
				
				int childType = ast.getChild(0).getType();
				switch (childType) {
				case smallcParser.INCLUDE:
					Log.info("Include: " + childType);
					try {
						fIncludes.add(new Include(this, ast.getChild(0)));
					} catch (SemanticError e1) {
						tree.addError(e1);
					}
					break;
				case smallcParser.TYPEDEF:
					Log.info("Typedef: " + childType);
					fTypedefs.add(new Typedef(this, ast.getChild(0)));
					break;
				case smallcParser.FUNCTION:
					Log.info("Function: " + childType);
					try {
						fFunctions.add(new Function(this, ast.getChild(0)));
					} catch (SemanticError e) {
						tree.addError(e);
					}
					break;
				case smallcParser.DECLARATION:
					Log.info("Declaration: " + childType);
					fDeclarations.add(new Declaration(this, ast.getChild(0)));
					break;
				}
			}
		}
		
		tree.getSymbolTable().printSymbols();
		
		// Check if main exists
		try {
			tree.getSymbolTable().getSymbol("main");
		} catch (SymbolError se) {
			tree.addError(se);
		}
		
		// Check if forward declarations were defined.
		try {
            tree.getSymbolTable().checkForwardDecls();
        } catch (SymbolError e) {
            tree.addError(e);
        }
	}

	@Override
	public void generateCode(OutputStream o) throws IOException {
		Log.info("Codegeneration started..");
		
		Vector<Pair> globals = fTree.getSymbolTable().getGlobals();
		for (Pair p : globals) {
			fTree.getStackSpace().addVariable(p);
		}
		int ssp = fTree.getStackSpace().getAddress()+5;
		write(o, "ssp " + ssp);
		for (Declaration decl : fDeclarations) {
			decl.generateCode(o);
		}
		write(o, "ujp program");
		for (Function func : fFunctions) {
			func.generateCode(o);
		}
		write(o, "program:");
		write(o, "mst 0"); // calling and entering procedures
		write(o, "cup 0 function_main"); // call user procedure main met 0 parameters
		write(o, "hlt");
		
		Log.info("Codegeneration successful.");
	}

}
