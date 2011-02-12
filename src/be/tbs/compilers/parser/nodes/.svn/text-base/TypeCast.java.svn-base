package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;

/**
 * TypeCast Representation
 * @author Gino
 */
public class TypeCast extends SimpleExpression {
	
	private Type fType;
	private VariableID fVariable;

	public TypeCast(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.CAST);
		
		// A type cast contains a target type and the variable to cast.
		fType = new Type(tree.getChild(0));
		
		if (fType.equals(new Type(Types.VOID)))
			tree.addError(new SemanticError(tree.getLocation() + "Cannot cast to type " + fType));
		
		try {
			fVariable = new VariableID(this, tree.getChild(1), false);
		} catch (SemanticError e) {
			tree.addError(e);
		}

		Log.info("Typecast from var: " + fVariable.getVariableName() + " with type: " + fVariable.evalType() + " to type: " + fType);
	}

	public Type getNewType() {
		return fType;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		// Store the variable
		fVariable.generateCode(o);
		// Now convert it, reusing older code =)
		try {
			generateCode(o, fVariable.evalType(), fType, fAST);
		} catch (CompileWarning e) {
			// Explicit casts do not issue warnings. The programmer knows what he's doing.
		}
	}
	
	/**
	 * Generates code for a simple type conversion on a variable at SP
	 * 
	 * ONLY USE THIS METHOD FOR AN IMPLICIT CAST,
	 * explicit casts are handled by an instantiated object of this type!
	 * 
	 * @param o
	 * @param sourceT
	 * @param destinationT
	 * @throws IOException 
	 * @throws CompileWarning 
	 */
	public static void generateCode(OutputStream o, Type sourceT, Type destinationT, AST tree) throws IOException, CompileWarning {
	    Types source = sourceT.getBase().get();
		Types destination = destinationT.getBase().get();
		if (!source.equals(destination)) {
			write(o, "conv " + sourceT.PMachineType() + " " + destinationT.PMachineType());
		}
		
		// Generate a warning when !sourceT.equals(destinationT) (this returns TRUE when casting from rich to poor types)
		// We generate and throw the warning at the end of this method, so the code will always be generated.
	    if (!sourceT.canCastTo(destinationT)) {
	        Log.info("Casting is unsafe " + sourceT + " - " + destinationT);
            throw new CompileWarning(tree.getLocation() + "Unsafe implicit cast from " + sourceT + " to " + destinationT);
        } else {
            Log.info("Casting is safe " + sourceT + " - " + destinationT);
        }
	}

}
