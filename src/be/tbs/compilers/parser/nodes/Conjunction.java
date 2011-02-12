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
 * Conjunction Representation
 * @author Gino
 */
public class Conjunction extends ASTNode {
	
	private List<Comparison> fComparisons = new ArrayList<Comparison>();

	public Conjunction(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.CONJUNCTION);
		
		// A conjunction contains one or more comparisons
		for (AST child : tree.getChildren()) {
			// Can't be anything but a comparison
			Log.info("Comparison: " + smallcParser.COMPARISON);
			fComparisons.add(new Comparison(this, child));
		}
	}

	public List<Comparison> getComparisons() {
		return fComparisons;
	}
	
	public Type evalType() {
	    return fComparisons.size()>1?new Type(Types.INT):fComparisons.get(0).evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		Log.info("Generate code conjunction..");
		fComparisons.get(0).generateCode(o);
		
		// Same structure as the disjunction code, only with an and operation		
		
		if (fComparisons.size() > 1) {
			String compType = fComparisons.get(0).evalType().PMachineType();
			
			write(o, "ldc " + compType + " 0");
			write(o, "equ " + compType); // SP = TRUE if first comparison is FALSE
			write(o, "not"); // SP is FALSE if first comparison is FALSE
			
			// Now we do this for all the other conjunctions
			
			for (int i = 1; i < fComparisons.size(); i++) {
				compType = fComparisons.get(i).evalType().PMachineType();
				fComparisons.get(i).generateCode(o);
				
				write(o, "ldc " + compType + " 0");
				write(o, "equ " + compType); // SP = TRUE if first comparison is FALSE
				write(o, "not"); // SP is FALSE if first comparison is FALSE
				
				// Perform the or operation
				write(o, "and");
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
		// Only works when there is only one comparison
		if (fComparisons.size() == 1)
			return fComparisons.get(0).compileTimeEval(o);
		else return false;
	}

}
