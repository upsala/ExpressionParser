// Generated from /home/stefan/IdeaProjects/ExpressionParser/src/main/java/de/weinzierlstefan/expressionparser/Parser.g4 by ANTLR 4.13.1
package de.weinzierlstefan.expressionparser.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DoubleQuoteString=1, SingleQuoteString=2, QuotedVariable=3, NullLiteral=4, 
		BooleanLiteral=5, HexIntegerLiteral=6, OctalIntegerLiteral=7, BinaryIntegerLiteral=8, 
		DecimalLiteral=9, NULL=10, FALSE=11, TRUE=12, AS=13, WITH=14, AND=15, 
		OR=16, XOR=17, NOT=18, Identifier=19, MUL=20, DIV=21, ADD=22, SUB=23, 
		POWER=24, MODULO=25, UNDERSCORE=26, COMMA=27, LBRACKET=28, RBRACKET=29, 
		LPARENT=30, RPARENT=31, LBRACE=32, RBRACE=33, DOT=34, COLON=35, DOUBLE_QUOTE=36, 
		SINGLE_QUOTE=37, VARIABLE_QUOTE=38, CMP_GT=39, CMP_LE=40, CMP_GE=41, CMP_LT=42, 
		CMP_NE1=43, CMP_NE2=44, CMP_EQ=45, QMARK=46, BOOL_OR=47, BOOL_AND=48, 
		BOOL_XOR=49, BIT_OR=50, BIT_AND=51, BIT_XOR=52, BIT_NOT=53, SHIFT_LEFT=54, 
		SHIFT_RIGHT=55, EXCLMATION_MARK=56, ARRAY_RANGE=57, WHITESPACE=58;
	public static final int
		RULE_start_expression = 0, RULE_expression = 1, RULE_objectEntry = 2, 
		RULE_arraySelectorEntries = 3, RULE_arraySelectorEntry = 4, RULE_functionParameter = 5, 
		RULE_withLiteral = 6, RULE_withParameter = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start_expression", "expression", "objectEntry", "arraySelectorEntries", 
			"arraySelectorEntry", "functionParameter", "withLiteral", "withParameter"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'*'", "'/'", "'+'", 
			"'-'", "'**'", "'%'", "'_'", "','", "'['", "']'", "'('", "')'", "'{'", 
			"'}'", "'.'", "':'", "'\"'", "'''", "'`'", "'>'", "'<='", "'>='", "'<'", 
			"'<>'", "'!='", "'=='", "'?'", "'||'", "'&&'", "'^^'", "'|'", "'&'", 
			"'^'", "'~'", "'<<'", "'>>'", "'!'", "'..'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DoubleQuoteString", "SingleQuoteString", "QuotedVariable", "NullLiteral", 
			"BooleanLiteral", "HexIntegerLiteral", "OctalIntegerLiteral", "BinaryIntegerLiteral", 
			"DecimalLiteral", "NULL", "FALSE", "TRUE", "AS", "WITH", "AND", "OR", 
			"XOR", "NOT", "Identifier", "MUL", "DIV", "ADD", "SUB", "POWER", "MODULO", 
			"UNDERSCORE", "COMMA", "LBRACKET", "RBRACKET", "LPARENT", "RPARENT", 
			"LBRACE", "RBRACE", "DOT", "COLON", "DOUBLE_QUOTE", "SINGLE_QUOTE", "VARIABLE_QUOTE", 
			"CMP_GT", "CMP_LE", "CMP_GE", "CMP_LT", "CMP_NE1", "CMP_NE2", "CMP_EQ", 
			"QMARK", "BOOL_OR", "BOOL_AND", "BOOL_XOR", "BIT_OR", "BIT_AND", "BIT_XOR", 
			"BIT_NOT", "SHIFT_LEFT", "SHIFT_RIGHT", "EXCLMATION_MARK", "ARRAY_RANGE", 
			"WHITESPACE"
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
	public String getGrammarFileName() { return "Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Start_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ParserParser.EOF, 0); }
		public Start_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterStart_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitStart_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitStart_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_expressionContext start_expression() throws RecognitionException {
		Start_expressionContext _localctx = new Start_expressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			expression(0);
			setState(17);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExpressionContext {
		public Token name;
		public TerminalNode Identifier() { return getToken(ParserParser.Identifier, 0); }
		public VariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralContext extends ExpressionContext {
		public TerminalNode BooleanLiteral() { return getToken(ParserParser.BooleanLiteral, 0); }
		public BooleanLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WithContext extends ExpressionContext {
		public WithLiteralContext withLiteral() {
			return getRuleContext(WithLiteralContext.class,0);
		}
		public WithContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitWith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitWith(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ExpressionContext {
		public Token name;
		public FunctionParameterContext parameter;
		public TerminalNode LPARENT() { return getToken(ParserParser.LPARENT, 0); }
		public TerminalNode RPARENT() { return getToken(ParserParser.RPARENT, 0); }
		public TerminalNode Identifier() { return getToken(ParserParser.Identifier, 0); }
		public FunctionParameterContext functionParameter() {
			return getRuleContext(FunctionParameterContext.class,0);
		}
		public FunctionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryIntegerLiteralContext extends ExpressionContext {
		public TerminalNode BinaryIntegerLiteral() { return getToken(ParserParser.BinaryIntegerLiteral, 0); }
		public BinaryIntegerLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterBinaryIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitBinaryIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitBinaryIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyObjectContext extends ExpressionContext {
		public TerminalNode LBRACE() { return getToken(ParserParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ParserParser.RBRACE, 0); }
		public EmptyObjectContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterEmptyObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitEmptyObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitEmptyObject(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CMP_EQ() { return getToken(ParserParser.CMP_EQ, 0); }
		public TerminalNode CMP_GE() { return getToken(ParserParser.CMP_GE, 0); }
		public TerminalNode CMP_GT() { return getToken(ParserParser.CMP_GT, 0); }
		public TerminalNode CMP_LE() { return getToken(ParserParser.CMP_LE, 0); }
		public TerminalNode CMP_LT() { return getToken(ParserParser.CMP_LT, 0); }
		public TerminalNode CMP_NE1() { return getToken(ParserParser.CMP_NE1, 0); }
		public TerminalNode CMP_NE2() { return getToken(ParserParser.CMP_NE2, 0); }
		public ComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BOOL_AND() { return getToken(ParserParser.BOOL_AND, 0); }
		public TerminalNode BOOL_OR() { return getToken(ParserParser.BOOL_OR, 0); }
		public TerminalNode BOOL_XOR() { return getToken(ParserParser.BOOL_XOR, 0); }
		public BoolContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalLiteralContext extends ExpressionContext {
		public TerminalNode DecimalLiteral() { return getToken(ParserParser.DecimalLiteral, 0); }
		public DecimalLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleQuoteStringContext extends ExpressionContext {
		public TerminalNode SingleQuoteString() { return getToken(ParserParser.SingleQuoteString, 0); }
		public SingleQuoteStringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterSingleQuoteString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitSingleQuoteString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitSingleQuoteString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesContext extends ExpressionContext {
		public ExpressionContext inner;
		public TerminalNode LPARENT() { return getToken(ParserParser.LPARENT, 0); }
		public TerminalNode RPARENT() { return getToken(ParserParser.RPARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesesContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OctalIntegerLiteralContext extends ExpressionContext {
		public TerminalNode OctalIntegerLiteral() { return getToken(ParserParser.OctalIntegerLiteral, 0); }
		public OctalIntegerLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterOctalIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitOctalIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitOctalIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShiftContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SHIFT_LEFT() { return getToken(ParserParser.SHIFT_LEFT, 0); }
		public TerminalNode SHIFT_RIGHT() { return getToken(ParserParser.SHIFT_RIGHT, 0); }
		public ShiftContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterShift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitShift(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitShift(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyArrayContext extends ExpressionContext {
		public TerminalNode LBRACKET() { return getToken(ParserParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ParserParser.RBRACKET, 0); }
		public EmptyArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterEmptyArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitEmptyArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitEmptyArray(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryContext extends ExpressionContext {
		public ExpressionContext condition;
		public ExpressionContext choice1;
		public ExpressionContext choice2;
		public TerminalNode QMARK() { return getToken(ParserParser.QMARK, 0); }
		public TerminalNode COLON() { return getToken(ParserParser.COLON, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterTernary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitTernary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitTernary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleQuoteStringContext extends ExpressionContext {
		public TerminalNode DoubleQuoteString() { return getToken(ParserParser.DoubleQuoteString, 0); }
		public DoubleQuoteStringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterDoubleQuoteString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitDoubleQuoteString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitDoubleQuoteString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuotedVariableContext extends ExpressionContext {
		public TerminalNode QuotedVariable() { return getToken(ParserParser.QuotedVariable, 0); }
		public QuotedVariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterQuotedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitQuotedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitQuotedVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitOperationsContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BIT_AND() { return getToken(ParserParser.BIT_AND, 0); }
		public TerminalNode BIT_OR() { return getToken(ParserParser.BIT_OR, 0); }
		public TerminalNode BIT_XOR() { return getToken(ParserParser.BIT_XOR, 0); }
		public BitOperationsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterBitOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitBitOperations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitBitOperations(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HexIntegerLiteralContext extends ExpressionContext {
		public TerminalNode HexIntegerLiteral() { return getToken(ParserParser.HexIntegerLiteral, 0); }
		public HexIntegerLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterHexIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitHexIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitHexIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ExpressionContext {
		public TerminalNode LBRACKET() { return getToken(ParserParser.LBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(ParserParser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserParser.COMMA, i);
		}
		public ArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExpressionContext {
		public ExpressionContext right;
		public TerminalNode EXCLMATION_MARK() { return getToken(ParserParser.EXCLMATION_MARK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionOrSubtractionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ParserParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ParserParser.SUB, 0); }
		public AdditionOrSubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterAdditionOrSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitAdditionOrSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitAdditionOrSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationOrDivisionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ParserParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ParserParser.DIV, 0); }
		public TerminalNode MODULO() { return getToken(ParserParser.MODULO, 0); }
		public MultiplicationOrDivisionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterMultiplicationOrDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitMultiplicationOrDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitMultiplicationOrDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectContext extends ExpressionContext {
		public TerminalNode LBRACE() { return getToken(ParserParser.LBRACE, 0); }
		public List<ObjectEntryContext> objectEntry() {
			return getRuleContexts(ObjectEntryContext.class);
		}
		public ObjectEntryContext objectEntry(int i) {
			return getRuleContext(ObjectEntryContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(ParserParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserParser.COMMA, i);
		}
		public ObjectContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateContext extends ExpressionContext {
		public Token operator;
		public ExpressionContext right;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SUB() { return getToken(ParserParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(ParserParser.ADD, 0); }
		public TerminalNode BIT_NOT() { return getToken(ParserParser.BIT_NOT, 0); }
		public NegateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitNegate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitNegate(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArraySelectorContext extends ExpressionContext {
		public ExpressionContext expr;
		public ArraySelectorEntriesContext selector;
		public TerminalNode LBRACKET() { return getToken(ParserParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ParserParser.RBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArraySelectorEntriesContext arraySelectorEntries() {
			return getRuleContext(ArraySelectorEntriesContext.class,0);
		}
		public ArraySelectorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterArraySelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitArraySelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitArraySelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullLiteralContext extends ExpressionContext {
		public TerminalNode NullLiteral() { return getToken(ParserParser.NullLiteral, 0); }
		public NullLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowerContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode POWER() { return getToken(ParserParser.POWER, 0); }
		public PowerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new NullLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(20);
				match(NullLiteral);
				}
				break;
			case 2:
				{
				_localctx = new BooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(BooleanLiteral);
				}
				break;
			case 3:
				{
				_localctx = new DecimalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(DecimalLiteral);
				}
				break;
			case 4:
				{
				_localctx = new HexIntegerLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(HexIntegerLiteral);
				}
				break;
			case 5:
				{
				_localctx = new OctalIntegerLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(OctalIntegerLiteral);
				}
				break;
			case 6:
				{
				_localctx = new BinaryIntegerLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(BinaryIntegerLiteral);
				}
				break;
			case 7:
				{
				_localctx = new DoubleQuoteStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(DoubleQuoteString);
				}
				break;
			case 8:
				{
				_localctx = new SingleQuoteStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(SingleQuoteString);
				}
				break;
			case 9:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				((VariableContext)_localctx).name = match(Identifier);
				}
				break;
			case 10:
				{
				_localctx = new QuotedVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(QuotedVariable);
				}
				break;
			case 11:
				{
				_localctx = new EmptyArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(LBRACKET);
				setState(31);
				match(RBRACKET);
				}
				break;
			case 12:
				{
				_localctx = new ArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				match(LBRACKET);
				setState(33);
				expression(0);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(34);
					match(COMMA);
					setState(35);
					expression(0);
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(41);
				match(RBRACKET);
				}
				break;
			case 13:
				{
				_localctx = new EmptyObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(LBRACE);
				setState(44);
				match(RBRACE);
				}
				break;
			case 14:
				{
				_localctx = new ObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(LBRACE);
				setState(46);
				objectEntry();
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(47);
					match(COMMA);
					setState(48);
					objectEntry();
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(RBRACE);
				}
				break;
			case 15:
				{
				_localctx = new WithContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				withLiteral();
				}
				break;
			case 16:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				((FunctionContext)_localctx).name = match(Identifier);
				setState(58);
				match(LPARENT);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 81064798942938110L) != 0)) {
					{
					setState(59);
					((FunctionContext)_localctx).parameter = functionParameter();
					}
				}

				setState(62);
				match(RPARENT);
				}
				break;
			case 17:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				match(LPARENT);
				setState(64);
				((ParenthesesContext)_localctx).inner = expression(0);
				setState(65);
				match(RPARENT);
				}
				break;
			case 18:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				((NegateContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199267323904L) != 0)) ) {
					((NegateContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(68);
				((NegateContext)_localctx).right = expression(10);
				}
				break;
			case 19:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(EXCLMATION_MARK);
				setState(70);
				((NotContext)_localctx).right = expression(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExpressionContext(_parentctx, _parentState));
						((PowerContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(73);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(74);
						((PowerContext)_localctx).operator = match(POWER);
						setState(75);
						((PowerContext)_localctx).right = expression(10);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationOrDivisionContext(new ExpressionContext(_parentctx, _parentState));
						((MultiplicationOrDivisionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(76);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(77);
						((MultiplicationOrDivisionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 36700160L) != 0)) ) {
							((MultiplicationOrDivisionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(78);
						((MultiplicationOrDivisionContext)_localctx).right = expression(8);
						}
						break;
					case 3:
						{
						_localctx = new AdditionOrSubtractionContext(new ExpressionContext(_parentctx, _parentState));
						((AdditionOrSubtractionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(79);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(80);
						((AdditionOrSubtractionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AdditionOrSubtractionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(81);
						((AdditionOrSubtractionContext)_localctx).right = expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ShiftContext(new ExpressionContext(_parentctx, _parentState));
						((ShiftContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(82);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(83);
						((ShiftContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SHIFT_LEFT || _la==SHIFT_RIGHT) ) {
							((ShiftContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(84);
						((ShiftContext)_localctx).right = expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(85);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(86);
						((ComparisonContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 69818988363776L) != 0)) ) {
							((ComparisonContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(87);
						((ComparisonContext)_localctx).right = expression(5);
						}
						break;
					case 6:
						{
						_localctx = new BitOperationsContext(new ExpressionContext(_parentctx, _parentState));
						((BitOperationsContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(88);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(89);
						((BitOperationsContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7881299347898368L) != 0)) ) {
							((BitOperationsContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(90);
						((BitOperationsContext)_localctx).right = expression(4);
						}
						break;
					case 7:
						{
						_localctx = new TernaryContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(91);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(92);
						match(QMARK);
						setState(94);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 81064798942938110L) != 0)) {
							{
							setState(93);
							((TernaryContext)_localctx).choice1 = expression(0);
							}
						}

						setState(96);
						match(COLON);
						setState(97);
						((TernaryContext)_localctx).choice2 = expression(3);
						}
						break;
					case 8:
						{
						_localctx = new BoolContext(new ExpressionContext(_parentctx, _parentState));
						((BoolContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(98);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(99);
						((BoolContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) ) {
							((BoolContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						((BoolContext)_localctx).right = expression(2);
						}
						break;
					case 9:
						{
						_localctx = new ArraySelectorContext(new ExpressionContext(_parentctx, _parentState));
						((ArraySelectorContext)_localctx).expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(102);
						match(LBRACKET);
						setState(103);
						((ArraySelectorContext)_localctx).selector = arraySelectorEntries();
						setState(104);
						match(RBRACKET);
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectEntryContext extends ParserRuleContext {
		public ExpressionContext key;
		public ExpressionContext value;
		public TerminalNode COLON() { return getToken(ParserParser.COLON, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ObjectEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterObjectEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitObjectEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitObjectEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectEntryContext objectEntry() throws RecognitionException {
		ObjectEntryContext _localctx = new ObjectEntryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_objectEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			((ObjectEntryContext)_localctx).key = expression(0);
			setState(112);
			match(COLON);
			setState(113);
			((ObjectEntryContext)_localctx).value = expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArraySelectorEntriesContext extends ParserRuleContext {
		public List<ArraySelectorEntryContext> arraySelectorEntry() {
			return getRuleContexts(ArraySelectorEntryContext.class);
		}
		public ArraySelectorEntryContext arraySelectorEntry(int i) {
			return getRuleContext(ArraySelectorEntryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserParser.COMMA, i);
		}
		public ArraySelectorEntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySelectorEntries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterArraySelectorEntries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitArraySelectorEntries(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitArraySelectorEntries(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySelectorEntriesContext arraySelectorEntries() throws RecognitionException {
		ArraySelectorEntriesContext _localctx = new ArraySelectorEntriesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arraySelectorEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			arraySelectorEntry();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(116);
				match(COMMA);
				setState(117);
				arraySelectorEntry();
				}
				}
				setState(122);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArraySelectorEntryContext extends ParserRuleContext {
		public ExpressionContext from;
		public ExpressionContext to;
		public TerminalNode ARRAY_RANGE() { return getToken(ParserParser.ARRAY_RANGE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArraySelectorEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySelectorEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterArraySelectorEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitArraySelectorEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitArraySelectorEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySelectorEntryContext arraySelectorEntry() throws RecognitionException {
		ArraySelectorEntryContext _localctx = new ArraySelectorEntryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arraySelectorEntry);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((ArraySelectorEntryContext)_localctx).from = expression(0);
				setState(124);
				match(ARRAY_RANGE);
				setState(125);
				((ArraySelectorEntryContext)_localctx).to = expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				((ArraySelectorEntryContext)_localctx).from = expression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionParameterContext extends ParserRuleContext {
		public ExpressionContext expr;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserParser.COMMA, i);
		}
		public FunctionParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterFunctionParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitFunctionParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitFunctionParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParameterContext functionParameter() throws RecognitionException {
		FunctionParameterContext _localctx = new FunctionParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			((FunctionParameterContext)_localctx).expr = expression(0);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(131);
				match(COMMA);
				setState(132);
				((FunctionParameterContext)_localctx).expr = expression(0);
				}
				}
				setState(137);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WithLiteralContext extends ParserRuleContext {
		public FunctionParameterContext parameter;
		public TerminalNode WITH() { return getToken(ParserParser.WITH, 0); }
		public TerminalNode LPARENT() { return getToken(ParserParser.LPARENT, 0); }
		public TerminalNode RPARENT() { return getToken(ParserParser.RPARENT, 0); }
		public FunctionParameterContext functionParameter() {
			return getRuleContext(FunctionParameterContext.class,0);
		}
		public List<WithParameterContext> withParameter() {
			return getRuleContexts(WithParameterContext.class);
		}
		public WithParameterContext withParameter(int i) {
			return getRuleContext(WithParameterContext.class,i);
		}
		public WithLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterWithLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitWithLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitWithLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithLiteralContext withLiteral() throws RecognitionException {
		WithLiteralContext _localctx = new WithLiteralContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_withLiteral);
		try {
			int _alt;
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(WITH);
				setState(139);
				match(LPARENT);
				setState(141); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(140);
						withParameter();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(143); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(145);
				((WithLiteralContext)_localctx).parameter = functionParameter();
				setState(146);
				match(RPARENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(WITH);
				setState(149);
				match(LPARENT);
				setState(150);
				((WithLiteralContext)_localctx).parameter = functionParameter();
				setState(151);
				match(RPARENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WithParameterContext extends ParserRuleContext {
		public ExpressionContext expr;
		public Token id;
		public TerminalNode AS() { return getToken(ParserParser.AS, 0); }
		public TerminalNode COMMA() { return getToken(ParserParser.COMMA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ParserParser.Identifier, 0); }
		public WithParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterWithParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitWithParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ParserVisitor ) return ((ParserVisitor<? extends T>)visitor).visitWithParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithParameterContext withParameter() throws RecognitionException {
		WithParameterContext _localctx = new WithParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_withParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			((WithParameterContext)_localctx).expr = expression(0);
			setState(156);
			match(AS);
			setState(157);
			((WithParameterContext)_localctx).id = match(Identifier);
			setState(158);
			match(COMMA);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001:\u00a1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001=\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001H\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001_\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001k\b\u0001\n\u0001"+
		"\f\u0001n\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003w\b\u0003\n\u0003\f\u0003z\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u0081\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0086"+
		"\b\u0005\n\u0005\f\u0005\u0089\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0004\u0006\u008e\b\u0006\u000b\u0006\f\u0006\u008f\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u009a\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0000\u0001\u0002\b\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0000\u0007\u0002\u0000\u0016\u001755\u0002\u0000\u0014\u0015"+
		"\u0019\u0019\u0001\u0000\u0016\u0017\u0001\u000067\u0001\u0000\'-\u0001"+
		"\u000024\u0001\u0000/1\u00bc\u0000\u0010\u0001\u0000\u0000\u0000\u0002"+
		"G\u0001\u0000\u0000\u0000\u0004o\u0001\u0000\u0000\u0000\u0006s\u0001"+
		"\u0000\u0000\u0000\b\u0080\u0001\u0000\u0000\u0000\n\u0082\u0001\u0000"+
		"\u0000\u0000\f\u0099\u0001\u0000\u0000\u0000\u000e\u009b\u0001\u0000\u0000"+
		"\u0000\u0010\u0011\u0003\u0002\u0001\u0000\u0011\u0012\u0005\u0000\u0000"+
		"\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0014\u0006\u0001\uffff"+
		"\uffff\u0000\u0014H\u0005\u0004\u0000\u0000\u0015H\u0005\u0005\u0000\u0000"+
		"\u0016H\u0005\t\u0000\u0000\u0017H\u0005\u0006\u0000\u0000\u0018H\u0005"+
		"\u0007\u0000\u0000\u0019H\u0005\b\u0000\u0000\u001aH\u0005\u0001\u0000"+
		"\u0000\u001bH\u0005\u0002\u0000\u0000\u001cH\u0005\u0013\u0000\u0000\u001d"+
		"H\u0005\u0003\u0000\u0000\u001e\u001f\u0005\u001c\u0000\u0000\u001fH\u0005"+
		"\u001d\u0000\u0000 !\u0005\u001c\u0000\u0000!&\u0003\u0002\u0001\u0000"+
		"\"#\u0005\u001b\u0000\u0000#%\u0003\u0002\u0001\u0000$\"\u0001\u0000\u0000"+
		"\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\')\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0005"+
		"\u001d\u0000\u0000*H\u0001\u0000\u0000\u0000+,\u0005 \u0000\u0000,H\u0005"+
		"!\u0000\u0000-.\u0005 \u0000\u0000.3\u0003\u0004\u0002\u0000/0\u0005\u001b"+
		"\u0000\u000002\u0003\u0004\u0002\u00001/\u0001\u0000\u0000\u000025\u0001"+
		"\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u0000"+
		"46\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000067\u0005!\u0000\u0000"+
		"7H\u0001\u0000\u0000\u00008H\u0003\f\u0006\u00009:\u0005\u0013\u0000\u0000"+
		":<\u0005\u001e\u0000\u0000;=\u0003\n\u0005\u0000<;\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>H\u0005\u001f\u0000"+
		"\u0000?@\u0005\u001e\u0000\u0000@A\u0003\u0002\u0001\u0000AB\u0005\u001f"+
		"\u0000\u0000BH\u0001\u0000\u0000\u0000CD\u0007\u0000\u0000\u0000DH\u0003"+
		"\u0002\u0001\nEF\u00058\u0000\u0000FH\u0003\u0002\u0001\bG\u0013\u0001"+
		"\u0000\u0000\u0000G\u0015\u0001\u0000\u0000\u0000G\u0016\u0001\u0000\u0000"+
		"\u0000G\u0017\u0001\u0000\u0000\u0000G\u0018\u0001\u0000\u0000\u0000G"+
		"\u0019\u0001\u0000\u0000\u0000G\u001a\u0001\u0000\u0000\u0000G\u001b\u0001"+
		"\u0000\u0000\u0000G\u001c\u0001\u0000\u0000\u0000G\u001d\u0001\u0000\u0000"+
		"\u0000G\u001e\u0001\u0000\u0000\u0000G \u0001\u0000\u0000\u0000G+\u0001"+
		"\u0000\u0000\u0000G-\u0001\u0000\u0000\u0000G8\u0001\u0000\u0000\u0000"+
		"G9\u0001\u0000\u0000\u0000G?\u0001\u0000\u0000\u0000GC\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000Hl\u0001\u0000\u0000\u0000IJ\n\t\u0000"+
		"\u0000JK\u0005\u0018\u0000\u0000Kk\u0003\u0002\u0001\nLM\n\u0007\u0000"+
		"\u0000MN\u0007\u0001\u0000\u0000Nk\u0003\u0002\u0001\bOP\n\u0006\u0000"+
		"\u0000PQ\u0007\u0002\u0000\u0000Qk\u0003\u0002\u0001\u0007RS\n\u0005\u0000"+
		"\u0000ST\u0007\u0003\u0000\u0000Tk\u0003\u0002\u0001\u0006UV\n\u0004\u0000"+
		"\u0000VW\u0007\u0004\u0000\u0000Wk\u0003\u0002\u0001\u0005XY\n\u0003\u0000"+
		"\u0000YZ\u0007\u0005\u0000\u0000Zk\u0003\u0002\u0001\u0004[\\\n\u0002"+
		"\u0000\u0000\\^\u0005.\u0000\u0000]_\u0003\u0002\u0001\u0000^]\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0005"+
		"#\u0000\u0000ak\u0003\u0002\u0001\u0003bc\n\u0001\u0000\u0000cd\u0007"+
		"\u0006\u0000\u0000dk\u0003\u0002\u0001\u0002ef\n\u0010\u0000\u0000fg\u0005"+
		"\u001c\u0000\u0000gh\u0003\u0006\u0003\u0000hi\u0005\u001d\u0000\u0000"+
		"ik\u0001\u0000\u0000\u0000jI\u0001\u0000\u0000\u0000jL\u0001\u0000\u0000"+
		"\u0000jO\u0001\u0000\u0000\u0000jR\u0001\u0000\u0000\u0000jU\u0001\u0000"+
		"\u0000\u0000jX\u0001\u0000\u0000\u0000j[\u0001\u0000\u0000\u0000jb\u0001"+
		"\u0000\u0000\u0000je\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000"+
		"lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u0003\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0003\u0002\u0001\u0000pq\u0005"+
		"#\u0000\u0000qr\u0003\u0002\u0001\u0000r\u0005\u0001\u0000\u0000\u0000"+
		"sx\u0003\b\u0004\u0000tu\u0005\u001b\u0000\u0000uw\u0003\b\u0004\u0000"+
		"vt\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000y\u0007\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000{|\u0003\u0002\u0001\u0000|}\u00059\u0000\u0000}~\u0003"+
		"\u0002\u0001\u0000~\u0081\u0001\u0000\u0000\u0000\u007f\u0081\u0003\u0002"+
		"\u0001\u0000\u0080{\u0001\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\t\u0001\u0000\u0000\u0000\u0082\u0087\u0003\u0002\u0001\u0000"+
		"\u0083\u0084\u0005\u001b\u0000\u0000\u0084\u0086\u0003\u0002\u0001\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000"+
		"\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u000b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\u000e\u0000\u0000\u008b\u008d\u0005\u001e\u0000\u0000"+
		"\u008c\u008e\u0003\u000e\u0007\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0003\n\u0005\u0000\u0092\u0093\u0005\u001f\u0000\u0000\u0093"+
		"\u009a\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u000e\u0000\u0000\u0095"+
		"\u0096\u0005\u001e\u0000\u0000\u0096\u0097\u0003\n\u0005\u0000\u0097\u0098"+
		"\u0005\u001f\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u008a"+
		"\u0001\u0000\u0000\u0000\u0099\u0094\u0001\u0000\u0000\u0000\u009a\r\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0003\u0002\u0001\u0000\u009c\u009d\u0005"+
		"\r\u0000\u0000\u009d\u009e\u0005\u0013\u0000\u0000\u009e\u009f\u0005\u001b"+
		"\u0000\u0000\u009f\u000f\u0001\u0000\u0000\u0000\f&3<G^jlx\u0080\u0087"+
		"\u008f\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}