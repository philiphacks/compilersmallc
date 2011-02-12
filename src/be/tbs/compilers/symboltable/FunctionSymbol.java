package be.tbs.compilers.symboltable;

import java.util.Vector;

import be.tbs.compilers.parser.nodes.Type;
import be.tbs.compilers.utility.Pair;

public class FunctionSymbol extends Symbol {
	private Vector<Pair> fParameters;
	private boolean fIsForwardDecl;
	
	public FunctionSymbol(String name, Type type, Vector<Pair> parameters, boolean forward) {
		super(name, type);
		fParameters = parameters;
		fIsForwardDecl = forward;
	}

	public Vector<Pair> getParameters() {
		return fParameters;
	}
	
	public void setParameters(Vector<Pair> params) {
		fParameters = params;
	}
	
	public boolean isForwardDeclaration() {
		return fIsForwardDecl;
	}
	
	public void setForwardDeclaration(boolean forward) {
		fIsForwardDecl = forward;
	}
}
