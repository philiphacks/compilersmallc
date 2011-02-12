package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Vector;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;
import be.tbs.compilers.stackmachine.AddressSpace;
import be.tbs.compilers.symboltable.FunctionSymbol;
import be.tbs.compilers.utility.Pair;

/**
 * Function Representation
 * @author Gino
 */
public class Function extends ASTNode {
	
	private AST fTree;
	private Type fReturn;
	private String fName;
	private CompoundStatement fContent;
	private ParameterList fParameters;
	private String fPLabel;
	
	public Function(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.FUNCTION);
		// Function contains a (return) type, id, possibly a parameterlist and possibly a compound statement
		
		fTree = tree;
		fName = tree.getChild(1).toString();		
		Log.info("New function: " + fName);		
		fReturn = new Type(tree.getChild(0));
		
		int compoundStatementIndex = 3;
		boolean fwdDecl = false;
		
		if (tree.getChild(2) != null) {
			if (tree.getChild(2).getType() == smallcParser.PARAMETER_LIST) {
				fParameters = new ParameterList(this, tree.getChild(2));
			} else {
				compoundStatementIndex = 2;
			}
		}
		
		if (tree.getChild(compoundStatementIndex) == null) {
			fwdDecl = true;
		}
				
	    addSymbol(tree,fwdDecl);
	    if (!fwdDecl) {
    	    tree.getSymbolTable().startScope();
    	    if (fParameters!=null) fParameters.addSymbols();		
            fContent = new CompoundStatement(this, tree.getChild(compoundStatementIndex));
            tree.getSymbolTable().endScope();
	    }
		
		if (!fwdDecl && !fReturn.equals(new Type(Types.VOID))) {
			if (!fContent.returnForAllPaths(fReturn)) {
				throw new SemanticError(tree.getLocation() + "Function " + fName + " must return a value of type " + fReturn.baseString());
			}
		}

	}

	/**
	 * Adds this object to the symbol table.
	 * @param tree
	 * @param fwdDecl
	 */
	private void addSymbol(AST tree, boolean fwdDecl) {
        Vector<Pair> paramList = null;
        if (fParameters!=null)
            paramList = fParameters.getParameters();
        FunctionSymbol sym = new FunctionSymbol(fName, fReturn, paramList, fwdDecl);
        if (fwdDecl) {
            tree.getSymbolTable().addForwardDecl(sym);
        } else {
            try {
                tree.getSymbolTable().addSymbol(sym);
            } catch (SymbolError e) {
                // There might have already been a forward declaration for this function.
                // TODO check if fwd decl corresponds to this function.
                // if not, error!
            }
        }
    }
	
	public Type getReturn() {
		return fReturn;
	}
	
	public String getPLabel() {
		return fPLabel;
	}
	
	private Vector<Pair> getParameterNames() {
		if (fParameters != null) {
			Vector<Pair> params = fParameters.getParameters();
			return params;
		}
		return null;
	}
	
	private Vector<Pair> getVariableNames() {
		Vector<Pair> names = new Vector<Pair>();
		ArrayList<Declaration> decls = (ArrayList<Declaration>) fContent.getDeclarations();
		for (Declaration d : decls) {
			DeclarationVariables declv = d.getVariables();
			Vector<Pair> declnames = declv.getNames();
			for (Pair p : declnames) {
				names.add(p);
			}
		}
		return names;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		fPLabel = "function_"+fName;
		write(o, fPLabel + ":");
		fTree.getStackSpace().startNestingDepth();
		
		Vector<Pair> params = getParameterNames();
		if (params != null) {
			for (Pair p : params) {
				fTree.getStackSpace().addVariable(p);
			}
		}
		Vector<Pair> names = getVariableNames();
		for (Pair p : names) {
			fTree.getStackSpace().addVariable(p);
		}
		
		int ssp = fTree.getStackSpace().getAddress()+AddressSpace.STACK_RESERVED_WORDS;
		write(o, "ssp " + ssp);
		fContent.generateCode(o);
		
		fTree.getStackSpace().endNestingDepth();
		o.flush();
	}

}
