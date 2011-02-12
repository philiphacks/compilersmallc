package be.tbs.compilers.parser.nodes;

import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;
import be.tbs.compilers.parser.nodes.parser.ExpressionParser;
import be.tbs.compilers.symboltable.ArraySymbol;
import be.tbs.compilers.symboltable.Symbol;
import be.tbs.compilers.symboltable.VarSymbol;
import be.tbs.compilers.utility.Pair;

/**
 * Parameter Representation
 * @author Gino
 */
public class Parameter extends ASTNode {
	
	private Type fType;
	private String fName;
	private String fArrayLength;
	
	public Parameter(ASTNode parent, AST tree) throws SymbolError {
		super(parent, tree, smallcParser.PARAMETER);
		
		fArrayLength = "0";
		// A Parameter has a type and a variable id
		fType = new Type(tree.getChild(0));
		fName = tree.getChild(1).toString();
		Log.info("Parameter name: " + fName + " type: " + fType);
		if (tree.getChild(2) != null && tree.getChild(2).getType() == smallcParser.ARRAY_INDEX) {
			ArrayIndex arrIndex = new ArrayIndex(this, tree.getChild(2));
			Condition c = arrIndex.getExpression().getCondition();
			fArrayLength = ExpressionParser.parseValue(c, new Type(Types.INT));
		}
	}
	
	public Pair getInfo() {
		return new Pair(fType, fName);
	}
	
	public void addSymbol() {
		Symbol sym = null;
	    if (fArrayLength.equals("0")) {
	    	sym = new VarSymbol(fName, fType, "0");
	    } else {
	    	sym = new ArraySymbol(fName, fType, fArrayLength, null);
	    }
	    
	    try {
            fAST.getSymbolTable().addSymbol(sym);
        } catch (SymbolError e) {
            fAST.addError(e);
        }
	}
	
	public Integer getSize() {
		if (fArrayLength.equals("0")) {
			return 1;
		} else {
			return Integer.valueOf(fArrayLength);
		}
	}
	
	@Override
	public void generateCode(OutputStream o) {}

}
