package be.tbs.compilers.test.features.globalvar;

import be.tbs.compilers.test.TestCase;

public class Global extends TestCase {
	
	private static String fFile = "./test/features/globalvar/global.csmall";

	public Global() {
		super("Globalvar: Global");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "Global int a = 5 \nGlobal const int b = 3 \nGlobal float c = 3.4124 \nGlobal char d = d \n");
	}

}
