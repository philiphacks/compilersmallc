/**
 * 
 */
package be.tbs.compilers.log;

import java.io.PrintStream;

import be.tbs.compilers.parser.AST;


/**
 * Log logs logs!
 * Default behaviour logs warnings to System.out and errors to System.err
 * @author Gino
 */
public class Log {
		
	/**
	 * If true, log messages are automatically flushed when they are entered.
	 */
	public static boolean AUTOFLUSH = true;
	   
    private static String PREFIX_INFO = "[I] ";
    private static String PREFIX_WARNING = "[W] ";
    private static String PREFIX_ERROR = "[E] ";
	
	private static volatile PrintStream fWarningOs = new PrintStream(System.out, Log.AUTOFLUSH);
	private static volatile PrintStream fErrorOs = new PrintStream(System.err, Log.AUTOFLUSH);
	private static boolean fVerbose = true;
	private static int fLoggedErrors = 0;
	private static int fLoggedWarnings = 0;
	private static LogLevel fMaxLevel = LogLevel.ERROR;
	
	/**
	 * Sets the warning outputstream.
	 * Informational messages are also logged to this stream.
	 * @param o OutputStream
	 */
	public static void setWarningStream(PrintStream o) {
		if (o!=null)
			fWarningOs = new PrintStream(o, Log.AUTOFLUSH);
	}
	
	/**
	 * Sets the error outputstream.
	 * Only errors are logged to this stream.
	 * @param o OutputStream
	 */
	public static void setErrorStream(PrintStream o) {
		if (o!=null)
			fErrorOs  = new PrintStream(o, Log.AUTOFLUSH);
	}
	
	/**
	 * Logs something on some stream.
	 * @param o - The PrintStream to log to.
	 * @param msg - The msg to log.
	 */
	protected static void logSomething(PrintStream o, String msg) {
	    if (fVerbose) {
	    	o.println(msg);
	    }
	}
	
	/**
	 * Log an informational message.
	 * @param s The message.
	 */
	public static void info(String s) {
		logSomething(fWarningOs,PREFIX_INFO + s);
	}
	
	/**
	 * Log a warning message.
	 * @param s The message.
	 */
	public static void warning(String s) {
		if (fMaxLevel != LogLevel.INFO) {
			fLoggedWarnings++;
			logSomething(fWarningOs,PREFIX_WARNING + s);
		}
	}
	
	/**
	 * Log an error message.
	 * @param s The message.
	 */
	public static void error(String s) {
		if (fMaxLevel == LogLevel.ERROR) {
			fLoggedErrors++;
			logSomething(fErrorOs,PREFIX_ERROR + s);
		}
	}
	
	/**
	 * Log an exception.
	 * @param e - The exception.
	 */
	@Deprecated // Use Log.info(AST t, Exception e) for compile info.
	public static void info(Exception e) {
		logSomething(fWarningOs,PREFIX_INFO + e.getMessage());
	}
	
	/**
	 * Log an exception at warning level.
	 * @param e - The exception.
	 */
    @Deprecated // Use Log.warning(AST t, Exception e) for compile warnings.
	public static void warning(Exception e) {
		if (fMaxLevel != LogLevel.INFO) {
			fLoggedWarnings++;
			logSomething(fWarningOs,PREFIX_WARNING + e.getMessage());
		}
	}
	
	/**
	 * Log an exception at error level.
	 * @param e - The exception.
	 */
	@Deprecated // Use Log.error(AST t, Exception e) for compile errors.
	public static void error(Exception e) {
		if (fMaxLevel == LogLevel.ERROR) {
			fLoggedErrors++;
			logSomething(fErrorOs,PREFIX_ERROR + e.getMessage());
		}
	}
	
	   /**
     * Log an informational message.
     * @param t The AST to which this msg corresponds.
     * @param s The message.
     */
    public static void info(AST t, String s) {
        logSomething(fWarningOs,PREFIX_INFO + ((t!=null)?t.getLocation():"") + s);
    }
    
    /**
     * Log a warning message.
     * @param t The AST to which this msg corresponds.
     * @param s The message.
     */
    public static void warning(AST t,String s) {
		if (fMaxLevel != LogLevel.INFO) {
			fLoggedWarnings++;
			logSomething(fWarningOs,PREFIX_WARNING + ((t!=null)?t.getLocation():"") + s);
		}
    }
    
