package be.tbs.compilers.parser.nodes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;

/**
 * PrintStatement Representation
 * @author Gino
 */
public class PrintStatement extends Statement {
	
	private String fFormat;
	private List<Expression> fParams = new ArrayList<Expression>();

	public PrintStatement(ASTNode parent, AST tree) throws SemanticError {
		super(parent, tree, smallcParser.PRINT);
		
		// A print statement contains a character literal, followed by zero or more expressions
		
		// Without quotation marks
		fFormat = tree.getChild(0).toString().substring(1, tree.getChild(0).toString().length()-1);
		Log.info("Print format: " + fFormat + " met lengte: " + fFormat.length());
		for (int i = 1; i < tree.getChildCount(); i++) {
			fParams.add(new Expression(this, tree.getChild(i)));
		}
		checkFormatString(tree);
	}

	private void checkFormatString(AST tree) throws SemanticError {
		int index = 0;
		int noOfExpressions = 0;
		for (int i = 0; i < fFormat.length(); i++) {
			if (fFormat.charAt(i) == '%') {
				char outputType = fFormat.charAt(++i);
				String style = "-1";
				if (Character.isDigit(outputType)) {
					style = Character.toString(outputType);
					while (Character.isDigit(fFormat.charAt(++i))) {
						style += fFormat.charAt(i);
					}
				}
				switch (outputType) {
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
		Expression e = null;
		for (int i = 0; i < fFormat.length(); i++) {
			if (fFormat.charAt(i) == '%') {
				char outputType = fFormat.charAt(++i);
				String style = "-1";
				if (Character.isDigit(outputType)) {
					style = Character.toString(outputType);
					while (Character.isDigit(fFormat.charAt(++i))) {
						style += fFormat.charAt(i);
					}
				}
				if (!style.equals("-1")) {
					int width = Integer.valueOf(style);
					for (int s = 0; s < width; s++) {
						write(o, "ldc c ' '");
						write(o, "out c");
					}
				}
				outputType = fFormat.charAt(i);
				if (outputType == 'i' || outputType == 'd') {
					e = fParams.get(j++);
					e.generateCode(o);
					write(o, "out i");	
				} else if (outputType == 'f') {
					e = fParams.get(j++);
					e.generateCode(o);
					write(o, "out r");	
				} else if (outputType == 'c') {
					e = fParams.get(j++);
					e.generateCode(o);
					write(o, "out c");	
				} else if (outputType == 's') {
					e = fParams.get(j++);
					int size = e.evalType().getSize();
					ByteArrayOutputStream newOs = new ByteArrayOutputStream();
					e.generateCode(newOs);
					String[] lines = newOs.toString().split("\n");
					String command = lines[0].substring(4);
					String[] numbers = command.split(" ");
					int depth = Integer.valueOf(numbers[0]);
					int address = Integer.valueOf(numbers[1]);
					String type = e.evalType().PMachineType();
					
					for (int k = 0; k < size; k++) {
						write(o, "lod " + type + " " + depth + " " + (address + k));
						write(o, "out " + type);
						if (!type.equals("c")) {
							write(o, "ldc c 10");
							write(o, "out c");
						}
					}
				}
			} else {
				// We do not want to print a variable so we will print text or another ascii character.
				if (fFormat.charAt(i) == '\\') {
					int pos = i;
					if (fFormat.length() >= pos+2) {
						if (fFormat.charAt(pos+1) == 't') {
							write(o, "ldc c 9");
							i++;
						} else if (fFormat.charAt(pos+1) == 'n') {
							write(o, "ldc c 10");
							i++;
						} else {
							write(o, "ldc c 92");
						}
					} else {
						write(o, "ldc c 92");
					}
					write(o, "out c");
				} else {
					write(o, "ldc c '" + fFormat.charAt(i) + "'");
					write(o, "out c");
				}
			}
		}
	}

}
