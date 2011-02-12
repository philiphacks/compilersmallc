package be.tbs.compilers.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Runs the P Machine for a given p file.
 * Needed to perform unit tests.
 * Allows us to time the execution of a p program.
 * 
 * @author Gino Wuytjens & Philip De Smedt
 */
public class PMachine {
	
	private String fFileName;
	private List<String> fInput;
	private boolean fOk;
	private boolean fPok;
	private String fOut;
	private long fExecTime;
	
	/**
	 * Constructs a new PMachine without user input
	 * @param file The p file to run.
	 */
	public PMachine(String file) {
		fFileName = file;
	}
	
	/**
	 * Constructs a new PMachine with user input
	 * @param file The p file to run.
	 * @param input The user input.
	 */
	public PMachine(String file, List<String> input) {
		fFileName = file;
		fInput = input;
	}
	
	
	public void start() {
		String execTimeString = "--> Execution time: ";
		
		try {
			// Execute process
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(getPortableCmd());
			
			// Get streams
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			// Write inputs to the program, if any
			if (fInput != null) {
				for (String in : fInput) {
					writer.write(in);
					writer.flush();
				}
			}
			
			// Read output from program
			StringBuilder outAll = new StringBuilder();
			String tmp;
			while ((tmp = reader.readLine()) != null) {
				outAll.append(tmp + "\n");
			}
			
			// Read errors from program
			StringBuilder errAll = new StringBuilder();
			while ((tmp = error.readLine()) != null) {
				errAll.append(tmp + "\n");
			}
			
			// A failed execution does not contain the execution time.
			fOk = outAll.indexOf(execTimeString) != -1;
			
			if (fOk) {
				int outputEnd = outAll.indexOf(execTimeString);
				fOut = outAll.substring(0,outputEnd);
				fExecTime = Long.valueOf(outAll.substring(outputEnd+execTimeString.length(),outAll.length()-2));
			} else {
				fOut = errAll.toString();
				fExecTime = 0;
			}
			fPok = true;
		} catch (IOException e) {
			fOut = "Problem executing Pmachine.\nPlease check the Pmachine executable and p code file for presence/errors.";
			fOk = false;
			fPok = false;
		}
	}
	
	protected String getPortableCmd() {
		String containingFolder = "pmachine";
		String system = System.getProperty("os.name");
		
		if (system.equals("Mac OS X"))
			return containingFolder + "/Pmachine-mac " + fFileName;
		if (system.equals("Windows"))
			return "cmd /c " + containingFolder + "/Pmachine.exe " + fFileName;
		
		// If none of the above, assume some kind of linux distribution
		return "./" + containingFolder + "/Pmachine " + fFileName;
	}
	
	/**
	 * Fetches the output of the p program.
	 * @return The output.
	 */
	public String getOutput() {
		return fOut;
	}
	
	/**
	 * Checks if the Pmachine could run.
	 * @return True if yes, false if no. (duh)
	 */
	public boolean couldRun() {
		return fPok;
	}
	
	/**
	 * Checks if the Pmachine could run the program.
	 */
	public boolean programRan() {
		return fOk;
	}
	
	public long getExecTime() {
		return fExecTime;
	}
	
	public static void main(String args[]) {
		PMachine p = new PMachine("./test/pmachine/faculteit.p");
		p.start();
		
		if (p.couldRun()) {
			System.out.println(p.getOutput());
			System.out.println("Executed in: " + p.getExecTime());
		} else {
			System.out.println("Pmachine could not run.");
		}
	}	
	
}
