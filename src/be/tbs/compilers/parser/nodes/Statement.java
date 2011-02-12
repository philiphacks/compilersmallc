package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;

/**
 * Statement Representation
 * @author Gino
 */
public class Statement extends ASTNode {
	
	private Statement fStatement;
	
	public Statement (ASTNode parent, AST tree, int type) {
		super(parent, tree, type);
	}

	public Statement(ASTNode parent, AST tree) {
		super(parent, tree,-1);
		
		AST stmnt = tree;
		switch (stmnt.getType()) {
		case smallcParser.TYPEDEF:
			Log.info("Typedef: " + smallcParser.TYPEDEF);
			fStatement = new Typedef(this, stmnt);
			break;
		case smallcParser.CONTINUE:
			Log.info("Continue: " + smallcParser.CONTINUE);
			fStatement = new ContinueStatement(this, stmnt);
			break;
		case smallcParser.BREAK:
			Log.info("Break: " + smallcParser.BREAK);
			fStatement = new BreakStatement(this, stmnt);
			break;
		case smallcParser.RETURN:
			Log.info("Return: " + smallcParser.RETURN);
			fStatement = new ReturnStatement(this, stmnt);
			break;
		case smallcParser.FUNCTION_CALL:
			Log.info("Function call: " + smallcParser.FUNCTION_CALL);
			try {
				fStatement = new FunctionCall(this, stmnt);
			} catch (SemanticError e) {
				tree.addError(e);
			}
			break;
		case smallcParser.IF:
			Log.info("If: " + smallcParser.IF);
			fStatement = new IfStatement(this, stmnt);
			break;
		case smallcParser.WHILE:
			Log.info("While: " + smallcParser.WHILE);
			fStatement = new WhileStatement(this, stmnt);
			break;
		case smallcParser.COMPOUND_STATEMENT:
			Log.info("Compound Statement: " + smallcParser.COMPOUND_STATEMENT);
			fStatement = new CompoundStatement(this, stmnt);
			break;
		case smallcParser.EXPRESSION:
			Log.info("Expression: " + smallcParser.EXPRESSION);
			fStatement = new Expression(this, stmnt);
			break;
		case smallcParser.DECLARATION:
			Log.info("Declaration: " + smallcParser.DECLARATION);
			fStatement = new Declaration(this, stmnt);
			break;
		case smallcParser.PRINT:
			Log.info("Print: " + smallcParser.PRINT);
			try {
				fStatement = new PrintStatement(this, stmnt);
			} catch (SemanticError e) {
				tree.addError(e);
			}
			break;
		case smallcParser.READ:
			Log.info("Read: " + smallcParser.READ);
			try {
				fStatement = new ReadStatement(this, stmnt);
			} catch (SemanticError e) {
				tree.addError(e);
			}
			break;
		}
	}
	
	public ASTNode getStatement() {
		return fStatement;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		fStatement.generateCode(o);
	}

}
