package be.tbs.compilers.test.features.stdio;

import java.util.ArrayList;
import java.util.List;

import be.tbs.compilers.test.TestCase;

public class Scan extends TestCase {
	
	private static String fFile = "./test/features/stdio/scan.csmall";

	public Scan() {
		super("Stdio: Scan");
	}
	
	public void setUp() throws Exception {
		super.setUp();
	}
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test() {
		List<String> input = new ArrayList<String>();
		input.add("1");
		input.add("1.1");
		input.add("a");
		outputEquals(fFile, "Geef integer in: Integer ingelezen: 1 \n\nGeef float in: Float ingelezen: 1.1 \n\nGeef character in: Character ingelezen: a");
	}

}
