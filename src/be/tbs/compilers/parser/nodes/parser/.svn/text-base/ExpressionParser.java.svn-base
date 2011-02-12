package be.tbs.compilers.parser.nodes.parser;

import java.util.ArrayList;

import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.parser.nodes.Atom;
import be.tbs.compilers.parser.nodes.Comparison;
import be.tbs.compilers.parser.nodes.Condition;
import be.tbs.compilers.parser.nodes.Conjunction;
import be.tbs.compilers.parser.nodes.Factor;
import be.tbs.compilers.parser.nodes.Relation;
import be.tbs.compilers.parser.nodes.Sum;
import be.tbs.compilers.parser.nodes.Term;
import be.tbs.compilers.parser.nodes.Type;
import be.tbs.compilers.parser.nodes.VariableID;
import be.tbs.compilers.parser.nodes.Type.Types;

public class ExpressionParser {
	
	private static Double fResult;
	private static String fCharResult;
	
	public static String parseValue(Condition con, Type fType) { 
		fResult = Double.valueOf(0);
		parseExpression(con);
		if (fType.get() == Types.INT || fType.get() == Types.CONST_INT) {
			Integer result = fResult.intValue();
			return result.toString();
		} else if (fType.get() == Types.FLOAT || fType.get() == Types.CONST_FLOAT) {
			return fResult.toString();
		} else if (fType.get() == Types.CHAR || fType.get() == Types.CONST_CHAR) {
			return fCharResult.toString();
		}
		return null;
	}
	
	private static void parseExpression(Condition con) {
		ArrayList<Conjunction> c = (ArrayList<Conjunction>) con.getDisjunction().getConjunctions();
		for (int i = 0; i < c.size(); i++) {
			ArrayList<Comparison> comps = (ArrayList<Comparison>) c.get(i).getComparisons();
			for (int j = 0; j < comps.size(); j++) {
				Relation lRel = comps.get(j).getLeftRelation();
				if (lRel.getRelation() != null) {
					recursiveRelation(lRel.getRelation());
				}
				
				Sum s = lRel.getSum();
				if (s != null) {
					recursiveSum(s, s.getOperator());
				}
			}
		}
	}
	
	private static void recursiveSum(Sum s, int op) {
		Term t = s.getTerm();
		
		Factor f = t.getFactor();
		Atom a = f.getAtom();
		if (f.getFactorOperator() != null) {
			switch (f.getFactorOperator()) {
				case smallcParser.PLUS:
					op = smallcParser.PLUS;
					a = f.getFactor().getAtom();
					break;
				case smallcParser.MINUS:
					op = smallcParser.MINUS;
					a = f.getFactor().getAtom();
					break;
			}
		}
		
		if (a.getExpression() != null) {
			parseExpression(a.getExpression().getSimpleExpression().getCondition());
		} else if (a.getInt() != null) {
			//Log.info("ExpressionParser: Parsing Constant");
			doOperation(op, a);
		} else if (a.getFloat() != null) {
			doOperation(op, a);
		} else if (a.getChar() != null) {
			doOperation(op, a);
		} else if (a.getFunctionCall() != null) {
			//processFunctionCall();
		} else if (a.getVariable() != null) {
			//Log.info("ExpressionParser: Parsing Variable");
			if (a.getArrayValue() != null) {
				fResult = Double.valueOf(a.getArrayValue());
			} else {
				processVariable(a.getVariable());
			}
		}
		
		if (s.getSum() != null) {
			recursiveSum(s.getSum(), s.getOperator());
		} else {
			if (t.getTerm() != null) {
				recursiveTerm(t.getTerm(), t.getOperation());
			}
		}
	}
	
	private static void processVariable(VariableID variable) {
		fResult = Double.valueOf(variable.getValue());
	}

	private static void recursiveTerm(Term t, int op) {
		Factor f = t.getFactor();
		Atom a = f.getAtom();
		if (f.getFactorOperator() != null) {
			switch (f.getFactorOperator()) {
				case smallcParser.PLUS:
					op = smallcParser.PLUS;
					a = f.getFactor().getAtom();
					break;
				case smallcParser.MINUS:
					op = smallcParser.MINUS;
					a = f.getFactor().getAtom();
					break;
			}
		}
		
		if (a != null) {
			doOperation(op, a);
		}
		if (t.getTerm() != null) {
			recursiveTerm(t.getTerm(), op);
		}
	}

	private static void recursiveRelation(Relation r) {
		// Nothing to do for the expressionparser..
	}
	
	private static void doOperation(int op, Atom a) {
		switch (op) {
			case smallcParser.PLUS:
				if (a.getInt() != null) {
					fResult += a.getInt().doubleValue();
				} else if (a.getFloat() != null) {
					fResult += a.getFloat().doubleValue();
				} else if (a.getArrayValue() != null) {
					fResult += Double.valueOf(a.getArrayValue());
				}
				break;
			case smallcParser.MINUS:
				if (a.getInt() != null) {
					fResult -= a.getInt().doubleValue();
				} else if (a.getFloat() != null) {
					fResult -= a.getFloat().doubleValue();
				} else if (a.getArrayValue() != null) {
					fResult -= Double.valueOf(a.getArrayValue());
				}
				break;
			case smallcParser.MULT:
				if (a.getInt() != null) {
					fResult *= a.getInt().doubleValue();
				} else if (a.getFloat() != null) {
					fResult *= a.getFloat().doubleValue();
				} else if (a.getArrayValue() != null) {
					fResult *= Double.valueOf(a.getArrayValue());
				}
				break;
			case smallcParser.DIV:
				if (a.getInt() != null) {
					fResult /= a.getInt().doubleValue();
				} else if (a.getFloat() != null) {
					fResult /= a.getFloat().doubleValue();
				} else if (a.getArrayValue() != null) {
					fResult /= Double.valueOf(a.getArrayValue());
				}
				break;
			case smallcParser.MOD:
				if (a.getInt() != null) {
					fResult %= a.getInt().doubleValue();
				} else if (a.getFloat() != null) {
					fResult %= a.getFloat().doubleValue();
				} else if (a.getArrayValue() != null) {
					fResult %= Double.valueOf(a.getArrayValue());
				}
				break;
			default:
				if (fResult.equals(Double.valueOf(0))) {
					if (a.getInt() != null) {
						fResult = a.getInt().doubleValue();
					} else if (a.getFloat() != null) {
						fResult = a.getFloat().doubleValue();
					} else if (a.getChar() != null) {
						fCharResult = a.getChar();
					} else if (a.getArrayValue() != null) {
						fResult = Double.valueOf(a.getArrayValue());
					}
				}
				break;
		}
	}

}
