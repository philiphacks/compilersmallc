package be.tbs.compilers.symboltable;

import java.util.ArrayList;
import java.util.List;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.parser.nodes.Type;

public class ArraySymbol extends Symbol {
	private String fLength;
	private List<String> fValues = new ArrayList<String>();
	
	public ArraySymbol(String name, Type type, String length, List<String> values) {
		super(name, type);
		fLength = length;
		fValues = values;
	}
	
	public String getLength() {
		return fLength;
	}
	
	public List<String> getValues() {
		return fValues;
	}
	
	public void setValues(List<String> values) {
		fValues = values;
	}
	
	public void setArrayValue(int index, String value) throws SemanticError {
		if (index > Integer.valueOf(fLength)) {
			throw new SemanticError("Array index out of bounds");
		}
		fValues.remove(index);
		fValues.add(index, value);
	}
}
