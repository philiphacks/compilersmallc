package be.tbs.compilers.test.features.stdio;

import be.tbs.compilers.test.TestCase;

public class PrintVars extends TestCase {
	
	private static String fFile = "./test/features/stdio/printvars.csmall";

	public PrintVars() {
		super("Stdio: Print Vars");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "2 3.5 c ");
	}

}
