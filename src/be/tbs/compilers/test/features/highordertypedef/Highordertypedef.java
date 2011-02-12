package be.tbs.compilers.test.features.highordertypedef;

import be.tbs.compilers.test.TestCase;

public class Highordertypedef extends TestCase {
	
	private static String fFile = "./test/features/highordertypedef/highordertypedef.csmall";

	public Highordertypedef() {
		super("Highordertypedef: Highordertypedef");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Getal a = 5 \nCijfer b = 3 \nInteger c = 4");
	}

}
