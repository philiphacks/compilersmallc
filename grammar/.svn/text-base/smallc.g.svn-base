/*
* SmallC Grammar File
* Author: Gino Wuytjens & Philip De Smedt
*   20061835  20061649
* Grammar Syntax: http://www.antlr.org/wiki/display/ANTLR3/Grammars
* Features: http://win.ua.ac.be/~hschipp/teaching/compilers/Features.html
*/

grammar smallc;

options {
  //k = 2; //Lookahead Value
  backtrack = true;
  memoize = true;
  output=AST;
  ASTLabelType=CommonTree;
}

/*
* Token Definitions
*/
tokens {
  CONST = 'const';
  CHAR = 'char';
  INT = 'int';
  FLOAT = 'float';
  PLUS = '+';
  MINUS = '-';
  MULT = '*';
  DIV = '/';
  NOT = '!';
  BREAK_WORD = 'break';
  CONTINUE_WORD = 'continue';
  ELSE_WORD = 'else';
  IF_WORD = 'if';
  RETURN_WORD = 'return';
  WHILE_WORD = 'while';
  TYPEDEF_WORD = 'typedef';
  VOID = 'void';
  READ_WORD = 'scanf';
  PRINT_WORD = 'printf';
  SEMICOLON = ';';
  UNDERSCORE = '_';
  DOT = '.';
  INCLUDE_WORD = '#include';
  ASSIGN = '=';
  ST = '<';
  GT = '>';
  STEQ = '<=';
  GTEQ = '>=';
  EQUAL = '==';
  NONEQUAL = '!=';
  OR = '||';
  AND = '&&';
  MOD = '%';
  
  PROGRAM;
  ELEMENT;
  TYPE;
  TYPEDEF;
  CAST;
  INCLUDE;
  FUNCTION_CALL;
  FUNCTION;
  PARAMETER_LIST;
  PARAMETER;
  COMPOUND_STATEMENT;
  EXPRESSION;
  DECLARATION;
  ASSIGNMENT;
  BREAK;
  CONTINUE;
  READ;
  PRINT;
  RETURN;
  IF;
  WHILE;
  ARRAY_INDEX;
  ARRAY_INIT;
  CONDITION;
  DISJUNCTION;
  CONJUNCTION;
  COMPARISON;
  RELATION;
  SUM;
  TERM;
  FACTOR;
  ATOM;
  DECLARATION_VARIABLES;
  VARIABLE_INIT;
}

@members {
  // Edited to use our logger instead of ANTLR's
  public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    List stack = getRuleInvocationStack(e, this.getClass().getName());
    String msg = null;
    if ( e instanceof NoViableAltException ) {
      NoViableAltException nvae = (NoViableAltException)e;
      msg = "no viable alternative - wrong or missing token: "+e.token.getText();
       // " decision=<<"+nvae.grammarDecisionDescription+">>";
    } else if (e instanceof MismatchedTokenException) {
      MismatchedTokenException mte = (MismatchedTokenException)e;
      msg = "mismatched token - expected: " + tokenNames[mte.expecting];
    } else if (e instanceof MissingTokenException) {
      MissingTokenException mte = (MissingTokenException)e;
      msg = "missing token - expected: " + tokenNames[mte.getMissingType()];
    }
    else {
      msg = super.getErrorMessage(e, tokenNames);
    }
    be.tbs.compilers.log.Log.error(stack+" "+msg);
    return new String("");
  }
  
  // Edited to use our logger instead of ANTLR's
  public String getTokenErrorDisplay(Token t) {
    be.tbs.compilers.log.Log.error(t.toString());
    return new String("");
  }
  
}

@lexer::header { package be.tbs.compilers.parser; }
@header { package be.tbs.compilers.parser; }

/*
* Parser Rules
*/

id : IDENTIFIER;
id_list : id (',' id_list)?;
variable_id : IDENTIFIER (array_index)?;

variable_list : variable_id (',' variable_id)* -> variable_id+;

program : element* -> ^(PROGRAM element*);
element : typedef SEMICOLON -> ^(ELEMENT typedef)
            | include -> ^(ELEMENT include)
            | function -> ^(ELEMENT function)
            | declaration SEMICOLON -> ^(ELEMENT declaration);

type : (CONST)? (t=VOID | t=CHAR | t=INT | t=FLOAT | id) -> ^(TYPE ($t)? id? CONST?);
typedef : TYPEDEF_WORD (type|id) id -> ^(TYPEDEF type? id+);
type_cast : '(' type ')' variable_id -> ^(CAST type variable_id);

include : INCLUDE_WORD ('<'|'"') (id | FILE) ('>'|'"')
  -> ^(INCLUDE id? FILE?);

function_call : id '(' expression_list? ')' -> ^(FUNCTION_CALL id expression_list?);
function : type id '(' parameter_list? ')' (compound_statement | SEMICOLON)
  -> ^(FUNCTION type id parameter_list? compound_statement?);
