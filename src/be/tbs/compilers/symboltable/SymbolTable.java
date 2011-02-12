package be.tbs.compilers.symboltable;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.nodes.Type;
import be.tbs.compilers.parser.nodes.Type.Types;
import be.tbs.compilers.utility.Pair;

public class SymbolTable {
		
	/**
	 * The keywords
	 * 
	 * @desc Symbols may not have the name of keywords
	 * @author Philip De Smedt
	 */
	private Keywords fKeywords = new Keywords();
	
	/**
	 * The Stack
	 * 
	 * The stack contains, per scope, a vector containing all the Symbols
	 */
	private static Stack<Hashtable<String, Symbol>> fStack;
	
	/**
	 * List of Forward Declarations
	 * 
	 */
	private static List<FunctionSymbol> fForwardDecls;
	
	public SymbolTable() {
		fStack = new Stack<Hashtable<String, Symbol>>();
		fForwardDecls = new ArrayList<FunctionSymbol>();
		startScope();
	}
	
	public void startScope() {
		 fStack.push(new Hashtable<String, Symbol>());
	}
	
	public void endScope() {
		if (fStack.size() > 1) {
			fStack.pop();
		}
	}
	
	public void addSymbol(Symbol sym) throws SymbolError {
		if (fKeywords.isKeyword(sym.getName())) {
			throw new SymbolError("Name conflict: Symbol '" + sym.getName() + "' is a keyword.");
		}
		
		// add symbol to top scope of stack and to main symbol table
		if (isSymbol(sym.getName())) {
			throw new SymbolError("Name conflict: Symbol '" + sym.getName() + "' already exists.");
		}
		fStack.peek().put(sym.getName(), sym);
		Log.info("\t\tSymbolTable: Add Symbol " + sym.getName() + ".");
		printSymbols();
	}
	
	public Vector<Pair> getGlobals() {
		return getVariablesAtDepth(fStack.size()-1);
	}
	
	public Vector<Pair> getVariablesAtDepth(int depth) {
		Vector<Pair> vars = new Vector<Pair>();
		Hashtable<String, Symbol> entry = fStack.get(depth);
		for (Enumeration<Symbol> e = entry.elements(); e.hasMoreElements();) {
			Symbol s = e.nextElement();
			if (s instanceof VarSymbol) {
				Pair p = new Pair(s.getName(), 1);
				vars.add(p);
			} else if (s instanceof ArraySymbol) {
				Pair p = new Pair(s.getName(), ((ArraySymbol) s).getLength());
				vars.add(p);
			}
		}
		return vars;
	}
	
	public void includeStd() throws SymbolError {
		addSymbol(new FunctionSymbol("printf", new Type(Types.VOID), null, false));
		addSymbol(new FunctionSymbol("scanf", new Type(Types.VOID), null, false));
	}
	
	public Symbol getSymbol(String sym) throws SymbolError {
		Symbol s = null;
		Hashtable<String, Symbol> myTable = null;
		for (int i = 0; i < fStack.size(); i++) {
			myTable = fStack.get(i);
			s = myTable.get(sym);
			if (s != null) {
				return s;
			}
		}
		if (s == null) {
			throw new SymbolError(sym + " was not declared in this scope.");
		}
		return s;
	}
	
	public boolean isSymbol(String sym) {
		Symbol s = null;
		Hashtable<String, Symbol> myTable = null;
		for (int i = 0; i < fStack.size(); i++) {
			myTable = fStack.get(i);
			s = myTable.get(sym);
			if (s != null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteSymbol(String sym) {
		Log.info("\t\tSymbolTable: Del Symbol " + sym + ".");
		Symbol s = null;
		for (int i = 0; i < fStack.size(); i++) {
			Hashtable<String, Symbol> myTable = fStack.get(i);
			s = myTable.get(sym);
			if (s != null) {
				myTable.remove(sym);
				fStack.remove(i);
				fStack.add(i, myTable);
				return true;
			}
		}
		return false;
	}
	
	public void addParametersToFunction(String name, Vector<Pair> parameters) throws SymbolError {
		FunctionSymbol sym = (FunctionSymbol) getSymbol(name);
		sym.setParameters(parameters);
	}
	
	public void addForwardDecl(FunctionSymbol sym) {
		if (sym.isForwardDeclaration()) {
			fForwardDecls.add(sym);
		}
	}
	
	public void checkForwardDecls() throws SymbolError {
	    for (FunctionSymbol fwdDecl : fForwardDecls) {
            try {
                getSymbol(fwdDecl.getName());
            } catch (SymbolError e) {
                throw new SymbolError("Function " + fwdDecl.getName() + " declared but not defined.",e);
            }
            Log.info("All Forward declarations were defined.");
        }
	}
	
	public void printSymbols() {
		Log.info("\tPrinting the SymbolTable");
		String key = null;
		Type val = null;
		if (fStack.isEmpty()) {
			Log.info("\t\tSymbolTable: EMPTY.");
			return;
		}
		for (int i = 0; i < fStack.size(); i++) {
			Hashtable<String, Symbol> myTable = fStack.get(i);
			Enumeration<String> myKeys = myTable.keys();
			while (myKeys.hasMoreElements()) {
				key = myKeys.nextElement();
				val = myTable.get(key).getType();
				Symbol sym = myTable.get(key);
				if (sym instanceof ConstVarSymbol) {
					String value = ((ConstVarSymbol) sym).getValue();
					Log.info("\t\tVAR: " + " " + key + " TYPE: " + val + " VALUE: " + value);
				} else if (sym instanceof FunctionSymbol) {
					Log.info("\t\tFUNCTION: " + key + " RETURNTYPE: " + val);
					Vector<Pair> params = ((FunctionSymbol) sym).getParameters();
					if (params != null) {
						for (int j = 0; j < params.size(); j++) {
							Pair p = params.get(j);
							if (p.getY() instanceof Pair) {
								Pair y = (Pair) p.getY();
								Log.info("\t\t\t Parameter: " + p.getX() + " " + y.getX() + " = " + y.getY());
							} else {
								Log.info("\t\t\t Parameter: " + p.getX() + " " + p.getY());
							}
						}
					}
					if (((FunctionSymbol) sym).isForwardDeclaration()) {
						Log.info("\t\t\tFunction is (unimplemented) forward declaration!");
					}
				} else if (sym instanceof ArraySymbol) {
					Log.info("\t\tARRAYVAR: " + key + " TYPE: " + val + " LENGTH: " + ((ArraySymbol) sym).getLength());
					String stringedvalues = "";
					ArrayList<String> values = (ArrayList<String>) ((ArraySymbol) sym).getValues();
					if (values != null) {
						for (int j = 0; j < values.size(); j++) {
							stringedvalues += values.get(j);
							stringedvalues += " ";
						}
						Log.info("\t\t\tVALUES: " + stringedvalues);
					}
				} else if (sym instanceof TypedefSymbol) {
					Log.info("\t\tTYPEDEF KEY: " + key + " AS TYPE: " + sym.getType());
				} else if (sym instanceof VarSymbol) {
					Log.info("\t\tVAR: " + key + " TYPE: " + val + " VALUE: " + ((VarSymbol) sym).getValue());
				} else {
					Log.info("\t\tKEY: " + key + " TYPE: " + sym.getType());
				}
			}
		}
	}
}
