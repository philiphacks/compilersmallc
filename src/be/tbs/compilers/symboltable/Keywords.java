package be.tbs.compilers.symboltable;

import java.util.Vector;

public class Keywords {
	
	/**
	 * Contains all the reserved words in the compiler
	 * @author Philip De Smedt
	 */
	private Vector<String> fKeywords = new Vector<String>();
	
	public Keywords() {
		fKeywords.add("int");
		fKeywords.add("float");
		fKeywords.add("char");
		fKeywords.add("void");
		fKeywords.add("const");
		fKeywords.add("typedef");
		fKeywords.add("if");
		fKeywords.add("else");
		fKeywords.add("while");
		fKeywords.add("return");
		fKeywords.add("break");
		fKeywords.add("continue");
	}
	
	/**
	 * Check if the given word is a keyword
	 * 
	 * @param word
	 * @return true if the word is a keyword
	 */
	public boolean isKeyword(String word) {
		return fKeywords.contains(word);
	}
	
	/**
	 * Add a keyword
	 * @param word - word to be added
	 */
	public void addKeyword(String word) {
		fKeywords.add(word);
	}
}
