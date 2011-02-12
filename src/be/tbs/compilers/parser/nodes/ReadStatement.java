package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;
import be.tbs.compilers.utility.Pair;

/**
 * ReadStatement Representation
 * @author Gino
 */
public class ReadStatement extends Statement {

	private AST fTree;
	private String fFormat;
	private List<VariableID> fParams = new ArrayList<VariableID>();

	public ReadStatement(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.READ);
		
		// A read statement contains a character literal, followed by one or more variables
		
		fTree = tree;
		// Without quotation marks
		fFormat = tree.getChild(0).toString().substring(1, tree.getChild(0).toString().length()-1);
		Log.info("Read format: " + fFormat);
		for (int i = 1; i < tree.getChildCount(); i++) {
			try {
				fParams.add(new VariableID(this, tree.getChild(i), false));
			} catch (SemanticError e) {
				tree.addError(e);
			}
		}
		checkFormatString(tree);
	}

	private void checkFormatString(AST tree) throws SemanticError {
		int index = 0;
		int noOfExpressions = 0;
		for (int i = 0; i < fFormat.length(); i++) {
			if (fFormat.charAt(i) == '%') {
				char inputType = fFormat.charAt(++i);
				switch (inputType) {
				case 'd':
				case 'i':
					if (!fParams.get(index).evalType().equals(new Type(Types.INT))) {
						throw new SemanticError(tree.getLocation() + "Expression of type 'int' expected");
					}
					noOfExpressions++;
					break;
				case 'f':
					if (!fParams.get(index).evalType().equals(new Type(Types.FLOAT))) {
						throw new SemanticError(tree.getLocation() + "Expression of type 'float' expected");
					}
					noOfExpressions++;
					break;
				case 'c':
					noOfExpressions++;
					break;
				}
			}
		}
		if (fParams.size() < noOfExpressions) {
			throw new SemanticError(tree.getLocation() + "Not enough format arguments.");
		}
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		int j = 0;
		VariableID e = null;
		for (int i = 0; i < fFormat.length(); i++) {
			if (fFormat.charAt(i) == '%') {
				char inputType = fFormat.charAt(++i);
				if (inputType == 'i' || inputType == 'd') {
					write(o, "in i");
					e = fParams.get(j++);
					Pair p = fTree.getStackSpace().getName(e.getVariableName());
					if (p != null) {
						int depth = fTree.getStackSpace().getNestingDepth() - (Integer)p.getY();
						int address = (Integer)p.getX()+5;
						write(o, "str i " + depth + " " + address);
					}
				} else if (inputType == 'f') {
					write(o, "in r");
					e = fParams.get(j++);
					Pair p = fTree.getStackSpace().getName(e.getVariableName());
					if (p != null) {
						int depth = fTree.getStackSpace().getNestingDepth() - (Integer)p.getY();
						int address = (Integer)p.getX()+5;
						write(o, "str r " + depth + " " + address);
					}	
				} else if (inputType == 'c') {
					write(o, "in c");
					e = fParams.get(j++);
					Pair p = fTree.getStackSpace().getName(e.getVariableName());
					if (p != null) {
						int depth = fTree.getStackSpace().getNestingDepth() - (Integer)p.getY();
						int address = (Integer)p.getX()+5;
						write(o, "str c " + depth + " " + address);
					}	
				} else if (inputType == 's') {
					e = fParams.get(j++);
					Pair p = fTree.getStackSpace().getName(e.getVariableName());
					if (p != null) {
						int depth = fTree.getStackSpace().getNestingDepth() - (Integer)p.getY();
						int address = (Integer)p.getX()+5;
						int size = e.evalType().getSize();
						for (int k = 0; k < size; k++) {
							write(o, "in c");
							write(o, "str c " + depth + " " + address);
							address++;
						}
					}
				} else {
					write(o, "ldc c %");
					write(o, "out c");
					write(o, "ldc c " + inputType);
					write(o, "out c");
				}
			}
		}
	}

}
