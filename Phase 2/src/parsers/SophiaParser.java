// Generated from D:/Compiler/ca2/Phase 2/src/main/grammar\Sophia.g4 by ANTLR 4.8
package parsers;

    import main.ast.types.*;
    import main.ast.types.functionPointer.*;
    import main.ast.types.list.*;
    import main.ast.types.single.*;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.declaration.classDec.*;
    import main.ast.nodes.declaration.classDec.classMembersDec.*;
    import main.ast.nodes.declaration.variableDec.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.expression.operators.*;
    import main.ast.nodes.expression.values.*;
    import main.ast.nodes.expression.values.primitive.*;
    import main.ast.nodes.statement.*;
    import main.ast.nodes.statement.loop.*;
    import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SophiaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DEF=1, EXTENDS=2, CLASS=3, PRINT=4, FUNC=5, NEW=6, CONTINUE=7, BREAK=8, 
		RETURN=9, FOREACH=10, IN=11, FOR=12, IF=13, ELSE=14, BOOLEAN=15, STRING=16, 
		INT=17, VOID=18, NULL=19, LIST=20, TRUE=21, FALSE=22, THIS=23, ARROW=24, 
		GREATER_THAN=25, LESS_THAN=26, NOT_EQUAL=27, EQUAL=28, MULT=29, DIVIDE=30, 
		MOD=31, PLUS=32, MINUS=33, AND=34, OR=35, NOT=36, QUESTION_MARK=37, ASSIGN=38, 
		INCREMENT=39, DECREMENT=40, LPAR=41, RPAR=42, LBRACK=43, RBRACK=44, LBRACE=45, 
		RBRACE=46, SHARP=47, COMMA=48, DOT=49, COLON=50, SEMICOLLON=51, INT_VALUE=52, 
		IDENTIFIER=53, STRING_VALUE=54, COMMENT=55, WS=56;
	public static final int
		RULE_sophia = 0, RULE_program = 1, RULE_sophiaClass = 2, RULE_varDeclaration = 3, 
		RULE_method = 4, RULE_constructor = 5, RULE_methodArguments = 6, RULE_variableWithType = 7, 
		RULE_type = 8, RULE_classType = 9, RULE_listType = 10, RULE_listItemsTypes = 11, 
		RULE_listItemType = 12, RULE_functionPointerType = 13, RULE_typesWithComma = 14, 
		RULE_primitiveDataType = 15, RULE_methodBody = 16, RULE_statement = 17, 
		RULE_block = 18, RULE_assignmentStatement = 19, RULE_assignment = 20, 
		RULE_printStatement = 21, RULE_returnStatement = 22, RULE_methodCallStatement = 23, 
		RULE_methodCall = 24, RULE_methodCallArguments = 25, RULE_continueBreakStatement = 26, 
		RULE_forStatement = 27, RULE_foreachStatement = 28, RULE_ifStatement = 29, 
		RULE_expression = 30, RULE_orExpression = 31, RULE_andExpression = 32, 
		RULE_equalityExpression = 33, RULE_relationalExpression = 34, RULE_additiveExpression = 35, 
		RULE_multiplicativeExpression = 36, RULE_preUnaryExpression = 37, RULE_postUnaryExpression = 38, 
		RULE_accessExpression = 39, RULE_otherExpression = 40, RULE_newExpression = 41, 
		RULE_values = 42, RULE_boolValue = 43, RULE_listValue = 44, RULE_identifier = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"sophia", "program", "sophiaClass", "varDeclaration", "method", "constructor", 
			"methodArguments", "variableWithType", "type", "classType", "listType", 
			"listItemsTypes", "listItemType", "functionPointerType", "typesWithComma", 
			"primitiveDataType", "methodBody", "statement", "block", "assignmentStatement", 
			"assignment", "printStatement", "returnStatement", "methodCallStatement", 
			"methodCall", "methodCallArguments", "continueBreakStatement", "forStatement", 
			"foreachStatement", "ifStatement", "expression", "orExpression", "andExpression", 
			"equalityExpression", "relationalExpression", "additiveExpression", "multiplicativeExpression", 
			"preUnaryExpression", "postUnaryExpression", "accessExpression", "otherExpression", 
			"newExpression", "values", "boolValue", "listValue", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'extends'", "'class'", "'print'", "'func'", "'new'", 
			"'continue'", "'break'", "'return'", "'foreach'", "'in'", "'for'", "'if'", 
			"'else'", "'bool'", "'string'", "'int'", "'void'", "'null'", "'list'", 
			"'true'", "'false'", "'this'", "'->'", "'>'", "'<'", "'!='", "'=='", 
			"'*'", "'/'", "'%'", "'+'", "'-'", "'&&'", "'||'", "'!'", "'?'", "'='", 
			"'++'", "'--'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'#'", "','", 
			"'.'", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DEF", "EXTENDS", "CLASS", "PRINT", "FUNC", "NEW", "CONTINUE", 
			"BREAK", "RETURN", "FOREACH", "IN", "FOR", "IF", "ELSE", "BOOLEAN", "STRING", 
			"INT", "VOID", "NULL", "LIST", "TRUE", "FALSE", "THIS", "ARROW", "GREATER_THAN", 
			"LESS_THAN", "NOT_EQUAL", "EQUAL", "MULT", "DIVIDE", "MOD", "PLUS", "MINUS", 
			"AND", "OR", "NOT", "QUESTION_MARK", "ASSIGN", "INCREMENT", "DECREMENT", 
			"LPAR", "RPAR", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "SHARP", "COMMA", 
			"DOT", "COLON", "SEMICOLLON", "INT_VALUE", "IDENTIFIER", "STRING_VALUE", 
			"COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Sophia.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SophiaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SophiaContext extends ParserRuleContext {
		public Program sophiaProgram;
		public ProgramContext p;
		public TerminalNode EOF() { return getToken(SophiaParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public SophiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sophia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterSophia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitSophia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitSophia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SophiaContext sophia() throws RecognitionException {
		SophiaContext _localctx = new SophiaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sophia);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((SophiaContext)_localctx).p = program();
			 ((SophiaContext)_localctx).sophiaProgram =  ((SophiaContext)_localctx).p.programRet; 
			setState(94);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public SophiaClassContext c;
		public List<SophiaClassContext> sophiaClass() {
			return getRuleContexts(SophiaClassContext.class);
		}
		public SophiaClassContext sophiaClass(int i) {
			return getRuleContext(SophiaClassContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ProgramContext)_localctx).programRet =  new Program();
			      _localctx.programRet.setLine(1);
			    
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(97);
				((ProgramContext)_localctx).c = sophiaClass();
				_localctx.programRet.addClass(((ProgramContext)_localctx).c.sophiaClassRet); 
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SophiaClassContext extends ParserRuleContext {
		public ClassDeclaration sophiaClassRet;
		public Token c;
		public IdentifierContext id;
		public IdentifierContext parid;
		public VarDeclarationContext var1;
		public MethodContext met1;
		public ConstructorContext constr;
		public VarDeclarationContext var2;
		public MethodContext met2;
		public VarDeclarationContext var3;
		public MethodContext met3;
		public TerminalNode LBRACE() { return getToken(SophiaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SophiaParser.RBRACE, 0); }
		public TerminalNode CLASS() { return getToken(SophiaParser.CLASS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode EXTENDS() { return getToken(SophiaParser.EXTENDS, 0); }
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public SophiaClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sophiaClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterSophiaClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitSophiaClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitSophiaClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SophiaClassContext sophiaClass() throws RecognitionException {
		SophiaClassContext _localctx = new SophiaClassContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sophiaClass);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((SophiaClassContext)_localctx).c = match(CLASS);
			setState(106);
			((SophiaClassContext)_localctx).id = identifier();
			((SophiaClassContext)_localctx).sophiaClassRet =  new ClassDeclaration(((SophiaClassContext)_localctx).id.my_id); _localctx.sophiaClassRet.setLine(((SophiaClassContext)_localctx).c.getLine());
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(108);
				match(EXTENDS);
				setState(109);
				((SophiaClassContext)_localctx).parid = identifier();
				_localctx.sophiaClassRet.setParentClassName(((SophiaClassContext)_localctx).parid.my_id);
				}
			}

			setState(114);
			match(LBRACE);
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				{
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(121);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IDENTIFIER:
							{
							setState(115);
							((SophiaClassContext)_localctx).var1 = varDeclaration();
							_localctx.sophiaClassRet.addField(((SophiaClassContext)_localctx).var1.fieldRet);
							}
							break;
						case DEF:
							{
							setState(118);
							((SophiaClassContext)_localctx).met1 = method();
							_localctx.sophiaClassRet.addMethod(((SophiaClassContext)_localctx).met1.methodRet);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(125);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(126);
				((SophiaClassContext)_localctx).constr = constructor();
				_localctx.sophiaClassRet.setConstructor(((SophiaClassContext)_localctx).constr.constructorRet);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DEF || _la==IDENTIFIER) {
					{
					setState(134);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case IDENTIFIER:
						{
						setState(128);
						((SophiaClassContext)_localctx).var2 = varDeclaration();
						_localctx.sophiaClassRet.addField(((SophiaClassContext)_localctx).var2.fieldRet);
						}
						break;
					case DEF:
						{
						setState(131);
						((SophiaClassContext)_localctx).met2 = method();
						_localctx.sophiaClassRet.addMethod(((SophiaClassContext)_localctx).met2.methodRet);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DEF || _la==IDENTIFIER) {
					{
					setState(145);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case IDENTIFIER:
						{
						setState(139);
						((SophiaClassContext)_localctx).var3 = varDeclaration();
						_localctx.sophiaClassRet.addField(((SophiaClassContext)_localctx).var3.fieldRet);
						}
						break;
					case DEF:
						{
						setState(142);
						((SophiaClassContext)_localctx).met3 = method();
						_localctx.sophiaClassRet.addMethod(((SophiaClassContext)_localctx).met3.methodRet);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			}
			setState(152);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclaration varRet;
		public FieldDeclaration fieldRet;
		public IdentifierContext id;
		public TypeContext t;
		public TerminalNode COLON() { return getToken(SophiaParser.COLON, 0); }
		public TerminalNode SEMICOLLON() { return getToken(SophiaParser.SEMICOLLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			((VarDeclarationContext)_localctx).id = identifier();
			setState(155);
			match(COLON);
			setState(156);
			((VarDeclarationContext)_localctx).t = type();
			setState(157);
			match(SEMICOLLON);
			((VarDeclarationContext)_localctx).varRet =  new VarDeclaration(((VarDeclarationContext)_localctx).id.my_id, ((VarDeclarationContext)_localctx).t.my_type);
			                                               _localctx.varRet.setLine(((VarDeclarationContext)_localctx).id.my_id.getLine());
			((VarDeclarationContext)_localctx).fieldRet =  new FieldDeclaration (_localctx.varRet);
			                                               _localctx.fieldRet.setLine(((VarDeclarationContext)_localctx).id.my_id.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public MethodDeclaration methodRet;
		public Token d;
		public TypeContext t;
		public Token v;
		public IdentifierContext id;
		public MethodArgumentsContext met;
		public MethodBodyContext m;
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(SophiaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SophiaParser.RBRACE, 0); }
		public TerminalNode DEF() { return getToken(SophiaParser.DEF, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MethodArgumentsContext methodArguments() {
			return getRuleContext(MethodArgumentsContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SophiaParser.VOID, 0); }
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((MethodContext)_localctx).d = match(DEF);
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC:
			case BOOLEAN:
			case STRING:
			case INT:
			case LIST:
			case IDENTIFIER:
				{
				setState(162);
				((MethodContext)_localctx).t = type();
				}
				break;
			case VOID:
				{
				setState(163);
				((MethodContext)_localctx).v = match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(166);
			((MethodContext)_localctx).id = identifier();
			if ((((MethodContext)_localctx).v!=null?((MethodContext)_localctx).v.getText():null) != null) ((MethodContext)_localctx).methodRet =  new MethodDeclaration(((MethodContext)_localctx).id.my_id, new NullType());

			                                               else {((MethodContext)_localctx).methodRet =  new MethodDeclaration(((MethodContext)_localctx).id.my_id, ((MethodContext)_localctx).t.my_type);}
			                                               _localctx.methodRet.setLine(((MethodContext)_localctx).d.getLine());
			setState(168);
			match(LPAR);
			setState(169);
			((MethodContext)_localctx).met = methodArguments();
			_localctx.methodRet.setArgs(((MethodContext)_localctx).met.methodargRet);
			setState(171);
			match(RPAR);
			setState(172);
			match(LBRACE);
			setState(173);
			((MethodContext)_localctx).m = methodBody();
			_localctx.methodRet.setLocalVars(((MethodContext)_localctx).m.bodyvarRet);
			                                _localctx.methodRet.setBody(((MethodContext)_localctx).m.bodystmtRet);
			setState(175);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public ConstructorDeclaration constructorRet;
		public Token d;
		public IdentifierContext id;
		public MethodArgumentsContext met;
		public MethodBodyContext m;
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(SophiaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SophiaParser.RBRACE, 0); }
		public TerminalNode DEF() { return getToken(SophiaParser.DEF, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MethodArgumentsContext methodArguments() {
			return getRuleContext(MethodArgumentsContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			((ConstructorContext)_localctx).d = match(DEF);
			setState(178);
			((ConstructorContext)_localctx).id = identifier();
			((ConstructorContext)_localctx).constructorRet =  new ConstructorDeclaration(((ConstructorContext)_localctx).id.my_id);
			                              _localctx.constructorRet.setLine(((ConstructorContext)_localctx).d.getLine());
			setState(180);
			match(LPAR);
			setState(181);
			((ConstructorContext)_localctx).met = methodArguments();
			_localctx.constructorRet.setArgs(((ConstructorContext)_localctx).met.methodargRet);
			setState(183);
			match(RPAR);
			setState(184);
			match(LBRACE);
			setState(185);
			((ConstructorContext)_localctx).m = methodBody();
			_localctx.constructorRet.setLocalVars(((ConstructorContext)_localctx).m.bodyvarRet);
			                                _localctx.constructorRet.setBody(((ConstructorContext)_localctx).m.bodystmtRet);
			setState(187);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodArgumentsContext extends ParserRuleContext {
		public ArrayList<VarDeclaration> methodargRet;
		public VariableWithTypeContext var1;
		public VariableWithTypeContext var2;
		public List<VariableWithTypeContext> variableWithType() {
			return getRuleContexts(VariableWithTypeContext.class);
		}
		public VariableWithTypeContext variableWithType(int i) {
			return getRuleContext(VariableWithTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SophiaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SophiaParser.COMMA, i);
		}
		public MethodArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterMethodArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitMethodArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitMethodArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgumentsContext methodArguments() throws RecognitionException {
		MethodArgumentsContext _localctx = new MethodArgumentsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((MethodArgumentsContext)_localctx).methodargRet =  new ArrayList<>();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(190);
				((MethodArgumentsContext)_localctx).var1 = variableWithType();
				_localctx.methodargRet.add(((MethodArgumentsContext)_localctx).var1.varwithtype);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(192);
					match(COMMA);
					setState(193);
					((MethodArgumentsContext)_localctx).var2 = variableWithType();
					_localctx.methodargRet.add(((MethodArgumentsContext)_localctx).var2.varwithtype);
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableWithTypeContext extends ParserRuleContext {
		public VarDeclaration varwithtype;
		public IdentifierContext id;
		public TypeContext t;
		public TerminalNode COLON() { return getToken(SophiaParser.COLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableWithTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableWithType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterVariableWithType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitVariableWithType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitVariableWithType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableWithTypeContext variableWithType() throws RecognitionException {
		VariableWithTypeContext _localctx = new VariableWithTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableWithType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			((VariableWithTypeContext)_localctx).id = identifier();
			setState(204);
			match(COLON);
			setState(205);
			((VariableWithTypeContext)_localctx).t = type();
			((VariableWithTypeContext)_localctx).varwithtype =  new VarDeclaration (((VariableWithTypeContext)_localctx).id.my_id, ((VariableWithTypeContext)_localctx).t.my_type);
			                                    _localctx.varwithtype.setLine(((VariableWithTypeContext)_localctx).id.my_id.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type my_type;
		public PrimitiveDataTypeContext prim;
		public ListTypeContext a;
		public FunctionPointerTypeContext b;
		public ClassTypeContext c;
		public PrimitiveDataTypeContext primitiveDataType() {
			return getRuleContext(PrimitiveDataTypeContext.class,0);
		}
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public FunctionPointerTypeContext functionPointerType() {
			return getRuleContext(FunctionPointerTypeContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case STRING:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				((TypeContext)_localctx).prim = primitiveDataType();
				((TypeContext)_localctx).my_type =  ((TypeContext)_localctx).prim.primRet;
				}
				break;
			case LIST:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				((TypeContext)_localctx).a = listType();
				((TypeContext)_localctx).my_type =  ((TypeContext)_localctx).a.listTypeRet;
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				((TypeContext)_localctx).b = functionPointerType();
				((TypeContext)_localctx).my_type =  ((TypeContext)_localctx).b.funcptrTypeRet;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				((TypeContext)_localctx).c = classType();
				((TypeContext)_localctx).my_type =  ((TypeContext)_localctx).c.classTypeRet;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassTypeContext extends ParserRuleContext {
		public ClassType classTypeRet;
		public IdentifierContext id;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			((ClassTypeContext)_localctx).id = identifier();
			((ClassTypeContext)_localctx).classTypeRet =  new ClassType(((ClassTypeContext)_localctx).id.my_id);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListTypeContext extends ParserRuleContext {
		public ListType listTypeRet;
		public Token size;
		public TypeContext t;
		public ListItemsTypesContext a;
		public TerminalNode LIST() { return getToken(SophiaParser.LIST, 0); }
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public TerminalNode SHARP() { return getToken(SophiaParser.SHARP, 0); }
		public TerminalNode INT_VALUE() { return getToken(SophiaParser.INT_VALUE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ListItemsTypesContext listItemsTypes() {
			return getRuleContext(ListItemsTypesContext.class,0);
		}
		public ListTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitListType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTypeContext listType() throws RecognitionException {
		ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_listType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(LIST);
			setState(226);
			match(LPAR);
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VALUE:
				{
				{
				setState(227);
				((ListTypeContext)_localctx).size = match(INT_VALUE);
				setState(228);
				match(SHARP);
				setState(229);
				((ListTypeContext)_localctx).t = type();
				}
				((ListTypeContext)_localctx).listTypeRet =  new ListType(Integer.parseInt((((ListTypeContext)_localctx).size!=null?((ListTypeContext)_localctx).size.getText():null)), new ListNameType(((ListTypeContext)_localctx).t.my_type));
				}
				break;
			case FUNC:
			case BOOLEAN:
			case STRING:
			case INT:
			case LIST:
			case IDENTIFIER:
				{
				{
				setState(233);
				((ListTypeContext)_localctx).a = listItemsTypes();
				((ListTypeContext)_localctx).listTypeRet =  new ListType(((ListTypeContext)_localctx).a.listitemstype.getElementsTypes());
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(238);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListItemsTypesContext extends ParserRuleContext {
		public ListType listitemstype;
		public ListItemTypeContext l;
		public ListItemTypeContext l2;
		public List<ListItemTypeContext> listItemType() {
			return getRuleContexts(ListItemTypeContext.class);
		}
		public ListItemTypeContext listItemType(int i) {
			return getRuleContext(ListItemTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SophiaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SophiaParser.COMMA, i);
		}
		public ListItemsTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listItemsTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterListItemsTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitListItemsTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitListItemsTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListItemsTypesContext listItemsTypes() throws RecognitionException {
		ListItemsTypesContext _localctx = new ListItemsTypesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listItemsTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ListItemsTypesContext)_localctx).listitemstype =  new ListType();
			setState(241);
			((ListItemsTypesContext)_localctx).l = listItemType();
			_localctx.listitemstype.addElementType(((ListItemsTypesContext)_localctx).l.listitemtype);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(243);
				match(COMMA);
				setState(244);
				((ListItemsTypesContext)_localctx).l2 = listItemType();
				_localctx.listitemstype.addElementType(((ListItemsTypesContext)_localctx).l2.listitemtype);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListItemTypeContext extends ParserRuleContext {
		public ListNameType listitemtype;
		public VariableWithTypeContext a;
		public TypeContext t;
		public VariableWithTypeContext variableWithType() {
			return getRuleContext(VariableWithTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ListItemTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listItemType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterListItemType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitListItemType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitListItemType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListItemTypeContext listItemType() throws RecognitionException {
		ListItemTypeContext _localctx = new ListItemTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listItemType);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				((ListItemTypeContext)_localctx).a = variableWithType();
				((ListItemTypeContext)_localctx).listitemtype =  new ListNameType(((ListItemTypeContext)_localctx).a.varwithtype);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				((ListItemTypeContext)_localctx).t = type();
				((ListItemTypeContext)_localctx).listitemtype =  new ListNameType(((ListItemTypeContext)_localctx).t.my_type);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionPointerTypeContext extends ParserRuleContext {
		public FptrType funcptrTypeRet;
		public TypesWithCommaContext a;
		public TypeContext t;
		public TerminalNode FUNC() { return getToken(SophiaParser.FUNC, 0); }
		public TerminalNode LESS_THAN() { return getToken(SophiaParser.LESS_THAN, 0); }
		public TerminalNode ARROW() { return getToken(SophiaParser.ARROW, 0); }
		public TerminalNode GREATER_THAN() { return getToken(SophiaParser.GREATER_THAN, 0); }
		public List<TerminalNode> VOID() { return getTokens(SophiaParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(SophiaParser.VOID, i);
		}
		public TypesWithCommaContext typesWithComma() {
			return getRuleContext(TypesWithCommaContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionPointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionPointerType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterFunctionPointerType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitFunctionPointerType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitFunctionPointerType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionPointerTypeContext functionPointerType() throws RecognitionException {
		FunctionPointerTypeContext _localctx = new FunctionPointerTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionPointerType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FunctionPointerTypeContext)_localctx).funcptrTypeRet =  new FptrType();
			setState(261);
			match(FUNC);
			setState(262);
			match(LESS_THAN);
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(263);
				match(VOID);
				}
				break;
			case FUNC:
			case BOOLEAN:
			case STRING:
			case INT:
			case LIST:
			case IDENTIFIER:
				{
				setState(264);
				((FunctionPointerTypeContext)_localctx).a = typesWithComma();
				_localctx.funcptrTypeRet.setArgumentsTypes(((FunctionPointerTypeContext)_localctx).a.typecomma);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(269);
			match(ARROW);
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(270);
				match(VOID);
				_localctx.funcptrTypeRet.setReturnType(new NullType());
				}
				break;
			case FUNC:
			case BOOLEAN:
			case STRING:
			case INT:
			case LIST:
			case IDENTIFIER:
				{
				setState(272);
				((FunctionPointerTypeContext)_localctx).t = type();
				_localctx.funcptrTypeRet.setReturnType(((FunctionPointerTypeContext)_localctx).t.my_type);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(277);
			match(GREATER_THAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesWithCommaContext extends ParserRuleContext {
		public ArrayList<Type> typecomma;
		public TypeContext t1;
		public TypeContext t2;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SophiaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SophiaParser.COMMA, i);
		}
		public TypesWithCommaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typesWithComma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterTypesWithComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitTypesWithComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitTypesWithComma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesWithCommaContext typesWithComma() throws RecognitionException {
		TypesWithCommaContext _localctx = new TypesWithCommaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typesWithComma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((TypesWithCommaContext)_localctx).typecomma =  new ArrayList<>();
			setState(280);
			((TypesWithCommaContext)_localctx).t1 = type();
			_localctx.typecomma.add(((TypesWithCommaContext)_localctx).t1.my_type);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(282);
				match(COMMA);
				setState(283);
				((TypesWithCommaContext)_localctx).t2 = type();
				_localctx.typecomma.add(((TypesWithCommaContext)_localctx).t2.my_type);
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveDataTypeContext extends ParserRuleContext {
		public Type primRet;
		public TerminalNode INT() { return getToken(SophiaParser.INT, 0); }
		public TerminalNode STRING() { return getToken(SophiaParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(SophiaParser.BOOLEAN, 0); }
		public PrimitiveDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveDataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterPrimitiveDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitPrimitiveDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitPrimitiveDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveDataTypeContext primitiveDataType() throws RecognitionException {
		PrimitiveDataTypeContext _localctx = new PrimitiveDataTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_primitiveDataType);
		try {
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(INT);
				((PrimitiveDataTypeContext)_localctx).primRet =  new IntType();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(STRING);
				((PrimitiveDataTypeContext)_localctx).primRet =  new StringType();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				match(BOOLEAN);
				((PrimitiveDataTypeContext)_localctx).primRet =  new BoolType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public ArrayList<VarDeclaration> bodyvarRet;
		public ArrayList <Statement> bodystmtRet;
		public VarDeclarationContext v;
		public StatementContext s;
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_methodBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((MethodBodyContext)_localctx).bodyvarRet =  new ArrayList<>();
			    ((MethodBodyContext)_localctx).bodystmtRet =  new ArrayList<>();
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(300);
					((MethodBodyContext)_localctx).v = varDeclaration();
					_localctx.bodyvarRet.add(((MethodBodyContext)_localctx).v.varRet);
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << NEW) | (1L << CONTINUE) | (1L << BREAK) | (1L << RETURN) | (1L << FOREACH) | (1L << FOR) | (1L << IF) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << THIS) | (1L << MINUS) | (1L << NOT) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LPAR) | (1L << LBRACK) | (1L << LBRACE) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				{
				setState(308);
				((MethodBodyContext)_localctx).s = statement();
				_localctx.bodystmtRet.add(((MethodBodyContext)_localctx).s.stmt);
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement stmt;
		public ForStatementContext s1;
		public ForeachStatementContext s2;
		public IfStatementContext s3;
		public AssignmentStatementContext s4;
		public PrintStatementContext s5;
		public ContinueBreakStatementContext s6;
		public MethodCallStatementContext s7;
		public ReturnStatementContext s8;
		public BlockContext s9;
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForeachStatementContext foreachStatement() {
			return getRuleContext(ForeachStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ContinueBreakStatementContext continueBreakStatement() {
			return getRuleContext(ContinueBreakStatementContext.class,0);
		}
		public MethodCallStatementContext methodCallStatement() {
			return getRuleContext(MethodCallStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				((StatementContext)_localctx).s1 = forStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s1.forRet;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				((StatementContext)_localctx).s2 = foreachStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s2.foreachRet;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				((StatementContext)_localctx).s3 = ifStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s3.ifRet;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(325);
				((StatementContext)_localctx).s4 = assignmentStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s4.stmt;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(328);
				((StatementContext)_localctx).s5 = printStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s5.stmt;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(331);
				((StatementContext)_localctx).s6 = continueBreakStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s6.stmt;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(334);
				((StatementContext)_localctx).s7 = methodCallStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s7.metstmt;
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(337);
				((StatementContext)_localctx).s8 = returnStatement();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s8.stmt;
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(340);
				((StatementContext)_localctx).s9 = block();
				((StatementContext)_localctx).stmt =  ((StatementContext)_localctx).s9.stmt;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockStmt stmt;
		public Token lb;
		public StatementContext st;
		public TerminalNode RBRACE() { return getToken(SophiaParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(SophiaParser.LBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((BlockContext)_localctx).stmt =  new BlockStmt();
			setState(346);
			((BlockContext)_localctx).lb = match(LBRACE);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << NEW) | (1L << CONTINUE) | (1L << BREAK) | (1L << RETURN) | (1L << FOREACH) | (1L << FOR) | (1L << IF) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << THIS) | (1L << MINUS) | (1L << NOT) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LPAR) | (1L << LBRACK) | (1L << LBRACE) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				{
				setState(347);
				((BlockContext)_localctx).st = statement();
				 _localctx.stmt.addStatement(((BlockContext)_localctx).st.stmt); 
				}
				}
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(355);
			match(RBRACE);
			 _localctx.stmt.setLine(((BlockContext)_localctx).lb.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public AssignmentStmt stmt;
		public AssignmentContext s;
		public TerminalNode SEMICOLLON() { return getToken(SophiaParser.SEMICOLLON, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			((AssignmentStatementContext)_localctx).s = assignment();
			setState(359);
			match(SEMICOLLON);
			((AssignmentStatementContext)_localctx).stmt =  ((AssignmentStatementContext)_localctx).s.stmt;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentStmt stmt;
		public OrExpressionContext l;
		public Token as;
		public ExpressionContext r;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SophiaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			((AssignmentContext)_localctx).l = orExpression();
			setState(363);
			((AssignmentContext)_localctx).as = match(ASSIGN);
			setState(364);
			((AssignmentContext)_localctx).r = expression();
			((AssignmentContext)_localctx).stmt =  new AssignmentStmt(((AssignmentContext)_localctx).l.expr,((AssignmentContext)_localctx).r.expr);
			  _localctx.stmt.setLine(((AssignmentContext)_localctx).as.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public Statement stmt;
		public Token p;
		public ExpressionContext expr;
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public TerminalNode SEMICOLLON() { return getToken(SophiaParser.SEMICOLLON, 0); }
		public TerminalNode PRINT() { return getToken(SophiaParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			((PrintStatementContext)_localctx).p = match(PRINT);
			setState(368);
			match(LPAR);
			setState(369);
			((PrintStatementContext)_localctx).expr = expression();
			setState(370);
			match(RPAR);
			setState(371);
			match(SEMICOLLON);
			 ((PrintStatementContext)_localctx).stmt =  new PrintStmt(((PrintStatementContext)_localctx).expr.expr);
			    _localctx.stmt.setLine(((PrintStatementContext)_localctx).p.getLine());
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public Statement stmt;
		public Token r;
		public ExpressionContext rexpr;
		public TerminalNode SEMICOLLON() { return getToken(SophiaParser.SEMICOLLON, 0); }
		public TerminalNode RETURN() { return getToken(SophiaParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			((ReturnStatementContext)_localctx).r = match(RETURN);
			((ReturnStatementContext)_localctx).stmt =  new ReturnStmt(); _localctx.stmt.setLine(((ReturnStatementContext)_localctx).r.getLine());
			               NullValue nul = new NullValue(); nul.setLine(_localctx.stmt.getLine()); ((ReturnStmt)_localctx.stmt).setReturnedExpr(nul);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << THIS) | (1L << MINUS) | (1L << NOT) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LPAR) | (1L << LBRACK) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				setState(376);
				((ReturnStatementContext)_localctx).rexpr = expression();
				((ReturnStmt)_localctx.stmt).setReturnedExpr(((ReturnStatementContext)_localctx).rexpr.expr);
				}
			}

			setState(381);
			match(SEMICOLLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallStatementContext extends ParserRuleContext {
		public MethodCallStmt metstmt;
		public MethodCallContext m;
		public TerminalNode SEMICOLLON() { return getToken(SophiaParser.SEMICOLLON, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public MethodCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterMethodCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitMethodCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitMethodCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallStatementContext methodCallStatement() throws RecognitionException {
		MethodCallStatementContext _localctx = new MethodCallStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_methodCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			((MethodCallStatementContext)_localctx).m = methodCall();
			setState(384);
			match(SEMICOLLON);
			((MethodCallStatementContext)_localctx).metstmt =  new MethodCallStmt(((MethodCallStatementContext)_localctx).m.methodcallRet);
			                            _localctx.metstmt.setLine(((MethodCallStatementContext)_localctx).m.methodcallRet.getLine());
			                            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallContext extends ParserRuleContext {
		public MethodCall methodcallRet;
		public OtherExpressionContext other;
		public Token par;
		public MethodCallArgumentsContext m;
		public IdentifierContext id;
		public Token lb;
		public ExpressionContext e;
		public Token l;
		public MethodCallArgumentsContext met;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(SophiaParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(SophiaParser.RPAR, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(SophiaParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(SophiaParser.LPAR, i);
		}
		public List<MethodCallArgumentsContext> methodCallArguments() {
			return getRuleContexts(MethodCallArgumentsContext.class);
		}
		public MethodCallArgumentsContext methodCallArguments(int i) {
			return getRuleContext(MethodCallArgumentsContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SophiaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SophiaParser.DOT, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(SophiaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(SophiaParser.RBRACK, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(SophiaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(SophiaParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_methodCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			Expression expr;
			setState(388);
			((MethodCallContext)_localctx).other = otherExpression();
			expr = ((MethodCallContext)_localctx).other.expr; 
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(405);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(390);
						((MethodCallContext)_localctx).par = match(LPAR);
						setState(391);
						((MethodCallContext)_localctx).m = methodCallArguments();
						setState(392);
						match(RPAR);
						MethodCall newmet = new MethodCall(expr, ((MethodCallContext)_localctx).m.metargRet);
						                                      newmet.setLine(((MethodCallContext)_localctx).par.getLine()); expr = newmet;
						}
						}
						break;
					case DOT:
						{
						{
						setState(395);
						match(DOT);
						setState(396);
						((MethodCallContext)_localctx).id = identifier();
						ObjectOrListMemberAccess obj = new ObjectOrListMemberAccess(expr, ((MethodCallContext)_localctx).id.my_id);
						                            obj.setLine(((MethodCallContext)_localctx).id.my_id.getLine()); expr = obj;
						}
						}
						break;
					case LBRACK:
						{
						{
						setState(399);
						((MethodCallContext)_localctx).lb = match(LBRACK);
						setState(400);
						((MethodCallContext)_localctx).e = expression();
						setState(401);
						match(RBRACK);
						}
						ListAccessByIndex ac = new ListAccessByIndex(expr,((MethodCallContext)_localctx).e.expr);
						                                    ac.setLine(((MethodCallContext)_localctx).lb.getLine()); expr = ac;
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			{
			setState(410);
			((MethodCallContext)_localctx).l = match(LPAR);
			setState(411);
			((MethodCallContext)_localctx).met = methodCallArguments();
			setState(412);
			match(RPAR);
			((MethodCallContext)_localctx).methodcallRet =  new MethodCall(expr, ((MethodCallContext)_localctx).met.metargRet);
			}
			_localctx.methodcallRet.setLine(((MethodCallContext)_localctx).l.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallArgumentsContext extends ParserRuleContext {
		public ArrayList<Expression> metargRet;
		public ExpressionContext ex1;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SophiaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SophiaParser.COMMA, i);
		}
		public MethodCallArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterMethodCallArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitMethodCallArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitMethodCallArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallArgumentsContext methodCallArguments() throws RecognitionException {
		MethodCallArgumentsContext _localctx = new MethodCallArgumentsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_methodCallArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((MethodCallArgumentsContext)_localctx).metargRet =  new ArrayList<>();
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << THIS) | (1L << MINUS) | (1L << NOT) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LPAR) | (1L << LBRACK) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				setState(418);
				((MethodCallArgumentsContext)_localctx).ex1 = expression();
				_localctx.metargRet.add(((MethodCallArgumentsContext)_localctx).ex1.expr);
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(420);
					match(COMMA);
					setState(421);
					((MethodCallArgumentsContext)_localctx).ex2 = expression();
					_localctx.metargRet.add(((MethodCallArgumentsContext)_localctx).ex2.expr);
					}
					}
					setState(428);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinueBreakStatementContext extends ParserRuleContext {
		public Statement stmt;
		public Token b;
		public Token c;
		public TerminalNode SEMICOLLON() { return getToken(SophiaParser.SEMICOLLON, 0); }
		public TerminalNode BREAK() { return getToken(SophiaParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(SophiaParser.CONTINUE, 0); }
		public ContinueBreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueBreakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterContinueBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitContinueBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitContinueBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueBreakStatementContext continueBreakStatement() throws RecognitionException {
		ContinueBreakStatementContext _localctx = new ContinueBreakStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_continueBreakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BREAK:
				{
				setState(431);
				((ContinueBreakStatementContext)_localctx).b = match(BREAK);
				((ContinueBreakStatementContext)_localctx).stmt =  new BreakStmt();
				             _localctx.stmt.setLine(((ContinueBreakStatementContext)_localctx).b.getLine());
				            
				}
				break;
			case CONTINUE:
				{
				setState(433);
				((ContinueBreakStatementContext)_localctx).c = match(CONTINUE);
				((ContinueBreakStatementContext)_localctx).stmt =  new ContinueStmt();
				               _localctx.stmt.setLine(((ContinueBreakStatementContext)_localctx).c.getLine());
				               
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(437);
			match(SEMICOLLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public ForStmt forRet;
		public Token f;
		public AssignmentContext a;
		public ExpressionContext b;
		public AssignmentContext c;
		public StatementContext d;
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public List<TerminalNode> SEMICOLLON() { return getTokens(SophiaParser.SEMICOLLON); }
		public TerminalNode SEMICOLLON(int i) {
			return getToken(SophiaParser.SEMICOLLON, i);
		}
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public TerminalNode FOR() { return getToken(SophiaParser.FOR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ForStatementContext)_localctx).forRet =  new ForStmt();
			setState(440);
			((ForStatementContext)_localctx).f = match(FOR);
			setState(441);
			match(LPAR);
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << THIS) | (1L << MINUS) | (1L << NOT) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LPAR) | (1L << LBRACK) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				setState(442);
				((ForStatementContext)_localctx).a = assignment();
				_localctx.forRet.setInitialize(((ForStatementContext)_localctx).a.stmt);
				}
			}

			setState(447);
			match(SEMICOLLON);
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << THIS) | (1L << MINUS) | (1L << NOT) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LPAR) | (1L << LBRACK) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				setState(448);
				((ForStatementContext)_localctx).b = expression();
				_localctx.forRet.setCondition(((ForStatementContext)_localctx).b.expr);
				}
			}

			setState(453);
			match(SEMICOLLON);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << THIS) | (1L << MINUS) | (1L << NOT) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LPAR) | (1L << LBRACK) | (1L << INT_VALUE) | (1L << IDENTIFIER) | (1L << STRING_VALUE))) != 0)) {
				{
				setState(454);
				((ForStatementContext)_localctx).c = assignment();
				_localctx.forRet.setUpdate(((ForStatementContext)_localctx).c.stmt);
				}
			}

			setState(459);
			match(RPAR);
			setState(460);
			((ForStatementContext)_localctx).d = statement();
			_localctx.forRet.setBody(((ForStatementContext)_localctx).d.stmt);
			_localctx.forRet.setLine(((ForStatementContext)_localctx).f.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForeachStatementContext extends ParserRuleContext {
		public ForeachStmt foreachRet;
		public Token f;
		public IdentifierContext id;
		public ExpressionContext ex;
		public StatementContext st;
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public TerminalNode IN() { return getToken(SophiaParser.IN, 0); }
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public TerminalNode FOREACH() { return getToken(SophiaParser.FOREACH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterForeachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitForeachStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitForeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_foreachStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			((ForeachStatementContext)_localctx).f = match(FOREACH);
			setState(465);
			match(LPAR);
			setState(466);
			((ForeachStatementContext)_localctx).id = identifier();
			setState(467);
			match(IN);
			setState(468);
			((ForeachStatementContext)_localctx).ex = expression();
			setState(469);
			match(RPAR);
			setState(470);
			((ForeachStatementContext)_localctx).st = statement();
			((ForeachStatementContext)_localctx).foreachRet =  new ForeachStmt(((ForeachStatementContext)_localctx).id.my_id, ((ForeachStatementContext)_localctx).ex.expr);
			     _localctx.foreachRet.setBody(((ForeachStatementContext)_localctx).st.stmt);
			_localctx.foreachRet.setLine(((ForeachStatementContext)_localctx).f.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ConditionalStmt ifRet;
		public Token cond;
		public ExpressionContext ex;
		public StatementContext st;
		public StatementContext st2;
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public TerminalNode IF() { return getToken(SophiaParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SophiaParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			((IfStatementContext)_localctx).cond = match(IF);
			setState(475);
			match(LPAR);
			setState(476);
			((IfStatementContext)_localctx).ex = expression();
			setState(477);
			match(RPAR);
			setState(478);
			((IfStatementContext)_localctx).st = statement();
			((IfStatementContext)_localctx).ifRet =  new ConditionalStmt(((IfStatementContext)_localctx).ex.expr, ((IfStatementContext)_localctx).st.stmt);
			setState(484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(480);
				match(ELSE);
				setState(481);
				((IfStatementContext)_localctx).st2 = statement();
				_localctx.ifRet.setElseBody(((IfStatementContext)_localctx).st2.stmt);
				}
				break;
			}
			_localctx.ifRet.setLine(((IfStatementContext)_localctx).cond.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression expr;
		public OrExpressionContext l;
		public Token as;
		public ExpressionContext r;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SophiaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			((ExpressionContext)_localctx).l = orExpression();
			((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).l.expr ;
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(490);
				((ExpressionContext)_localctx).as = match(ASSIGN);
				setState(491);
				((ExpressionContext)_localctx).r = expression();
				 ((ExpressionContext)_localctx).expr =  new BinaryExpression(((ExpressionContext)_localctx).l.expr,((ExpressionContext)_localctx).r.expr,BinaryOperator.assign);
				                               _localctx.expr.setLine(((ExpressionContext)_localctx).as.getLine());
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpressionContext extends ParserRuleContext {
		public Expression expr;
		public AndExpressionContext l;
		public Token op;
		public AndExpressionContext r;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SophiaParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SophiaParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			((OrExpressionContext)_localctx).l = andExpression();
			((OrExpressionContext)_localctx).expr =  ((OrExpressionContext)_localctx).l.expr ;
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(498);
				((OrExpressionContext)_localctx).op = match(OR);
				setState(499);
				((OrExpressionContext)_localctx).r = andExpression();
				 ((OrExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((OrExpressionContext)_localctx).r.expr,BinaryOperator.or); _localctx.expr.setLine(((OrExpressionContext)_localctx).op.getLine());
				}
				}
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public Expression expr;
		public EqualityExpressionContext l;
		public Token op;
		public EqualityExpressionContext r;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SophiaParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SophiaParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			((AndExpressionContext)_localctx).l = equalityExpression();
			((AndExpressionContext)_localctx).expr =  ((AndExpressionContext)_localctx).l.expr ;
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(509);
				((AndExpressionContext)_localctx).op = match(AND);
				setState(510);
				((AndExpressionContext)_localctx).r = equalityExpression();
				 ((AndExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((AndExpressionContext)_localctx).r.expr,BinaryOperator.and); {_localctx.expr.setLine(((AndExpressionContext)_localctx).op.getLine());} 
				}
				}
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression expr;
		public RelationalExpressionContext l;
		public Token op1;
		public RelationalExpressionContext r;
		public Token op2;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(SophiaParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(SophiaParser.EQUAL, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(SophiaParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(SophiaParser.NOT_EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			((EqualityExpressionContext)_localctx).l = relationalExpression();
			((EqualityExpressionContext)_localctx).expr =  ((EqualityExpressionContext)_localctx).l.expr ;
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOT_EQUAL || _la==EQUAL) {
				{
				setState(530);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EQUAL:
					{
					setState(520);
					((EqualityExpressionContext)_localctx).op1 = match(EQUAL);
					setState(521);
					((EqualityExpressionContext)_localctx).r = relationalExpression();
					 ((EqualityExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((EqualityExpressionContext)_localctx).r.expr,BinaryOperator.eq); 
					_localctx.expr.setLine(((EqualityExpressionContext)_localctx).op1.getLine());
					}
					break;
				case NOT_EQUAL:
					{
					setState(525);
					((EqualityExpressionContext)_localctx).op2 = match(NOT_EQUAL);
					setState(526);
					((EqualityExpressionContext)_localctx).r = relationalExpression();
					 ((EqualityExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((EqualityExpressionContext)_localctx).r.expr,BinaryOperator.neq); 
					{_localctx.expr.setLine(((EqualityExpressionContext)_localctx).op2.getLine());}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression expr;
		public AdditiveExpressionContext l;
		public Token op1;
		public AdditiveExpressionContext r;
		public Token op2;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(SophiaParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(SophiaParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(SophiaParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(SophiaParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			((RelationalExpressionContext)_localctx).l = additiveExpression();
			((RelationalExpressionContext)_localctx).expr =  ((RelationalExpressionContext)_localctx).l.expr ;
			setState(547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				setState(545);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					setState(537);
					((RelationalExpressionContext)_localctx).op1 = match(GREATER_THAN);
					setState(538);
					((RelationalExpressionContext)_localctx).r = additiveExpression();
					 ((RelationalExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((RelationalExpressionContext)_localctx).r.expr,BinaryOperator.gt);
					                                                {_localctx.expr.setLine(((RelationalExpressionContext)_localctx).op1.getLine());}
					}
					break;
				case LESS_THAN:
					{
					setState(541);
					((RelationalExpressionContext)_localctx).op2 = match(LESS_THAN);
					setState(542);
					((RelationalExpressionContext)_localctx).r = additiveExpression();
					 ((RelationalExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((RelationalExpressionContext)_localctx).r.expr,BinaryOperator.lt);
					                                        {_localctx.expr.setLine(((RelationalExpressionContext)_localctx).op2.getLine());}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(549);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression expr;
		public MultiplicativeExpressionContext l;
		public Token op1;
		public MultiplicativeExpressionContext r;
		public Token op2;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SophiaParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SophiaParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SophiaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SophiaParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			((AdditiveExpressionContext)_localctx).l = multiplicativeExpression();
			((AdditiveExpressionContext)_localctx).expr =  ((AdditiveExpressionContext)_localctx).l.expr;
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(560);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(552);
					((AdditiveExpressionContext)_localctx).op1 = match(PLUS);
					setState(553);
					((AdditiveExpressionContext)_localctx).r = multiplicativeExpression();
					 ((AdditiveExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((AdditiveExpressionContext)_localctx).r.expr,BinaryOperator.add);
					                                        {_localctx.expr.setLine(((AdditiveExpressionContext)_localctx).op1.getLine());}
					}
					break;
				case MINUS:
					{
					setState(556);
					((AdditiveExpressionContext)_localctx).op2 = match(MINUS);
					setState(557);
					((AdditiveExpressionContext)_localctx).r = multiplicativeExpression();
					 ((AdditiveExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((AdditiveExpressionContext)_localctx).r.expr,BinaryOperator.sub);
					                                        {_localctx.expr.setLine(((AdditiveExpressionContext)_localctx).op2.getLine());}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression expr;
		public PreUnaryExpressionContext l;
		public Token op1;
		public PreUnaryExpressionContext r;
		public Token op2;
		public Token op3;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(SophiaParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(SophiaParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(SophiaParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(SophiaParser.DIVIDE, i);
		}
		public List<TerminalNode> MOD() { return getTokens(SophiaParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(SophiaParser.MOD, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			((MultiplicativeExpressionContext)_localctx).l = preUnaryExpression();
			((MultiplicativeExpressionContext)_localctx).expr =  ((MultiplicativeExpressionContext)_localctx).l.expr;
			setState(581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIVIDE) | (1L << MOD))) != 0)) {
				{
				setState(579);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(567);
					((MultiplicativeExpressionContext)_localctx).op1 = match(MULT);
					setState(568);
					((MultiplicativeExpressionContext)_localctx).r = preUnaryExpression();
					 ((MultiplicativeExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((MultiplicativeExpressionContext)_localctx).r.expr,BinaryOperator.mult);
					                                {_localctx.expr.setLine(((MultiplicativeExpressionContext)_localctx).op1.getLine());}
					}
					break;
				case DIVIDE:
					{
					setState(571);
					((MultiplicativeExpressionContext)_localctx).op2 = match(DIVIDE);
					setState(572);
					((MultiplicativeExpressionContext)_localctx).r = preUnaryExpression();
					 ((MultiplicativeExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((MultiplicativeExpressionContext)_localctx).r.expr,BinaryOperator.div);
					                                    {_localctx.expr.setLine(((MultiplicativeExpressionContext)_localctx).op2.getLine());}
					}
					break;
				case MOD:
					{
					setState(575);
					((MultiplicativeExpressionContext)_localctx).op3 = match(MOD);
					setState(576);
					((MultiplicativeExpressionContext)_localctx).r = preUnaryExpression();
					 ((MultiplicativeExpressionContext)_localctx).expr =  new BinaryExpression(_localctx.expr,((MultiplicativeExpressionContext)_localctx).r.expr,BinaryOperator.mod);
					                                {_localctx.expr.setLine(((MultiplicativeExpressionContext)_localctx).op3.getLine());}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Expression expr;
		public Token op1;
		public Token op2;
		public Token op3;
		public Token op4;
		public PreUnaryExpressionContext op;
		public PostUnaryExpressionContext o;
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SophiaParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(SophiaParser.MINUS, 0); }
		public TerminalNode INCREMENT() { return getToken(SophiaParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(SophiaParser.DECREMENT, 0); }
		public PostUnaryExpressionContext postUnaryExpression() {
			return getRuleContext(PostUnaryExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_preUnaryExpression);
		try {
			setState(602);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case INCREMENT:
			case DECREMENT:
				enterOuterAlt(_localctx, 1);
				{
				UnaryOperator u;
				int line;
				{
				setState(594);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(586);
					((PreUnaryExpressionContext)_localctx).op1 = match(NOT);
					u = UnaryOperator.not; line = ((PreUnaryExpressionContext)_localctx).op1.getLine();
					}
					break;
				case MINUS:
					{
					setState(588);
					((PreUnaryExpressionContext)_localctx).op2 = match(MINUS);
					u = UnaryOperator.minus; line = ((PreUnaryExpressionContext)_localctx).op2.getLine();
					}
					break;
				case INCREMENT:
					{
					setState(590);
					((PreUnaryExpressionContext)_localctx).op3 = match(INCREMENT);
					u = UnaryOperator.preinc; line = ((PreUnaryExpressionContext)_localctx).op3.getLine();
					}
					break;
				case DECREMENT:
					{
					setState(592);
					((PreUnaryExpressionContext)_localctx).op4 = match(DECREMENT);
					u = UnaryOperator.predec; line = ((PreUnaryExpressionContext)_localctx).op4.getLine();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(596);
				((PreUnaryExpressionContext)_localctx).op = preUnaryExpression();
				((PreUnaryExpressionContext)_localctx).expr =  new UnaryExpression(((PreUnaryExpressionContext)_localctx).op.expr,u);
				                           _localctx.expr.setLine(line);
				}
				}
				break;
			case NEW:
			case NULL:
			case TRUE:
			case FALSE:
			case THIS:
			case LPAR:
			case LBRACK:
			case INT_VALUE:
			case IDENTIFIER:
			case STRING_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(599);
				((PreUnaryExpressionContext)_localctx).o = postUnaryExpression();
				((PreUnaryExpressionContext)_localctx).expr =  ((PreUnaryExpressionContext)_localctx).o.expr;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostUnaryExpressionContext extends ParserRuleContext {
		public Expression expr;
		public AccessExpressionContext a;
		public Token op1;
		public Token op2;
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(SophiaParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(SophiaParser.DECREMENT, 0); }
		public PostUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterPostUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitPostUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitPostUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostUnaryExpressionContext postUnaryExpression() throws RecognitionException {
		PostUnaryExpressionContext _localctx = new PostUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_postUnaryExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			((PostUnaryExpressionContext)_localctx).a = accessExpression();
			((PostUnaryExpressionContext)_localctx).expr =  ((PostUnaryExpressionContext)_localctx).a.expr;
			setState(610);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCREMENT:
				{
				setState(606);
				((PostUnaryExpressionContext)_localctx).op1 = match(INCREMENT);
				((PostUnaryExpressionContext)_localctx).expr =  new UnaryExpression(_localctx.expr,UnaryOperator.postinc);
				                   _localctx.expr.setLine(((PostUnaryExpressionContext)_localctx).op1.getLine());
				}
				break;
			case DECREMENT:
				{
				setState(608);
				((PostUnaryExpressionContext)_localctx).op2 = match(DECREMENT);
				((PostUnaryExpressionContext)_localctx).expr =  new UnaryExpression(_localctx.expr,UnaryOperator.postdec);
				               _localctx.expr.setLine(((PostUnaryExpressionContext)_localctx).op2.getLine());
				}
				break;
			case GREATER_THAN:
			case LESS_THAN:
			case NOT_EQUAL:
			case EQUAL:
			case MULT:
			case DIVIDE:
			case MOD:
			case PLUS:
			case MINUS:
			case AND:
			case OR:
			case ASSIGN:
			case RPAR:
			case RBRACK:
			case COMMA:
			case SEMICOLLON:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessExpressionContext extends ParserRuleContext {
		public Expression expr;
		public OtherExpressionContext other;
		public Token op1;
		public MethodCallArgumentsContext met;
		public IdentifierContext id;
		public Token op2;
		public ExpressionContext e;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(SophiaParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(SophiaParser.RPAR, i);
		}
		public List<TerminalNode> DOT() { return getTokens(SophiaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SophiaParser.DOT, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(SophiaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(SophiaParser.RBRACK, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(SophiaParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(SophiaParser.LPAR, i);
		}
		public List<MethodCallArgumentsContext> methodCallArguments() {
			return getRuleContexts(MethodCallArgumentsContext.class);
		}
		public MethodCallArgumentsContext methodCallArguments(int i) {
			return getRuleContext(MethodCallArgumentsContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(SophiaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(SophiaParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_accessExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			((AccessExpressionContext)_localctx).other = otherExpression();
			((AccessExpressionContext)_localctx).expr =  ((AccessExpressionContext)_localctx).other.expr;
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << LBRACK) | (1L << DOT))) != 0)) {
				{
				setState(629);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAR:
					{
					{
					setState(614);
					((AccessExpressionContext)_localctx).op1 = match(LPAR);
					setState(615);
					((AccessExpressionContext)_localctx).met = methodCallArguments();
					setState(616);
					match(RPAR);
					}
					MethodCall method = new MethodCall(_localctx.expr, ((AccessExpressionContext)_localctx).met.metargRet);
					                                               method.setLine(((AccessExpressionContext)_localctx).op1.getLine());
					                                               ((AccessExpressionContext)_localctx).expr =  method;
					}
					break;
				case DOT:
					{
					{
					setState(620);
					match(DOT);
					setState(621);
					((AccessExpressionContext)_localctx).id = identifier();
					ObjectOrListMemberAccess obj = new ObjectOrListMemberAccess(_localctx.expr,((AccessExpressionContext)_localctx).id.my_id);
					                       obj.setLine(((AccessExpressionContext)_localctx).id.my_id.getLine());
					                       ((AccessExpressionContext)_localctx).expr =  obj;
					}
					}
					break;
				case LBRACK:
					{
					{
					setState(624);
					((AccessExpressionContext)_localctx).op2 = match(LBRACK);
					setState(625);
					((AccessExpressionContext)_localctx).e = expression();
					setState(626);
					match(RBRACK);
					ListAccessByIndex ac = new ListAccessByIndex(_localctx.expr,((AccessExpressionContext)_localctx).e.expr);
					                                        ac.setLine(((AccessExpressionContext)_localctx).op2.getLine());
					                                        ((AccessExpressionContext)_localctx).expr =  ac;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(633);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherExpressionContext extends ParserRuleContext {
		public Expression expr;
		public Token t;
		public NewExpressionContext n;
		public ValuesContext v;
		public IdentifierContext id;
		public ExpressionContext e;
		public TerminalNode THIS() { return getToken(SophiaParser.THIS, 0); }
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_otherExpression);
		try {
			setState(650);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(634);
				((OtherExpressionContext)_localctx).t = match(THIS);
				ThisClass tclas = new ThisClass();
				                                                    tclas.setLine(((OtherExpressionContext)_localctx).t.getLine());
				                                                    ((OtherExpressionContext)_localctx).expr =  tclas;
				}
				break;
			case NEW:
				enterOuterAlt(_localctx, 2);
				{
				setState(636);
				((OtherExpressionContext)_localctx).n = newExpression();
				((OtherExpressionContext)_localctx).expr =  ((OtherExpressionContext)_localctx).n.expr;
				}
				break;
			case NULL:
			case TRUE:
			case FALSE:
			case LBRACK:
			case INT_VALUE:
			case STRING_VALUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(639);
				((OtherExpressionContext)_localctx).v = values();
				((OtherExpressionContext)_localctx).expr =  ((OtherExpressionContext)_localctx).v.val;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(642);
				((OtherExpressionContext)_localctx).id = identifier();
				((OtherExpressionContext)_localctx).expr =  ((OtherExpressionContext)_localctx).id.my_id;
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(645);
				match(LPAR);
				{
				setState(646);
				((OtherExpressionContext)_localctx).e = expression();
				}
				setState(647);
				match(RPAR);
				((OtherExpressionContext)_localctx).expr =  ((OtherExpressionContext)_localctx).e.expr;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExpressionContext extends ParserRuleContext {
		public Expression expr;
		public Token n;
		public ClassTypeContext c;
		public MethodCallArgumentsContext met;
		public TerminalNode LPAR() { return getToken(SophiaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SophiaParser.RPAR, 0); }
		public TerminalNode NEW() { return getToken(SophiaParser.NEW, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public MethodCallArgumentsContext methodCallArguments() {
			return getRuleContext(MethodCallArgumentsContext.class,0);
		}
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_newExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			((NewExpressionContext)_localctx).n = match(NEW);
			setState(653);
			((NewExpressionContext)_localctx).c = classType();
			setState(654);
			match(LPAR);
			setState(655);
			((NewExpressionContext)_localctx).met = methodCallArguments();
			setState(656);
			match(RPAR);
			((NewExpressionContext)_localctx).expr =  new NewClassInstance(((NewExpressionContext)_localctx).c.classTypeRet, ((NewExpressionContext)_localctx).met.metargRet);
			 _localctx.expr.setLine(((NewExpressionContext)_localctx).n.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesContext extends ParserRuleContext {
		public Value val;
		public BoolValueContext b;
		public Token str;
		public Token my_int;
		public Token n;
		public ListValueContext l;
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode STRING_VALUE() { return getToken(SophiaParser.STRING_VALUE, 0); }
		public TerminalNode INT_VALUE() { return getToken(SophiaParser.INT_VALUE, 0); }
		public TerminalNode NULL() { return getToken(SophiaParser.NULL, 0); }
		public ListValueContext listValue() {
			return getRuleContext(ListValueContext.class,0);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_values);
		try {
			setState(671);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(659);
				((ValuesContext)_localctx).b = boolValue();
				((ValuesContext)_localctx).val =  ((ValuesContext)_localctx).b.val;
				}
				break;
			case STRING_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(662);
				((ValuesContext)_localctx).str = match(STRING_VALUE);
				((ValuesContext)_localctx).val =  new StringValue((((ValuesContext)_localctx).str!=null?((ValuesContext)_localctx).str.getText():null).replaceAll("^\"|\"$", ""));
				                             _localctx.val.setLine(((ValuesContext)_localctx).str.getLine());
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(664);
				((ValuesContext)_localctx).my_int = match(INT_VALUE);
				((ValuesContext)_localctx).val =  new IntValue((((ValuesContext)_localctx).my_int!=null?Integer.valueOf(((ValuesContext)_localctx).my_int.getText()):0));
				                             _localctx.val.setLine(((ValuesContext)_localctx).my_int.getLine());
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(666);
				((ValuesContext)_localctx).n = match(NULL);
				NullValue temp = new NullValue();
				                  temp.setLine(((ValuesContext)_localctx).n.getLine());
				                  ((ValuesContext)_localctx).val =  temp;
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 5);
				{
				setState(668);
				((ValuesContext)_localctx).l = listValue();
				((ValuesContext)_localctx).val =  ((ValuesContext)_localctx).l.listval;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolValueContext extends ParserRuleContext {
		public Value val;
		public Token t;
		public Token f;
		public TerminalNode TRUE() { return getToken(SophiaParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SophiaParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_boolValue);
		try {
			setState(677);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(673);
				((BoolValueContext)_localctx).t = match(TRUE);
				((BoolValueContext)_localctx).val =  new BoolValue(true);
				                                              _localctx.val.setLine(((BoolValueContext)_localctx).t.getLine());
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(675);
				((BoolValueContext)_localctx).f = match(FALSE);
				((BoolValueContext)_localctx).val =  new BoolValue(false);
				                                               _localctx.val.setLine(((BoolValueContext)_localctx).f.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListValueContext extends ParserRuleContext {
		public ListValue listval;
		public Token op;
		public MethodCallArgumentsContext met;
		public TerminalNode RBRACK() { return getToken(SophiaParser.RBRACK, 0); }
		public TerminalNode LBRACK() { return getToken(SophiaParser.LBRACK, 0); }
		public MethodCallArgumentsContext methodCallArguments() {
			return getRuleContext(MethodCallArgumentsContext.class,0);
		}
		public ListValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterListValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitListValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitListValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListValueContext listValue() throws RecognitionException {
		ListValueContext _localctx = new ListValueContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_listValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			((ListValueContext)_localctx).op = match(LBRACK);
			setState(680);
			((ListValueContext)_localctx).met = methodCallArguments();
			setState(681);
			match(RBRACK);
			((ListValueContext)_localctx).listval =  new ListValue(((ListValueContext)_localctx).met.metargRet);
			_localctx.listval.setLine(((ListValueContext)_localctx).op.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier my_id;
		public Token id;
		public TerminalNode IDENTIFIER() { return getToken(SophiaParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SophiaListener ) ((SophiaListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SophiaVisitor ) return ((SophiaVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			((IdentifierContext)_localctx).id = match(IDENTIFIER);
			((IdentifierContext)_localctx).my_id =  new Identifier((((IdentifierContext)_localctx).id!=null?((IdentifierContext)_localctx).id.getText():null));
			                     _localctx.my_id.setLine(((IdentifierContext)_localctx).id.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u02b3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3g\n\3\f\3\16"+
		"\3j\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4s\n\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\7\4|\n\4\f\4\16\4\177\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0089"+
		"\n\4\f\4\16\4\u008c\13\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0094\n\4\f\4\16"+
		"\4\u0097\13\4\5\4\u0099\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\5\6\u00a7\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\b\u00c7\n\b\f\b\16\b\u00ca\13\b\5\b\u00cc\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00df\n\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ef\n\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00fa\n\r\f\r\16\r\u00fd\13\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u0105\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u010e\n\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0116\n\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0121\n\20\f\20\16\20"+
		"\u0124\13\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u012c\n\21\3\22\3\22\3"+
		"\22\3\22\7\22\u0132\n\22\f\22\16\22\u0135\13\22\3\22\3\22\3\22\7\22\u013a"+
		"\n\22\f\22\16\22\u013d\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u015a\n\23\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u0161\n\24\f\24\16\24\u0164\13\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u017e\n\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\7\32\u0198\n\32\f\32\16\32\u019b\13\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u01ab\n\33\f\33"+
		"\16\33\u01ae\13\33\5\33\u01b0\n\33\3\34\3\34\3\34\3\34\5\34\u01b6\n\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01c0\n\35\3\35\3\35\3\35"+
		"\3\35\5\35\u01c6\n\35\3\35\3\35\3\35\3\35\5\35\u01cc\n\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u01e7\n\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3 \5 \u01f1\n \3!\3!\3!\3!\3!\3!\7!\u01f9\n!\f!\16!\u01fc"+
		"\13!\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0204\n\"\f\"\16\"\u0207\13\"\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u0215\n#\f#\16#\u0218\13#\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\7$\u0224\n$\f$\16$\u0227\13$\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\7%\u0233\n%\f%\16%\u0236\13%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\7&\u0246\n&\f&\16&\u0249\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\5\'\u0255\n\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u025d\n\'\3(\3(\3("+
		"\3(\3(\3(\5(\u0265\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\7)\u0278\n)\f)\16)\u027b\13)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\5*\u028d\n*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\5,\u02a2\n,\3-\3-\3-\3-\5-\u02a8\n-\3.\3.\3.\3.\3.\3.\3/\3"+
		"/\3/\3/\2\2\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\\2\2\2\u02cf\2^\3\2\2\2\4b\3\2\2\2\6k\3\2\2\2\b"+
		"\u009c\3\2\2\2\n\u00a3\3\2\2\2\f\u00b3\3\2\2\2\16\u00bf\3\2\2\2\20\u00cd"+
		"\3\2\2\2\22\u00de\3\2\2\2\24\u00e0\3\2\2\2\26\u00e3\3\2\2\2\30\u00f2\3"+
		"\2\2\2\32\u0104\3\2\2\2\34\u0106\3\2\2\2\36\u0119\3\2\2\2 \u012b\3\2\2"+
		"\2\"\u012d\3\2\2\2$\u0159\3\2\2\2&\u015b\3\2\2\2(\u0168\3\2\2\2*\u016c"+
		"\3\2\2\2,\u0171\3\2\2\2.\u0178\3\2\2\2\60\u0181\3\2\2\2\62\u0185\3\2\2"+
		"\2\64\u01a3\3\2\2\2\66\u01b5\3\2\2\28\u01b9\3\2\2\2:\u01d2\3\2\2\2<\u01dc"+
		"\3\2\2\2>\u01ea\3\2\2\2@\u01f2\3\2\2\2B\u01fd\3\2\2\2D\u0208\3\2\2\2F"+
		"\u0219\3\2\2\2H\u0228\3\2\2\2J\u0237\3\2\2\2L\u025c\3\2\2\2N\u025e\3\2"+
		"\2\2P\u0266\3\2\2\2R\u028c\3\2\2\2T\u028e\3\2\2\2V\u02a1\3\2\2\2X\u02a7"+
		"\3\2\2\2Z\u02a9\3\2\2\2\\\u02af\3\2\2\2^_\5\4\3\2_`\b\2\1\2`a\7\2\2\3"+
		"a\3\3\2\2\2bh\b\3\1\2cd\5\6\4\2de\b\3\1\2eg\3\2\2\2fc\3\2\2\2gj\3\2\2"+
		"\2hf\3\2\2\2hi\3\2\2\2i\5\3\2\2\2jh\3\2\2\2kl\7\5\2\2lm\5\\/\2mr\b\4\1"+
		"\2no\7\4\2\2op\5\\/\2pq\b\4\1\2qs\3\2\2\2rn\3\2\2\2rs\3\2\2\2st\3\2\2"+
		"\2t\u0098\7/\2\2uv\5\b\5\2vw\b\4\1\2w|\3\2\2\2xy\5\n\6\2yz\b\4\1\2z|\3"+
		"\2\2\2{u\3\2\2\2{x\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2"+
		"\2\2\177}\3\2\2\2\u0080\u0081\5\f\7\2\u0081\u008a\b\4\1\2\u0082\u0083"+
		"\5\b\5\2\u0083\u0084\b\4\1\2\u0084\u0089\3\2\2\2\u0085\u0086\5\n\6\2\u0086"+
		"\u0087\b\4\1\2\u0087\u0089\3\2\2\2\u0088\u0082\3\2\2\2\u0088\u0085\3\2"+
		"\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u0099\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\5\b\5\2\u008e\u008f\b\4"+
		"\1\2\u008f\u0094\3\2\2\2\u0090\u0091\5\n\6\2\u0091\u0092\b\4\1\2\u0092"+
		"\u0094\3\2\2\2\u0093\u008d\3\2\2\2\u0093\u0090\3\2\2\2\u0094\u0097\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098}\3\2\2\2\u0098\u0095\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u009a\u009b\7\60\2\2\u009b\7\3\2\2\2\u009c\u009d\5\\/\2\u009d\u009e\7"+
		"\64\2\2\u009e\u009f\5\22\n\2\u009f\u00a0\7\65\2\2\u00a0\u00a1\b\5\1\2"+
		"\u00a1\u00a2\b\5\1\2\u00a2\t\3\2\2\2\u00a3\u00a6\7\3\2\2\u00a4\u00a7\5"+
		"\22\n\2\u00a5\u00a7\7\24\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\5\\/\2\u00a9\u00aa\b\6\1\2\u00aa\u00ab\7+\2"+
		"\2\u00ab\u00ac\5\16\b\2\u00ac\u00ad\b\6\1\2\u00ad\u00ae\7,\2\2\u00ae\u00af"+
		"\7/\2\2\u00af\u00b0\5\"\22\2\u00b0\u00b1\b\6\1\2\u00b1\u00b2\7\60\2\2"+
		"\u00b2\13\3\2\2\2\u00b3\u00b4\7\3\2\2\u00b4\u00b5\5\\/\2\u00b5\u00b6\b"+
		"\7\1\2\u00b6\u00b7\7+\2\2\u00b7\u00b8\5\16\b\2\u00b8\u00b9\b\7\1\2\u00b9"+
		"\u00ba\7,\2\2\u00ba\u00bb\7/\2\2\u00bb\u00bc\5\"\22\2\u00bc\u00bd\b\7"+
		"\1\2\u00bd\u00be\7\60\2\2\u00be\r\3\2\2\2\u00bf\u00cb\b\b\1\2\u00c0\u00c1"+
		"\5\20\t\2\u00c1\u00c8\b\b\1\2\u00c2\u00c3\7\62\2\2\u00c3\u00c4\5\20\t"+
		"\2\u00c4\u00c5\b\b\1\2\u00c5\u00c7\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c7\u00ca"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00c0\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\17\3\2\2"+
		"\2\u00cd\u00ce\5\\/\2\u00ce\u00cf\7\64\2\2\u00cf\u00d0\5\22\n\2\u00d0"+
		"\u00d1\b\t\1\2\u00d1\21\3\2\2\2\u00d2\u00d3\5 \21\2\u00d3\u00d4\b\n\1"+
		"\2\u00d4\u00df\3\2\2\2\u00d5\u00d6\5\26\f\2\u00d6\u00d7\b\n\1\2\u00d7"+
		"\u00df\3\2\2\2\u00d8\u00d9\5\34\17\2\u00d9\u00da\b\n\1\2\u00da\u00df\3"+
		"\2\2\2\u00db\u00dc\5\24\13\2\u00dc\u00dd\b\n\1\2\u00dd\u00df\3\2\2\2\u00de"+
		"\u00d2\3\2\2\2\u00de\u00d5\3\2\2\2\u00de\u00d8\3\2\2\2\u00de\u00db\3\2"+
		"\2\2\u00df\23\3\2\2\2\u00e0\u00e1\5\\/\2\u00e1\u00e2\b\13\1\2\u00e2\25"+
		"\3\2\2\2\u00e3\u00e4\7\26\2\2\u00e4\u00ee\7+\2\2\u00e5\u00e6\7\66\2\2"+
		"\u00e6\u00e7\7\61\2\2\u00e7\u00e8\5\22\n\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea"+
		"\b\f\1\2\u00ea\u00ef\3\2\2\2\u00eb\u00ec\5\30\r\2\u00ec\u00ed\b\f\1\2"+
		"\u00ed\u00ef\3\2\2\2\u00ee\u00e5\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1\27\3\2\2\2\u00f2\u00f3\b\r\1\2\u00f3"+
		"\u00f4\5\32\16\2\u00f4\u00fb\b\r\1\2\u00f5\u00f6\7\62\2\2\u00f6\u00f7"+
		"\5\32\16\2\u00f7\u00f8\b\r\1\2\u00f8\u00fa\3\2\2\2\u00f9\u00f5\3\2\2\2"+
		"\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\31"+
		"\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\5\20\t\2\u00ff\u0100\b\16\1\2"+
		"\u0100\u0105\3\2\2\2\u0101\u0102\5\22\n\2\u0102\u0103\b\16\1\2\u0103\u0105"+
		"\3\2\2\2\u0104\u00fe\3\2\2\2\u0104\u0101\3\2\2\2\u0105\33\3\2\2\2\u0106"+
		"\u0107\b\17\1\2\u0107\u0108\7\7\2\2\u0108\u010d\7\34\2\2\u0109\u010e\7"+
		"\24\2\2\u010a\u010b\5\36\20\2\u010b\u010c\b\17\1\2\u010c\u010e\3\2\2\2"+
		"\u010d\u0109\3\2\2\2\u010d\u010a\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0115"+
		"\7\32\2\2\u0110\u0111\7\24\2\2\u0111\u0116\b\17\1\2\u0112\u0113\5\22\n"+
		"\2\u0113\u0114\b\17\1\2\u0114\u0116\3\2\2\2\u0115\u0110\3\2\2\2\u0115"+
		"\u0112\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\7\33\2\2\u0118\35\3\2\2"+
		"\2\u0119\u011a\b\20\1\2\u011a\u011b\5\22\n\2\u011b\u0122\b\20\1\2\u011c"+
		"\u011d\7\62\2\2\u011d\u011e\5\22\n\2\u011e\u011f\b\20\1\2\u011f\u0121"+
		"\3\2\2\2\u0120\u011c\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\37\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7\23\2"+
		"\2\u0126\u012c\b\21\1\2\u0127\u0128\7\22\2\2\u0128\u012c\b\21\1\2\u0129"+
		"\u012a\7\21\2\2\u012a\u012c\b\21\1\2\u012b\u0125\3\2\2\2\u012b\u0127\3"+
		"\2\2\2\u012b\u0129\3\2\2\2\u012c!\3\2\2\2\u012d\u0133\b\22\1\2\u012e\u012f"+
		"\5\b\5\2\u012f\u0130\b\22\1\2\u0130\u0132\3\2\2\2\u0131\u012e\3\2\2\2"+
		"\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u013b"+
		"\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\5$\23\2\u0137\u0138\b\22\1\2"+
		"\u0138\u013a\3\2\2\2\u0139\u0136\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013b\u013c\3\2\2\2\u013c#\3\2\2\2\u013d\u013b\3\2\2\2\u013e"+
		"\u013f\58\35\2\u013f\u0140\b\23\1\2\u0140\u015a\3\2\2\2\u0141\u0142\5"+
		":\36\2\u0142\u0143\b\23\1\2\u0143\u015a\3\2\2\2\u0144\u0145\5<\37\2\u0145"+
		"\u0146\b\23\1\2\u0146\u015a\3\2\2\2\u0147\u0148\5(\25\2\u0148\u0149\b"+
		"\23\1\2\u0149\u015a\3\2\2\2\u014a\u014b\5,\27\2\u014b\u014c\b\23\1\2\u014c"+
		"\u015a\3\2\2\2\u014d\u014e\5\66\34\2\u014e\u014f\b\23\1\2\u014f\u015a"+
		"\3\2\2\2\u0150\u0151\5\60\31\2\u0151\u0152\b\23\1\2\u0152\u015a\3\2\2"+
		"\2\u0153\u0154\5.\30\2\u0154\u0155\b\23\1\2\u0155\u015a\3\2\2\2\u0156"+
		"\u0157\5&\24\2\u0157\u0158\b\23\1\2\u0158\u015a\3\2\2\2\u0159\u013e\3"+
		"\2\2\2\u0159\u0141\3\2\2\2\u0159\u0144\3\2\2\2\u0159\u0147\3\2\2\2\u0159"+
		"\u014a\3\2\2\2\u0159\u014d\3\2\2\2\u0159\u0150\3\2\2\2\u0159\u0153\3\2"+
		"\2\2\u0159\u0156\3\2\2\2\u015a%\3\2\2\2\u015b\u015c\b\24\1\2\u015c\u0162"+
		"\7/\2\2\u015d\u015e\5$\23\2\u015e\u015f\b\24\1\2\u015f\u0161\3\2\2\2\u0160"+
		"\u015d\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\7\60\2\2\u0166"+
		"\u0167\b\24\1\2\u0167\'\3\2\2\2\u0168\u0169\5*\26\2\u0169\u016a\7\65\2"+
		"\2\u016a\u016b\b\25\1\2\u016b)\3\2\2\2\u016c\u016d\5@!\2\u016d\u016e\7"+
		"(\2\2\u016e\u016f\5> \2\u016f\u0170\b\26\1\2\u0170+\3\2\2\2\u0171\u0172"+
		"\7\6\2\2\u0172\u0173\7+\2\2\u0173\u0174\5> \2\u0174\u0175\7,\2\2\u0175"+
		"\u0176\7\65\2\2\u0176\u0177\b\27\1\2\u0177-\3\2\2\2\u0178\u0179\7\13\2"+
		"\2\u0179\u017d\b\30\1\2\u017a\u017b\5> \2\u017b\u017c\b\30\1\2\u017c\u017e"+
		"\3\2\2\2\u017d\u017a\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f"+
		"\u0180\7\65\2\2\u0180/\3\2\2\2\u0181\u0182\5\62\32\2\u0182\u0183\7\65"+
		"\2\2\u0183\u0184\b\31\1\2\u0184\61\3\2\2\2\u0185\u0186\b\32\1\2\u0186"+
		"\u0187\5R*\2\u0187\u0199\b\32\1\2\u0188\u0189\7+\2\2\u0189\u018a\5\64"+
		"\33\2\u018a\u018b\7,\2\2\u018b\u018c\b\32\1\2\u018c\u0198\3\2\2\2\u018d"+
		"\u018e\7\63\2\2\u018e\u018f\5\\/\2\u018f\u0190\b\32\1\2\u0190\u0198\3"+
		"\2\2\2\u0191\u0192\7-\2\2\u0192\u0193\5> \2\u0193\u0194\7.\2\2\u0194\u0195"+
		"\3\2\2\2\u0195\u0196\b\32\1\2\u0196\u0198\3\2\2\2\u0197\u0188\3\2\2\2"+
		"\u0197\u018d\3\2\2\2\u0197\u0191\3\2\2\2\u0198\u019b\3\2\2\2\u0199\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019c\3\2\2\2\u019b\u0199\3\2\2\2\u019c"+
		"\u019d\7+\2\2\u019d\u019e\5\64\33\2\u019e\u019f\7,\2\2\u019f\u01a0\b\32"+
		"\1\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\b\32\1\2\u01a2\63\3\2\2\2\u01a3\u01af"+
		"\b\33\1\2\u01a4\u01a5\5> \2\u01a5\u01ac\b\33\1\2\u01a6\u01a7\7\62\2\2"+
		"\u01a7\u01a8\5> \2\u01a8\u01a9\b\33\1\2\u01a9\u01ab\3\2\2\2\u01aa\u01a6"+
		"\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01a4\3\2\2\2\u01af\u01b0\3\2"+
		"\2\2\u01b0\65\3\2\2\2\u01b1\u01b2\7\n\2\2\u01b2\u01b6\b\34\1\2\u01b3\u01b4"+
		"\7\t\2\2\u01b4\u01b6\b\34\1\2\u01b5\u01b1\3\2\2\2\u01b5\u01b3\3\2\2\2"+
		"\u01b6\u01b7\3\2\2\2\u01b7\u01b8\7\65\2\2\u01b8\67\3\2\2\2\u01b9\u01ba"+
		"\b\35\1\2\u01ba\u01bb\7\16\2\2\u01bb\u01bf\7+\2\2\u01bc\u01bd\5*\26\2"+
		"\u01bd\u01be\b\35\1\2\u01be\u01c0\3\2\2\2\u01bf\u01bc\3\2\2\2\u01bf\u01c0"+
		"\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c5\7\65\2\2\u01c2\u01c3\5> \2\u01c3"+
		"\u01c4\b\35\1\2\u01c4\u01c6\3\2\2\2\u01c5\u01c2\3\2\2\2\u01c5\u01c6\3"+
		"\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01cb\7\65\2\2\u01c8\u01c9\5*\26\2\u01c9"+
		"\u01ca\b\35\1\2\u01ca\u01cc\3\2\2\2\u01cb\u01c8\3\2\2\2\u01cb\u01cc\3"+
		"\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\7,\2\2\u01ce\u01cf\5$\23\2\u01cf"+
		"\u01d0\b\35\1\2\u01d0\u01d1\b\35\1\2\u01d19\3\2\2\2\u01d2\u01d3\7\f\2"+
		"\2\u01d3\u01d4\7+\2\2\u01d4\u01d5\5\\/\2\u01d5\u01d6\7\r\2\2\u01d6\u01d7"+
		"\5> \2\u01d7\u01d8\7,\2\2\u01d8\u01d9\5$\23\2\u01d9\u01da\b\36\1\2\u01da"+
		"\u01db\b\36\1\2\u01db;\3\2\2\2\u01dc\u01dd\7\17\2\2\u01dd\u01de\7+\2\2"+
		"\u01de\u01df\5> \2\u01df\u01e0\7,\2\2\u01e0\u01e1\5$\23\2\u01e1\u01e6"+
		"\b\37\1\2\u01e2\u01e3\7\20\2\2\u01e3\u01e4\5$\23\2\u01e4\u01e5\b\37\1"+
		"\2\u01e5\u01e7\3\2\2\2\u01e6\u01e2\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8"+
		"\3\2\2\2\u01e8\u01e9\b\37\1\2\u01e9=\3\2\2\2\u01ea\u01eb\5@!\2\u01eb\u01f0"+
		"\b \1\2\u01ec\u01ed\7(\2\2\u01ed\u01ee\5> \2\u01ee\u01ef\b \1\2\u01ef"+
		"\u01f1\3\2\2\2\u01f0\u01ec\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1?\3\2\2\2"+
		"\u01f2\u01f3\5B\"\2\u01f3\u01fa\b!\1\2\u01f4\u01f5\7%\2\2\u01f5\u01f6"+
		"\5B\"\2\u01f6\u01f7\b!\1\2\u01f7\u01f9\3\2\2\2\u01f8\u01f4\3\2\2\2\u01f9"+
		"\u01fc\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fbA\3\2\2\2"+
		"\u01fc\u01fa\3\2\2\2\u01fd\u01fe\5D#\2\u01fe\u0205\b\"\1\2\u01ff\u0200"+
		"\7$\2\2\u0200\u0201\5D#\2\u0201\u0202\b\"\1\2\u0202\u0204\3\2\2\2\u0203"+
		"\u01ff\3\2\2\2\u0204\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2"+
		"\2\2\u0206C\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u0209\5F$\2\u0209\u0216"+
		"\b#\1\2\u020a\u020b\7\36\2\2\u020b\u020c\5F$\2\u020c\u020d\b#\1\2\u020d"+
		"\u020e\b#\1\2\u020e\u0215\3\2\2\2\u020f\u0210\7\35\2\2\u0210\u0211\5F"+
		"$\2\u0211\u0212\b#\1\2\u0212\u0213\b#\1\2\u0213\u0215\3\2\2\2\u0214\u020a"+
		"\3\2\2\2\u0214\u020f\3\2\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216"+
		"\u0217\3\2\2\2\u0217E\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u021a\5H%\2\u021a"+
		"\u0225\b$\1\2\u021b\u021c\7\33\2\2\u021c\u021d\5H%\2\u021d\u021e\b$\1"+
		"\2\u021e\u0224\3\2\2\2\u021f\u0220\7\34\2\2\u0220\u0221\5H%\2\u0221\u0222"+
		"\b$\1\2\u0222\u0224\3\2\2\2\u0223\u021b\3\2\2\2\u0223\u021f\3\2\2\2\u0224"+
		"\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226G\3\2\2\2"+
		"\u0227\u0225\3\2\2\2\u0228\u0229\5J&\2\u0229\u0234\b%\1\2\u022a\u022b"+
		"\7\"\2\2\u022b\u022c\5J&\2\u022c\u022d\b%\1\2\u022d\u0233\3\2\2\2\u022e"+
		"\u022f\7#\2\2\u022f\u0230\5J&\2\u0230\u0231\b%\1\2\u0231\u0233\3\2\2\2"+
		"\u0232\u022a\3\2\2\2\u0232\u022e\3\2\2\2\u0233\u0236\3\2\2\2\u0234\u0232"+
		"\3\2\2\2\u0234\u0235\3\2\2\2\u0235I\3\2\2\2\u0236\u0234\3\2\2\2\u0237"+
		"\u0238\5L\'\2\u0238\u0247\b&\1\2\u0239\u023a\7\37\2\2\u023a\u023b\5L\'"+
		"\2\u023b\u023c\b&\1\2\u023c\u0246\3\2\2\2\u023d\u023e\7 \2\2\u023e\u023f"+
		"\5L\'\2\u023f\u0240\b&\1\2\u0240\u0246\3\2\2\2\u0241\u0242\7!\2\2\u0242"+
		"\u0243\5L\'\2\u0243\u0244\b&\1\2\u0244\u0246\3\2\2\2\u0245\u0239\3\2\2"+
		"\2\u0245\u023d\3\2\2\2\u0245\u0241\3\2\2\2\u0246\u0249\3\2\2\2\u0247\u0245"+
		"\3\2\2\2\u0247\u0248\3\2\2\2\u0248K\3\2\2\2\u0249\u0247\3\2\2\2\u024a"+
		"\u024b\b\'\1\2\u024b\u0254\b\'\1\2\u024c\u024d\7&\2\2\u024d\u0255\b\'"+
		"\1\2\u024e\u024f\7#\2\2\u024f\u0255\b\'\1\2\u0250\u0251\7)\2\2\u0251\u0255"+
		"\b\'\1\2\u0252\u0253\7*\2\2\u0253\u0255\b\'\1\2\u0254\u024c\3\2\2\2\u0254"+
		"\u024e\3\2\2\2\u0254\u0250\3\2\2\2\u0254\u0252\3\2\2\2\u0255\u0256\3\2"+
		"\2\2\u0256\u0257\5L\'\2\u0257\u0258\b\'\1\2\u0258\u025d\3\2\2\2\u0259"+
		"\u025a\5N(\2\u025a\u025b\b\'\1\2\u025b\u025d\3\2\2\2\u025c\u024a\3\2\2"+
		"\2\u025c\u0259\3\2\2\2\u025dM\3\2\2\2\u025e\u025f\5P)\2\u025f\u0264\b"+
		"(\1\2\u0260\u0261\7)\2\2\u0261\u0265\b(\1\2\u0262\u0263\7*\2\2\u0263\u0265"+
		"\b(\1\2\u0264\u0260\3\2\2\2\u0264\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265"+
		"O\3\2\2\2\u0266\u0267\5R*\2\u0267\u0279\b)\1\2\u0268\u0269\7+\2\2\u0269"+
		"\u026a\5\64\33\2\u026a\u026b\7,\2\2\u026b\u026c\3\2\2\2\u026c\u026d\b"+
		")\1\2\u026d\u0278\3\2\2\2\u026e\u026f\7\63\2\2\u026f\u0270\5\\/\2\u0270"+
		"\u0271\b)\1\2\u0271\u0278\3\2\2\2\u0272\u0273\7-\2\2\u0273\u0274\5> \2"+
		"\u0274\u0275\7.\2\2\u0275\u0276\b)\1\2\u0276\u0278\3\2\2\2\u0277\u0268"+
		"\3\2\2\2\u0277\u026e\3\2\2\2\u0277\u0272\3\2\2\2\u0278\u027b\3\2\2\2\u0279"+
		"\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027aQ\3\2\2\2\u027b\u0279\3\2\2\2"+
		"\u027c\u027d\7\31\2\2\u027d\u028d\b*\1\2\u027e\u027f\5T+\2\u027f\u0280"+
		"\b*\1\2\u0280\u028d\3\2\2\2\u0281\u0282\5V,\2\u0282\u0283\b*\1\2\u0283"+
		"\u028d\3\2\2\2\u0284\u0285\5\\/\2\u0285\u0286\b*\1\2\u0286\u028d\3\2\2"+
		"\2\u0287\u0288\7+\2\2\u0288\u0289\5> \2\u0289\u028a\7,\2\2\u028a\u028b"+
		"\b*\1\2\u028b\u028d\3\2\2\2\u028c\u027c\3\2\2\2\u028c\u027e\3\2\2\2\u028c"+
		"\u0281\3\2\2\2\u028c\u0284\3\2\2\2\u028c\u0287\3\2\2\2\u028dS\3\2\2\2"+
		"\u028e\u028f\7\b\2\2\u028f\u0290\5\24\13\2\u0290\u0291\7+\2\2\u0291\u0292"+
		"\5\64\33\2\u0292\u0293\7,\2\2\u0293\u0294\b+\1\2\u0294U\3\2\2\2\u0295"+
		"\u0296\5X-\2\u0296\u0297\b,\1\2\u0297\u02a2\3\2\2\2\u0298\u0299\78\2\2"+
		"\u0299\u02a2\b,\1\2\u029a\u029b\7\66\2\2\u029b\u02a2\b,\1\2\u029c\u029d"+
		"\7\25\2\2\u029d\u02a2\b,\1\2\u029e\u029f\5Z.\2\u029f\u02a0\b,\1\2\u02a0"+
		"\u02a2\3\2\2\2\u02a1\u0295\3\2\2\2\u02a1\u0298\3\2\2\2\u02a1\u029a\3\2"+
		"\2\2\u02a1\u029c\3\2\2\2\u02a1\u029e\3\2\2\2\u02a2W\3\2\2\2\u02a3\u02a4"+
		"\7\27\2\2\u02a4\u02a8\b-\1\2\u02a5\u02a6\7\30\2\2\u02a6\u02a8\b-\1\2\u02a7"+
		"\u02a3\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a8Y\3\2\2\2\u02a9\u02aa\7-\2\2\u02aa"+
		"\u02ab\5\64\33\2\u02ab\u02ac\7.\2\2\u02ac\u02ad\b.\1\2\u02ad\u02ae\b."+
		"\1\2\u02ae[\3\2\2\2\u02af\u02b0\7\67\2\2\u02b0\u02b1\b/\1\2\u02b1]\3\2"+
		"\2\2\67hr{}\u0088\u008a\u0093\u0095\u0098\u00a6\u00c8\u00cb\u00de\u00ee"+
		"\u00fb\u0104\u010d\u0115\u0122\u012b\u0133\u013b\u0159\u0162\u017d\u0197"+
		"\u0199\u01ac\u01af\u01b5\u01bf\u01c5\u01cb\u01e6\u01f0\u01fa\u0205\u0214"+
		"\u0216\u0223\u0225\u0232\u0234\u0245\u0247\u0254\u025c\u0264\u0277\u0279"+
		"\u028c\u02a1\u02a7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}