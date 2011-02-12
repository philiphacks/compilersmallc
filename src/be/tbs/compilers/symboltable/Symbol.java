package be.tbs.compilers.symboltable;

import be.tbs.compilers.parser.nodes.Type;

public class Symbol {
	
	/**
	 * Represents the name of the Symbol
	 * @author Philip De Smedt
	 */
	private String fName;
	
	/**
	 * Represents the type of the symbol
	 * 
	 * Possible types: int, float, char, void, ..
	 */
	private Type fType;
	
	public Symbol(String name, Type type) {
		fName = name;
		fType = type;
	}

	public String getName() {
		return fName;
	}
	
	public Type getType() {
		return fType;
	}
	
	public void setName(String name) {
		fName = name;
	}
	
	public void setType(Type type) {
		fType = type;
	}
	
}
