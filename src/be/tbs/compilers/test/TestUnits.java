package be.tbs.compilers.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * jUnit Suite, contains all implemented unit tests.
 * @author gino
 */

@RunWith(Suite.class)
@Suite.SuiteClasses( {
	
	// Features
	
	// BasicTypes
	be.tbs.compilers.test.features.basictypes.Char.class,
	be.tbs.compilers.test.features.basictypes.Float.class,
	
	// Comments
	be.tbs.compilers.test.features.comments.Multiline.class,
	be.tbs.compilers.test.features.comments.Singleline.class,
	
	// Constants
	be.tbs.compilers.test.features.constants.Const.class,
	
	// Conversion
	be.tbs.compilers.test.features.conversion.Cast.class,
	be.tbs.compilers.test.features.conversion.Implicit.class,
	
	// Functions
	be.tbs.compilers.test.features.functions.Function.class,
	
	// Globalvar
	be.tbs.compilers.test.features.globalvar.Global.class,
	
	// Highordertypedef
	be.tbs.compilers.test.features.highordertypedef.Highordertypedef.class,
	
	// Noinitialization
	be.tbs.compilers.test.features.noinitialization.Noinitvalue.class,
	
	// Reservedwords
	be.tbs.compilers.test.features.reservedwords.IfTest.class,
	be.tbs.compilers.test.features.reservedwords.TypedefTest.class,
	be.tbs.compilers.test.features.reservedwords.WhileTest.class,
	
	// Return
	be.tbs.compilers.test.features.returntests.Returnvalues.class,
	
	// Staticarray
	be.tbs.compilers.test.features.staticarray.Assignment.class,
	be.tbs.compilers.test.features.staticarray.Fullassignment.class,
	be.tbs.compilers.test.features.staticarray.Initialization.class,
	be.tbs.compilers.test.features.staticarray.Parameter.class,
	
	// Stdio
	be.tbs.compilers.test.features.stdio.Print.class,
	be.tbs.compilers.test.features.stdio.PrintArray.class,
	be.tbs.compilers.test.features.stdio.PrintExpr.class,
	be.tbs.compilers.test.features.stdio.PrintSpecial.class,
	be.tbs.compilers.test.features.stdio.PrintVars.class,
	//be.tbs.compilers.test.features.stdio.Scan.class,
	//be.tbs.compilers.test.features.stdio.ScanString.class
	
	})

public class TestUnits {
	
	public static void runAfterClass() {
		Runtime.getRuntime().gc();
	}
	
}
