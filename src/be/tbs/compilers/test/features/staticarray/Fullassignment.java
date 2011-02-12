package be.tbs.compilers.test.features.staticarray;

import be.tbs.compilers.test.TestCase;

public class Fullassignment extends TestCase {
	
	private static String fFile = "./test/features/staticarray/full_assignment.csmall";

	public Fullassignment() {
		super("Staticarray: Fullassignment");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Array Declaratie\nint a[5] = {0, 8, 18, 3, 4}; \n\nFull array assignment int b[5] = a \na[2] = 18 | b[2] = 18 \n");
	}

}
