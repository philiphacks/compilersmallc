package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;

/**
 * ReturnStatement Representation
 * @author Gino
 */
public class ReturnStatement extends Statement {
	
	private Expression fReturnValue;
    private Type fReturnType;

	public ReturnStatement(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.RETURN);
		
		// A return statement contains an expression
		fReturnValue = new Expression(this, tree.getChild(0));
	}

	public Expression getReturnValue() {
		return fReturnValue;
	}
	
	public void checkType(Type specifiedType) {
		Type returnType = (fReturnValue!=null)?fReturnValue.evalType():new Type(Types.VOID);
		if (returnType != null && !returnType.equals(specifiedType)) {
			fAST.addError(new SemanticError(fAST.getLocation() + "Return type " + returnType + " does not match return type " + specifiedType + " of function."));
		} else if (returnType == null)
		    fAST.addError(new SemanticError(fAST.getLocation() + "Return statement cannot be resolved."));
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
        if (fReturnValue != null) {
        	searchReturnType();
            
            // Calculate the value first.
            fReturnValue.generateCode(o);
            
            // If needed, implicitly cast the return value.
            if (fReturnValue != null) {
                try {
                    TypeCast.generateCode(o, fReturnValue.evalType(), fReturnType, fAST);
                } catch (CompileWarning w) {
                    fAST.addWarning(w);
                }
            }
            
            // Return the calculated value over the needed amount of stack frames
            write(o, "str " + fReturnType.PMachineType() + " " + getDistanceToFunction() + " 0");
        }
        
        // Lastly, jump to some administrative return tasks, defined in this scope's code.
        write(o, "ujp " + getParentScope().getLabel() + "return");
	}
	
	/**
     * Gets the number of scopes between this statement and the function body.
     * @return the distance (in scopes) to the function body scope.
     */
    private int getDistanceToFunction() {
        int scopes = 0;
        ASTNode n = fParent;
        while (!(n instanceof Function)) {
            if (n instanceof CompoundStatement)
                scopes++;
            n = n.fParent;
        }
        // n is now the Function, and we counted the function body scope
        // We must reduce the distance by one, because the function body
        // scope contains the necessary routines for returning values.
        scopes--;
        return scopes;
    }
	
   public CompoundStatement getParentScope() {
        ASTNode n = fParent;
        while(!(n instanceof CompoundStatement))
            n = n.fParent;
        return (CompoundStatement)n;
    }
	    	
	protected void searchReturnType() {
	    ASTNode n = fParent;
	    while (n != null && !(n instanceof Function)) {
            n = n.fParent;
        }
	    fReturnType = (n==null)?null:((Function)n).getReturn();	    
	}

}
