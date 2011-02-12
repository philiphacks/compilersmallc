package be.tbs.compilers.test.features.stdio;

import be.tbs.compilers.test.TestCase;

public class PrintArray extends TestCase {
	
	private static String fFile = "./test/features/stdio/print_array.csmall";

	public PrintArray() {
		super("Stdio: Print array");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Hallo");
	}

}
