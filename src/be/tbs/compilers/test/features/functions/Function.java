package be.tbs.compilers.test.features.functions;

import be.tbs.compilers.test.TestCase;

public class Function extends TestCase {
	
	private static String fFile = "./test/features/functions/function.csmall";

	public Function() {
		super("Functions: Function");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Dit is een functie.\na is kleiner dan b\na is positief\n");
	}

}
