package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;

import be.tbs.compilers.exceptions.warning.CompileWarning;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.utility.LabelGenerator;
import be.tbs.compilers.utility.LabelGenerator.LabelTypes;

/**
 * Condition Representation
 * @author Gino
 */
public class Condition extends SimpleExpression {
	
	private Disjunction fDisjunction;
	private Expression fExpression;
	private Condition fCondition;

	public Condition(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.CONDITION);
		
		// A condition has a disjunction, and possibly an expression and other condition too.
		for (AST child : tree.getChildren()) {
			switch (child.getType()) {
			case smallcParser.DISJUNCTION:
				Log.info("Disjunction: " + smallcParser.DISJUNCTION);
				fDisjunction = new Disjunction(this, child);
				break;
			case smallcParser.CONDITION:
				Log.info("Condition: " + smallcParser.DISJUNCTION);
				fCondition = new Condition(this, child);
				break;
			case smallcParser.EXPRESSION:
				Log.info("Expression: " + smallcParser.DISJUNCTION);
				fExpression = new Expression(this, child);
				break;
			}
		}
	}

	public Disjunction getDisjunction() {
		return fDisjunction;
	}
	
	public Type evalType() {
	    // A Condition has the type of it's disjunction, or the biggest of it's expression and condition.
	    if (fExpression!=null && fCondition!=null)
	        return Type.getResultType(fExpression.evalType(), fCondition.evalType());
	    else
	        return fDisjunction.evalType();
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		
		// Optimization
		// Does not work with ExpressionParser (yet), temporary solution		
		if (fAST.getOptimized()) {
			if (evalType().isConst()) {
				try {
					boolean succes = compileTimeEval(o);
					if (succes) // Compile time evaluation could be performed and we should not generate other code here
						return;
				} catch (NullPointerException e) {
					// This occurs when the expression contains certain unsupported stuff.
					// We'll let normal code generation continue
					Log.info("Optimization enabled, but an unsupported expression could not be optimized.");
				}
			}
		}
		
		
		// Get a label for this condition
		String label = LabelGenerator.generate(LabelTypes.COND);
		
		// Generate code for child disjunction
		fDisjunction.generateCode(o);
		String disjType = fDisjunction.evalType().PMachineType();
		
		if (fCondition != null && fExpression != null) {
			write(o, "ldc " + disjType + " 0");
			write(o, "equ " + disjType); // If result of disjunction was 0, SP contains TRUE
			
			write(o, "fjp " + label+"true"); // Jump to cond_x_true when SP contains FALSE
			
			fCondition.generateCode(o); // Code executed when disjunction result is 0 (false)
			
			// Condition and expression might not be of the same type, look that up
			Type resultType = Type.getResultType(fCondition.evalType(), fExpression.evalType());
			
			// Convert condition to result type (if needed)
			try {
                TypeCast.generateCode(o, fCondition.evalType(), resultType, fAST);
            } catch (CompileWarning w) {
                fAST.addWarning(w);
            }
			
			// Code for a false disjunction executed, now jump to the end of this condition.
			write(o, "ujp " + label+"end");
			
			// Code for a true disjunction, starts with the true label ofcourse
			write(o, label+"true:");
			fExpression.generateCode(o);
			
			// Expression type might have to be converted to result type
			try {
                TypeCast.generateCode(o, fExpression.evalType(), resultType, fAST);
            } catch (CompileWarning w) {
                fAST.addWarning(w);
            }
			
			// Label for the end of this condition
			write(o, label+"end:");
			
		}
		
		o.flush();
	}

	/**
	 * Generates code for an expression that can be evaluated at compile time.
	 * @param o
	 * @throws IOException 
	 */
	private boolean compileTimeEval(OutputStream o) throws IOException {
		// Only works when there's only a disjunction
		if (fExpression == null && fCondition == null)
			return fDisjunction.compileTimeEval(o);
		else return false;
	}

}
