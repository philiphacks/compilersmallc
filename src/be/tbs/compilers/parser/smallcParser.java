// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g 2010-01-11 15:24:36
 package be.tbs.compilers.parser; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class smallcParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CONST", "CHAR", "INT", "FLOAT", "PLUS", "MINUS", "MULT", "DIV", "NOT", "BREAK_WORD", "CONTINUE_WORD", "ELSE_WORD", "IF_WORD", "RETURN_WORD", "WHILE_WORD", "TYPEDEF_WORD", "VOID", "READ_WORD", "PRINT_WORD", "SEMICOLON", "UNDERSCORE", "DOT", "INCLUDE_WORD", "ASSIGN", "ST", "GT", "STEQ", "GTEQ", "EQUAL", "NONEQUAL", "OR", "AND", "MOD", "PROGRAM", "ELEMENT", "TYPE", "TYPEDEF", "CAST", "INCLUDE", "FUNCTION_CALL", "FUNCTION", "PARAMETER_LIST", "PARAMETER", "COMPOUND_STATEMENT", "EXPRESSION", "DECLARATION", "ASSIGNMENT", "BREAK", "CONTINUE", "READ", "PRINT", "RETURN", "IF", "WHILE", "ARRAY_INDEX", "ARRAY_INIT", "CONDITION", "DISJUNCTION", "CONJUNCTION", "COMPARISON", "RELATION", "SUM", "TERM", "FACTOR", "ATOM", "DECLARATION_VARIABLES", "VARIABLE_INIT", "IDENTIFIER", "FILE", "CHARLITERAL", "DECIMAL", "INTEGER", "DIGIT", "NUMBER", "CHARACTER", "SIGN", "EXPONENT", "NEWLINE", "WHITESPACE", "SINGLELINE_COMMENT", "MULTILINE_COMMENT", "','", "'('", "')'", "'\"'", "'{'", "'}'", "'['", "']'", "'?'", "':'"
    };
    public static final int CAST=41;
    public static final int FUNCTION=44;
    public static final int SIGN=79;
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
    public static final int CONTINUE_WORD=14;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int INCLUDE=42;
    public static final int PARAMETER=46;
    public static final int RETURN=55;
    public static final int ELEMENT=38;
    public static final int VOID=20;
    public static final int PARAMETER_LIST=45;
    public static final int ARRAY_INIT=59;
    public static final int READ_WORD=21;
    public static final int CONJUNCTION=62;
    public static final int NUMBER=77;
    public static final int WHITESPACE=82;
    public static final int UNDERSCORE=24;
    public static final int SEMICOLON=23;
    public static final int INT=6;
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


        public smallcParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public smallcParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[106+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return smallcParser.tokenNames; }
    public String getGrammarFileName() { return "/home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g"; }


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
      


    public static class id_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:131:1: id : IDENTIFIER ;
    public final smallcParser.id_return id() throws RecognitionException {
        smallcParser.id_return retval = new smallcParser.id_return();
        retval.start = input.LT(1);
        int id_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IDENTIFIER1=null;

        CommonTree IDENTIFIER1_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:131:4: ( IDENTIFIER )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:131:6: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENTIFIER1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_id553); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER1_tree = (CommonTree)adaptor.create(IDENTIFIER1);
            adaptor.addChild(root_0, IDENTIFIER1_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, id_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "id"

    public static class id_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id_list"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:132:1: id_list : id ( ',' id_list )? ;
    public final smallcParser.id_list_return id_list() throws RecognitionException {
        smallcParser.id_list_return retval = new smallcParser.id_list_return();
        retval.start = input.LT(1);
        int id_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal3=null;
        smallcParser.id_return id2 = null;

        smallcParser.id_list_return id_list4 = null;


        CommonTree char_literal3_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:132:9: ( id ( ',' id_list )? )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:132:11: id ( ',' id_list )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_id_in_id_list560);
            id2=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, id2.getTree());
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:132:14: ( ',' id_list )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==85) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:132:15: ',' id_list
                    {
                    char_literal3=(Token)match(input,85,FOLLOW_85_in_id_list563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal3_tree = (CommonTree)adaptor.create(char_literal3);
                    adaptor.addChild(root_0, char_literal3_tree);
                    }
                    pushFollow(FOLLOW_id_list_in_id_list565);
                    id_list4=id_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, id_list4.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, id_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "id_list"

    public static class variable_id_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_id"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:133:1: variable_id : IDENTIFIER ( array_index )? ;
    public final smallcParser.variable_id_return variable_id() throws RecognitionException {
        smallcParser.variable_id_return retval = new smallcParser.variable_id_return();
        retval.start = input.LT(1);
        int variable_id_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IDENTIFIER5=null;
        smallcParser.array_index_return array_index6 = null;


        CommonTree IDENTIFIER5_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:133:13: ( IDENTIFIER ( array_index )? )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:133:15: IDENTIFIER ( array_index )?
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENTIFIER5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variable_id574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER5_tree = (CommonTree)adaptor.create(IDENTIFIER5);
            adaptor.addChild(root_0, IDENTIFIER5_tree);
            }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:133:26: ( array_index )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==91) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:133:27: array_index
                    {
                    pushFollow(FOLLOW_array_index_in_variable_id577);
                    array_index6=array_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, array_index6.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, variable_id_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "variable_id"

    public static class variable_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_list"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:135:1: variable_list : variable_id ( ',' variable_id )* -> ( variable_id )+ ;
    public final smallcParser.variable_list_return variable_list() throws RecognitionException {
        smallcParser.variable_list_return retval = new smallcParser.variable_list_return();
        retval.start = input.LT(1);
        int variable_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal8=null;
        smallcParser.variable_id_return variable_id7 = null;

        smallcParser.variable_id_return variable_id9 = null;


        CommonTree char_literal8_tree=null;
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_variable_id=new RewriteRuleSubtreeStream(adaptor,"rule variable_id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:135:15: ( variable_id ( ',' variable_id )* -> ( variable_id )+ )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:135:17: variable_id ( ',' variable_id )*
            {
            pushFollow(FOLLOW_variable_id_in_variable_list587);
            variable_id7=variable_id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variable_id.add(variable_id7.getTree());
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:135:29: ( ',' variable_id )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==85) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:135:30: ',' variable_id
            	    {
            	    char_literal8=(Token)match(input,85,FOLLOW_85_in_variable_list590); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_85.add(char_literal8);

            	    pushFollow(FOLLOW_variable_id_in_variable_list592);
            	    variable_id9=variable_id();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_variable_id.add(variable_id9.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);



            // AST REWRITE
            // elements: variable_id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 135:48: -> ( variable_id )+
            {
                if ( !(stream_variable_id.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_variable_id.hasNext() ) {
                    adaptor.addChild(root_0, stream_variable_id.nextTree());

                }
                stream_variable_id.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, variable_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "variable_list"

    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:137:1: program : ( element )* -> ^( PROGRAM ( element )* ) ;
    public final smallcParser.program_return program() throws RecognitionException {
        smallcParser.program_return retval = new smallcParser.program_return();
        retval.start = input.LT(1);
        int program_StartIndex = input.index();
        CommonTree root_0 = null;

        smallcParser.element_return element10 = null;


        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:137:9: ( ( element )* -> ^( PROGRAM ( element )* ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:137:11: ( element )*
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:137:11: ( element )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=CONST && LA4_0<=FLOAT)||(LA4_0>=TYPEDEF_WORD && LA4_0<=VOID)||LA4_0==INCLUDE_WORD||LA4_0==IDENTIFIER) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:0:0: element
            	    {
            	    pushFollow(FOLLOW_element_in_program607);
            	    element10=element();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_element.add(element10.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);



            // AST REWRITE
            // elements: element
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 137:20: -> ^( PROGRAM ( element )* )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:137:23: ^( PROGRAM ( element )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROGRAM, "PROGRAM"), root_1);

                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:137:33: ( element )*
                while ( stream_element.hasNext() ) {
                    adaptor.addChild(root_1, stream_element.nextTree());

                }
                stream_element.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, program_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class element_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "element"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:138:1: element : ( typedef SEMICOLON -> ^( ELEMENT typedef ) | include -> ^( ELEMENT include ) | function -> ^( ELEMENT function ) | declaration SEMICOLON -> ^( ELEMENT declaration ) );
    public final smallcParser.element_return element() throws RecognitionException {
        smallcParser.element_return retval = new smallcParser.element_return();
        retval.start = input.LT(1);
        int element_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SEMICOLON12=null;
        Token SEMICOLON16=null;
        smallcParser.typedef_return typedef11 = null;

        smallcParser.include_return include13 = null;

        smallcParser.function_return function14 = null;

        smallcParser.declaration_return declaration15 = null;


        CommonTree SEMICOLON12_tree=null;
        CommonTree SEMICOLON16_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");
        RewriteRuleSubtreeStream stream_typedef=new RewriteRuleSubtreeStream(adaptor,"rule typedef");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        RewriteRuleSubtreeStream stream_include=new RewriteRuleSubtreeStream(adaptor,"rule include");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:138:9: ( typedef SEMICOLON -> ^( ELEMENT typedef ) | include -> ^( ELEMENT include ) | function -> ^( ELEMENT function ) | declaration SEMICOLON -> ^( ELEMENT declaration ) )
            int alt5=4;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:138:11: typedef SEMICOLON
                    {
                    pushFollow(FOLLOW_typedef_in_element624);
                    typedef11=typedef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_typedef.add(typedef11.getTree());
                    SEMICOLON12=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_element626); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON12);



                    // AST REWRITE
                    // elements: typedef
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 138:29: -> ^( ELEMENT typedef )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:138:32: ^( ELEMENT typedef )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                        adaptor.addChild(root_1, stream_typedef.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:139:15: include
                    {
                    pushFollow(FOLLOW_include_in_element650);
                    include13=include();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_include.add(include13.getTree());


                    // AST REWRITE
                    // elements: include
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 139:23: -> ^( ELEMENT include )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:139:26: ^( ELEMENT include )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                        adaptor.addChild(root_1, stream_include.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:140:15: function
                    {
                    pushFollow(FOLLOW_function_in_element674);
                    function14=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_function.add(function14.getTree());


                    // AST REWRITE
                    // elements: function
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 140:24: -> ^( ELEMENT function )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:140:27: ^( ELEMENT function )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                        adaptor.addChild(root_1, stream_function.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:141:15: declaration SEMICOLON
                    {
                    pushFollow(FOLLOW_declaration_in_element698);
                    declaration15=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_declaration.add(declaration15.getTree());
                    SEMICOLON16=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_element700); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON16);



                    // AST REWRITE
                    // elements: declaration
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 141:37: -> ^( ELEMENT declaration )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:141:40: ^( ELEMENT declaration )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                        adaptor.addChild(root_1, stream_declaration.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, element_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "element"

    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:1: type : ( CONST )? (t= VOID | t= CHAR | t= INT | t= FLOAT | id ) -> ^( TYPE ( $t)? ( id )? ( CONST )? ) ;
    public final smallcParser.type_return type() throws RecognitionException {
        smallcParser.type_return retval = new smallcParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        CommonTree root_0 = null;

        Token t=null;
        Token CONST17=null;
        smallcParser.id_return id18 = null;


        CommonTree t_tree=null;
        CommonTree CONST17_tree=null;
        RewriteRuleTokenStream stream_CHAR=new RewriteRuleTokenStream(adaptor,"token CHAR");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_VOID=new RewriteRuleTokenStream(adaptor,"token VOID");
        RewriteRuleTokenStream stream_CONST=new RewriteRuleTokenStream(adaptor,"token CONST");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:6: ( ( CONST )? (t= VOID | t= CHAR | t= INT | t= FLOAT | id ) -> ^( TYPE ( $t)? ( id )? ( CONST )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:8: ( CONST )? (t= VOID | t= CHAR | t= INT | t= FLOAT | id )
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:8: ( CONST )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==CONST) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:9: CONST
                    {
                    CONST17=(Token)match(input,CONST,FOLLOW_CONST_in_type717); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONST.add(CONST17);


                    }
                    break;

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:17: (t= VOID | t= CHAR | t= INT | t= FLOAT | id )
            int alt7=5;
            switch ( input.LA(1) ) {
            case VOID:
                {
                alt7=1;
                }
                break;
            case CHAR:
                {
                alt7=2;
                }
                break;
            case INT:
                {
                alt7=3;
                }
                break;
            case FLOAT:
                {
                alt7=4;
                }
                break;
            case IDENTIFIER:
                {
                alt7=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:18: t= VOID
                    {
                    t=(Token)match(input,VOID,FOLLOW_VOID_in_type724); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VOID.add(t);


                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:27: t= CHAR
                    {
                    t=(Token)match(input,CHAR,FOLLOW_CHAR_in_type730); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR.add(t);


                    }
                    break;
                case 3 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:36: t= INT
                    {
                    t=(Token)match(input,INT,FOLLOW_INT_in_type736); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(t);


                    }
                    break;
                case 4 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:44: t= FLOAT
                    {
                    t=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_type742); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FLOAT.add(t);


                    }
                    break;
                case 5 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:54: id
                    {
                    pushFollow(FOLLOW_id_in_type746);
                    id18=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id18.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: CONST, id, t
            // token labels: t
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_t=new RewriteRuleTokenStream(adaptor,"token t",t);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 143:58: -> ^( TYPE ( $t)? ( id )? ( CONST )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:61: ^( TYPE ( $t)? ( id )? ( CONST )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:68: ( $t)?
                if ( stream_t.hasNext() ) {
                    adaptor.addChild(root_1, stream_t.nextNode());

                }
                stream_t.reset();
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:74: ( id )?
                if ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:143:78: ( CONST )?
                if ( stream_CONST.hasNext() ) {
                    adaptor.addChild(root_1, stream_CONST.nextNode());

                }
                stream_CONST.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, type_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class typedef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typedef"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:1: typedef : TYPEDEF_WORD ( type | id ) id -> ^( TYPEDEF ( type )? ( id )+ ) ;
    public final smallcParser.typedef_return typedef() throws RecognitionException {
        smallcParser.typedef_return retval = new smallcParser.typedef_return();
        retval.start = input.LT(1);
        int typedef_StartIndex = input.index();
        CommonTree root_0 = null;

        Token TYPEDEF_WORD19=null;
        smallcParser.type_return type20 = null;

        smallcParser.id_return id21 = null;

        smallcParser.id_return id22 = null;


        CommonTree TYPEDEF_WORD19_tree=null;
        RewriteRuleTokenStream stream_TYPEDEF_WORD=new RewriteRuleTokenStream(adaptor,"token TYPEDEF_WORD");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:9: ( TYPEDEF_WORD ( type | id ) id -> ^( TYPEDEF ( type )? ( id )+ ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:11: TYPEDEF_WORD ( type | id ) id
            {
            TYPEDEF_WORD19=(Token)match(input,TYPEDEF_WORD,FOLLOW_TYPEDEF_WORD_in_typedef772); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TYPEDEF_WORD.add(TYPEDEF_WORD19);

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:24: ( type | id )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=CONST && LA8_0<=FLOAT)||LA8_0==VOID) ) {
                alt8=1;
            }
            else if ( (LA8_0==IDENTIFIER) ) {
                int LA8_2 = input.LA(2);

                if ( (synpred13_smallc()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:25: type
                    {
                    pushFollow(FOLLOW_type_in_typedef775);
                    type20=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type20.getTree());

                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:30: id
                    {
                    pushFollow(FOLLOW_id_in_typedef777);
                    id21=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id21.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_id_in_typedef780);
            id22=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id22.getTree());


            // AST REWRITE
            // elements: id, type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 144:37: -> ^( TYPEDEF ( type )? ( id )+ )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:40: ^( TYPEDEF ( type )? ( id )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPEDEF, "TYPEDEF"), root_1);

                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:50: ( type )?
                if ( stream_type.hasNext() ) {
                    adaptor.addChild(root_1, stream_type.nextTree());

                }
                stream_type.reset();
                if ( !(stream_id.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, typedef_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typedef"

    public static class type_cast_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_cast"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:145:1: type_cast : '(' type ')' variable_id -> ^( CAST type variable_id ) ;
    public final smallcParser.type_cast_return type_cast() throws RecognitionException {
        smallcParser.type_cast_return retval = new smallcParser.type_cast_return();
        retval.start = input.LT(1);
        int type_cast_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal23=null;
        Token char_literal25=null;
        smallcParser.type_return type24 = null;

        smallcParser.variable_id_return variable_id26 = null;


        CommonTree char_literal23_tree=null;
        CommonTree char_literal25_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleSubtreeStream stream_variable_id=new RewriteRuleSubtreeStream(adaptor,"rule variable_id");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:145:11: ( '(' type ')' variable_id -> ^( CAST type variable_id ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:145:13: '(' type ')' variable_id
            {
            char_literal23=(Token)match(input,86,FOLLOW_86_in_type_cast799); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(char_literal23);

            pushFollow(FOLLOW_type_in_type_cast801);
            type24=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type24.getTree());
            char_literal25=(Token)match(input,87,FOLLOW_87_in_type_cast803); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal25);

            pushFollow(FOLLOW_variable_id_in_type_cast805);
            variable_id26=variable_id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variable_id.add(variable_id26.getTree());


            // AST REWRITE
            // elements: variable_id, type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 145:38: -> ^( CAST type variable_id )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:145:41: ^( CAST type variable_id )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CAST, "CAST"), root_1);

                adaptor.addChild(root_1, stream_type.nextTree());
                adaptor.addChild(root_1, stream_variable_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, type_cast_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type_cast"

    public static class include_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "include"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:1: include : INCLUDE_WORD ( '<' | '\"' ) ( id | FILE ) ( '>' | '\"' ) -> ^( INCLUDE ( id )? ( FILE )? ) ;
    public final smallcParser.include_return include() throws RecognitionException {
        smallcParser.include_return retval = new smallcParser.include_return();
        retval.start = input.LT(1);
        int include_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INCLUDE_WORD27=null;
        Token char_literal28=null;
        Token char_literal29=null;
        Token FILE31=null;
        Token char_literal32=null;
        Token char_literal33=null;
        smallcParser.id_return id30 = null;


        CommonTree INCLUDE_WORD27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree FILE31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree char_literal33_tree=null;
        RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
        RewriteRuleTokenStream stream_INCLUDE_WORD=new RewriteRuleTokenStream(adaptor,"token INCLUDE_WORD");
        RewriteRuleTokenStream stream_ST=new RewriteRuleTokenStream(adaptor,"token ST");
        RewriteRuleTokenStream stream_FILE=new RewriteRuleTokenStream(adaptor,"token FILE");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:9: ( INCLUDE_WORD ( '<' | '\"' ) ( id | FILE ) ( '>' | '\"' ) -> ^( INCLUDE ( id )? ( FILE )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:11: INCLUDE_WORD ( '<' | '\"' ) ( id | FILE ) ( '>' | '\"' )
            {
            INCLUDE_WORD27=(Token)match(input,INCLUDE_WORD,FOLLOW_INCLUDE_WORD_in_include823); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INCLUDE_WORD.add(INCLUDE_WORD27);

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:24: ( '<' | '\"' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ST) ) {
                alt9=1;
            }
            else if ( (LA9_0==88) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:25: '<'
                    {
                    char_literal28=(Token)match(input,ST,FOLLOW_ST_in_include826); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ST.add(char_literal28);


                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:29: '\"'
                    {
                    char_literal29=(Token)match(input,88,FOLLOW_88_in_include828); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_88.add(char_literal29);


                    }
                    break;

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:34: ( id | FILE )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENTIFIER) ) {
                alt10=1;
            }
            else if ( (LA10_0==FILE) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:35: id
                    {
                    pushFollow(FOLLOW_id_in_include832);
                    id30=id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_id.add(id30.getTree());

                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:40: FILE
                    {
                    FILE31=(Token)match(input,FILE,FOLLOW_FILE_in_include836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FILE.add(FILE31);


                    }
                    break;

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:46: ( '>' | '\"' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==GT) ) {
                alt11=1;
            }
            else if ( (LA11_0==88) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:47: '>'
                    {
                    char_literal32=(Token)match(input,GT,FOLLOW_GT_in_include840); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GT.add(char_literal32);


                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:147:51: '\"'
                    {
                    char_literal33=(Token)match(input,88,FOLLOW_88_in_include842); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_88.add(char_literal33);


                    }
                    break;

            }



            // AST REWRITE
            // elements: id, FILE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:3: -> ^( INCLUDE ( id )? ( FILE )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:148:6: ^( INCLUDE ( id )? ( FILE )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INCLUDE, "INCLUDE"), root_1);

                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:148:16: ( id )?
                if ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:148:20: ( FILE )?
                if ( stream_FILE.hasNext() ) {
                    adaptor.addChild(root_1, stream_FILE.nextNode());

                }
                stream_FILE.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, include_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "include"

    public static class function_call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_call"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:150:1: function_call : id '(' ( expression_list )? ')' -> ^( FUNCTION_CALL id ( expression_list )? ) ;
    public final smallcParser.function_call_return function_call() throws RecognitionException {
        smallcParser.function_call_return retval = new smallcParser.function_call_return();
        retval.start = input.LT(1);
        int function_call_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal35=null;
        Token char_literal37=null;
        smallcParser.id_return id34 = null;

        smallcParser.expression_list_return expression_list36 = null;


        CommonTree char_literal35_tree=null;
        CommonTree char_literal37_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_expression_list=new RewriteRuleSubtreeStream(adaptor,"rule expression_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:150:15: ( id '(' ( expression_list )? ')' -> ^( FUNCTION_CALL id ( expression_list )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:150:17: id '(' ( expression_list )? ')'
            {
            pushFollow(FOLLOW_id_in_function_call865);
            id34=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id34.getTree());
            char_literal35=(Token)match(input,86,FOLLOW_86_in_function_call867); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(char_literal35);

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:150:24: ( expression_list )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=CONST && LA12_0<=FLOAT)||LA12_0==MINUS||LA12_0==NOT||LA12_0==VOID||LA12_0==IDENTIFIER||(LA12_0>=CHARLITERAL && LA12_0<=INTEGER)||LA12_0==86||LA12_0==89) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:0:0: expression_list
                    {
                    pushFollow(FOLLOW_expression_list_in_function_call869);
                    expression_list36=expression_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression_list.add(expression_list36.getTree());

                    }
                    break;

            }

            char_literal37=(Token)match(input,87,FOLLOW_87_in_function_call872); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal37);



            // AST REWRITE
            // elements: id, expression_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 150:45: -> ^( FUNCTION_CALL id ( expression_list )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:150:48: ^( FUNCTION_CALL id ( expression_list )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:150:67: ( expression_list )?
                if ( stream_expression_list.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression_list.nextTree());

                }
                stream_expression_list.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, function_call_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function_call"

    public static class function_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:151:1: function : type id '(' ( parameter_list )? ')' ( compound_statement | SEMICOLON ) -> ^( FUNCTION type id ( parameter_list )? ( compound_statement )? ) ;
    public final smallcParser.function_return function() throws RecognitionException {
        smallcParser.function_return retval = new smallcParser.function_return();
        retval.start = input.LT(1);
        int function_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal40=null;
        Token char_literal42=null;
        Token SEMICOLON44=null;
        smallcParser.type_return type38 = null;

        smallcParser.id_return id39 = null;

        smallcParser.parameter_list_return parameter_list41 = null;

        smallcParser.compound_statement_return compound_statement43 = null;


        CommonTree char_literal40_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree SEMICOLON44_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_compound_statement=new RewriteRuleSubtreeStream(adaptor,"rule compound_statement");
        RewriteRuleSubtreeStream stream_parameter_list=new RewriteRuleSubtreeStream(adaptor,"rule parameter_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:151:10: ( type id '(' ( parameter_list )? ')' ( compound_statement | SEMICOLON ) -> ^( FUNCTION type id ( parameter_list )? ( compound_statement )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:151:12: type id '(' ( parameter_list )? ')' ( compound_statement | SEMICOLON )
            {
            pushFollow(FOLLOW_type_in_function890);
            type38=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type38.getTree());
            pushFollow(FOLLOW_id_in_function892);
            id39=id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_id.add(id39.getTree());
            char_literal40=(Token)match(input,86,FOLLOW_86_in_function894); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(char_literal40);

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:151:24: ( parameter_list )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=CONST && LA13_0<=FLOAT)||LA13_0==VOID||LA13_0==IDENTIFIER) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:0:0: parameter_list
                    {
                    pushFollow(FOLLOW_parameter_list_in_function896);
                    parameter_list41=parameter_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_parameter_list.add(parameter_list41.getTree());

                    }
                    break;

            }

            char_literal42=(Token)match(input,87,FOLLOW_87_in_function899); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal42);

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:151:44: ( compound_statement | SEMICOLON )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==89) ) {
                alt14=1;
            }
            else if ( (LA14_0==SEMICOLON) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:151:45: compound_statement
                    {
                    pushFollow(FOLLOW_compound_statement_in_function902);
                    compound_statement43=compound_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_compound_statement.add(compound_statement43.getTree());

                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:151:66: SEMICOLON
                    {
                    SEMICOLON44=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function906); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON44);


                    }
                    break;

            }



            // AST REWRITE
            // elements: parameter_list, type, compound_statement, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 152:3: -> ^( FUNCTION type id ( parameter_list )? ( compound_statement )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:152:6: ^( FUNCTION type id ( parameter_list )? ( compound_statement )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_type.nextTree());
                adaptor.addChild(root_1, stream_id.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:152:25: ( parameter_list )?
                if ( stream_parameter_list.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameter_list.nextTree());

                }
                stream_parameter_list.reset();
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:152:41: ( compound_statement )?
                if ( stream_compound_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_compound_statement.nextTree());

                }
                stream_compound_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, function_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class parameter_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter_list"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:153:1: parameter_list : parameter ( ',' parameter )* -> ^( PARAMETER_LIST ( parameter )+ ) ;
    public final smallcParser.parameter_list_return parameter_list() throws RecognitionException {
        smallcParser.parameter_list_return retval = new smallcParser.parameter_list_return();
        retval.start = input.LT(1);
        int parameter_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal46=null;
        smallcParser.parameter_return parameter45 = null;

        smallcParser.parameter_return parameter47 = null;


        CommonTree char_literal46_tree=null;
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_parameter=new RewriteRuleSubtreeStream(adaptor,"rule parameter");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:153:16: ( parameter ( ',' parameter )* -> ^( PARAMETER_LIST ( parameter )+ ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:153:18: parameter ( ',' parameter )*
            {
            pushFollow(FOLLOW_parameter_in_parameter_list932);
            parameter45=parameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_parameter.add(parameter45.getTree());
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:153:28: ( ',' parameter )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==85) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:153:29: ',' parameter
            	    {
            	    char_literal46=(Token)match(input,85,FOLLOW_85_in_parameter_list935); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_85.add(char_literal46);

            	    pushFollow(FOLLOW_parameter_in_parameter_list937);
            	    parameter47=parameter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_parameter.add(parameter47.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);



            // AST REWRITE
            // elements: parameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 154:3: -> ^( PARAMETER_LIST ( parameter )+ )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:154:6: ^( PARAMETER_LIST ( parameter )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETER_LIST, "PARAMETER_LIST"), root_1);

                if ( !(stream_parameter.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_parameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameter.nextTree());

                }
                stream_parameter.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, parameter_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "parameter_list"

    public static class parameter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:155:1: parameter : type variable_id -> ^( PARAMETER type variable_id ) ;
    public final smallcParser.parameter_return parameter() throws RecognitionException {
        smallcParser.parameter_return retval = new smallcParser.parameter_return();
        retval.start = input.LT(1);
        int parameter_StartIndex = input.index();
        CommonTree root_0 = null;

        smallcParser.type_return type48 = null;

        smallcParser.variable_id_return variable_id49 = null;


        RewriteRuleSubtreeStream stream_variable_id=new RewriteRuleSubtreeStream(adaptor,"rule variable_id");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:155:11: ( type variable_id -> ^( PARAMETER type variable_id ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:155:13: type variable_id
            {
            pushFollow(FOLLOW_type_in_parameter957);
            type48=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type48.getTree());
            pushFollow(FOLLOW_variable_id_in_parameter959);
            variable_id49=variable_id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variable_id.add(variable_id49.getTree());


            // AST REWRITE
            // elements: type, variable_id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 155:30: -> ^( PARAMETER type variable_id )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:155:33: ^( PARAMETER type variable_id )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAMETER, "PARAMETER"), root_1);

                adaptor.addChild(root_1, stream_type.nextTree());
                adaptor.addChild(root_1, stream_variable_id.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parameter_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "parameter"

    public static class expression_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression_list"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:156:1: expression_list : expression ( ',' expression_list )? -> expression ( expression_list )? ;
    public final smallcParser.expression_list_return expression_list() throws RecognitionException {
        smallcParser.expression_list_return retval = new smallcParser.expression_list_return();
        retval.start = input.LT(1);
        int expression_list_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal51=null;
        smallcParser.expression_return expression50 = null;

        smallcParser.expression_list_return expression_list52 = null;


        CommonTree char_literal51_tree=null;
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_expression_list=new RewriteRuleSubtreeStream(adaptor,"rule expression_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:156:17: ( expression ( ',' expression_list )? -> expression ( expression_list )? )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:156:19: expression ( ',' expression_list )?
            {
            pushFollow(FOLLOW_expression_in_expression_list976);
            expression50=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression50.getTree());
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:156:30: ( ',' expression_list )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==85) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:156:32: ',' expression_list
                    {
                    char_literal51=(Token)match(input,85,FOLLOW_85_in_expression_list980); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_85.add(char_literal51);

                    pushFollow(FOLLOW_expression_list_in_expression_list982);
                    expression_list52=expression_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression_list.add(expression_list52.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: expression_list, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 156:54: -> expression ( expression_list )?
            {
                adaptor.addChild(root_0, stream_expression.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:156:68: ( expression_list )?
                if ( stream_expression_list.hasNext() ) {
                    adaptor.addChild(root_0, stream_expression_list.nextTree());

                }
                stream_expression_list.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, expression_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression_list"

    public static class compound_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compound_statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:158:1: compound_statement : '{' ( statement )* '}' -> ^( COMPOUND_STATEMENT ( statement )* ) ;
    public final smallcParser.compound_statement_return compound_statement() throws RecognitionException {
        smallcParser.compound_statement_return retval = new smallcParser.compound_statement_return();
        retval.start = input.LT(1);
        int compound_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal53=null;
        Token char_literal55=null;
        smallcParser.statement_return statement54 = null;


        CommonTree char_literal53_tree=null;
        CommonTree char_literal55_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:158:20: ( '{' ( statement )* '}' -> ^( COMPOUND_STATEMENT ( statement )* ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:158:22: '{' ( statement )* '}'
            {
            char_literal53=(Token)match(input,89,FOLLOW_89_in_compound_statement999); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_89.add(char_literal53);

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:158:26: ( statement )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=CONST && LA17_0<=FLOAT)||LA17_0==MINUS||(LA17_0>=NOT && LA17_0<=CONTINUE_WORD)||(LA17_0>=IF_WORD && LA17_0<=PRINT_WORD)||LA17_0==IDENTIFIER||(LA17_0>=CHARLITERAL && LA17_0<=INTEGER)||LA17_0==86||LA17_0==89) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:158:27: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_compound_statement1002);
            	    statement54=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement54.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            char_literal55=(Token)match(input,90,FOLLOW_90_in_compound_statement1006); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_90.add(char_literal55);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 158:43: -> ^( COMPOUND_STATEMENT ( statement )* )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:158:46: ^( COMPOUND_STATEMENT ( statement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COMPOUND_STATEMENT, "COMPOUND_STATEMENT"), root_1);

                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:158:67: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, compound_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compound_statement"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:159:1: statement : ( typedef SEMICOLON | continue_statement | break_statement | return_statement | function_call SEMICOLON -> function_call | if_statement | while_statement | compound_statement | expression SEMICOLON -> expression | declaration SEMICOLON -> declaration | print_statement SEMICOLON -> print_statement | read_statement SEMICOLON -> read_statement );
    public final smallcParser.statement_return statement() throws RecognitionException {
        smallcParser.statement_return retval = new smallcParser.statement_return();
        retval.start = input.LT(1);
        int statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SEMICOLON57=null;
        Token SEMICOLON62=null;
        Token SEMICOLON67=null;
        Token SEMICOLON69=null;
        Token SEMICOLON71=null;
        Token SEMICOLON73=null;
        smallcParser.typedef_return typedef56 = null;

        smallcParser.continue_statement_return continue_statement58 = null;

        smallcParser.break_statement_return break_statement59 = null;

        smallcParser.return_statement_return return_statement60 = null;

        smallcParser.function_call_return function_call61 = null;

        smallcParser.if_statement_return if_statement63 = null;

        smallcParser.while_statement_return while_statement64 = null;

        smallcParser.compound_statement_return compound_statement65 = null;

        smallcParser.expression_return expression66 = null;

        smallcParser.declaration_return declaration68 = null;

        smallcParser.print_statement_return print_statement70 = null;

        smallcParser.read_statement_return read_statement72 = null;


        CommonTree SEMICOLON57_tree=null;
        CommonTree SEMICOLON62_tree=null;
        CommonTree SEMICOLON67_tree=null;
        CommonTree SEMICOLON69_tree=null;
        CommonTree SEMICOLON71_tree=null;
        CommonTree SEMICOLON73_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");
        RewriteRuleSubtreeStream stream_function_call=new RewriteRuleSubtreeStream(adaptor,"rule function_call");
        RewriteRuleSubtreeStream stream_print_statement=new RewriteRuleSubtreeStream(adaptor,"rule print_statement");
        RewriteRuleSubtreeStream stream_read_statement=new RewriteRuleSubtreeStream(adaptor,"rule read_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:159:11: ( typedef SEMICOLON | continue_statement | break_statement | return_statement | function_call SEMICOLON -> function_call | if_statement | while_statement | compound_statement | expression SEMICOLON -> expression | declaration SEMICOLON -> declaration | print_statement SEMICOLON -> print_statement | read_statement SEMICOLON -> read_statement )
            int alt18=12;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:159:13: typedef SEMICOLON
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_typedef_in_statement1022);
                    typedef56=typedef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typedef56.getTree());
                    SEMICOLON57=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1024); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON57_tree = (CommonTree)adaptor.create(SEMICOLON57);
                    adaptor.addChild(root_0, SEMICOLON57_tree);
                    }

                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:160:17: continue_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_continue_statement_in_statement1042);
                    continue_statement58=continue_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continue_statement58.getTree());

                    }
                    break;
                case 3 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:161:17: break_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_break_statement_in_statement1060);
                    break_statement59=break_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, break_statement59.getTree());

                    }
                    break;
                case 4 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:162:17: return_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_return_statement_in_statement1078);
                    return_statement60=return_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, return_statement60.getTree());

                    }
                    break;
                case 5 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:163:17: function_call SEMICOLON
                    {
                    pushFollow(FOLLOW_function_call_in_statement1096);
                    function_call61=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_function_call.add(function_call61.getTree());
                    SEMICOLON62=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1098); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON62);



                    // AST REWRITE
                    // elements: function_call
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 163:41: -> function_call
                    {
                        adaptor.addChild(root_0, stream_function_call.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:164:17: if_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_statement_in_statement1120);
                    if_statement63=if_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_statement63.getTree());

                    }
                    break;
                case 7 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:165:17: while_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_statement_in_statement1138);
                    while_statement64=while_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_statement64.getTree());

                    }
                    break;
                case 8 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:166:17: compound_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_compound_statement_in_statement1156);
                    compound_statement65=compound_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_statement65.getTree());

                    }
                    break;
                case 9 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:167:17: expression SEMICOLON
                    {
                    pushFollow(FOLLOW_expression_in_statement1174);
                    expression66=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression66.getTree());
                    SEMICOLON67=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1176); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON67);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 167:38: -> expression
                    {
                        adaptor.addChild(root_0, stream_expression.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:168:17: declaration SEMICOLON
                    {
                    pushFollow(FOLLOW_declaration_in_statement1198);
                    declaration68=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_declaration.add(declaration68.getTree());
                    SEMICOLON69=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1200); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON69);



                    // AST REWRITE
                    // elements: declaration
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 168:39: -> declaration
                    {
                        adaptor.addChild(root_0, stream_declaration.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:169:17: print_statement SEMICOLON
                    {
                    pushFollow(FOLLOW_print_statement_in_statement1222);
                    print_statement70=print_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_print_statement.add(print_statement70.getTree());
                    SEMICOLON71=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1224); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON71);



                    // AST REWRITE
                    // elements: print_statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 169:43: -> print_statement
                    {
                        adaptor.addChild(root_0, stream_print_statement.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:170:17: read_statement SEMICOLON
                    {
                    pushFollow(FOLLOW_read_statement_in_statement1246);
                    read_statement72=read_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_read_statement.add(read_statement72.getTree());
                    SEMICOLON73=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_statement1248); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON73);



                    // AST REWRITE
                    // elements: read_statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 170:42: -> read_statement
                    {
                        adaptor.addChild(root_0, stream_read_statement.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:1: expression : ( assignment | simple_expression | declaration ) -> ^( EXPRESSION ( simple_expression )? ( declaration )? ( assignment )? ) ;
    public final smallcParser.expression_return expression() throws RecognitionException {
        smallcParser.expression_return retval = new smallcParser.expression_return();
        retval.start = input.LT(1);
        int expression_StartIndex = input.index();
        CommonTree root_0 = null;

        smallcParser.assignment_return assignment74 = null;

        smallcParser.simple_expression_return simple_expression75 = null;

        smallcParser.declaration_return declaration76 = null;


        RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");
        RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");
        RewriteRuleSubtreeStream stream_simple_expression=new RewriteRuleSubtreeStream(adaptor,"rule simple_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:12: ( ( assignment | simple_expression | declaration ) -> ^( EXPRESSION ( simple_expression )? ( declaration )? ( assignment )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:14: ( assignment | simple_expression | declaration )
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:14: ( assignment | simple_expression | declaration )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:15: assignment
                    {
                    pushFollow(FOLLOW_assignment_in_expression1275);
                    assignment74=assignment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignment.add(assignment74.getTree());

                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:28: simple_expression
                    {
                    pushFollow(FOLLOW_simple_expression_in_expression1279);
                    simple_expression75=simple_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_simple_expression.add(simple_expression75.getTree());

                    }
                    break;
                case 3 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:48: declaration
                    {
                    pushFollow(FOLLOW_declaration_in_expression1283);
                    declaration76=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_declaration.add(declaration76.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: simple_expression, assignment, declaration
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 172:61: -> ^( EXPRESSION ( simple_expression )? ( declaration )? ( assignment )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:64: ^( EXPRESSION ( simple_expression )? ( declaration )? ( assignment )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);

                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:77: ( simple_expression )?
                if ( stream_simple_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_simple_expression.nextTree());

                }
                stream_simple_expression.reset();
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:96: ( declaration )?
                if ( stream_declaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_declaration.nextTree());

                }
                stream_declaration.reset();
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:109: ( assignment )?
                if ( stream_assignment.hasNext() ) {
                    adaptor.addChild(root_1, stream_assignment.nextTree());

                }
                stream_assignment.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class simple_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple_expression"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:173:1: simple_expression : ( type_cast | condition | variable_id | array_init );
    public final smallcParser.simple_expression_return simple_expression() throws RecognitionException {
        smallcParser.simple_expression_return retval = new smallcParser.simple_expression_return();
        retval.start = input.LT(1);
        int simple_expression_StartIndex = input.index();
        CommonTree root_0 = null;

        smallcParser.type_cast_return type_cast77 = null;

        smallcParser.condition_return condition78 = null;

        smallcParser.variable_id_return variable_id79 = null;

        smallcParser.array_init_return array_init80 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:173:19: ( type_cast | condition | variable_id | array_init )
            int alt20=4;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:173:21: type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_type_cast_in_simple_expression1306);
                    type_cast77=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type_cast77.getTree());

                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:174:17: condition
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_condition_in_simple_expression1324);
                    condition78=condition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, condition78.getTree());

                    }
                    break;
                case 3 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:175:17: variable_id
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_id_in_simple_expression1342);
                    variable_id79=variable_id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variable_id79.getTree());

                    }
                    break;
                case 4 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:176:17: array_init
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_array_init_in_simple_expression1360);
                    array_init80=array_init();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, array_init80.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, simple_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "simple_expression"

    public static class declaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:178:1: declaration : type declaration_variables -> ^( DECLARATION type declaration_variables ) ;
    public final smallcParser.declaration_return declaration() throws RecognitionException {
        smallcParser.declaration_return retval = new smallcParser.declaration_return();
        retval.start = input.LT(1);
        int declaration_StartIndex = input.index();
        CommonTree root_0 = null;

        smallcParser.type_return type81 = null;

        smallcParser.declaration_variables_return declaration_variables82 = null;


        RewriteRuleSubtreeStream stream_declaration_variables=new RewriteRuleSubtreeStream(adaptor,"rule declaration_variables");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:178:13: ( type declaration_variables -> ^( DECLARATION type declaration_variables ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:178:15: type declaration_variables
            {
            pushFollow(FOLLOW_type_in_declaration1368);
            type81=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type81.getTree());
            pushFollow(FOLLOW_declaration_variables_in_declaration1370);
            declaration_variables82=declaration_variables();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_declaration_variables.add(declaration_variables82.getTree());


            // AST REWRITE
            // elements: declaration_variables, type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 178:42: -> ^( DECLARATION type declaration_variables )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:178:45: ^( DECLARATION type declaration_variables )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLARATION, "DECLARATION"), root_1);

                adaptor.addChild(root_1, stream_type.nextTree());
                adaptor.addChild(root_1, stream_declaration_variables.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, declaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "declaration"

    public static class declaration_variables_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration_variables"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:179:1: declaration_variables : variable_init ( ',' variable_init )* -> ^( DECLARATION_VARIABLES ( variable_init )+ ) ;
    public final smallcParser.declaration_variables_return declaration_variables() throws RecognitionException {
        smallcParser.declaration_variables_return retval = new smallcParser.declaration_variables_return();
        retval.start = input.LT(1);
        int declaration_variables_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal84=null;
        smallcParser.variable_init_return variable_init83 = null;

        smallcParser.variable_init_return variable_init85 = null;


        CommonTree char_literal84_tree=null;
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_variable_init=new RewriteRuleSubtreeStream(adaptor,"rule variable_init");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:179:23: ( variable_init ( ',' variable_init )* -> ^( DECLARATION_VARIABLES ( variable_init )+ ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:179:25: variable_init ( ',' variable_init )*
            {
            pushFollow(FOLLOW_variable_init_in_declaration_variables1387);
            variable_init83=variable_init();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variable_init.add(variable_init83.getTree());
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:179:39: ( ',' variable_init )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==85) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred39_smallc()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:179:40: ',' variable_init
            	    {
            	    char_literal84=(Token)match(input,85,FOLLOW_85_in_declaration_variables1390); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_85.add(char_literal84);

            	    pushFollow(FOLLOW_variable_init_in_declaration_variables1392);
            	    variable_init85=variable_init();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_variable_init.add(variable_init85.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);



            // AST REWRITE
            // elements: variable_init
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 179:60: -> ^( DECLARATION_VARIABLES ( variable_init )+ )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:179:63: ^( DECLARATION_VARIABLES ( variable_init )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLARATION_VARIABLES, "DECLARATION_VARIABLES"), root_1);

                if ( !(stream_variable_init.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_variable_init.hasNext() ) {
                    adaptor.addChild(root_1, stream_variable_init.nextTree());

                }
                stream_variable_init.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, declaration_variables_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "declaration_variables"

    public static class variable_init_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_init"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:180:1: variable_init : variable_id ( ASSIGN expression )? -> ^( VARIABLE_INIT variable_id ( expression )? ) ;
    public final smallcParser.variable_init_return variable_init() throws RecognitionException {
        smallcParser.variable_init_return retval = new smallcParser.variable_init_return();
        retval.start = input.LT(1);
        int variable_init_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ASSIGN87=null;
        smallcParser.variable_id_return variable_id86 = null;

        smallcParser.expression_return expression88 = null;


        CommonTree ASSIGN87_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_variable_id=new RewriteRuleSubtreeStream(adaptor,"rule variable_id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:180:15: ( variable_id ( ASSIGN expression )? -> ^( VARIABLE_INIT variable_id ( expression )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:180:17: variable_id ( ASSIGN expression )?
            {
            pushFollow(FOLLOW_variable_id_in_variable_init1410);
            variable_id86=variable_id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variable_id.add(variable_id86.getTree());
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:180:29: ( ASSIGN expression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ASSIGN) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:180:30: ASSIGN expression
                    {
                    ASSIGN87=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_variable_init1413); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN87);

                    pushFollow(FOLLOW_expression_in_variable_init1415);
                    expression88=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression88.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: variable_id, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 180:50: -> ^( VARIABLE_INIT variable_id ( expression )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:180:53: ^( VARIABLE_INIT variable_id ( expression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VARIABLE_INIT, "VARIABLE_INIT"), root_1);

                adaptor.addChild(root_1, stream_variable_id.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:180:81: ( expression )?
                if ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.nextTree());

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, variable_init_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "variable_init"

    public static class assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:182:1: assignment : variable_id ASSIGN expression -> ^( ASSIGNMENT variable_id expression ) ;
    public final smallcParser.assignment_return assignment() throws RecognitionException {
        smallcParser.assignment_return retval = new smallcParser.assignment_return();
        retval.start = input.LT(1);
        int assignment_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ASSIGN90=null;
        smallcParser.variable_id_return variable_id89 = null;

        smallcParser.expression_return expression91 = null;


        CommonTree ASSIGN90_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_variable_id=new RewriteRuleSubtreeStream(adaptor,"rule variable_id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:182:12: ( variable_id ASSIGN expression -> ^( ASSIGNMENT variable_id expression ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:182:14: variable_id ASSIGN expression
            {
            pushFollow(FOLLOW_variable_id_in_assignment1440);
            variable_id89=variable_id();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variable_id.add(variable_id89.getTree());
            ASSIGN90=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment1442); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN90);

            pushFollow(FOLLOW_expression_in_assignment1444);
            expression91=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression91.getTree());


            // AST REWRITE
            // elements: expression, variable_id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 182:44: -> ^( ASSIGNMENT variable_id expression )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:182:47: ^( ASSIGNMENT variable_id expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);

                adaptor.addChild(root_1, stream_variable_id.nextTree());
                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, assignment_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class break_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "break_statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:184:1: break_statement : BREAK_WORD SEMICOLON -> BREAK ;
    public final smallcParser.break_statement_return break_statement() throws RecognitionException {
        smallcParser.break_statement_return retval = new smallcParser.break_statement_return();
        retval.start = input.LT(1);
        int break_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token BREAK_WORD92=null;
        Token SEMICOLON93=null;

        CommonTree BREAK_WORD92_tree=null;
        CommonTree SEMICOLON93_tree=null;
        RewriteRuleTokenStream stream_BREAK_WORD=new RewriteRuleTokenStream(adaptor,"token BREAK_WORD");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:184:17: ( BREAK_WORD SEMICOLON -> BREAK )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:184:19: BREAK_WORD SEMICOLON
            {
            BREAK_WORD92=(Token)match(input,BREAK_WORD,FOLLOW_BREAK_WORD_in_break_statement1462); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BREAK_WORD.add(BREAK_WORD92);

            SEMICOLON93=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_break_statement1464); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON93);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 184:40: -> BREAK
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(BREAK, "BREAK"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, break_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "break_statement"

    public static class continue_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "continue_statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:185:1: continue_statement : CONTINUE_WORD SEMICOLON -> CONTINUE ;
    public final smallcParser.continue_statement_return continue_statement() throws RecognitionException {
        smallcParser.continue_statement_return retval = new smallcParser.continue_statement_return();
        retval.start = input.LT(1);
        int continue_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CONTINUE_WORD94=null;
        Token SEMICOLON95=null;

        CommonTree CONTINUE_WORD94_tree=null;
        CommonTree SEMICOLON95_tree=null;
        RewriteRuleTokenStream stream_CONTINUE_WORD=new RewriteRuleTokenStream(adaptor,"token CONTINUE_WORD");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:185:20: ( CONTINUE_WORD SEMICOLON -> CONTINUE )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:185:22: CONTINUE_WORD SEMICOLON
            {
            CONTINUE_WORD94=(Token)match(input,CONTINUE_WORD,FOLLOW_CONTINUE_WORD_in_continue_statement1475); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONTINUE_WORD.add(CONTINUE_WORD94);

            SEMICOLON95=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_continue_statement1477); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON95);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 185:46: -> CONTINUE
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(CONTINUE, "CONTINUE"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, continue_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "continue_statement"

    public static class return_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "return_statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:186:1: return_statement : RETURN_WORD expression SEMICOLON -> ^( RETURN expression ) ;
    public final smallcParser.return_statement_return return_statement() throws RecognitionException {
        smallcParser.return_statement_return retval = new smallcParser.return_statement_return();
        retval.start = input.LT(1);
        int return_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token RETURN_WORD96=null;
        Token SEMICOLON98=null;
        smallcParser.expression_return expression97 = null;


        CommonTree RETURN_WORD96_tree=null;
        CommonTree SEMICOLON98_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_RETURN_WORD=new RewriteRuleTokenStream(adaptor,"token RETURN_WORD");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:186:18: ( RETURN_WORD expression SEMICOLON -> ^( RETURN expression ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:186:20: RETURN_WORD expression SEMICOLON
            {
            RETURN_WORD96=(Token)match(input,RETURN_WORD,FOLLOW_RETURN_WORD_in_return_statement1488); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RETURN_WORD.add(RETURN_WORD96);

            pushFollow(FOLLOW_expression_in_return_statement1490);
            expression97=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression97.getTree());
            SEMICOLON98=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_return_statement1492); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON98);



            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 186:53: -> ^( RETURN expression )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:186:56: ^( RETURN expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURN, "RETURN"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, return_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "return_statement"

    public static class print_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "print_statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:1: print_statement : PRINT_WORD '(' CHARLITERAL ( ',' ( expression | function_call ) )* ')' -> ^( PRINT CHARLITERAL ( expression )* ( function_call )* ) ;
    public final smallcParser.print_statement_return print_statement() throws RecognitionException {
        smallcParser.print_statement_return retval = new smallcParser.print_statement_return();
        retval.start = input.LT(1);
        int print_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token PRINT_WORD99=null;
        Token char_literal100=null;
        Token CHARLITERAL101=null;
        Token char_literal102=null;
        Token char_literal105=null;
        smallcParser.expression_return expression103 = null;

        smallcParser.function_call_return function_call104 = null;


        CommonTree PRINT_WORD99_tree=null;
        CommonTree char_literal100_tree=null;
        CommonTree CHARLITERAL101_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree char_literal105_tree=null;
        RewriteRuleTokenStream stream_PRINT_WORD=new RewriteRuleTokenStream(adaptor,"token PRINT_WORD");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_CHARLITERAL=new RewriteRuleTokenStream(adaptor,"token CHARLITERAL");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_function_call=new RewriteRuleSubtreeStream(adaptor,"rule function_call");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:17: ( PRINT_WORD '(' CHARLITERAL ( ',' ( expression | function_call ) )* ')' -> ^( PRINT CHARLITERAL ( expression )* ( function_call )* ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:19: PRINT_WORD '(' CHARLITERAL ( ',' ( expression | function_call ) )* ')'
            {
            PRINT_WORD99=(Token)match(input,PRINT_WORD,FOLLOW_PRINT_WORD_in_print_statement1507); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PRINT_WORD.add(PRINT_WORD99);

            char_literal100=(Token)match(input,86,FOLLOW_86_in_print_statement1509); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(char_literal100);

            CHARLITERAL101=(Token)match(input,CHARLITERAL,FOLLOW_CHARLITERAL_in_print_statement1511); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CHARLITERAL.add(CHARLITERAL101);

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:46: ( ',' ( expression | function_call ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==85) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:47: ',' ( expression | function_call )
            	    {
            	    char_literal102=(Token)match(input,85,FOLLOW_85_in_print_statement1514); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_85.add(char_literal102);

            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:51: ( expression | function_call )
            	    int alt23=2;
            	    alt23 = dfa23.predict(input);
            	    switch (alt23) {
            	        case 1 :
            	            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:52: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_print_statement1517);
            	            expression103=expression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_expression.add(expression103.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:63: function_call
            	            {
            	            pushFollow(FOLLOW_function_call_in_print_statement1519);
            	            function_call104=function_call();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_function_call.add(function_call104.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            char_literal105=(Token)match(input,87,FOLLOW_87_in_print_statement1524); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal105);



            // AST REWRITE
            // elements: CHARLITERAL, function_call, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 188:3: -> ^( PRINT CHARLITERAL ( expression )* ( function_call )* )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:188:6: ^( PRINT CHARLITERAL ( expression )* ( function_call )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PRINT, "PRINT"), root_1);

                adaptor.addChild(root_1, stream_CHARLITERAL.nextNode());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:188:26: ( expression )*
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.nextTree());

                }
                stream_expression.reset();
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:188:38: ( function_call )*
                while ( stream_function_call.hasNext() ) {
                    adaptor.addChild(root_1, stream_function_call.nextTree());

                }
                stream_function_call.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, print_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "print_statement"

    public static class read_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "read_statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:189:1: read_statement : READ_WORD '(' CHARLITERAL ',' variable_list ')' -> ^( READ CHARLITERAL variable_list ) ;
    public final smallcParser.read_statement_return read_statement() throws RecognitionException {
        smallcParser.read_statement_return retval = new smallcParser.read_statement_return();
        retval.start = input.LT(1);
        int read_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token READ_WORD106=null;
        Token char_literal107=null;
        Token CHARLITERAL108=null;
        Token char_literal109=null;
        Token char_literal111=null;
        smallcParser.variable_list_return variable_list110 = null;


        CommonTree READ_WORD106_tree=null;
        CommonTree char_literal107_tree=null;
        CommonTree CHARLITERAL108_tree=null;
        CommonTree char_literal109_tree=null;
        CommonTree char_literal111_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_READ_WORD=new RewriteRuleTokenStream(adaptor,"token READ_WORD");
        RewriteRuleTokenStream stream_CHARLITERAL=new RewriteRuleTokenStream(adaptor,"token CHARLITERAL");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_variable_list=new RewriteRuleSubtreeStream(adaptor,"rule variable_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:189:16: ( READ_WORD '(' CHARLITERAL ',' variable_list ')' -> ^( READ CHARLITERAL variable_list ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:189:18: READ_WORD '(' CHARLITERAL ',' variable_list ')'
            {
            READ_WORD106=(Token)match(input,READ_WORD,FOLLOW_READ_WORD_in_read_statement1547); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_READ_WORD.add(READ_WORD106);

            char_literal107=(Token)match(input,86,FOLLOW_86_in_read_statement1549); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(char_literal107);

            CHARLITERAL108=(Token)match(input,CHARLITERAL,FOLLOW_CHARLITERAL_in_read_statement1551); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CHARLITERAL.add(CHARLITERAL108);

            char_literal109=(Token)match(input,85,FOLLOW_85_in_read_statement1553); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_85.add(char_literal109);

            pushFollow(FOLLOW_variable_list_in_read_statement1555);
            variable_list110=variable_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variable_list.add(variable_list110.getTree());
            char_literal111=(Token)match(input,87,FOLLOW_87_in_read_statement1557); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal111);



            // AST REWRITE
            // elements: variable_list, CHARLITERAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 190:3: -> ^( READ CHARLITERAL variable_list )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:190:6: ^( READ CHARLITERAL variable_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(READ, "READ"), root_1);

                adaptor.addChild(root_1, stream_CHARLITERAL.nextNode());
                adaptor.addChild(root_1, stream_variable_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, read_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "read_statement"

    public static class if_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:192:1: if_statement : IF_WORD '(' expression ')' i= statement ( ELSE_WORD e= statement )? -> ^( IF expression $i ( $e)? ) ;
    public final smallcParser.if_statement_return if_statement() throws RecognitionException {
        smallcParser.if_statement_return retval = new smallcParser.if_statement_return();
        retval.start = input.LT(1);
        int if_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IF_WORD112=null;
        Token char_literal113=null;
        Token char_literal115=null;
        Token ELSE_WORD116=null;
        smallcParser.statement_return i = null;

        smallcParser.statement_return e = null;

        smallcParser.expression_return expression114 = null;


        CommonTree IF_WORD112_tree=null;
        CommonTree char_literal113_tree=null;
        CommonTree char_literal115_tree=null;
        CommonTree ELSE_WORD116_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_ELSE_WORD=new RewriteRuleTokenStream(adaptor,"token ELSE_WORD");
        RewriteRuleTokenStream stream_IF_WORD=new RewriteRuleTokenStream(adaptor,"token IF_WORD");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:192:14: ( IF_WORD '(' expression ')' i= statement ( ELSE_WORD e= statement )? -> ^( IF expression $i ( $e)? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:192:16: IF_WORD '(' expression ')' i= statement ( ELSE_WORD e= statement )?
            {
            IF_WORD112=(Token)match(input,IF_WORD,FOLLOW_IF_WORD_in_if_statement1577); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IF_WORD.add(IF_WORD112);

            char_literal113=(Token)match(input,86,FOLLOW_86_in_if_statement1579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(char_literal113);

            pushFollow(FOLLOW_expression_in_if_statement1581);
            expression114=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression114.getTree());
            char_literal115=(Token)match(input,87,FOLLOW_87_in_if_statement1583); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal115);

            pushFollow(FOLLOW_statement_in_if_statement1587);
            i=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(i.getTree());
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:192:55: ( ELSE_WORD e= statement )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ELSE_WORD) ) {
                int LA25_1 = input.LA(2);

                if ( (synpred43_smallc()) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:192:56: ELSE_WORD e= statement
                    {
                    ELSE_WORD116=(Token)match(input,ELSE_WORD,FOLLOW_ELSE_WORD_in_if_statement1590); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ELSE_WORD.add(ELSE_WORD116);

                    pushFollow(FOLLOW_statement_in_if_statement1594);
                    e=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(e.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: e, i, expression
            // token labels: 
            // rule labels: retval, e, i
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.tree:null);
            RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 193:3: -> ^( IF expression $i ( $e)? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:193:6: ^( IF expression $i ( $e)? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF, "IF"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_i.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:193:25: ( $e)?
                if ( stream_e.hasNext() ) {
                    adaptor.addChild(root_1, stream_e.nextTree());

                }
                stream_e.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, if_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "if_statement"

    public static class while_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "while_statement"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:194:1: while_statement : WHILE_WORD '(' expression ')' statement -> ^( WHILE expression statement ) ;
    public final smallcParser.while_statement_return while_statement() throws RecognitionException {
        smallcParser.while_statement_return retval = new smallcParser.while_statement_return();
        retval.start = input.LT(1);
        int while_statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token WHILE_WORD117=null;
        Token char_literal118=null;
        Token char_literal120=null;
        smallcParser.expression_return expression119 = null;

        smallcParser.statement_return statement121 = null;


        CommonTree WHILE_WORD117_tree=null;
        CommonTree char_literal118_tree=null;
        CommonTree char_literal120_tree=null;
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_WHILE_WORD=new RewriteRuleTokenStream(adaptor,"token WHILE_WORD");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:194:17: ( WHILE_WORD '(' expression ')' statement -> ^( WHILE expression statement ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:194:19: WHILE_WORD '(' expression ')' statement
            {
            WHILE_WORD117=(Token)match(input,WHILE_WORD,FOLLOW_WHILE_WORD_in_while_statement1620); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHILE_WORD.add(WHILE_WORD117);

            char_literal118=(Token)match(input,86,FOLLOW_86_in_while_statement1622); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_86.add(char_literal118);

            pushFollow(FOLLOW_expression_in_while_statement1624);
            expression119=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression119.getTree());
            char_literal120=(Token)match(input,87,FOLLOW_87_in_while_statement1626); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_87.add(char_literal120);

            pushFollow(FOLLOW_statement_in_while_statement1628);
            statement121=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement121.getTree());


            // AST REWRITE
            // elements: statement, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 195:3: -> ^( WHILE expression statement )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:195:6: ^( WHILE expression statement )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, while_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "while_statement"

    public static class array_index_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array_index"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:197:1: array_index : '[' simple_expression ']' -> ^( ARRAY_INDEX simple_expression ) ;
    public final smallcParser.array_index_return array_index() throws RecognitionException {
        smallcParser.array_index_return retval = new smallcParser.array_index_return();
        retval.start = input.LT(1);
        int array_index_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal122=null;
        Token char_literal124=null;
        smallcParser.simple_expression_return simple_expression123 = null;


        CommonTree char_literal122_tree=null;
        CommonTree char_literal124_tree=null;
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleSubtreeStream stream_simple_expression=new RewriteRuleSubtreeStream(adaptor,"rule simple_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:197:13: ( '[' simple_expression ']' -> ^( ARRAY_INDEX simple_expression ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:197:15: '[' simple_expression ']'
            {
            char_literal122=(Token)match(input,91,FOLLOW_91_in_array_index1648); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_91.add(char_literal122);

            pushFollow(FOLLOW_simple_expression_in_array_index1650);
            simple_expression123=simple_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_simple_expression.add(simple_expression123.getTree());
            char_literal124=(Token)match(input,92,FOLLOW_92_in_array_index1652); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_92.add(char_literal124);



            // AST REWRITE
            // elements: simple_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 197:41: -> ^( ARRAY_INDEX simple_expression )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:197:44: ^( ARRAY_INDEX simple_expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_INDEX, "ARRAY_INDEX"), root_1);

                adaptor.addChild(root_1, stream_simple_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, array_index_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "array_index"

    public static class array_init_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array_init"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:198:1: array_init : '{' expression ( ',' expression )* '}' -> ^( ARRAY_INIT ( expression )* ) ;
    public final smallcParser.array_init_return array_init() throws RecognitionException {
        smallcParser.array_init_return retval = new smallcParser.array_init_return();
        retval.start = input.LT(1);
        int array_init_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal125=null;
        Token char_literal127=null;
        Token char_literal129=null;
        smallcParser.expression_return expression126 = null;

        smallcParser.expression_return expression128 = null;


        CommonTree char_literal125_tree=null;
        CommonTree char_literal127_tree=null;
        CommonTree char_literal129_tree=null;
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:198:12: ( '{' expression ( ',' expression )* '}' -> ^( ARRAY_INIT ( expression )* ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:198:14: '{' expression ( ',' expression )* '}'
            {
            char_literal125=(Token)match(input,89,FOLLOW_89_in_array_init1667); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_89.add(char_literal125);

            pushFollow(FOLLOW_expression_in_array_init1669);
            expression126=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression126.getTree());
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:198:29: ( ',' expression )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==85) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:198:30: ',' expression
            	    {
            	    char_literal127=(Token)match(input,85,FOLLOW_85_in_array_init1672); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_85.add(char_literal127);

            	    pushFollow(FOLLOW_expression_in_array_init1674);
            	    expression128=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expression.add(expression128.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            char_literal129=(Token)match(input,90,FOLLOW_90_in_array_init1678); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_90.add(char_literal129);



            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 199:3: -> ^( ARRAY_INIT ( expression )* )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:199:6: ^( ARRAY_INIT ( expression )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_INIT, "ARRAY_INIT"), root_1);

                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:199:19: ( expression )*
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.nextTree());

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, array_init_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "array_init"

    public static class condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condition"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:1: condition : ( disjunction ) ( '?' expression ':' condition )? -> ^( CONDITION disjunction ( expression condition )? ) ;
    public final smallcParser.condition_return condition() throws RecognitionException {
        smallcParser.condition_return retval = new smallcParser.condition_return();
        retval.start = input.LT(1);
        int condition_StartIndex = input.index();
        CommonTree root_0 = null;

        Token char_literal131=null;
        Token char_literal133=null;
        smallcParser.disjunction_return disjunction130 = null;

        smallcParser.expression_return expression132 = null;

        smallcParser.condition_return condition134 = null;


        CommonTree char_literal131_tree=null;
        CommonTree char_literal133_tree=null;
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        RewriteRuleSubtreeStream stream_disjunction=new RewriteRuleSubtreeStream(adaptor,"rule disjunction");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:11: ( ( disjunction ) ( '?' expression ':' condition )? -> ^( CONDITION disjunction ( expression condition )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:13: ( disjunction ) ( '?' expression ':' condition )?
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:13: ( disjunction )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:14: disjunction
            {
            pushFollow(FOLLOW_disjunction_in_condition1698);
            disjunction130=disjunction();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_disjunction.add(disjunction130.getTree());

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:27: ( '?' expression ':' condition )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==93) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:28: '?' expression ':' condition
                    {
                    char_literal131=(Token)match(input,93,FOLLOW_93_in_condition1702); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_93.add(char_literal131);

                    pushFollow(FOLLOW_expression_in_condition1704);
                    expression132=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression132.getTree());
                    char_literal133=(Token)match(input,94,FOLLOW_94_in_condition1706); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_94.add(char_literal133);

                    pushFollow(FOLLOW_condition_in_condition1708);
                    condition134=condition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_condition.add(condition134.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: expression, condition, disjunction
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 201:59: -> ^( CONDITION disjunction ( expression condition )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:62: ^( CONDITION disjunction ( expression condition )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITION, "CONDITION"), root_1);

                adaptor.addChild(root_1, stream_disjunction.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:201:86: ( expression condition )?
                if ( stream_expression.hasNext()||stream_condition.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.nextTree());
                    adaptor.addChild(root_1, stream_condition.nextTree());

                }
                stream_expression.reset();
                stream_condition.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, condition_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "condition"

    public static class disjunction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "disjunction"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:202:1: disjunction : ( conjunction ) ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) ;
    public final smallcParser.disjunction_return disjunction() throws RecognitionException {
        smallcParser.disjunction_return retval = new smallcParser.disjunction_return();
        retval.start = input.LT(1);
        int disjunction_StartIndex = input.index();
        CommonTree root_0 = null;

        Token OR136=null;
        smallcParser.conjunction_return conjunction135 = null;

        smallcParser.conjunction_return conjunction137 = null;


        CommonTree OR136_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_conjunction=new RewriteRuleSubtreeStream(adaptor,"rule conjunction");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:202:13: ( ( conjunction ) ( OR conjunction )* -> ^( DISJUNCTION ( conjunction )+ ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:202:15: ( conjunction ) ( OR conjunction )*
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:202:15: ( conjunction )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:202:16: conjunction
            {
            pushFollow(FOLLOW_conjunction_in_disjunction1733);
            conjunction135=conjunction();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_conjunction.add(conjunction135.getTree());

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:202:29: ( OR conjunction )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==OR) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:202:30: OR conjunction
            	    {
            	    OR136=(Token)match(input,OR,FOLLOW_OR_in_disjunction1737); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_OR.add(OR136);

            	    pushFollow(FOLLOW_conjunction_in_disjunction1739);
            	    conjunction137=conjunction();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_conjunction.add(conjunction137.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);



            // AST REWRITE
            // elements: conjunction
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 202:47: -> ^( DISJUNCTION ( conjunction )+ )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:202:50: ^( DISJUNCTION ( conjunction )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DISJUNCTION, "DISJUNCTION"), root_1);

                if ( !(stream_conjunction.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_conjunction.hasNext() ) {
                    adaptor.addChild(root_1, stream_conjunction.nextTree());

                }
                stream_conjunction.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, disjunction_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "disjunction"

    public static class conjunction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conjunction"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:203:1: conjunction : ( comparison ) ( AND comparison )* -> ^( CONJUNCTION ( comparison )+ ) ;
    public final smallcParser.conjunction_return conjunction() throws RecognitionException {
        smallcParser.conjunction_return retval = new smallcParser.conjunction_return();
        retval.start = input.LT(1);
        int conjunction_StartIndex = input.index();
        CommonTree root_0 = null;

        Token AND139=null;
        smallcParser.comparison_return comparison138 = null;

        smallcParser.comparison_return comparison140 = null;


        CommonTree AND139_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_comparison=new RewriteRuleSubtreeStream(adaptor,"rule comparison");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:203:13: ( ( comparison ) ( AND comparison )* -> ^( CONJUNCTION ( comparison )+ ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:203:15: ( comparison ) ( AND comparison )*
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:203:15: ( comparison )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:203:16: comparison
            {
            pushFollow(FOLLOW_comparison_in_conjunction1758);
            comparison138=comparison();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_comparison.add(comparison138.getTree());

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:203:28: ( AND comparison )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==AND) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:203:29: AND comparison
            	    {
            	    AND139=(Token)match(input,AND,FOLLOW_AND_in_conjunction1762); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND139);

            	    pushFollow(FOLLOW_comparison_in_conjunction1764);
            	    comparison140=comparison();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_comparison.add(comparison140.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);



            // AST REWRITE
            // elements: comparison
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 203:46: -> ^( CONJUNCTION ( comparison )+ )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:203:49: ^( CONJUNCTION ( comparison )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONJUNCTION, "CONJUNCTION"), root_1);

                if ( !(stream_comparison.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_comparison.hasNext() ) {
                    adaptor.addChild(root_1, stream_comparison.nextTree());

                }
                stream_comparison.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, conjunction_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "conjunction"

    public static class comparison_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparison"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:1: comparison : (a= relation ) ( (e= EQUAL | e= NONEQUAL ) b= relation )? -> ^( COMPARISON $a ( $e $b)? ) ;
    public final smallcParser.comparison_return comparison() throws RecognitionException {
        smallcParser.comparison_return retval = new smallcParser.comparison_return();
        retval.start = input.LT(1);
        int comparison_StartIndex = input.index();
        CommonTree root_0 = null;

        Token e=null;
        smallcParser.relation_return a = null;

        smallcParser.relation_return b = null;


        CommonTree e_tree=null;
        RewriteRuleTokenStream stream_NONEQUAL=new RewriteRuleTokenStream(adaptor,"token NONEQUAL");
        RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
        RewriteRuleSubtreeStream stream_relation=new RewriteRuleSubtreeStream(adaptor,"rule relation");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:12: ( (a= relation ) ( (e= EQUAL | e= NONEQUAL ) b= relation )? -> ^( COMPARISON $a ( $e $b)? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:14: (a= relation ) ( (e= EQUAL | e= NONEQUAL ) b= relation )?
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:14: (a= relation )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:15: a= relation
            {
            pushFollow(FOLLOW_relation_in_comparison1785);
            a=relation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_relation.add(a.getTree());

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:27: ( (e= EQUAL | e= NONEQUAL ) b= relation )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=EQUAL && LA31_0<=NONEQUAL)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:28: (e= EQUAL | e= NONEQUAL ) b= relation
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:28: (e= EQUAL | e= NONEQUAL )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==EQUAL) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==NONEQUAL) ) {
                        alt30=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:29: e= EQUAL
                            {
                            e=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_comparison1792); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUAL.add(e);


                            }
                            break;
                        case 2 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:37: e= NONEQUAL
                            {
                            e=(Token)match(input,NONEQUAL,FOLLOW_NONEQUAL_in_comparison1796); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_NONEQUAL.add(e);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_relation_in_comparison1801);
                    b=relation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_relation.add(b.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: b, a, e
            // token labels: e
            // rule labels: retval, b, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_e=new RewriteRuleTokenStream(adaptor,"token e",e);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 204:62: -> ^( COMPARISON $a ( $e $b)? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:65: ^( COMPARISON $a ( $e $b)? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(COMPARISON, "COMPARISON"), root_1);

                adaptor.addChild(root_1, stream_a.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:204:81: ( $e $b)?
                if ( stream_b.hasNext()||stream_e.hasNext() ) {
                    adaptor.addChild(root_1, stream_e.nextNode());
                    adaptor.addChild(root_1, stream_b.nextTree());

                }
                stream_b.reset();
                stream_e.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, comparison_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "comparison"

    public static class relation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:1: relation : ( sum ) ( (e= ST | e= GT | e= STEQ | e= GTEQ ) relation )? -> ^( RELATION sum ( $e relation )? ) ;
    public final smallcParser.relation_return relation() throws RecognitionException {
        smallcParser.relation_return retval = new smallcParser.relation_return();
        retval.start = input.LT(1);
        int relation_StartIndex = input.index();
        CommonTree root_0 = null;

        Token e=null;
        smallcParser.sum_return sum141 = null;

        smallcParser.relation_return relation142 = null;


        CommonTree e_tree=null;
        RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
        RewriteRuleTokenStream stream_ST=new RewriteRuleTokenStream(adaptor,"token ST");
        RewriteRuleTokenStream stream_STEQ=new RewriteRuleTokenStream(adaptor,"token STEQ");
        RewriteRuleTokenStream stream_GTEQ=new RewriteRuleTokenStream(adaptor,"token GTEQ");
        RewriteRuleSubtreeStream stream_relation=new RewriteRuleSubtreeStream(adaptor,"rule relation");
        RewriteRuleSubtreeStream stream_sum=new RewriteRuleSubtreeStream(adaptor,"rule sum");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:10: ( ( sum ) ( (e= ST | e= GT | e= STEQ | e= GTEQ ) relation )? -> ^( RELATION sum ( $e relation )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:12: ( sum ) ( (e= ST | e= GT | e= STEQ | e= GTEQ ) relation )?
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:12: ( sum )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:13: sum
            {
            pushFollow(FOLLOW_sum_in_relation1829);
            sum141=sum();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sum.add(sum141.getTree());

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:18: ( (e= ST | e= GT | e= STEQ | e= GTEQ ) relation )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=ST && LA33_0<=GTEQ)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:19: (e= ST | e= GT | e= STEQ | e= GTEQ ) relation
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:19: (e= ST | e= GT | e= STEQ | e= GTEQ )
                    int alt32=4;
                    switch ( input.LA(1) ) {
                    case ST:
                        {
                        alt32=1;
                        }
                        break;
                    case GT:
                        {
                        alt32=2;
                        }
                        break;
                    case STEQ:
                        {
                        alt32=3;
                        }
                        break;
                    case GTEQ:
                        {
                        alt32=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }

                    switch (alt32) {
                        case 1 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:20: e= ST
                            {
                            e=(Token)match(input,ST,FOLLOW_ST_in_relation1836); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ST.add(e);


                            }
                            break;
                        case 2 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:27: e= GT
                            {
                            e=(Token)match(input,GT,FOLLOW_GT_in_relation1842); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_GT.add(e);


                            }
                            break;
                        case 3 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:34: e= STEQ
                            {
                            e=(Token)match(input,STEQ,FOLLOW_STEQ_in_relation1848); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_STEQ.add(e);


                            }
                            break;
                        case 4 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:43: e= GTEQ
                            {
                            e=(Token)match(input,GTEQ,FOLLOW_GTEQ_in_relation1854); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_GTEQ.add(e);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_relation_in_relation1857);
                    relation142=relation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_relation.add(relation142.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: e, sum, relation
            // token labels: e
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_e=new RewriteRuleTokenStream(adaptor,"token e",e);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 205:62: -> ^( RELATION sum ( $e relation )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:65: ^( RELATION sum ( $e relation )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RELATION, "RELATION"), root_1);

                adaptor.addChild(root_1, stream_sum.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:205:80: ( $e relation )?
                if ( stream_e.hasNext()||stream_relation.hasNext() ) {
                    adaptor.addChild(root_1, stream_e.nextNode());
                    adaptor.addChild(root_1, stream_relation.nextTree());

                }
                stream_e.reset();
                stream_relation.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, relation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "relation"

    public static class sum_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sum"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:1: sum : ( term ) ( (e= PLUS | e= MINUS ) sum )? -> ^( SUM term ( $e sum )? ) ;
    public final smallcParser.sum_return sum() throws RecognitionException {
        smallcParser.sum_return retval = new smallcParser.sum_return();
        retval.start = input.LT(1);
        int sum_StartIndex = input.index();
        CommonTree root_0 = null;

        Token e=null;
        smallcParser.term_return term143 = null;

        smallcParser.sum_return sum144 = null;


        CommonTree e_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
        RewriteRuleSubtreeStream stream_sum=new RewriteRuleSubtreeStream(adaptor,"rule sum");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:5: ( ( term ) ( (e= PLUS | e= MINUS ) sum )? -> ^( SUM term ( $e sum )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:7: ( term ) ( (e= PLUS | e= MINUS ) sum )?
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:7: ( term )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:8: term
            {
            pushFollow(FOLLOW_term_in_sum1883);
            term143=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_term.add(term143.getTree());

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:14: ( (e= PLUS | e= MINUS ) sum )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=PLUS && LA35_0<=MINUS)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:15: (e= PLUS | e= MINUS ) sum
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:15: (e= PLUS | e= MINUS )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==PLUS) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==MINUS) ) {
                        alt34=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:16: e= PLUS
                            {
                            e=(Token)match(input,PLUS,FOLLOW_PLUS_in_sum1890); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PLUS.add(e);


                            }
                            break;
                        case 2 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:23: e= MINUS
                            {
                            e=(Token)match(input,MINUS,FOLLOW_MINUS_in_sum1894); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MINUS.add(e);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_sum_in_sum1897);
                    sum144=sum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_sum.add(sum144.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: term, sum, e
            // token labels: e
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_e=new RewriteRuleTokenStream(adaptor,"token e",e);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 206:38: -> ^( SUM term ( $e sum )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:41: ^( SUM term ( $e sum )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUM, "SUM"), root_1);

                adaptor.addChild(root_1, stream_term.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:206:52: ( $e sum )?
                if ( stream_sum.hasNext()||stream_e.hasNext() ) {
                    adaptor.addChild(root_1, stream_e.nextNode());
                    adaptor.addChild(root_1, stream_sum.nextTree());

                }
                stream_sum.reset();
                stream_e.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, sum_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "sum"

    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:1: term : ( factor ) ( (e= MULT | e= DIV | e= MOD ) term )? -> ^( TERM factor ( $e term )? ) ;
    public final smallcParser.term_return term() throws RecognitionException {
        smallcParser.term_return retval = new smallcParser.term_return();
        retval.start = input.LT(1);
        int term_StartIndex = input.index();
        CommonTree root_0 = null;

        Token e=null;
        smallcParser.factor_return factor145 = null;

        smallcParser.term_return term146 = null;


        CommonTree e_tree=null;
        RewriteRuleTokenStream stream_MULT=new RewriteRuleTokenStream(adaptor,"token MULT");
        RewriteRuleTokenStream stream_DIV=new RewriteRuleTokenStream(adaptor,"token DIV");
        RewriteRuleTokenStream stream_MOD=new RewriteRuleTokenStream(adaptor,"token MOD");
        RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
        RewriteRuleSubtreeStream stream_factor=new RewriteRuleSubtreeStream(adaptor,"rule factor");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:5: ( ( factor ) ( (e= MULT | e= DIV | e= MOD ) term )? -> ^( TERM factor ( $e term )? ) )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:7: ( factor ) ( (e= MULT | e= DIV | e= MOD ) term )?
            {
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:7: ( factor )
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:8: factor
            {
            pushFollow(FOLLOW_factor_in_term1922);
            factor145=factor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_factor.add(factor145.getTree());

            }

            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:16: ( (e= MULT | e= DIV | e= MOD ) term )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=MULT && LA37_0<=DIV)||LA37_0==MOD) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:17: (e= MULT | e= DIV | e= MOD ) term
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:17: (e= MULT | e= DIV | e= MOD )
                    int alt36=3;
                    switch ( input.LA(1) ) {
                    case MULT:
                        {
                        alt36=1;
                        }
                        break;
                    case DIV:
                        {
                        alt36=2;
                        }
                        break;
                    case MOD:
                        {
                        alt36=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }

                    switch (alt36) {
                        case 1 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:18: e= MULT
                            {
                            e=(Token)match(input,MULT,FOLLOW_MULT_in_term1929); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MULT.add(e);


                            }
                            break;
                        case 2 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:25: e= DIV
                            {
                            e=(Token)match(input,DIV,FOLLOW_DIV_in_term1933); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DIV.add(e);


                            }
                            break;
                        case 3 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:31: e= MOD
                            {
                            e=(Token)match(input,MOD,FOLLOW_MOD_in_term1937); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MOD.add(e);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_term_in_term1940);
                    term146=term();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_term.add(term146.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: e, factor, term
            // token labels: e
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_e=new RewriteRuleTokenStream(adaptor,"token e",e);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 207:45: -> ^( TERM factor ( $e term )? )
            {
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:48: ^( TERM factor ( $e term )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TERM, "TERM"), root_1);

                adaptor.addChild(root_1, stream_factor.nextTree());
                // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:207:62: ( $e term )?
                if ( stream_e.hasNext()||stream_term.hasNext() ) {
                    adaptor.addChild(root_1, stream_e.nextNode());
                    adaptor.addChild(root_1, stream_term.nextTree());

                }
                stream_e.reset();
                stream_term.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, term_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class factor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:1: factor : ( ( (e= NOT | e= MINUS ) factor ) -> ^( FACTOR $e factor ) | atom -> ^( FACTOR ( atom )? ) );
    public final smallcParser.factor_return factor() throws RecognitionException {
        smallcParser.factor_return retval = new smallcParser.factor_return();
        retval.start = input.LT(1);
        int factor_StartIndex = input.index();
        CommonTree root_0 = null;

        Token e=null;
        smallcParser.factor_return factor147 = null;

        smallcParser.atom_return atom148 = null;


        CommonTree e_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        RewriteRuleSubtreeStream stream_factor=new RewriteRuleSubtreeStream(adaptor,"rule factor");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:8: ( ( (e= NOT | e= MINUS ) factor ) -> ^( FACTOR $e factor ) | atom -> ^( FACTOR ( atom )? ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==MINUS||LA39_0==NOT) ) {
                alt39=1;
            }
            else if ( (LA39_0==IDENTIFIER||(LA39_0>=CHARLITERAL && LA39_0<=INTEGER)||LA39_0==86) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:10: ( (e= NOT | e= MINUS ) factor )
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:10: ( (e= NOT | e= MINUS ) factor )
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:11: (e= NOT | e= MINUS ) factor
                    {
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:11: (e= NOT | e= MINUS )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==NOT) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==MINUS) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:12: e= NOT
                            {
                            e=(Token)match(input,NOT,FOLLOW_NOT_in_factor1969); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_NOT.add(e);


                            }
                            break;
                        case 2 :
                            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:18: e= MINUS
                            {
                            e=(Token)match(input,MINUS,FOLLOW_MINUS_in_factor1973); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MINUS.add(e);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_factor_in_factor1976);
                    factor147=factor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_factor.add(factor147.getTree());

                    }



                    // AST REWRITE
                    // elements: e, factor
                    // token labels: e
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_e=new RewriteRuleTokenStream(adaptor,"token e",e);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 208:35: -> ^( FACTOR $e factor )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:38: ^( FACTOR $e factor )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FACTOR, "FACTOR"), root_1);

                        adaptor.addChild(root_1, stream_e.nextNode());
                        adaptor.addChild(root_1, stream_factor.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:60: atom
                    {
                    pushFollow(FOLLOW_atom_in_factor1992);
                    atom148=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom148.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 208:65: -> ^( FACTOR ( atom )? )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:68: ^( FACTOR ( atom )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FACTOR, "FACTOR"), root_1);

                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:208:77: ( atom )?
                        if ( stream_atom.hasNext() ) {
                            adaptor.addChild(root_1, stream_atom.nextTree());

                        }
                        stream_atom.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, factor_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "factor"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:1: atom : ( DECIMAL -> ^( ATOM DECIMAL ) | INTEGER -> ^( ATOM INTEGER ) | variable_id -> ^( ATOM variable_id ) | function_call -> ^( ATOM function_call ) | '(' expression ')' -> ^( ATOM expression ) | CHARLITERAL -> ^( ATOM CHARLITERAL ) );
    public final smallcParser.atom_return atom() throws RecognitionException {
        smallcParser.atom_return retval = new smallcParser.atom_return();
        retval.start = input.LT(1);
        int atom_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DECIMAL149=null;
        Token INTEGER150=null;
        Token char_literal153=null;
        Token char_literal155=null;
        Token CHARLITERAL156=null;
        smallcParser.variable_id_return variable_id151 = null;

        smallcParser.function_call_return function_call152 = null;

        smallcParser.expression_return expression154 = null;


        CommonTree DECIMAL149_tree=null;
        CommonTree INTEGER150_tree=null;
        CommonTree char_literal153_tree=null;
        CommonTree char_literal155_tree=null;
        CommonTree CHARLITERAL156_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleTokenStream stream_DECIMAL=new RewriteRuleTokenStream(adaptor,"token DECIMAL");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_CHARLITERAL=new RewriteRuleTokenStream(adaptor,"token CHARLITERAL");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_function_call=new RewriteRuleSubtreeStream(adaptor,"rule function_call");
        RewriteRuleSubtreeStream stream_variable_id=new RewriteRuleSubtreeStream(adaptor,"rule variable_id");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:6: ( DECIMAL -> ^( ATOM DECIMAL ) | INTEGER -> ^( ATOM INTEGER ) | variable_id -> ^( ATOM variable_id ) | function_call -> ^( ATOM function_call ) | '(' expression ')' -> ^( ATOM expression ) | CHARLITERAL -> ^( ATOM CHARLITERAL ) )
            int alt40=6;
            switch ( input.LA(1) ) {
            case DECIMAL:
                {
                alt40=1;
                }
                break;
            case INTEGER:
                {
                alt40=2;
                }
                break;
            case IDENTIFIER:
                {
                int LA40_3 = input.LA(2);

                if ( (LA40_3==EOF||(LA40_3>=PLUS && LA40_3<=DIV)||LA40_3==SEMICOLON||(LA40_3>=ST && LA40_3<=MOD)||LA40_3==85||LA40_3==87||(LA40_3>=90 && LA40_3<=94)) ) {
                    alt40=3;
                }
                else if ( (LA40_3==86) ) {
                    alt40=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 3, input);

                    throw nvae;
                }
                }
                break;
            case 86:
                {
                alt40=5;
                }
                break;
            case CHARLITERAL:
                {
                alt40=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:8: DECIMAL
                    {
                    DECIMAL149=(Token)match(input,DECIMAL,FOLLOW_DECIMAL_in_atom2009); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DECIMAL.add(DECIMAL149);



                    // AST REWRITE
                    // elements: DECIMAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 210:16: -> ^( ATOM DECIMAL )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:19: ^( ATOM DECIMAL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATOM, "ATOM"), root_1);

                        adaptor.addChild(root_1, stream_DECIMAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:37: INTEGER
                    {
                    INTEGER150=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_atom2021); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER150);



                    // AST REWRITE
                    // elements: INTEGER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 210:45: -> ^( ATOM INTEGER )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:48: ^( ATOM INTEGER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATOM, "ATOM"), root_1);

                        adaptor.addChild(root_1, stream_INTEGER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:66: variable_id
                    {
                    pushFollow(FOLLOW_variable_id_in_atom2033);
                    variable_id151=variable_id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_variable_id.add(variable_id151.getTree());


                    // AST REWRITE
                    // elements: variable_id
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 210:78: -> ^( ATOM variable_id )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:81: ^( ATOM variable_id )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATOM, "ATOM"), root_1);

                        adaptor.addChild(root_1, stream_variable_id.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:103: function_call
                    {
                    pushFollow(FOLLOW_function_call_in_atom2045);
                    function_call152=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_function_call.add(function_call152.getTree());


                    // AST REWRITE
                    // elements: function_call
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 210:117: -> ^( ATOM function_call )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:120: ^( ATOM function_call )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATOM, "ATOM"), root_1);

                        adaptor.addChild(root_1, stream_function_call.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:144: '(' expression ')'
                    {
                    char_literal153=(Token)match(input,86,FOLLOW_86_in_atom2057); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_86.add(char_literal153);

                    pushFollow(FOLLOW_expression_in_atom2059);
                    expression154=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression154.getTree());
                    char_literal155=(Token)match(input,87,FOLLOW_87_in_atom2061); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_87.add(char_literal155);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 210:163: -> ^( ATOM expression )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:166: ^( ATOM expression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATOM, "ATOM"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:187: CHARLITERAL
                    {
                    CHARLITERAL156=(Token)match(input,CHARLITERAL,FOLLOW_CHARLITERAL_in_atom2073); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHARLITERAL.add(CHARLITERAL156);



                    // AST REWRITE
                    // elements: CHARLITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 210:199: -> ^( ATOM CHARLITERAL )
                    {
                        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:210:202: ^( ATOM CHARLITERAL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ATOM, "ATOM"), root_1);

                        adaptor.addChild(root_1, stream_CHARLITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, atom_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "atom"

    // $ANTLR start synpred13_smallc
    public final void synpred13_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:25: ( type )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:144:25: type
        {
        pushFollow(FOLLOW_type_in_synpred13_smallc775);
        type();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_smallc

    // $ANTLR start synpred27_smallc
    public final void synpred27_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:163:17: ( function_call SEMICOLON )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:163:17: function_call SEMICOLON
        {
        pushFollow(FOLLOW_function_call_in_synpred27_smallc1096);
        function_call();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred27_smallc1098); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_smallc

    // $ANTLR start synpred30_smallc
    public final void synpred30_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:166:17: ( compound_statement )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:166:17: compound_statement
        {
        pushFollow(FOLLOW_compound_statement_in_synpred30_smallc1156);
        compound_statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_smallc

    // $ANTLR start synpred31_smallc
    public final void synpred31_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:167:17: ( expression SEMICOLON )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:167:17: expression SEMICOLON
        {
        pushFollow(FOLLOW_expression_in_synpred31_smallc1174);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred31_smallc1176); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_smallc

    // $ANTLR start synpred32_smallc
    public final void synpred32_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:168:17: ( declaration SEMICOLON )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:168:17: declaration SEMICOLON
        {
        pushFollow(FOLLOW_declaration_in_synpred32_smallc1198);
        declaration();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred32_smallc1200); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_smallc

    // $ANTLR start synpred34_smallc
    public final void synpred34_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:15: ( assignment )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:15: assignment
        {
        pushFollow(FOLLOW_assignment_in_synpred34_smallc1275);
        assignment();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_smallc

    // $ANTLR start synpred35_smallc
    public final void synpred35_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:28: ( simple_expression )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:172:28: simple_expression
        {
        pushFollow(FOLLOW_simple_expression_in_synpred35_smallc1279);
        simple_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_smallc

    // $ANTLR start synpred37_smallc
    public final void synpred37_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:174:17: ( condition )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:174:17: condition
        {
        pushFollow(FOLLOW_condition_in_synpred37_smallc1324);
        condition();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_smallc

    // $ANTLR start synpred38_smallc
    public final void synpred38_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:175:17: ( variable_id )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:175:17: variable_id
        {
        pushFollow(FOLLOW_variable_id_in_synpred38_smallc1342);
        variable_id();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_smallc

    // $ANTLR start synpred39_smallc
    public final void synpred39_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:179:40: ( ',' variable_init )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:179:40: ',' variable_init
        {
        match(input,85,FOLLOW_85_in_synpred39_smallc1390); if (state.failed) return ;
        pushFollow(FOLLOW_variable_init_in_synpred39_smallc1392);
        variable_init();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_smallc

    // $ANTLR start synpred41_smallc
    public final void synpred41_smallc_fragment() throws RecognitionException {   
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:52: ( expression )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:187:52: expression
        {
        pushFollow(FOLLOW_expression_in_synpred41_smallc1517);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_smallc

    // $ANTLR start synpred43_smallc
    public final void synpred43_smallc_fragment() throws RecognitionException {   
        smallcParser.statement_return e = null;


        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:192:56: ( ELSE_WORD e= statement )
        // /home/gino/Workspaces/Eclipse/Compilers/grammar/smallc.g:192:56: ELSE_WORD e= statement
        {
        match(input,ELSE_WORD,FOLLOW_ELSE_WORD_in_synpred43_smallc1590); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred43_smallc1594);
        e=statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_smallc

    // Delegated rules

    public final boolean synpred38_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_smallc() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_smallc_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA5_eotS =
        "\14\uffff";
    static final String DFA5_eofS =
        "\14\uffff";
    static final String DFA5_minS =
        "\1\4\2\uffff\1\5\5\107\1\27\2\uffff";
    static final String DFA5_maxS =
        "\1\107\2\uffff\6\107\1\133\2\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\7\uffff\1\4\1\3";
    static final String DFA5_specialS =
        "\14\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\3\1\5\1\6\1\7\13\uffff\1\1\1\4\5\uffff\1\2\54\uffff\1\10",
            "",
            "",
            "\1\5\1\6\1\7\14\uffff\1\4\62\uffff\1\10",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\12\3\uffff\1\12\71\uffff\1\12\1\13\4\uffff\1\12",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "138:1: element : ( typedef SEMICOLON -> ^( ELEMENT typedef ) | include -> ^( ELEMENT include ) | function -> ^( ELEMENT function ) | declaration SEMICOLON -> ^( ELEMENT declaration ) );";
        }
    }
    static final String DFA18_eotS =
        "\31\uffff";
    static final String DFA18_eofS =
        "\31\uffff";
    static final String DFA18_minS =
        "\1\4\4\uffff\1\0\2\uffff\1\0\6\uffff\5\0\5\uffff";
    static final String DFA18_maxS =
        "\1\131\4\uffff\1\0\2\uffff\1\0\6\uffff\5\0\5\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\uffff\1\11\12\uffff\1"+
        "\13\1\14\1\5\1\12\1\10";
    static final String DFA18_specialS =
        "\5\uffff\1\0\2\uffff\1\1\6\uffff\1\2\1\3\1\4\1\5\1\6\5\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\17\1\21\1\22\1\23\1\uffff\1\11\2\uffff\1\11\1\3\1\2\1\uffff"+
            "\1\6\1\4\1\7\1\1\1\20\1\25\1\24\60\uffff\1\5\1\uffff\3\11\12"+
            "\uffff\1\11\2\uffff\1\10",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "159:1: statement : ( typedef SEMICOLON | continue_statement | break_statement | return_statement | function_call SEMICOLON -> function_call | if_statement | while_statement | compound_statement | expression SEMICOLON -> expression | declaration SEMICOLON -> declaration | print_statement SEMICOLON -> print_statement | read_statement SEMICOLON -> read_statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_5 = input.LA(1);

                         
                        int index18_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_smallc()) ) {s = 22;}

                        else if ( (synpred31_smallc()) ) {s = 9;}

                        else if ( (synpred32_smallc()) ) {s = 23;}

                         
                        input.seek(index18_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_8 = input.LA(1);

                         
                        int index18_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_smallc()) ) {s = 24;}

                        else if ( (synpred31_smallc()) ) {s = 9;}

                         
                        input.seek(index18_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_15 = input.LA(1);

                         
                        int index18_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_smallc()) ) {s = 9;}

                        else if ( (synpred32_smallc()) ) {s = 23;}

                         
                        input.seek(index18_15);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_16 = input.LA(1);

                         
                        int index18_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_smallc()) ) {s = 9;}

                        else if ( (synpred32_smallc()) ) {s = 23;}

                         
                        input.seek(index18_16);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_17 = input.LA(1);

                         
                        int index18_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_smallc()) ) {s = 9;}

                        else if ( (synpred32_smallc()) ) {s = 23;}

                         
                        input.seek(index18_17);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_18 = input.LA(1);

                         
                        int index18_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_smallc()) ) {s = 9;}

                        else if ( (synpred32_smallc()) ) {s = 23;}

                         
                        input.seek(index18_18);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_19 = input.LA(1);

                         
                        int index18_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_smallc()) ) {s = 9;}

                        else if ( (synpred32_smallc()) ) {s = 23;}

                         
                        input.seek(index18_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA19_eotS =
        "\17\uffff";
    static final String DFA19_eofS =
        "\17\uffff";
    static final String DFA19_minS =
        "\1\4\1\0\15\uffff";
    static final String DFA19_maxS =
        "\1\131\1\0\15\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\2\6\uffff\1\3\4\uffff\1\1";
    static final String DFA19_specialS =
        "\1\uffff\1\0\15\uffff}>";
    static final String[] DFA19_transitionS = {
            "\4\11\1\uffff\1\2\2\uffff\1\2\7\uffff\1\11\62\uffff\1\1\1\uffff"+
            "\3\2\12\uffff\1\2\2\uffff\1\2",
            "\1\uffff",
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
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "172:14: ( assignment | simple_expression | declaration )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_1 = input.LA(1);

                         
                        int index19_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_smallc()) ) {s = 14;}

                        else if ( (synpred35_smallc()) ) {s = 2;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index19_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA20_eotS =
        "\17\uffff";
    static final String DFA20_eofS =
        "\14\uffff\1\2\2\uffff";
    static final String DFA20_minS =
        "\1\11\1\4\1\uffff\1\0\1\uffff\1\10\1\5\4\107\1\uffff\1\10\1\107"+
        "\1\uffff";
    static final String DFA20_maxS =
        "\2\131\1\uffff\1\0\1\uffff\1\135\1\107\4\127\1\uffff\1\136\1\127"+
        "\1\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\6\uffff\1\3\2\uffff\1\1";
    static final String DFA20_specialS =
        "\3\uffff\1\0\13\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\2\2\uffff\1\2\72\uffff\1\3\1\uffff\3\2\12\uffff\1\1\2\uffff"+
            "\1\4",
            "\1\6\1\10\1\11\1\12\1\uffff\1\2\2\uffff\1\2\7\uffff\1\7\62"+
            "\uffff\1\5\1\uffff\3\2\12\uffff\1\2\2\uffff\1\2",
            "",
            "\1\uffff",
            "",
            "\4\2\17\uffff\12\2\42\uffff\1\2\16\uffff\1\2\1\14\3\uffff\1"+
            "\2\1\uffff\1\2",
            "\1\10\1\11\1\12\14\uffff\1\7\62\uffff\1\15",
            "\1\2\17\uffff\1\16",
            "\1\2\17\uffff\1\16",
            "\1\2\17\uffff\1\16",
            "\1\2\17\uffff\1\16",
            "",
            "\4\2\13\uffff\1\2\4\uffff\11\2\42\uffff\1\16\15\uffff\1\2\1"+
            "\uffff\1\2\2\uffff\1\2\1\uffff\3\2",
            "\1\2\17\uffff\1\16",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "173:1: simple_expression : ( type_cast | condition | variable_id | array_init );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_smallc()) ) {s = 2;}

                        else if ( (synpred38_smallc()) ) {s = 11;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA23_eotS =
        "\17\uffff";
    static final String DFA23_eofS =
        "\17\uffff";
    static final String DFA23_minS =
        "\1\4\1\0\15\uffff";
    static final String DFA23_maxS =
        "\1\131\1\0\15\uffff";
    static final String DFA23_acceptS =
        "\2\uffff\1\1\13\uffff\1\2";
    static final String DFA23_specialS =
        "\1\uffff\1\0\15\uffff}>";
    static final String[] DFA23_transitionS = {
            "\4\2\1\uffff\1\2\2\uffff\1\2\7\uffff\1\2\62\uffff\1\1\1\uffff"+
            "\3\2\12\uffff\1\2\2\uffff\1\2",
            "\1\uffff",
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
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "187:51: ( expression | function_call )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_1 = input.LA(1);

                         
                        int index23_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_smallc()) ) {s = 2;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index23_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_IDENTIFIER_in_id553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_id_list560 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_id_list563 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_id_list_in_id_list565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_variable_id574 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_array_index_in_variable_id577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_id_in_variable_list587 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_variable_list590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_variable_id_in_variable_list592 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_element_in_program607 = new BitSet(new long[]{0x00000000041800F2L,0x0000000000000080L});
    public static final BitSet FOLLOW_typedef_in_element624 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_element626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_in_element650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_element674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_element698 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_element700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_type717 = new BitSet(new long[]{0x00000000001000E0L,0x0000000000000080L});
    public static final BitSet FOLLOW_VOID_in_type724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_type730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_type736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_type742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_type746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEDEF_WORD_in_typedef772 = new BitSet(new long[]{0x00000000001000F0L,0x0000000000000080L});
    public static final BitSet FOLLOW_type_in_typedef775 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_id_in_typedef777 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_id_in_typedef780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_type_cast799 = new BitSet(new long[]{0x00000000001000F0L,0x0000000000000080L});
    public static final BitSet FOLLOW_type_in_type_cast801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_type_cast803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_variable_id_in_type_cast805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_WORD_in_include823 = new BitSet(new long[]{0x0000000010000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_ST_in_include826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_88_in_include828 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_id_in_include832 = new BitSet(new long[]{0x0000000020000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_FILE_in_include836 = new BitSet(new long[]{0x0000000020000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_GT_in_include840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_include842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_function_call865 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_function_call867 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002C00E80L});
    public static final BitSet FOLLOW_expression_list_in_function_call869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_function_call872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_function890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_id_in_function892 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_function894 = new BitSet(new long[]{0x00000000001000F0L,0x0000000000800080L});
    public static final BitSet FOLLOW_parameter_list_in_function896 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_function899 = new BitSet(new long[]{0x0000000000800000L,0x0000000002000000L});
    public static final BitSet FOLLOW_compound_statement_in_function902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_function906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_parameter_list932 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_parameter_list935 = new BitSet(new long[]{0x00000000001000F0L,0x0000000000000080L});
    public static final BitSet FOLLOW_parameter_in_parameter_list937 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_type_in_parameter957 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_variable_id_in_parameter959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expression_list976 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_expression_list980 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_list_in_expression_list982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_compound_statement999 = new BitSet(new long[]{0x0000000004FF72F0L,0x0000000006400E80L});
    public static final BitSet FOLLOW_statement_in_compound_statement1002 = new BitSet(new long[]{0x0000000004FF72F0L,0x0000000006400E80L});
    public static final BitSet FOLLOW_90_in_compound_statement1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typedef_in_statement1022 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continue_statement_in_statement1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_statement_in_statement1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_statement_in_statement1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_statement1096 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_statement_in_statement1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_statement_in_statement1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement1174 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement1198 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_statement_in_statement1222 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_statement_in_statement1246 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_statement1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_expression1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_expression_in_expression1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_expression1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_cast_in_simple_expression1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condition_in_simple_expression1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_id_in_simple_expression1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_init_in_simple_expression1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_declaration1368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_declaration_variables_in_declaration1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_init_in_declaration_variables1387 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_declaration_variables1390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_variable_init_in_declaration_variables1392 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_variable_id_in_variable_init1410 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ASSIGN_in_variable_init1413 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_variable_init1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_id_in_assignment1440 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ASSIGN_in_assignment1442 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_assignment1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_WORD_in_break_statement1462 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_break_statement1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_WORD_in_continue_statement1475 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_continue_statement1477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_WORD_in_return_statement1488 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_return_statement1490 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_return_statement1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_WORD_in_print_statement1507 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_print_statement1509 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_CHARLITERAL_in_print_statement1511 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A00000L});
    public static final BitSet FOLLOW_85_in_print_statement1514 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_print_statement1517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A00000L});
    public static final BitSet FOLLOW_function_call_in_print_statement1519 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A00000L});
    public static final BitSet FOLLOW_87_in_print_statement1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_WORD_in_read_statement1547 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_read_statement1549 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_CHARLITERAL_in_read_statement1551 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_read_statement1553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_variable_list_in_read_statement1555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_read_statement1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_WORD_in_if_statement1577 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_if_statement1579 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_if_statement1581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_if_statement1583 = new BitSet(new long[]{0x0000000004FF72F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_statement_in_if_statement1587 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ELSE_WORD_in_if_statement1590 = new BitSet(new long[]{0x0000000004FF72F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_statement_in_if_statement1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_WORD_in_while_statement1620 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_while_statement1622 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_while_statement1624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_while_statement1626 = new BitSet(new long[]{0x0000000004FF72F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_statement_in_while_statement1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_array_index1648 = new BitSet(new long[]{0x0000000000001200L,0x0000000002400E80L});
    public static final BitSet FOLLOW_simple_expression_in_array_index1650 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_array_index1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_array_init1667 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_array_init1669 = new BitSet(new long[]{0x0000000000000000L,0x0000000004200000L});
    public static final BitSet FOLLOW_85_in_array_init1672 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_array_init1674 = new BitSet(new long[]{0x0000000000000000L,0x0000000004200000L});
    public static final BitSet FOLLOW_90_in_array_init1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_disjunction_in_condition1698 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_condition1702 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_condition1704 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_condition1706 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_condition_in_condition1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conjunction_in_disjunction1733 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_OR_in_disjunction1737 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_conjunction_in_disjunction1739 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_comparison_in_conjunction1758 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_AND_in_conjunction1762 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_comparison_in_conjunction1764 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_relation_in_comparison1785 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_EQUAL_in_comparison1792 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_NONEQUAL_in_comparison1796 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_relation_in_comparison1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sum_in_relation1829 = new BitSet(new long[]{0x00000000F0000002L});
    public static final BitSet FOLLOW_ST_in_relation1836 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_GT_in_relation1842 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_STEQ_in_relation1848 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_GTEQ_in_relation1854 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_relation_in_relation1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_sum1883 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_PLUS_in_sum1890 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_MINUS_in_sum1894 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_sum_in_sum1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term1922 = new BitSet(new long[]{0x0000001000000C02L});
    public static final BitSet FOLLOW_MULT_in_term1929 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_DIV_in_term1933 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_MOD_in_term1937 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_term_in_term1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_factor1969 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_MINUS_in_factor1973 = new BitSet(new long[]{0x0000000000001200L,0x0000000000400E80L});
    public static final BitSet FOLLOW_factor_in_factor1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_factor1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_in_atom2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_atom2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_id_in_atom2033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_atom2045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_atom2057 = new BitSet(new long[]{0x00000000041812F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_expression_in_atom2059 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_atom2061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARLITERAL_in_atom2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_synpred13_smallc775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_synpred27_smallc1096 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred27_smallc1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_statement_in_synpred30_smallc1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred31_smallc1174 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred31_smallc1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred32_smallc1198 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred32_smallc1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_synpred34_smallc1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_expression_in_synpred35_smallc1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condition_in_synpred37_smallc1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_id_in_synpred38_smallc1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_synpred39_smallc1390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_variable_init_in_synpred39_smallc1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred41_smallc1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_WORD_in_synpred43_smallc1590 = new BitSet(new long[]{0x0000000004FF72F0L,0x0000000002400E80L});
    public static final BitSet FOLLOW_statement_in_synpred43_smallc1594 = new BitSet(new long[]{0x0000000000000002L});

}