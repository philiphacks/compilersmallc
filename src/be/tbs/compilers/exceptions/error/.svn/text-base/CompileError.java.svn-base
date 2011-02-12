package be.tbs.compilers.exceptions.error;

import be.tbs.compilers.log.Log;
import be.tbs.compilers.log.LogLevel;

/**
 * Compile Error is an implementation of errors that may occur during compilation.
 * @author gino
 */
public class CompileError extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1728137829003601753L;

	/**
	 * No compile errors without reasons!
	 */
	@SuppressWarnings("unused")
	private CompileError() {
		super();
	}

	/**
	 * Construct a Compile Error with a given reason and cause.
	 * @param message - The reason for constructing this error.
	 * @param cause - The underlying cause for this error.
	 */
	public CompileError(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construct a Compile Error with a given reason.
	 * @param message - The reason for constructing this error.
	 */
	public CompileError(String message) {
		super(message);
	}

	/**
	 * No forwarding of errors through encapsulation without a good reason!
	 */
	@SuppressWarnings("unused")
	private CompileError(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Logs this error at error level.
	 */
	@SuppressWarnings("deprecation")
	public void log() {
		Log.error(this);
	}
	
	/**
	 * Logs this error at the requested level.
	 * @param l - The level to log at.
	 */
	@SuppressWarnings("deprecation")
	public void log(LogLevel l) {
		Log.log(l, this);
	}

}
