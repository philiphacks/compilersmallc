package be.tbs.compilers.test.features.noinitialization;

import be.tbs.compilers.test.TestCase;

public class Noinitvalue extends TestCase {
	
	private static String fFile = "./test/features/noinitialization/noinitvalue.csmall";

	public Noinitvalue() {
		super("Noinitialization: Noinitvalue");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "int: 0 \nfloat: 0 \nchar: \u0000 \n");
	}

}
