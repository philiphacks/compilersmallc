package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Type.Types;

/**
 * Disjunction Representation
 * @author Gino
 */
public class Disjunction extends ASTNode {
	
	private List<Conjunction> fConjunctions = new ArrayList<Conjunction>();

	public Disjunction(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.DISJUNCTION);
		
		// A disjunction contains one or more conjunctions
		for (AST child : tree.getChildren()) {
			// Can't be anything but a conjunction
			Log.info("Conjunction: " + smallcParser.CONJUNCTION);
			fConjunctions.add(new Conjunction(this, child));
		}
		
	}

	public List<Conjunction> getConjunctions() {
		return fConjunctions;
	}
	
	public Type evalType() {
	    // If this disjunction contains OR terms, the type is INT (b/c we don't have a boolean type)
	    // Otherwise, it's the type of its first conjunction
	    return fConjunctions.size()>1?new Type(Types.INT):fConjunctions.get(0).evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		Log.info("Generate code disjunction..");
		fConjunctions.get(0).generateCode(o);
		
		if (fConjunctions.size() > 1) {
			String conjType = fConjunctions.get(0).evalType().PMachineType();
			
			write(o, "ldc " + conjType + " 0");
			write(o, "equ " + conjType); // SP = TRUE if first conjunction is FALSE
			write(o, "not"); // SP is FALSE if first conjunction is FALSE
			
			// Now we do this for all the other conjunctions
			
			for (int i = 1; i < fConjunctions.size(); i++) {
				conjType = fConjunctions.get(i).evalType().PMachineType();
				fConjunctions.get(i).generateCode(o);
				
				write(o, "ldc " + conjType + " 0");
				write(o, "equ " + conjType); // SP = TRUE if first conjunction is FALSE
				write(o, "not"); // SP is FALSE if first conjunction is FALSE
				
				// Perform the or operation
				write(o, "or");
			}
			
			// csmall doesn't have booleans, so we must convert the result
			write(o, "conv b i");
		}
		
		o.flush();		
	}

	/**
	 * Generates code for an expression that can be evaluated at compile time.
	 * @param o
	 * @throws IOException 
	 */
	public boolean compileTimeEval(OutputStream o) throws IOException {
		// Only works when there is only one conjunction
		if (fConjunctions.size() == 1)
			return fConjunctions.get(0).compileTimeEval(o);
		else return false;
	}

}
