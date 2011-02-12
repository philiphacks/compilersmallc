package be.tbs.compilers.symboltable;

import be.tbs.compilers.parser.nodes.Type;

public class ConstVarSymbol extends VarSymbol {
	
	public ConstVarSymbol(String name, Type type, String value) {
		super(name, type, value);
	}
	
}
