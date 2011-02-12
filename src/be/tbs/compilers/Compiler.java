package be.tbs.compilers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.RecognitionException;

import be.tbs.compilers.exceptions.error.CompileError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.ASTGenerator;

public class Compiler {
	
	public static void main(String[] args) {
		// Check input arguments		
		if (args.length != 1) {
			Log.error("Number of command line arguments is " + args.length + ", expected 1");
			return;
		}
		String inputFileName = args[0];
		int index = inputFileName.lastIndexOf(".");
		String outputFileName = inputFileName.substring(0, index) + ".p";
		
		Log.info("Compiling " + inputFileName);
		
		// Check for source file existence
		if (!new File(inputFileName).exists()) {
			Log.error("No such file: " + inputFileName);
			return;
		}
		
		try {
			ASTGenerator astGen = new ASTGenerator(new ANTLRFileStream(inputFileName), false);
			FileOutputStream out = new FileOutputStream(outputFileName);
			//astGen.toStringTree();
			astGen.generate(out, false);
			
			out.flush();
			out.close();
			
			List<CompileError> errors;
			if ((errors = astGen.getErrors()) != null && errors.size() > 0) {
				new File(outputFileName).delete();
				Log.error("Finished with " + errors.size() + " semantic errors.");
			} else // No errors.
				Log.info("Finished.");
			
		} catch (RecognitionException e) {
			Log.error("Compilation failed due to syntax error(s).");
		} catch (IOException e) {
			Log.error("Could not read/write to filesystem, please check permissions.");
		} catch (Exception e) {
			Log.error("Compilation failed due to an unknown error. This never happened on our machines, we swear!");
			Log.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
