package be.tbs.compilers.test;

import java.util.List;

import junit.framework.Assert;
import be.tbs.compilers.utility.AutoCompile;

/**
 * Extended jUnit testcase.
 * Adds: 
 * Assertions on the output of a program. (Essential to test generated code)
 * Setter to enable or disable optimized code generation.
 * @author gino
 */
public class TestCase extends junit.framework.TestCase {
	
	private boolean fOptimized;

	/**
	 * Constructs the test case.
	 * @param name - The name of the test case.
	 */
	public TestCase(String name) {
		super(name);
		fOptimized = false;
	}
	
	/**
	 * Sets whether the code should be compiled with optimizations
	 * @param o True for optimized code.
	 */
	public void setOptimized(boolean o) {
		this.fOptimized = o;
	}
	
	public void outputEquals(String file, String output) {
		outputEquals(file, output, null);
	}
	
	public void outputEquals(String file, String output, List<String> input) {
		AutoCompile ac = new AutoCompile(file, true, true);
		ac.setOptimized(fOptimized);
		if (!ac.compile())
			fail("Could not compile test file: " + file);
		boolean couldRun = false;
		if (input != null)
			couldRun = ac.run(input);
		else
			couldRun = ac.run();
		if (!couldRun)
			fail("Could not run compiled source of test file: " + file);
		
		//System.out.println("[DEBUG] Comparing '" + output +"\n' to '" + ac.getOutput() + "'");
		
		// Adding a message seems completely useless, junit never prints any details about individual tests, regardless of settings.
		try {
			Assert.assertEquals(output+"\n", ac.getOutput());
		} catch (Exception e) {
			fail("Assertion operation raised an exception on test file: " + file);
		}
	}
	
	
}
