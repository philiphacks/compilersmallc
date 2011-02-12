package be.tbs.compilers.test.features.stdio;

import be.tbs.compilers.test.TestCase;

public class Print extends TestCase {
	
	private static String fFile = "./test/features/stdio/print.csmall";

	public Print() {
		super("Stdio: Print");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Dit is het compilerproject van Philip en Gino.");
	}

}
