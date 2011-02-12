package be.tbs.compilers.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.RecognitionException;

import be.tbs.compilers.exceptions.error.CompileError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.ASTGenerator;

/**
 * AutoCompile: The easiest way to compile csmall files and run them!
 * 
 * @author gino
 */
public class AutoCompile {
	
	private String fFile;
	private String fOutFile;
	private boolean fCompiled;
	private boolean fCompileOK;
	private boolean fRun;
	private boolean fRunOK;
	private PMachine fPMachine;
	private boolean fAutoRemove;
	private boolean fOptimized;
	private boolean fVerbose;

	/**
	 * Construct an Automatic Compiler object.
	 * Default behavior is not to output any information and delete all output after running it.
	 * @param file
	 */
	public AutoCompile(String file) {
		fFile = file;
		int index = fFile.lastIndexOf(".");
		fOutFile = fFile.substring(0, index) + ".p";
		Log.setVerbose(false);
		fCompiled = false;
		fCompileOK = false;
		fRun = false;
		fRunOK = false;
		fAutoRemove = true;
	}
	
	/**
	 * Construct an Automatic Compiler object.
	 * @param file
	 * @param verbose
	 * @param autoremove - automatic removal of p files after execution?
	 */
	public AutoCompile(String file, boolean verbose, boolean autoremove) {
		fFile = file;
		int index = fFile.lastIndexOf(".");
		fOutFile = fFile.substring(0, index) + ".p";
		Log.setVerbose(verbose);
		fCompiled = false;
		fCompileOK = false;
		fRun = false;
		fRunOK = false;
		fAutoRemove = autoremove;
	}
	
	/**
	 * Sets the auto compiler to verbose mode if desired.
	 * @param v - verbose or not?
	 */
	public void setVerbose(boolean v) {
		fVerbose = v;
		Log.setVerbose(v);
	}
	
	/**
	 * Starts compilation of the source file.
	 * @return Whether or not the compilation succeeded.
	 */
	public boolean compile() {
		
		fCompiled = true;
		Log.info("Compiling " + fFile);
		
		// Check for source file existence
		if (!new File(fFile).exists()) {
			Log.error("No such file: " + fFile);
			fCompileOK = false;
			return fCompileOK;
		}
		
		try {
			ASTGenerator astGen = new ASTGenerator(new ANTLRFileStream(fFile), fVerbose);
			FileOutputStream out = new FileOutputStream(fOutFile);
			astGen.generate(out, fOptimized);
			
			out.flush();
			out.close();
			
			List<CompileError> errors;
			if ((errors = astGen.getErrors()) != null && errors.size() > 0) {
				removeOutput();
				Log.error("Finished with " + errors.size() + " semantic errors.");
				fCompileOK = false;
			} else { // No errors.
				Log.info("Finished.");
				fCompileOK = true;
			}
			
		} catch (RecognitionException e) {
			Log.error("Compilation failed due to syntax error(s).");
			fCompileOK = false;
		} catch (IOException e) {
			Log.error("Could not read/write to filesystem, please check permissions.");
			fCompileOK = false;
		} catch (Exception e) {
			Log.error("Compilation failed due to an unknown error. This never happened on our machines, we swear!");
			Log.error(e.getMessage());
			e.printStackTrace();
			fCompileOK = false;
		}
		
		return fCompileOK;
	}
	
	/**
	 * Runs the compiled program iff compilation was succesful.
	 * Executes the compilation step if it wasn't already.
	 * @return Whether or not running the program was possible.
	 */
	public boolean run() {
		return run(null);
	}
	
	/**
	 * Runs the compiled program with the provided input iff compilation was succesful.
	 * Executes the compilation step if it wasn't already.
	 * @param input - Input to provide to the program
	 * @return Whether or not running the program was possible.
	 */
	public boolean run(List<String> input) {
		fRun = true;
		if (!fCompiled)
			compile();
		if (!fCompileOK) {
			fRunOK = false;
			return fRunOK;
		}
		
		if (input == null)
			fPMachine = new PMachine(fOutFile);
		else
			fPMachine = new PMachine(fOutFile,input);
		fPMachine.start();
		
		fRunOK = fPMachine.programRan();
		if (fAutoRemove)
			removeOutput();
		return fRunOK;
	}
	
	public String getOutput() {
		return fPMachine.getOutput();
	}
	
	/**
	 * Fetches the run environment of the program.
	 * This is null (!) when the program was not yet run!
	 * @return A PMachine object upon which the program was executed.
	 */
	public PMachine getRunEnv() {
		return fPMachine;
	}

	/**
	 * Removes any output files created by the compilation process.
	 */
	public void removeOutput() {
		File pFile = new File(fOutFile);
		if (pFile.exists())
			pFile.delete();
	}
	
	/**
	 * Sets whether the code should be compiled with optimizations
	 * @param o True for optimized code.
	 */
	public void setOptimized(boolean o) {
		this.fOptimized = o;
	}
	
	public static void main(String args[]) {
		AutoCompile ac = new AutoCompile("./test/valid/optimization_expr.csmall", true, false);
		ac.setOptimized(false);
		
		if (ac.compile()) {
			System.out.println("Compilation succesful");
						
			if (ac.run()) {
				System.out.println("Running succesful");
				System.out.println("Output:");
				System.out.println(ac.getRunEnv().getOutput());
				System.out.println("Execution took:");
				System.out.println(ac.getRunEnv().getExecTime());
			} else {
				System.out.println("Running failed");
				System.out.println("Reason:");
				System.out.println(ac.getRunEnv().getOutput());
			}
			
		} else {
			System.out.println("Compilation failed");
		}
	}

}
