package be.tbs.compilers.test.features.constants;

import be.tbs.compilers.test.TestCase;

public class Const extends TestCase {
	
	private static String fFile = "./test/features/constants/const.csmall";

	public Const() {
		super("Constants: Const");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Constant int a = 5 \nConstant float b = 3.21 \nConstant char c = c");
	}

}