    /**
     * Log an error message.
     * @param t The AST to which this msg corresponds.
     * @param s The message.
     */
    public static void error(AST t, String s) {
		if (fMaxLevel == LogLevel.ERROR) {
			fLoggedErrors++;
			logSomething(fErrorOs,PREFIX_ERROR + ((t!=null)?t.getLocation():"") + s);
		}
    }
    
    /**
     * Log an exception.
     * @param t The AST to which this msg corresponds.
     * @param e - The exception.
     */
    public static void info(AST t, Exception e) {
        logSomething(fWarningOs,PREFIX_INFO + ((t!=null)?t.getLocation():"") + e.getMessage());
    }
    
    /**
     * Log an exception at warning level.
     * @param t The AST to which this msg corresponds.
     * @param e - The exception.
     */
    public static void warning(AST t, Exception e) {
		if (fMaxLevel != LogLevel.INFO) {
			fLoggedWarnings++;
			logSomething(fWarningOs,PREFIX_WARNING + ((t!=null)?t.getLocation():"") + e.getMessage());
		}
    }
    
    /**
     * Log an exception at error level.
     * @param t The AST to which this msg corresponds.
     * @param e - The exception.
     */
    public static void error(AST t, Exception e) {
		if (fMaxLevel == LogLevel.ERROR) {
			fLoggedErrors++;
			logSomething(fErrorOs, PREFIX_ERROR + ((t!=null)?t.getLocation():"") + e.getMessage());
		}
    }
	
	/**
	 * Log a message at the specified log level.
	 * @param level - The requested log level of type LogLevel.
	 * @param s - The message to log.
	 */
	public static void log(LogLevel level, String s) {
		switch (level) {
		case ERROR:
			Log.error(s);
			break;
		case WARNING:
			Log.warning(s);
			break;
		default:
			Log.info(s);
			break;
		}
	}
	
	/**
	 * Log an error at the specified log level.
	 * @param level - The requested log level of type LogLevel.
	 * @param s - The error to log.
	 */
    @Deprecated // Use Log.log(LogLevel level, AST t, Exception e) for compile logs.
	public static void log(LogLevel level, Exception e) {
		switch (level) {
		case ERROR:
			Log.error(e);
			break;
		case WARNING:
			Log.warning(e);
			break;
		default:
			Log.info(e);
			break;
		}
	}
	
	   /**
     * Log a message at the specified log level.
     * @param level - The requested log level of type LogLevel.
     * @param t - The AST to which this msg corresponds.
     * @param s - The message to log.
     */
    public static void log(LogLevel level, AST t, String s) {
        switch (level) {
        case ERROR:
            Log.error(t,s);
            break;
        case WARNING:
            Log.warning(t,s);
            break;
        default:
            Log.info(t,s);
            break;
        }
    }
    
    /**
     * Log an error at the specified log level.
     * @param level - The requested log level of type LogLevel.
     * @param t - The AST to which this msg corresponds.
     * @param s - The error to log.
     */
    public static void log(LogLevel level, AST t, Exception e) {
        switch (level) {
        case ERROR:
            Log.error(t,e);
            break;
        case WARNING:
            Log.warning(t,e);
            break;
        default:
            Log.info(t,e);
            break;
        }
    }

	/**
	 * Sets verbose or non-verbose mode.
	 * @param verbose - Verbose or not?
	 */
	public static void setVerbose(boolean verbose) {
		fVerbose = verbose;
	}
	
	/**
	 * Sets the maximum log level to use.
	 * @param lvl
	 */
	public static void setMaxLevel(LogLevel lvl) {
		fMaxLevel = lvl;
	}
	
	/**
	 * Fetches the number of warnings logged through all but the method 'logSomething(PrintStream, String)'
	 * Note however that this is not a good estimate for the actual number of warnings generated while compiling,
	 * and should only be used when a rough estimate is adequate.
	 * @return The number of warning lines logged.
	 */
	public static int getNrWarnings() {
		return fLoggedWarnings;
	}
	
	/**
	 * Fetches the number of errors logged through all but the method 'logSomething(PrintStream, String)'
	 * Note however that this is not a good estimate for the actual number of errors generated while compiling,
	 * and should only be used when a rough estimate is adequate.
	 * Syntax errors are always one error and can thus be checked for using this method.
	 * @return The number of error lines logged.
	 */
	public static int getNrErrors() {
		return fLoggedErrors;
	}
}
