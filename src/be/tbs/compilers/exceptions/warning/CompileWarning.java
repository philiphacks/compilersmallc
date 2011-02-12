package be.tbs.compilers.exceptions.warning;

import be.tbs.compilers.log.Log;
import be.tbs.compilers.log.LogLevel;

/**
 * Compilation Warning
 * Can be thrown like a compilation error if compilation for the
 * concerning branch cannot continue. A warning should however
 * not cause compilation to fail.
 * 
 * @author Gino
 */
public class CompileWarning extends Exception {

    private static final long serialVersionUID = -4338574056013154194L;

    /**
     * No warnings without reasons.
     */
    @SuppressWarnings("unused")
    private CompileWarning() {}
    

    /**
     * No indirect causes for warnings
     * @param message - The reason for constructing this warning.
     * @param cause - The underlying cause for this warning.
     */
    @SuppressWarnings("unused")
	private CompileWarning(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct a Compile Warning with a given reason.
     * @param message - The reason for constructing this warning.
     */
    public CompileWarning(String message) {
        super(message);
    }

    /**
     * No forwarding of warnings through encapsulation!
     */
    @SuppressWarnings("unused")
    private CompileWarning(Throwable cause) {
        super(cause);
    }
    
    /**
     * Logs this error at warning level.
     */
    @SuppressWarnings("deprecation")
    public void log() {
        Log.warning(this);
    }
    
    /**
     * Logs this error at the requested level.
     * @param l - The level to log at.
     */
    @SuppressWarnings("deprecation")
    public void log(LogLevel l) {
        Log.log(l, this);
    }
    
    public int hashCode() {
    	return getMessage().hashCode();
    }
    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CompileWarning other = (CompileWarning) obj;
        if (getMessage().equals(other.getMessage()))
        	return true;
    	return false;
    }

}
