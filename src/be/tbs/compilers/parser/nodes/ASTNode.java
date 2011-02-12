package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.parser.AST;

/**
 * Abstract class, should be implemented by all classes used to generate P-code.
 * @author Gino
 */
public abstract class ASTNode {
	
	protected ASTNode fParent;
	protected int fType;
	protected AST fAST;

	/**
	 * Creates a new ASTNode with the given parent node, AST subtree and type.
	 * @param parent The parent node of this node.
	 * @param tree The AST of this node.
	 * @param type The type of this node.
	 */
	public ASTNode(ASTNode parent, AST tree, int type) {
		fParent = parent;
		fAST = tree;
		fType = type;
	}
	
	/**
	 * Gets this node's parent.
	 * @return The parent node of this node.
	 */
	public ASTNode getParent() {
		return fParent;
	}
	
	/**
	 * Gets this node's AST
	 * @return The AST of this node.
	 */
	public AST getAST() {
		return fAST;
	}
	
	/**
	 * Gets this node's type number.
	 * @return The type number of this node.
	 */
	public int getType() {
		return fType;
	}
	
	public abstract void generateCode(OutputStream o) throws IOException;

	public static void write(OutputStream o, String data) throws IOException {
		o.write((data + "\n").getBytes());
	}
}
