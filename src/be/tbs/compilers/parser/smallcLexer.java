// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g 2010-01-11 15:24:37
 package be.tbs.compilers.parser; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class smallcLexer extends Lexer {
    public static final int SIGN=79;
    public static final int FUNCTION=44;
    public static final int CAST=41;
    public static final int PRINT_WORD=22;
    public static final int EXPONENT=80;
    public static final int WHILE=57;
    public static final int MOD=36;
    public static final int CONST=4;
    public static final int CHAR=5;
    public static final int CONDITION=60;
    public static final int NOT=12;
    public static final int ATOM=68;
    public static final int EOF=-1;
    public static final int NONEQUAL=33;
    public static final int BREAK=51;
    public static final int DECLARATION_VARIABLES=69;
    public static final int CHARACTER=78;
    public static final int TYPE=39;
    public static final int IF_WORD=16;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int CONTINUE_WORD=14;
    public static final int T__90=90;
    public static final int INCLUDE=42;
    public static final int PARAMETER=46;
    public static final int RETURN=55;
    public static final int ELEMENT=38;
    public static final int VOID=20;
    public static final int ARRAY_INIT=59;
    public static final int PARAMETER_LIST=45;
    public static final int READ_WORD=21;
    public static final int CONJUNCTION=62;
    public static final int NUMBER=77;
    public static final int WHITESPACE=82;
    public static final int UNDERSCORE=24;
    public static final int INT=6;
    public static final int SEMICOLON=23;
    public static final int MULT=10;
    public static final int T__85=85;
    public static final int FILE=72;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int WHILE_WORD=18;
    public static final int VARIABLE_INIT=70;
    public static final int DISJUNCTION=61;
    public static final int READ=53;
    public static final int COMPOUND_STATEMENT=47;
    public static final int ELSE_WORD=15;
    public static final int OR=34;
    public static final int CHARLITERAL=73;
    public static final int GT=29;
    public static final int FUNCTION_CALL=43;
    public static final int TERM=66;
    public static final int TYPEDEF_WORD=19;
    public static final int SINGLELINE_COMMENT=83;
    public static final int STEQ=30;
    public static final int FLOAT=7;
    public static final int AND=35;
    public static final int SUM=65;
    public static final int DECLARATION=49;
    public static final int IF=56;
    public static final int MULTILINE_COMMENT=84;
    public static final int CONTINUE=52;
    public static final int FACTOR=67;
    public static final int IDENTIFIER=71;
    public static final int EQUAL=32;
    public static final int ARRAY_INDEX=58;
    public static final int PLUS=8;
    public static final int DIGIT=76;
    public static final int DOT=25;
    public static final int EXPRESSION=48;
    public static final int INTEGER=75;
    public static final int INCLUDE_WORD=26;
    public static final int TYPEDEF=40;
    public static final int RELATION=64;
    public static final int ST=28;
    public static final int BREAK_WORD=13;
    public static final int GTEQ=31;
    public static final int MINUS=9;
    public static final int PRINT=54;
    public static final int RETURN_WORD=17;
    public static final int NEWLINE=81;
    public static final int DECIMAL=74;
    public static final int COMPARISON=63;
    public static final int ASSIGN=27;
    public static final int PROGRAM=37;
    public static final int ASSIGNMENT=50;
    public static final int DIV=11;

    // delegates
    // delegators

    public smallcLexer() {;} 
    public smallcLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public smallcLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g"; }

    // $ANTLR start "CONST"
    public final void mCONST() throws RecognitionException {
        try {
            int _type = CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:5:7: ( 'const' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:5:9: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONST"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:6:6: ( 'char' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:6:8: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:7:5: ( 'int' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:7:7: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:8:7: ( 'float' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:8:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:9:6: ( '+' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:9:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:10:7: ( '-' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:10:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:11:6: ( '*' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:11:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:12:5: ( '/' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:12:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:13:5: ( '!' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:13:7: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "BREAK_WORD"
    public final void mBREAK_WORD() throws RecognitionException {
        try {
            int _type = BREAK_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:14:12: ( 'break' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:14:14: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BREAK_WORD"

    // $ANTLR start "CONTINUE_WORD"
    public final void mCONTINUE_WORD() throws RecognitionException {
        try {
            int _type = CONTINUE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:15:15: ( 'continue' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:15:17: 'continue'
            {
            match("continue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTINUE_WORD"

    // $ANTLR start "ELSE_WORD"
    public final void mELSE_WORD() throws RecognitionException {
        try {
            int _type = ELSE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:16:11: ( 'else' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:16:13: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE_WORD"

    // $ANTLR start "IF_WORD"
    public final void mIF_WORD() throws RecognitionException {
        try {
            int _type = IF_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:17:9: ( 'if' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:17:11: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF_WORD"

    // $ANTLR start "RETURN_WORD"
    public final void mRETURN_WORD() throws RecognitionException {
        try {
            int _type = RETURN_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:18:13: ( 'return' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:18:15: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURN_WORD"

    // $ANTLR start "WHILE_WORD"
    public final void mWHILE_WORD() throws RecognitionException {
        try {
            int _type = WHILE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:19:12: ( 'while' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:19:14: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE_WORD"

    // $ANTLR start "TYPEDEF_WORD"
    public final void mTYPEDEF_WORD() throws RecognitionException {
        try {
            int _type = TYPEDEF_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:20:14: ( 'typedef' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:20:16: 'typedef'
            {
            match("typedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPEDEF_WORD"

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:21:6: ( 'void' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:21:8: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "READ_WORD"
    public final void mREAD_WORD() throws RecognitionException {
        try {
            int _type = READ_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:22:11: ( 'scanf' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:22:13: 'scanf'
            {
            match("scanf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READ_WORD"

    // $ANTLR start "PRINT_WORD"
    public final void mPRINT_WORD() throws RecognitionException {
        try {
            int _type = PRINT_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:23:12: ( 'printf' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:23:14: 'printf'
            {
            match("printf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINT_WORD"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:24:11: ( ';' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:24:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:25:12: ( '_' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:25:14: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:26:5: ( '.' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:26:7: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "INCLUDE_WORD"
    public final void mINCLUDE_WORD() throws RecognitionException {
        try {
            int _type = INCLUDE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:27:14: ( '#include' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:27:16: '#include'
            {
            match("#include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDE_WORD"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:28:8: ( '=' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:28:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "ST"
    public final void mST() throws RecognitionException {
        try {
            int _type = ST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:29:4: ( '<' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:29:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ST"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:30:4: ( '>' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:30:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "STEQ"
    public final void mSTEQ() throws RecognitionException {
        try {
            int _type = STEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:31:6: ( '<=' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:31:8: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STEQ"

    // $ANTLR start "GTEQ"
    public final void mGTEQ() throws RecognitionException {
        try {
            int _type = GTEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:32:6: ( '>=' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:32:8: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GTEQ"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:33:7: ( '==' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:33:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "NONEQUAL"
    public final void mNONEQUAL() throws RecognitionException {
        try {
            int _type = NONEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:34:10: ( '!=' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:34:12: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NONEQUAL"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:35:4: ( '||' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:35:6: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:36:5: ( '&&' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:36:7: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:37:5: ( '%' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:37:7: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:38:7: ( ',' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:38:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:39:7: ( '(' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:39:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:40:7: ( ')' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:40:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:41:7: ( '\"' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:41:9: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:42:7: ( '{' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:42:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:43:7: ( '}' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:43:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:44:7: ( '[' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:44:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:45:7: ( ']' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:45:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:46:7: ( '?' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:46:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:47:7: ( ':' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:47:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:216:16: ( '0' .. '9' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:216:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:217:17: ( ( DIGIT )+ )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:217:19: ( DIGIT )+
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:217:19: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:217:19: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "CHARACTER"
    public final void mCHARACTER() throws RecognitionException {
        try {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:218:20: ( 'A' .. 'Z' | 'a' .. 'z' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "CHARACTER"

    // $ANTLR start "SIGN"
    public final void mSIGN() throws RecognitionException {
        try {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:219:15: ( PLUS | MINUS )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SIGN"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:220:19: ( ( 'e' | 'E' ) ( DIGIT )+ )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:220:21: ( 'e' | 'E' ) ( DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:220:35: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:220:35: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:222:9: ( ( ( '\\r' )? '\\n' )+ )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:222:11: ( ( '\\r' )? '\\n' )+
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:222:11: ( ( '\\r' )? '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:222:12: ( '\\r' )? '\\n'
            	    {
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:222:12: ( '\\r' )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0=='\r') ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:222:12: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:223:12: ( ( ' ' | NEWLINE | '\\t' | '\\u000C' ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:223:14: ( ' ' | NEWLINE | '\\t' | '\\u000C' )
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:223:14: ( ' ' | NEWLINE | '\\t' | '\\u000C' )
            int alt5=4;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt5=1;
                }
                break;
            case '\n':
            case '\r':
                {
                alt5=2;
                }
                break;
            case '\t':
                {
                alt5=3;
                }
                break;
            case '\f':
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:223:16: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:223:22: NEWLINE
                    {
                    mNEWLINE(); 

                    }
                    break;
                case 3 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:223:32: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 4 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:223:39: '\\u000C'
                    {
                    match('\f'); 

                    }
                    break;

            }

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "SINGLELINE_COMMENT"
    public final void mSINGLELINE_COMMENT() throws RecognitionException {
        try {
            int _type = SINGLELINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:224:20: ( '//' (~ ( '\\n' | '\\r' ) )* ( NEWLINE )? )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:224:22: '//' (~ ( '\\n' | '\\r' ) )* ( NEWLINE )?
            {
            match("//"); 

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:224:27: (~ ( '\\n' | '\\r' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:224:27: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:224:43: ( NEWLINE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:224:43: NEWLINE
                    {
                    mNEWLINE(); 

                    }
                    break;

            }

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINGLELINE_COMMENT"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:225:47: ( ( '/*' ( . )* '*/' ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:225:49: ( '/*' ( . )* '*/' )
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:225:49: ( '/*' ( . )* '*/' )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:225:51: '/*' ( . )* '*/'
            {
            match("/*"); 

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:225:56: ( . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:225:56: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:227:9: ( NUMBER )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:227:11: NUMBER
            {
            mNUMBER(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "DECIMAL"
    public final void mDECIMAL() throws RecognitionException {
        try {
            int _type = DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:228:9: ( ( ( NUMBER '.' NUMBER ( EXPONENT )? ) | ( '.' NUMBER ( EXPONENT )? ) | ( NUMBER EXPONENT ) ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:228:11: ( ( NUMBER '.' NUMBER ( EXPONENT )? ) | ( '.' NUMBER ( EXPONENT )? ) | ( NUMBER EXPONENT ) )
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:228:11: ( ( NUMBER '.' NUMBER ( EXPONENT )? ) | ( '.' NUMBER ( EXPONENT )? ) | ( NUMBER EXPONENT ) )
            int alt11=3;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:228:12: ( NUMBER '.' NUMBER ( EXPONENT )? )
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:228:12: ( NUMBER '.' NUMBER ( EXPONENT )? )
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:228:13: NUMBER '.' NUMBER ( EXPONENT )?
                    {
                    mNUMBER(); 
                    match('.'); 
                    mNUMBER(); 
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:228:31: ( EXPONENT )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='E'||LA9_0=='e') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:228:32: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:229:5: ( '.' NUMBER ( EXPONENT )? )
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:229:5: ( '.' NUMBER ( EXPONENT )? )
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:229:7: '.' NUMBER ( EXPONENT )?
                    {
                    match('.'); 
                    mNUMBER(); 
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:229:18: ( EXPONENT )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:229:19: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:230:5: ( NUMBER EXPONENT )
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:230:5: ( NUMBER EXPONENT )
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:230:7: NUMBER EXPONENT
                    {
                    mNUMBER(); 
                    mEXPONENT(); 

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:231:12: ( ( UNDERSCORE | CHARACTER ) ( UNDERSCORE | CHARACTER | DIGIT )* )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:231:14: ( UNDERSCORE | CHARACTER ) ( UNDERSCORE | CHARACTER | DIGIT )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:231:39: ( UNDERSCORE | CHARACTER | DIGIT )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "FILE"
    public final void mFILE() throws RecognitionException {
        try {
            int _type = FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:232:6: ( ( UNDERSCORE | CHARACTER | DIGIT | DOT )+ )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:232:8: ( UNDERSCORE | CHARACTER | DIGIT | DOT )+
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:232:8: ( UNDERSCORE | CHARACTER | DIGIT | DOT )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='.'||(LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FILE"

    // $ANTLR start "CHARLITERAL"
    public final void mCHARLITERAL() throws RecognitionException {
        try {
            int _type = CHARLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:233:13: ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\"') ) {
                alt16=1;
            }
            else if ( (LA16_0=='\'') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:233:15: '\"' ( . )* '\"'
                    {
                    match('\"'); 
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:233:19: ( . )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='\"') ) {
                            alt14=2;
                        }
                        else if ( ((LA14_0>='\u0000' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='\uFFFF')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:233:20: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:233:30: '\\'' ( . )* '\\''
                    {
                    match('\''); 
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:233:35: ( . )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='\'') ) {
                            alt15=2;
                        }
                        else if ( ((LA15_0>='\u0000' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='\uFFFF')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:233:36: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHARLITERAL"

    public void mTokens() throws RecognitionException {
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:8: ( CONST | CHAR | INT | FLOAT | PLUS | MINUS | MULT | DIV | NOT | BREAK_WORD | CONTINUE_WORD | ELSE_WORD | IF_WORD | RETURN_WORD | WHILE_WORD | TYPEDEF_WORD | VOID | READ_WORD | PRINT_WORD | SEMICOLON | UNDERSCORE | DOT | INCLUDE_WORD | ASSIGN | ST | GT | STEQ | GTEQ | EQUAL | NONEQUAL | OR | AND | MOD | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | NEWLINE | WHITESPACE | SINGLELINE_COMMENT | MULTILINE_COMMENT | INTEGER | DECIMAL | IDENTIFIER | FILE | CHARLITERAL )
        int alt17=52;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:10: CONST
                {
                mCONST(); 

                }
                break;
            case 2 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:16: CHAR
                {
                mCHAR(); 

                }
                break;
            case 3 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:21: INT
                {
                mINT(); 

                }
                break;
            case 4 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:25: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 5 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:31: PLUS
                {
                mPLUS(); 

                }
                break;
            case 6 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:36: MINUS
                {
                mMINUS(); 

                }
                break;
            case 7 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:42: MULT
                {
                mMULT(); 

                }
                break;
            case 8 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:47: DIV
                {
                mDIV(); 

                }
                break;
            case 9 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:51: NOT
                {
                mNOT(); 

                }
                break;
            case 10 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:55: BREAK_WORD
                {
                mBREAK_WORD(); 

                }
                break;
            case 11 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:66: CONTINUE_WORD
                {
                mCONTINUE_WORD(); 

                }
                break;
            case 12 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:80: ELSE_WORD
                {
                mELSE_WORD(); 

                }
                break;
            case 13 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:90: IF_WORD
                {
                mIF_WORD(); 

                }
                break;
            case 14 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:98: RETURN_WORD
                {
                mRETURN_WORD(); 

                }
                break;
            case 15 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:110: WHILE_WORD
                {
                mWHILE_WORD(); 

                }
                break;
            case 16 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:121: TYPEDEF_WORD
                {
                mTYPEDEF_WORD(); 

                }
                break;
            case 17 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:134: VOID
                {
                mVOID(); 

                }
                break;
            case 18 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:139: READ_WORD
                {
                mREAD_WORD(); 

                }
                break;
            case 19 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:149: PRINT_WORD
                {
                mPRINT_WORD(); 

                }
                break;
            case 20 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:160: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 21 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:170: UNDERSCORE
                {
                mUNDERSCORE(); 

                }
                break;
            case 22 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:181: DOT
                {
                mDOT(); 

                }
                break;
            case 23 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:185: INCLUDE_WORD
                {
                mINCLUDE_WORD(); 

                }
                break;
            case 24 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:198: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 25 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:205: ST
                {
                mST(); 

                }
                break;
            case 26 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:208: GT
                {
                mGT(); 

                }
                break;
            case 27 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:211: STEQ
                {
                mSTEQ(); 

                }
                break;
            case 28 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:216: GTEQ
                {
                mGTEQ(); 

                }
                break;
            case 29 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:221: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 30 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:227: NONEQUAL
                {
                mNONEQUAL(); 

                }
                break;
            case 31 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:236: OR
                {
                mOR(); 

                }
                break;
            case 32 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:239: AND
                {
                mAND(); 

                }
                break;
            case 33 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:243: MOD
                {
                mMOD(); 

                }
                break;
            case 34 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:247: T__85
                {
                mT__85(); 

                }
                break;
            case 35 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:253: T__86
                {
                mT__86(); 

                }
                break;
            case 36 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:259: T__87
                {
                mT__87(); 

                }
                break;
            case 37 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:265: T__88
                {
                mT__88(); 

                }
                break;
            case 38 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:271: T__89
                {
                mT__89(); 

                }
                break;
            case 39 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:277: T__90
                {
                mT__90(); 

                }
                break;
            case 40 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:283: T__91
                {
                mT__91(); 

                }
                break;
            case 41 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:289: T__92
                {
                mT__92(); 

                }
                break;
            case 42 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:295: T__93
                {
                mT__93(); 

                }
                break;
            case 43 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:301: T__94
                {
                mT__94(); 

                }
                break;
            case 44 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:307: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 45 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:315: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 46 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:326: SINGLELINE_COMMENT
                {
                mSINGLELINE_COMMENT(); 

                }
                break;
            case 47 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:345: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 48 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:363: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 49 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:371: DECIMAL
                {
                mDECIMAL(); 

                }
                break;
            case 50 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:379: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 51 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:390: FILE
                {
                mFILE(); 

                }
                break;
            case 52 :
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:1:395: CHARLITERAL
                {
                mCHARLITERAL(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA11_eotS =
        "\5\uffff";
    static final String DFA11_eofS =
        "\5\uffff";
    static final String DFA11_minS =
        "\2\56\3\uffff";
    static final String DFA11_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\3\1\1";
    static final String DFA11_specialS =
        "\5\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\4\1\uffff\12\1\13\uffff\1\3\37\uffff\1\3",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "228:11: ( ( NUMBER '.' NUMBER ( EXPONENT )? ) | ( '.' NUMBER ( EXPONENT )? ) | ( NUMBER EXPONENT ) )";
        }
    }
    static final String DFA17_eotS =
        "\1\uffff\3\55\3\uffff\1\65\1\67\10\55\1\uffff\1\100\1\102\1\uffff"+
        "\1\104\1\106\1\110\6\uffff\1\111\7\uffff\1\112\1\uffff\1\113\1\55"+
        "\1\uffff\2\55\1\uffff\1\55\1\uffff\1\55\1\121\1\55\5\uffff\10\55"+
        "\1\uffff\1\133\12\uffff\2\57\2\55\1\142\1\uffff\11\55\1\uffff\1"+
        "\57\2\133\2\55\1\160\1\uffff\2\55\1\163\3\55\1\167\2\55\1\133\1"+
        "\57\1\173\1\55\1\uffff\1\175\1\176\1\uffff\1\55\1\u0080\1\55\1\uffff"+
        "\1\u0082\1\55\1\133\1\uffff\1\55\2\uffff\1\u0085\1\uffff\1\55\1"+
        "\uffff\1\u0087\1\55\1\uffff\1\u0089\1\uffff\1\u008a\2\uffff";
    static final String DFA17_eofS =
        "\u008b\uffff";
    static final String DFA17_minS =
        "\1\11\3\56\3\uffff\1\52\1\75\10\56\1\uffff\2\56\1\uffff\3\75\6\uffff"+
        "\1\0\6\uffff\2\12\1\uffff\2\56\1\uffff\2\56\1\uffff\1\56\1\uffff"+
        "\3\56\5\uffff\10\56\1\uffff\1\56\12\uffff\2\60\3\56\1\uffff\11\56"+
        "\1\uffff\1\60\5\56\1\uffff\12\56\1\60\2\56\1\uffff\2\56\1\uffff"+
        "\3\56\1\uffff\3\56\1\uffff\1\56\2\uffff\1\56\1\uffff\1\56\1\uffff"+
        "\2\56\1\uffff\1\56\1\uffff\1\56\2\uffff";
    static final String DFA17_maxS =
        "\1\175\3\172\3\uffff\1\57\1\75\10\172\1\uffff\2\172\1\uffff\3\75"+
        "\6\uffff\1\uffff\6\uffff\1\12\1\15\1\uffff\2\172\1\uffff\2\172\1"+
        "\uffff\1\172\1\uffff\3\172\5\uffff\10\172\1\uffff\1\172\12\uffff"+
        "\2\71\3\172\1\uffff\11\172\1\uffff\1\71\5\172\1\uffff\12\172\1\71"+
        "\2\172\1\uffff\2\172\1\uffff\3\172\1\uffff\3\172\1\uffff\1\172\2"+
        "\uffff\1\172\1\uffff\1\172\1\uffff\2\172\1\uffff\1\172\1\uffff\1"+
        "\172\2\uffff";
    static final String DFA17_acceptS =
        "\4\uffff\1\5\1\6\1\7\12\uffff\1\24\2\uffff\1\27\3\uffff\1\37\1\40"+
        "\1\41\1\42\1\43\1\44\1\uffff\1\46\1\47\1\50\1\51\1\52\1\53\2\uffff"+
        "\1\55\2\uffff\1\64\2\uffff\1\62\1\uffff\1\63\3\uffff\1\56\1\57\1"+
        "\10\1\36\1\11\10\uffff\1\25\1\uffff\1\26\1\35\1\30\1\33\1\31\1\34"+
        "\1\32\1\45\1\54\1\60\5\uffff\1\15\11\uffff\1\61\6\uffff\1\3\15\uffff"+
        "\1\2\2\uffff\1\14\3\uffff\1\21\3\uffff\1\1\1\uffff\1\4\1\12\1\uffff"+
        "\1\17\1\uffff\1\22\2\uffff\1\16\1\uffff\1\23\1\uffff\1\20\1\13";
    static final String DFA17_specialS =
        "\36\uffff\1\0\154\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\47\1\46\1\uffff\1\47\1\45\22\uffff\1\47\1\10\1\36\1\24\1"+
            "\uffff\1\32\1\31\1\52\1\34\1\35\1\6\1\4\1\33\1\5\1\23\1\7\12"+
            "\50\1\44\1\21\1\26\1\25\1\27\1\43\1\uffff\32\51\1\41\1\uffff"+
            "\1\42\1\uffff\1\22\1\uffff\1\51\1\11\1\1\1\51\1\12\1\3\2\51"+
            "\1\2\6\51\1\20\1\51\1\13\1\17\1\15\1\51\1\16\1\14\3\51\1\37"+
            "\1\30\1\40",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\7\56"+
            "\1\54\6\56\1\53\13\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\5\56"+
            "\1\61\7\56\1\60\14\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\13\56"+
            "\1\62\16\56",
            "",
            "",
            "",
            "\1\64\4\uffff\1\63",
            "\1\66",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\21\56"+
            "\1\70\10\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\13\56"+
            "\1\71\16\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56"+
            "\1\72\25\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\7\56"+
            "\1\73\22\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\30\56"+
            "\1\74\1\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\16\56"+
            "\1\75\13\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\2\56"+
            "\1\76\27\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\21\56"+
            "\1\77\10\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\101\7\uffff\32\57\4\uffff\1\57\1\uffff\32"+
            "\57",
            "",
            "\1\103",
            "\1\105",
            "\1\107",
            "",
            "",
            "",
            "",
            "",
            "",
            "\0\52",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\46",
            "\1\46\2\uffff\1\45",
            "",
            "\1\114\1\uffff\12\50\7\uffff\4\57\1\115\25\57\4\uffff\1\57"+
            "\1\uffff\4\57\1\115\25\57",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\15\56"+
            "\1\116\14\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\1\117"+
            "\31\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\23\56"+
            "\1\120\6\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\16\56"+
            "\1\122\13\56",
            "",
            "",
            "",
            "",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56"+
            "\1\123\25\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\22\56"+
            "\1\124\7\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\23\56"+
            "\1\125\6\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\10\56"+
            "\1\126\21\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\17\56"+
            "\1\127\12\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\10\56"+
            "\1\130\21\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\1\131"+
            "\31\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\10\56"+
            "\1\132\21\56",
            "",
            "\1\57\1\uffff\12\101\7\uffff\4\57\1\134\25\57\4\uffff\1\57"+
            "\1\uffff\4\57\1\134\25\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\135",
            "\12\136",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\22\56"+
            "\1\137\1\140\6\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\21\56"+
            "\1\141\10\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\1\143"+
            "\31\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\1\144"+
            "\31\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56"+
            "\1\145\25\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\24\56"+
            "\1\146\5\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\13\56"+
            "\1\147\16\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56"+
            "\1\150\25\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\3\56"+
            "\1\151\26\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\15\56"+
            "\1\152\14\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\15\56"+
            "\1\153\14\56",
            "",
            "\12\154",
            "\1\57\1\uffff\12\135\7\uffff\4\57\1\155\25\57\4\uffff\1\57"+
            "\1\uffff\4\57\1\155\25\57",
            "\1\57\1\uffff\12\136\7\uffff\32\57\4\uffff\1\57\1\uffff\32"+
            "\57",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\23\56"+
            "\1\156\6\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\10\56"+
            "\1\157\21\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\23\56"+
            "\1\161\6\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\12\56"+
            "\1\162\17\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\21\56"+
            "\1\164\10\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56"+
            "\1\165\25\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\3\56"+
            "\1\166\26\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\5\56"+
            "\1\170\24\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\23\56"+
            "\1\171\6\56",
            "\1\57\1\uffff\12\154\7\uffff\32\57\4\uffff\1\57\1\uffff\32"+
            "\57",
            "\12\172",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\15\56"+
            "\1\174\14\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\15\56"+
            "\1\177\14\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56"+
            "\1\u0081\25\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\5\56"+
            "\1\u0083\24\56",
            "\1\57\1\uffff\12\172\7\uffff\32\57\4\uffff\1\57\1\uffff\32"+
            "\57",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\24\56"+
            "\1\u0084\5\56",
            "",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\5\56"+
            "\1\u0086\24\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\4\56"+
            "\1\u0088\25\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            "\1\57\1\uffff\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( CONST | CHAR | INT | FLOAT | PLUS | MINUS | MULT | DIV | NOT | BREAK_WORD | CONTINUE_WORD | ELSE_WORD | IF_WORD | RETURN_WORD | WHILE_WORD | TYPEDEF_WORD | VOID | READ_WORD | PRINT_WORD | SEMICOLON | UNDERSCORE | DOT | INCLUDE_WORD | ASSIGN | ST | GT | STEQ | GTEQ | EQUAL | NONEQUAL | OR | AND | MOD | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | NEWLINE | WHITESPACE | SINGLELINE_COMMENT | MULTILINE_COMMENT | INTEGER | DECIMAL | IDENTIFIER | FILE | CHARLITERAL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_30 = input.LA(1);

                        s = -1;
                        if ( ((LA17_30>='\u0000' && LA17_30<='\uFFFF')) ) {s = 42;}

                        else s = 73;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}