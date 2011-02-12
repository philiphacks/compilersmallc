package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * BreakStatement Representation
 * @author Gino
 */
public class BreakStatement extends Statement {

	public BreakStatement(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.BREAK);
		
		ASTNode n = fParent;
		while (n!=null && !(n instanceof WhileStatement))
			n = n.fParent;
		
		if (n == null)
			tree.addError(new SemanticError(tree.getLocation() + "Break statement is only allowed inside of a while statement."));
	}

	@Override
	public void generateCode(OutputStream o) throws IOException {
		if (isDirectWhileChild()) {
			// There is nothing in this while but a break statement
			// jump to the end of this while
			write(o, "ujp " + ((WhileStatement)fParent).getLabel() + "end");
		} else {
			write(o, "ujp " + getParentScope().getLabel() + "break");
		}
		
		o.flush();
	}
	
	public CompoundStatement getParentScope() {
		ASTNode n = fParent;
		while(!(n instanceof CompoundStatement))
			n = n.fParent;
		return (CompoundStatement)n;
	}
	
	/**
	 * Checks if this statement is a direct child of while or is in a cmpnd stmnt
	 * 
	 * @return True if while(something) break; False if the break is inside a cmpnd stmnt
	 */
	public boolean isDirectWhileChild() {
		ASTNode n = fParent;
		while (!(n instanceof WhileStatement)) {
			if (n instanceof CompoundStatement)
				return false;
			n = n.fParent;
		}
		return true;
	}

}
