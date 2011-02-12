package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.symboltable.FunctionSymbol;
import be.tbs.compilers.symboltable.Symbol;
import be.tbs.compilers.utility.Pair;

/**
 * FunctionCall Representation
 * @author Gino
 */
public class FunctionCall extends Statement {
	
	private String fName;
	private List<Expression> fParameters = new ArrayList<Expression>();

	public FunctionCall(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.FUNCTION_CALL);
		
		// A function call contains an id (the function name) and zero or more expressions.
		fName = tree.getChild(0).toString();
		Symbol sym;
		try {
			sym = tree.getSymbolTable().getSymbol(fName);
			if (sym instanceof FunctionSymbol) {
				if (((FunctionSymbol) sym).isForwardDeclaration()) {
					throw new SemanticError(tree.getLocation() + "Undefined reference to function '" + fName + "'");
				}
				Log.info("Call of function " + fName);
				for (int i = 1; i < tree.getChildCount(); i++) {
					fParameters.add(new Expression(this, tree.getChild(i)));			
				}
			} else {
				throw new SemanticError(tree.getLocation() + fName + " is not a function.");
			}
			Vector<Pair> params = ((FunctionSymbol) sym).getParameters();
			if (params != null) {
				doWarning(params.size());
				for (int i = 0; i < params.size(); i++) {
					// TODO Check if the provided parameters are consistent with the real parameters of this function, using the SymbolTable
					//Pair p = params.get(i);
					
				}
			} else {
				doWarning(0);
			}
		} catch (SymbolError e) {
			tree.addError(e);
		}
		
	}

	protected void doWarning(int formalParams) {
		if (fParameters.size() > formalParams)
			fAST.addWarning(new CompileWarning(fAST.getLocation() + "Found " + fParameters.size() + " actual parameter(s), but function " + fName + " only specifies " + formalParams + "."));
		// Maybe check for too few parameters?
	}
	
	public String getName() {
	    return fName;
	}
	
	public Type evalType() {
	    try {
            return fAST.getSymbolTable().getSymbol(fName).getType();
        } catch (SymbolError e) {
            fAST.addError(e);
            //return new Type(Types.VOID);
            return null;
        }
	}

	public Integer getParameterSize() {
		int size = 0;
		Log.info(">>>>>>>> No of Parameters: " + fParameters.size());
		for (Expression e : fParameters) {
			if (e.evalType() != null) {
				size += e.evalType().getSize();
			} else {
				size += 1;
			}
		}
		return size;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		write(o, "mst 0");
		
		// push parameters en calculate grootte
		for (int i = 0; i < fParameters.size(); i++) {
			fParameters.get(i).generateCode(o);
			//TODO convert type of real parameter to type of actual parameter if necessary
		}
		int size = getParameterSize();
		write(o, "cup " + size + " function_"+fName);
	}

}
