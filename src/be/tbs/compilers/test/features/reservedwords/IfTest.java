package be.tbs.compilers.test.features.reservedwords;

import be.tbs.compilers.test.TestCase;

public class IfTest extends TestCase {
	
	private static String fFile = "./test/features/reservedwords/if.csmall";

	public IfTest() {
		super("Reservedwords: If");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		outputEquals(fFile, "a is groter dan b en b = 2\n");
	}

}
