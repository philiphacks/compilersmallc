package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;
import be.tbs.compilers.stackmachine.AddressSpace;
import be.tbs.compilers.utility.LabelGenerator;
import be.tbs.compilers.utility.Pair;
import be.tbs.compilers.utility.LabelGenerator.LabelTypes;

/**
 * CompoundStatement Representation
 * @author Gino
 */
public class CompoundStatement extends Statement {
	
	private AST fTree;
	private List<Statement> fStatements = new ArrayList<Statement>();
	private Function fFunctionNode = null;
	private String fLabel;
	
	public CompoundStatement(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.COMPOUND_STATEMENT);
		
		fTree = tree;
		if (parent instanceof Function) {
			fFunctionNode = (Function) parent;
		}
		
		// A Compound statement is a list of 0 or more statements
		Log.info("Start of compound statement.");
		tree.getSymbolTable().startScope();
		
		List<AST> children = tree.getChildren();
		if (children!=null) {
			for (AST child : children) {
				fStatements.add(new Statement(this, child));
			}
		}
		
		Log.info("Ending Scope.....");
		tree.getSymbolTable().endScope();
		Log.info("End of compound statement.");
	}

	public List<Statement> getStatements() {
		return fStatements;
	}
	
	public ArrayList<Declaration> getDeclarations() {
		Log.info(">>>>>>> GET DECLARATIONS!");
		ArrayList<Declaration> d = new ArrayList<Declaration>();
		for (Statement s : fStatements) {
			Log.info(">>>>>> STATEMENT TYPE: " + s.getStatement().toString());
			if (s.getStatement().getType() == smallcParser.EXPRESSION) {
				Expression e = (Expression) s.getStatement();
				if (e.getDeclaration() != null) {
					d.add(e.getDeclaration());
				}
			} else if (s.getStatement().getType() == smallcParser.DECLARATION) {
				d.add((Declaration) s.getStatement());
			}
		}
		return d;
	}
	
    public boolean returnForAllPaths(Type specifiedType) {
		ArrayList<IfStatement> ifStatements = new ArrayList<IfStatement>();
		ArrayList<WhileStatement> whileStatements = new ArrayList<WhileStatement>();
		ArrayList<CompoundStatement> compoundStatements = new ArrayList<CompoundStatement>();
		boolean globalReturn = false;
		
		// If the function contains a 'global' return statement, everything is ok
		// if it does not, every if (else) statement should contain returns.
		for (Statement s : fStatements) {
			if (s.getStatement() != null) {
				switch (s.getStatement().getType()) {
				case smallcParser.RETURN:
					((ReturnStatement) s.getStatement()).checkType(specifiedType);
					globalReturn = true;
					break;
				case smallcParser.IF:
					ifStatements.add((IfStatement) s.getStatement());
					break;
				case smallcParser.WHILE:
					whileStatements.add((WhileStatement) s.getStatement());
					break;
				case smallcParser.COMPOUND_STATEMENT:
					compoundStatements.add((CompoundStatement) s.getStatement());
				default:
					break;
				}
			}
		}
		if (!globalReturn) {
			if (ifStatements.isEmpty() && whileStatements.isEmpty() && compoundStatements.isEmpty())
				return false;
			for (IfStatement ifStatement : ifStatements) {
				if(ifStatement.returnForAllPaths(specifiedType))
					return true;
			}
			for (WhileStatement whileStatement : whileStatements) {
				if (whileStatement.returnForAllPaths(specifiedType))
					return true;
			}
			for (CompoundStatement compoundStatement : compoundStatements) {
				if (compoundStatement.returnForAllPaths(specifiedType))
					return true;
			}
			return false;
		}
		return true;
	}
    
    /**
     * Gets the distance in the tree from this statement to a potential while statement parent.
     * 
     * @return The difference in level of this statement and the while statement.
     */
    protected int getWhileLvl() {
    	int lvls = 0;
    	ASTNode n = fParent;
    	while (n!=null) {
    		if (n instanceof WhileStatement) {
    			break;
    		} else if (n instanceof CompoundStatement) {
    			lvls++;
    		}
    		n = n.getParent();
    	}
    	return (n==null)?-1:lvls;
    }
    
    /**
     * Gets the compound statement encompassing this compound statement.
     * 
     * This WILL generate an (probably uncaught) exception when improperly used on functionbodies.
     * 
     * @return CompoundStatement parent of this one.
     */
    protected CompoundStatement getParentScope() {
    	ASTNode n = fParent;
    	while(!(n instanceof CompoundStatement))
    		n = n.fParent;
    	return  (CompoundStatement) n;
    }
    
    /**
     * Returns the p machine label for this node
     * 
     * @return P machine label as a string
     */
    public String getLabel() {
    	return fLabel;
    }
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		if (fFunctionNode != null) { // function body
			fLabel = fFunctionNode.getPLabel();
			
//			for (Declaration decl : getDeclarations()) {
//				decl.generateCode(o);
//			}
			
			for (Statement s : fStatements) {
				s.generateCode(o);
			}
			
			write(o, fLabel + "return:");
			if (fFunctionNode.getReturn().equals(new Type(Types.VOID))) {
				write(o, "retp"); // proper procedure with no results
			} else {
				write(o, "retf");
			}
			o.flush();
		} else {
			if (fAST.getOptimized()) {
				// If this only contains one statement, don't create a new stack entry
				if (fStatements.size() == 1) {
					ASTNode s = fStatements.get(0).getStatement();
					// The lone statement can't be return, continue or break, because compound statement
					// p code contains code to handle those statements!
					if (!(s instanceof ReturnStatement || s instanceof BreakStatement || s instanceof ContinueStatement)) {
						fStatements.get(0).generateCode(o);
						return;
					}
				}
			}
			fLabel = LabelGenerator.generate(LabelTypes.COMP_STMNT);
			
			// New nesting depth for this scope
			fTree.getStackSpace().startNestingDepth();
			
			// Variable declarations
			for (Declaration d : getDeclarations()) {
				DeclarationVariables declv = d.getVariables();
				Vector<Pair> declnames = declv.getNames();
				for (Pair p : declnames) {
					fTree.getStackSpace().addVariable(p);
				}
			}
			
			// First, jump to some administrative tasks
			write(o, "ujp " + fLabel + "init");
			
			// Start cmpnd stmnt body (lbl_x_body)
			write(o, fLabel + "body:");
			int ssp = fTree.getStackSpace().getAddress()+AddressSpace.STACK_RESERVED_WORDS;
			write(o,"ssp " + ssp);
			
			// Variable declarations (code)
			for (Declaration d : getDeclarations()) {
				d.generateCode(o);
			}
			
			// Actual instructions
			for (Statement s : fStatements) {
				s.generateCode(o);
			}

			write(o, "ldc i 0");
			write(o, "str i 0 0");
			write(o, "retf");
			write(o, fLabel + "return:");
			write(o, "ldc i 1");
			write(o, "str i 0 0");
			write(o, "retf");
			
			int whileDistance = getWhileLvl();
			
			
			if (whileDistance != -1) {
				// There is a while parent
				// We should write things needed for while statements
				
				// Break label & code
				write(o, fLabel+"break:");
				if (whileDistance==0) { // immediate parent is while
					write(o, "lod a 0 4");
					write(o, "inc a 12");
					write(o, "str a 0 4");
					write(o, "retp");
				} else { // Intermediate cmpnd stmnts
					write(o, "ldc i 2");
					write(o, "str i 0 0");
					write(o, "retf");
				}
				
				// Continue label & code
				write(o, fLabel+"continue:");
				if (whileDistance==0) { // immediate parrent is while
					write(o, "ldc i 0");
				} else { // Intermediate cmpnd stmnts
					write(o, "ldc i 3");
				}
				write(o, "str i 0 0");
				write(o, "retf");
			}
			
			// Administrative tasks for a cmpnd stmnt
			write(o, fLabel + "init:");
			write(o, "mst 0");
			write(o, "cup 0 " + fLabel + "body");
			
			if (whileDistance!=-1) { // While statement exists as a parent
				write(o, "dpl i");
				write(o, "dpl i");
			}
			
			
			write(o, "ldc i 1");
			write(o, "neq i");
			write(o, "fjp " + getParentScope().getLabel() + "return");			
			if (whileDistance!=-1) { // While statement exists as a parent
				write(o, "ldc i 2");
				write(o, "neq i");
				write(o, "fjp " + getParentScope().getLabel() + "break");
				write(o, "ldc i 3");
				write(o, "neq i");
				write(o, "fjp " + getParentScope().getLabel() + "continue");
			}
			
			// End of this scope
			fTree.getStackSpace().endNestingDepth();
			
		}
	}

}
