package be.tbs.compilers.exceptions.error;

/**
 * Syntax Error
 * @author gino
 */
public class SyntaxError extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 3633595394034814466L;

	/**
	 * Construct a Syntax Error with a given reason.
	 * @param message - The reason for constructing this error.
	 */
	public SyntaxError(String message) {
		super(message);
	}

	/**
	 * Construct a Syntax Error with a given reason and cause.
	 * @param message - The reason for constructing this error.
	 * @param cause - The underlying cause for this error.
	 */
	public SyntaxError(String message, Throwable cause) {
		super(message, cause);
	}

}
