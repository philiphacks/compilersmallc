package be.tbs.compilers.test.features.conversion;

import be.tbs.compilers.test.TestCase;

public class Cast extends TestCase {
	
	private static String fFile = "./test/features/conversion/cast.csmall";

	public Cast() {
		super("Conversion: Cast");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Explicit Cast: Float -> Int \nfloat a = 3.532 \nint b = (int)a \nb = 3");
	}

}
