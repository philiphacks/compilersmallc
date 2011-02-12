package be.tbs.compilers.test.features.stdio;

import java.util.ArrayList;
import java.util.List;

import be.tbs.compilers.test.TestCase;

public class ScanString extends TestCase {
	
	private static String fFile = "./test/features/stdio/scan_string.csmall";

	public ScanString() {
		super("Stdio: Scan String");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		List<String> input = new ArrayList<String>();
		input.add("abcde");
		outputEquals(fFile, "Laatste char: e");
	}

}
