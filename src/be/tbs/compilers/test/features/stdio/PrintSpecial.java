package be.tbs.compilers.test.features.stdio;

import be.tbs.compilers.test.TestCase;

public class PrintSpecial extends TestCase {
	
	private static String fFile = "./test/features/stdio/printspecial.csmall";

	public PrintSpecial() {
		super("Stdio: Print Special");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Deze 	 zin 	 wordt 	 gescheiden 	 door 	 tabs. \\");
	}

}