parameter_list : parameter (',' parameter)*
  -> ^(PARAMETER_LIST parameter+);
parameter : type variable_id -> ^(PARAMETER type variable_id);
expression_list : expression ( ',' expression_list)? -> expression expression_list?;

compound_statement : '{' (statement)* '}' -> ^(COMPOUND_STATEMENT statement*);
statement : typedef SEMICOLON
              | continue_statement
              | break_statement
              | return_statement
              | function_call SEMICOLON -> function_call
              | if_statement
              | while_statement
              | compound_statement
              | expression SEMICOLON -> expression
              | declaration SEMICOLON -> declaration
              | print_statement SEMICOLON -> print_statement
              | read_statement SEMICOLON -> read_statement;
              
expression : (assignment | simple_expression | declaration) -> ^(EXPRESSION simple_expression? declaration? assignment?);
simple_expression : type_cast
              | condition
              | variable_id
              | array_init;

declaration : type declaration_variables -> ^(DECLARATION type declaration_variables);
declaration_variables : variable_init (',' variable_init)* -> ^(DECLARATION_VARIABLES variable_init+);
variable_init : variable_id (ASSIGN expression)? -> ^(VARIABLE_INIT variable_id (expression)?);
  
assignment : variable_id ASSIGN expression -> ^(ASSIGNMENT variable_id expression);

break_statement : BREAK_WORD SEMICOLON -> BREAK;
continue_statement : CONTINUE_WORD SEMICOLON -> CONTINUE;
return_statement : RETURN_WORD expression SEMICOLON -> ^(RETURN expression);
print_statement : PRINT_WORD '(' CHARLITERAL (',' (expression|function_call))* ')'
  -> ^(PRINT CHARLITERAL expression* function_call*);
read_statement : READ_WORD '(' CHARLITERAL ',' variable_list ')'
  -> ^(READ CHARLITERAL variable_list);

if_statement : IF_WORD '(' expression ')' i=statement (ELSE_WORD e=statement)?
  -> ^(IF expression $i $e?);
while_statement : WHILE_WORD '(' expression ')' statement
  -> ^(WHILE expression statement);

array_index : '[' simple_expression ']' -> ^(ARRAY_INDEX simple_expression);
array_init : '{' expression (',' expression)* '}'
  -> ^(ARRAY_INIT expression*);

condition : (disjunction) ('?' expression ':' condition)? -> ^(CONDITION disjunction (expression condition)?);
disjunction : (conjunction) (OR conjunction)* -> ^(DISJUNCTION conjunction+);
conjunction : (comparison) (AND comparison)* -> ^(CONJUNCTION comparison+);
comparison : (a=relation) ((e=EQUAL|e=NONEQUAL) b=relation)? -> ^(COMPARISON $a ($e $b)?);
relation : (sum) ((e=ST | e=GT | e=STEQ | e=GTEQ) relation)? -> ^(RELATION sum ($e relation)?);
sum : (term) ((e=PLUS|e=MINUS) sum)? -> ^(SUM term ($e sum)?);
term: (factor) ((e=MULT|e=DIV|e=MOD) term)? -> ^(TERM factor ($e term)?);
factor : ((e=NOT|e=MINUS) factor) -> ^(FACTOR $e factor) | atom -> ^(FACTOR atom?);

atom : DECIMAL -> ^(ATOM DECIMAL) | INTEGER -> ^(ATOM INTEGER) | variable_id -> ^(ATOM variable_id) | function_call -> ^(ATOM function_call) | '(' expression ')' -> ^(ATOM expression) | CHARLITERAL -> ^(ATOM CHARLITERAL);

/*
* Lexer Rules
*/

fragment DIGIT : '0' .. '9';
fragment NUMBER : DIGIT+;
fragment CHARACTER : 'A' .. 'Z' | 'a' .. 'z';
fragment SIGN : PLUS | MINUS;
fragment EXPONENT : ( 'e' | 'E' ) DIGIT+;

NEWLINE : ('\r'? '\n')+ { $channel = HIDDEN; };
WHITESPACE : ( ' ' | NEWLINE | '\t' | '\u000C' ) { $channel = HIDDEN; };
SINGLELINE_COMMENT : '//' ~('\n' | '\r')* NEWLINE? { $channel = HIDDEN; };
MULTILINE_COMMENT options { greedy = false; } : ( '/*' .* '*/' ) { $channel = HIDDEN; };

INTEGER : NUMBER;
DECIMAL : ((NUMBER '.' NUMBER (EXPONENT)? ) 
  | ( '.' NUMBER (EXPONENT)? ) 
  | ( NUMBER EXPONENT ));
IDENTIFIER : (UNDERSCORE | CHARACTER) (UNDERSCORE | CHARACTER | DIGIT)*;
FILE : (UNDERSCORE | CHARACTER | DIGIT | DOT)+;
CHARLITERAL : '"' (.)* '"' | '\'' (.)* '\'';
