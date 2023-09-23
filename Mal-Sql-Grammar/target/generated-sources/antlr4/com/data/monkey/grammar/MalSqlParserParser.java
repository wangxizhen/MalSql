// Generated from com\data\monkey\grammar\MalSqlParser.g4 by ANTLR 4.9.2
package com.data.monkey.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MalSqlParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, DELETE=2, INSERT=3, UPDATE=4, FROM=5, HAVING=6, WHERE=7, ORDER=8, 
		BY=9, GROUP=10, INTO=11, AS=12, SOUNDS=13, REGEXP=14, FILTER=15, DURING=16, 
		CREATE=17, ALTER=18, DROP=19, SET=20, NULL=21, NOT=22, DISTINCT=23, DISTINCTROW=24, 
		HIGH_PRIORITY=25, MAX_STATEMENT_TIME=26, TABLE=27, TABLESPACE=28, VIEW=29, 
		SEQUENCE=30, TRIGGER=31, USER=32, INDEX=33, SESSION=34, PROCEDURE=35, 
		FUNCTION=36, PRIMARY=37, KEY=38, DEFAULT=39, CONSTRAINT=40, CHECK=41, 
		UNIQUE=42, FOREIGN=43, REFERENCES=44, EXPLAIN=45, FOR=46, IF=47, ALL=48, 
		UNION=49, EXCEPT=50, INTERSECT=51, MINUS=52, INNER=53, LEFT=54, RIGHT=55, 
		FULL=56, OUTER=57, JOIN=58, ON=59, SCHEMA=60, CAST=61, COLUMN=62, USE=63, 
		DATABASE=64, TO=65, AND=66, OR=67, XOR=68, CASE=69, WHEN=70, THEN=71, 
		ELSE=72, END=73, EXISTS=74, IN=75, NEW=76, ASC=77, DESC=78, IS=79, LIKE=80, 
		ESCAPE=81, BETWEEN=82, VALUES=83, INTERVAL=84, TRUE=85, FALSE=86, LIMIT=87, 
		BREAK=88, LAST=89, NONE=90, MINUTE=91, HOUR=92, DAY=93, WEEK=94, EVENTS=95, 
		FIFTEEN_MINUTE=96, NOW=97, EXPORT=98, LPAREN=99, RPAREN=100, LBRACE=101, 
		RBRACE=102, LBRACKET=103, RBRACKET=104, SEMI=105, COMMA=106, DOT=107, 
		DOTDOT=108, DOTDOTDOT=109, EQ=110, GT=111, LT=112, BANG=113, BANGBANG=114, 
		TILDE=115, QUES=116, COLON=117, COLONCOLON=118, COLONEQ=119, EQEQ=120, 
		LTEQ=121, LTEQGT=122, LTGT=123, GTEQ=124, NEQ=125, BANGEQ=126, BANGGT=127, 
		BANGLT=128, AMPAMP=129, BARBAR=130, BARBARSLASH=131, BARSLASH=132, PLUS=133, 
		SUB=134, STAR=135, SLASH=136, AMP=137, BAR=138, CARET=139, PERCENT=140, 
		LTLT=141, GTGT=142, MONKEYS_AT=143, POUND=144, DIV=145, MOD=146, UNDERLINE=147, 
		QUOTES=148, INT=149, FLOAT=150, NEG_INT=151, NEG_FLOAT=152, STRING=153, 
		ID=154, PARENTHESIS=155, WS=156;
	public static final int
		RULE_root = 0, RULE_columList = 1, RULE_allColumn = 2, RULE_nameOprand = 3, 
		RULE_name = 4, RULE_parenthesis = 5, RULE_identity = 6, RULE_tableRef = 7, 
		RULE_exportExpr = 8, RULE_whereCluaster = 9, RULE_boolExpr = 10, RULE_basicBoolExpr = 11, 
		RULE_collection = 12, RULE_durationExpr = 13, RULE_duration = 14, RULE_filterByExpr = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "columList", "allColumn", "nameOprand", "name", "parenthesis", 
			"identity", "tableRef", "exportExpr", "whereCluaster", "boolExpr", "basicBoolExpr", 
			"collection", "durationExpr", "duration", "filterByExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", 
			"'.'", "'..'", "'..,'", "'='", "'>'", "'<'", "'!'", "'!!'", "'~'", "'?'", 
			null, null, "':='", "'=='", "'<='", "'<=>'", null, "'>='", "'!='", null, 
			"'!>'", "'!<'", "'&&'", "'||'", "'||/'", "'|/'", "'+'", "'-'", "'*'", 
			"'/'", "'&'", "'|'", "'^'", null, "'<<'", "'>>'", "'@'", "'#'", null, 
			null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SELECT", "DELETE", "INSERT", "UPDATE", "FROM", "HAVING", "WHERE", 
			"ORDER", "BY", "GROUP", "INTO", "AS", "SOUNDS", "REGEXP", "FILTER", "DURING", 
			"CREATE", "ALTER", "DROP", "SET", "NULL", "NOT", "DISTINCT", "DISTINCTROW", 
			"HIGH_PRIORITY", "MAX_STATEMENT_TIME", "TABLE", "TABLESPACE", "VIEW", 
			"SEQUENCE", "TRIGGER", "USER", "INDEX", "SESSION", "PROCEDURE", "FUNCTION", 
			"PRIMARY", "KEY", "DEFAULT", "CONSTRAINT", "CHECK", "UNIQUE", "FOREIGN", 
			"REFERENCES", "EXPLAIN", "FOR", "IF", "ALL", "UNION", "EXCEPT", "INTERSECT", 
			"MINUS", "INNER", "LEFT", "RIGHT", "FULL", "OUTER", "JOIN", "ON", "SCHEMA", 
			"CAST", "COLUMN", "USE", "DATABASE", "TO", "AND", "OR", "XOR", "CASE", 
			"WHEN", "THEN", "ELSE", "END", "EXISTS", "IN", "NEW", "ASC", "DESC", 
			"IS", "LIKE", "ESCAPE", "BETWEEN", "VALUES", "INTERVAL", "TRUE", "FALSE", 
			"LIMIT", "BREAK", "LAST", "NONE", "MINUTE", "HOUR", "DAY", "WEEK", "EVENTS", 
			"FIFTEEN_MINUTE", "NOW", "EXPORT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACKET", "RBRACKET", "SEMI", "COMMA", "DOT", "DOTDOT", "DOTDOTDOT", 
			"EQ", "GT", "LT", "BANG", "BANGBANG", "TILDE", "QUES", "COLON", "COLONCOLON", 
			"COLONEQ", "EQEQ", "LTEQ", "LTEQGT", "LTGT", "GTEQ", "NEQ", "BANGEQ", 
			"BANGGT", "BANGLT", "AMPAMP", "BARBAR", "BARBARSLASH", "BARSLASH", "PLUS", 
			"SUB", "STAR", "SLASH", "AMP", "BAR", "CARET", "PERCENT", "LTLT", "GTGT", 
			"MONKEYS_AT", "POUND", "DIV", "MOD", "UNDERLINE", "QUOTES", "INT", "FLOAT", 
			"NEG_INT", "NEG_FLOAT", "STRING", "ID", "PARENTHESIS", "WS"
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
	public String getGrammarFileName() { return "MalSqlParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MalSqlParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(MalSqlParserParser.SELECT, 0); }
		public ColumListContext columList() {
			return getRuleContext(ColumListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(MalSqlParserParser.FROM, 0); }
		public TableRefContext tableRef() {
			return getRuleContext(TableRefContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MalSqlParserParser.EOF, 0); }
		public WhereCluasterContext whereCluaster() {
			return getRuleContext(WhereCluasterContext.class,0);
		}
		public DurationExprContext durationExpr() {
			return getRuleContext(DurationExprContext.class,0);
		}
		public ExportExprContext exportExpr() {
			return getRuleContext(ExportExprContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(SELECT);
			setState(33);
			columList();
			setState(34);
			match(FROM);
			setState(35);
			tableRef();
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(36);
				whereCluaster();
				}
			}

			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(39);
				durationExpr();
				}
			}

			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPORT) {
				{
				setState(42);
				exportExpr();
				}
			}

			setState(45);
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

	public static class ColumListContext extends ParserRuleContext {
		public List<NameOprandContext> nameOprand() {
			return getRuleContexts(NameOprandContext.class);
		}
		public NameOprandContext nameOprand(int i) {
			return getRuleContext(NameOprandContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MalSqlParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MalSqlParserParser.COMMA, i);
		}
		public AllColumnContext allColumn() {
			return getRuleContext(AllColumnContext.class,0);
		}
		public ColumListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterColumList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitColumList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitColumList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumListContext columList() throws RecognitionException {
		ColumListContext _localctx = new ColumListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_columList);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case INT:
			case FLOAT:
			case NEG_INT:
			case NEG_FLOAT:
			case STRING:
			case ID:
			case PARENTHESIS:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				nameOprand();
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(48);
					match(COMMA);
					setState(49);
					nameOprand();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				allColumn();
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

	public static class AllColumnContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(MalSqlParserParser.STAR, 0); }
		public AllColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allColumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterAllColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitAllColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitAllColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllColumnContext allColumn() throws RecognitionException {
		AllColumnContext _localctx = new AllColumnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_allColumn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(STAR);
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

	public static class NameOprandContext extends ParserRuleContext {
		public Token tableName;
		public NameContext columnName;
		public Token alias;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MalSqlParserParser.DOT, 0); }
		public TerminalNode AS() { return getToken(MalSqlParserParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(MalSqlParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MalSqlParserParser.ID, i);
		}
		public NameOprandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameOprand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterNameOprand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitNameOprand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitNameOprand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameOprandContext nameOprand() throws RecognitionException {
		NameOprandContext _localctx = new NameOprandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nameOprand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(60);
				((NameOprandContext)_localctx).tableName = match(ID);
				setState(61);
				match(DOT);
				}
				break;
			}
			setState(64);
			((NameOprandContext)_localctx).columnName = name(0);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(65);
				match(AS);
				setState(66);
				((NameOprandContext)_localctx).alias = match(ID);
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

	public static class NameContext extends ParserRuleContext {
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	 
		public NameContext() { }
		public void copyFrom(NameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulNameContext extends NameContext {
		public NameContext left;
		public Token op;
		public NameContext right;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode STAR() { return getToken(MalSqlParserParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(MalSqlParserParser.SLASH, 0); }
		public TerminalNode MOD() { return getToken(MalSqlParserParser.MOD, 0); }
		public MulNameContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterMulName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitMulName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitMulName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggregationNameContext extends NameContext {
		public NameContext columnName;
		public BoolExprContext predicate;
		public TerminalNode ID() { return getToken(MalSqlParserParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MalSqlParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MalSqlParserParser.RPAREN, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(MalSqlParserParser.COMMA, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public AggregationNameContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterAggregationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitAggregationName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitAggregationName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddNameContext extends NameContext {
		public NameContext left;
		public Token op;
		public NameContext right;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(MalSqlParserParser.PLUS, 0); }
		public TerminalNode SUB() { return getToken(MalSqlParserParser.SUB, 0); }
		public AddNameContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterAddName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitAddName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitAddName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisNameContext extends NameContext {
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public ParenthesisNameContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterParenthesisName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitParenthesisName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitParenthesisName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LRNameContext extends NameContext {
		public TerminalNode LPAREN() { return getToken(MalSqlParserParser.LPAREN, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MalSqlParserParser.RPAREN, 0); }
		public LRNameContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterLRName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitLRName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitLRName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnNameContext extends NameContext {
		public IdentityContext identity() {
			return getRuleContext(IdentityContext.class,0);
		}
		public ColumnNameContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseNameContext extends NameContext {
		public NameContext left;
		public Token op;
		public NameContext right;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode AMP() { return getToken(MalSqlParserParser.AMP, 0); }
		public TerminalNode BAR() { return getToken(MalSqlParserParser.BAR, 0); }
		public TerminalNode CARET() { return getToken(MalSqlParserParser.CARET, 0); }
		public TerminalNode LTLT() { return getToken(MalSqlParserParser.LTLT, 0); }
		public TerminalNode GTGT() { return getToken(MalSqlParserParser.GTGT, 0); }
		public BitwiseNameContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterBitwiseName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitBitwiseName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitBitwiseName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		return name(0);
	}

	private NameContext name(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NameContext _localctx = new NameContext(_ctx, _parentState);
		NameContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_name, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new LRNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(70);
				match(LPAREN);
				setState(71);
				name(0);
				setState(72);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new AggregationNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(ID);
				setState(75);
				match(LPAREN);
				setState(76);
				((AggregationNameContext)_localctx).columnName = name(0);
				setState(77);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new AggregationNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(ID);
				setState(80);
				match(LPAREN);
				setState(81);
				((AggregationNameContext)_localctx).columnName = name(0);
				setState(82);
				match(COMMA);
				setState(83);
				((AggregationNameContext)_localctx).predicate = boolExpr(0);
				setState(84);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new AggregationNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(ID);
				setState(87);
				match(LPAREN);
				setState(88);
				((AggregationNameContext)_localctx).predicate = boolExpr(0);
				setState(89);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new ColumnNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				identity();
				}
				break;
			case 6:
				{
				_localctx = new ParenthesisNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				parenthesis();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(104);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MulNameContext(new NameContext(_parentctx, _parentState));
						((MulNameContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_name);
						setState(95);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(96);
						((MulNameContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (STAR - 135)) | (1L << (SLASH - 135)) | (1L << (MOD - 135)))) != 0)) ) {
							((MulNameContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(97);
						((MulNameContext)_localctx).right = name(9);
						}
						break;
					case 2:
						{
						_localctx = new AddNameContext(new NameContext(_parentctx, _parentState));
						((AddNameContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_name);
						setState(98);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(99);
						((AddNameContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==SUB) ) {
							((AddNameContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						((AddNameContext)_localctx).right = name(8);
						}
						break;
					case 3:
						{
						_localctx = new BitwiseNameContext(new NameContext(_parentctx, _parentState));
						((BitwiseNameContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_name);
						setState(101);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(102);
						((BitwiseNameContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (AMP - 137)) | (1L << (BAR - 137)) | (1L << (CARET - 137)) | (1L << (LTLT - 137)) | (1L << (GTGT - 137)))) != 0)) ) {
							((BitwiseNameContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						((BitwiseNameContext)_localctx).right = name(7);
						}
						break;
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class ParenthesisContext extends ParserRuleContext {
		public TerminalNode PARENTHESIS() { return getToken(MalSqlParserParser.PARENTHESIS, 0); }
		public ParenthesisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesisContext parenthesis() throws RecognitionException {
		ParenthesisContext _localctx = new ParenthesisContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parenthesis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(PARENTHESIS);
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

	public static class IdentityContext extends ParserRuleContext {
		public IdentityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identity; }
	 
		public IdentityContext() { }
		public void copyFrom(IdentityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdEleContext extends IdentityContext {
		public TerminalNode ID() { return getToken(MalSqlParserParser.ID, 0); }
		public IdEleContext(IdentityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterIdEle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitIdEle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitIdEle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegativeFloatELeContext extends IdentityContext {
		public TerminalNode NEG_FLOAT() { return getToken(MalSqlParserParser.NEG_FLOAT, 0); }
		public NegativeFloatELeContext(IdentityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterNegativeFloatELe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitNegativeFloatELe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitNegativeFloatELe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegativeIntEleContext extends IdentityContext {
		public TerminalNode NEG_INT() { return getToken(MalSqlParserParser.NEG_INT, 0); }
		public NegativeIntEleContext(IdentityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterNegativeIntEle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitNegativeIntEle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitNegativeIntEle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringEleContext extends IdentityContext {
		public TerminalNode STRING() { return getToken(MalSqlParserParser.STRING, 0); }
		public StringEleContext(IdentityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterStringEle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitStringEle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitStringEle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatEleContext extends IdentityContext {
		public TerminalNode FLOAT() { return getToken(MalSqlParserParser.FLOAT, 0); }
		public FloatEleContext(IdentityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterFloatEle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitFloatEle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitFloatEle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntEleContext extends IdentityContext {
		public TerminalNode INT() { return getToken(MalSqlParserParser.INT, 0); }
		public IntEleContext(IdentityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterIntEle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitIntEle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitIntEle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentityContext identity() throws RecognitionException {
		IdentityContext _localctx = new IdentityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_identity);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new IdEleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(ID);
				}
				break;
			case INT:
				_localctx = new IntEleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatEleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(FLOAT);
				}
				break;
			case NEG_INT:
				_localctx = new NegativeIntEleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				match(NEG_INT);
				}
				break;
			case NEG_FLOAT:
				_localctx = new NegativeFloatELeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(NEG_FLOAT);
				}
				break;
			case STRING:
				_localctx = new StringEleContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				match(STRING);
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

	public static class TableRefContext extends ParserRuleContext {
		public Token tableName;
		public Token alias;
		public List<TerminalNode> ID() { return getTokens(MalSqlParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MalSqlParserParser.ID, i);
		}
		public TerminalNode AS() { return getToken(MalSqlParserParser.AS, 0); }
		public TableRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterTableRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitTableRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitTableRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableRefContext tableRef() throws RecognitionException {
		TableRefContext _localctx = new TableRefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tableRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((TableRefContext)_localctx).tableName = match(ID);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(120);
				match(AS);
				setState(121);
				((TableRefContext)_localctx).alias = match(ID);
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

	public static class ExportExprContext extends ParserRuleContext {
		public Token fileName;
		public TerminalNode EXPORT() { return getToken(MalSqlParserParser.EXPORT, 0); }
		public TerminalNode ID() { return getToken(MalSqlParserParser.ID, 0); }
		public ExportExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterExportExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitExportExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitExportExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportExprContext exportExpr() throws RecognitionException {
		ExportExprContext _localctx = new ExportExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exportExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(EXPORT);
			setState(125);
			((ExportExprContext)_localctx).fileName = match(ID);
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

	public static class WhereCluasterContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(MalSqlParserParser.WHERE, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public FilterByExprContext filterByExpr() {
			return getRuleContext(FilterByExprContext.class,0);
		}
		public DurationExprContext durationExpr() {
			return getRuleContext(DurationExprContext.class,0);
		}
		public WhereCluasterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCluaster; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterWhereCluaster(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitWhereCluaster(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitWhereCluaster(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereCluasterContext whereCluaster() throws RecognitionException {
		WhereCluasterContext _localctx = new WhereCluasterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whereCluaster);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(WHERE);
			setState(128);
			boolExpr(0);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FILTER) {
				{
				setState(129);
				filterByExpr();
				}
			}

			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(132);
				durationExpr();
				}
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

	public static class BoolExprContext extends ParserRuleContext {
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
	 
		public BoolExprContext() { }
		public void copyFrom(BoolExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BasicExprContext extends BoolExprContext {
		public BasicBoolExprContext basicBoolExpr() {
			return getRuleContext(BasicBoolExprContext.class,0);
		}
		public BasicExprContext(BoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterBasicExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitBasicExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitBasicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LrExprContext extends BoolExprContext {
		public TerminalNode LPAREN() { return getToken(MalSqlParserParser.LPAREN, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MalSqlParserParser.RPAREN, 0); }
		public LrExprContext(BoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterLrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitLrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitLrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndOprContext extends BoolExprContext {
		public BoolExprContext left;
		public BoolExprContext right;
		public TerminalNode AND() { return getToken(MalSqlParserParser.AND, 0); }
		public List<BoolExprContext> boolExpr() {
			return getRuleContexts(BoolExprContext.class);
		}
		public BoolExprContext boolExpr(int i) {
			return getRuleContext(BoolExprContext.class,i);
		}
		public AndOprContext(BoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterAndOpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitAndOpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitAndOpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrOprContext extends BoolExprContext {
		public BoolExprContext left;
		public BoolExprContext right;
		public TerminalNode OR() { return getToken(MalSqlParserParser.OR, 0); }
		public List<BoolExprContext> boolExpr() {
			return getRuleContexts(BoolExprContext.class);
		}
		public BoolExprContext boolExpr(int i) {
			return getRuleContext(BoolExprContext.class,i);
		}
		public OrOprContext(BoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterOrOpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitOrOpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitOrOpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		return boolExpr(0);
	}

	private BoolExprContext boolExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BoolExprContext _localctx = new BoolExprContext(_ctx, _parentState);
		BoolExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_boolExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new LrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(136);
				match(LPAREN);
				setState(137);
				boolExpr(0);
				setState(138);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new BasicExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				basicBoolExpr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new AndOprContext(new BoolExprContext(_parentctx, _parentState));
						((AndOprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
						setState(143);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(144);
						match(AND);
						setState(145);
						((AndOprContext)_localctx).right = boolExpr(4);
						}
						break;
					case 2:
						{
						_localctx = new OrOprContext(new BoolExprContext(_parentctx, _parentState));
						((OrOprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_boolExpr);
						setState(146);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(147);
						match(OR);
						setState(148);
						((OrOprContext)_localctx).right = boolExpr(3);
						}
						break;
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class BasicBoolExprContext extends ParserRuleContext {
		public BasicBoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicBoolExpr; }
	 
		public BasicBoolExprContext() { }
		public void copyFrom(BasicBoolExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InExprContext extends BasicBoolExprContext {
		public NameContext left;
		public Token option;
		public CollectionContext right;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode IN() { return getToken(MalSqlParserParser.IN, 0); }
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public InExprContext(BasicBoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterInExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitInExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitInExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareExprContext extends BasicBoolExprContext {
		public NameContext left;
		public Token option;
		public NameContext right;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode EQ() { return getToken(MalSqlParserParser.EQ, 0); }
		public TerminalNode GT() { return getToken(MalSqlParserParser.GT, 0); }
		public TerminalNode LT() { return getToken(MalSqlParserParser.LT, 0); }
		public TerminalNode GTEQ() { return getToken(MalSqlParserParser.GTEQ, 0); }
		public TerminalNode LTEQ() { return getToken(MalSqlParserParser.LTEQ, 0); }
		public TerminalNode NEQ() { return getToken(MalSqlParserParser.NEQ, 0); }
		public CompareExprContext(BasicBoolExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicBoolExprContext basicBoolExpr() throws RecognitionException {
		BasicBoolExprContext _localctx = new BasicBoolExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_basicBoolExpr);
		int _la;
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new CompareExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				((CompareExprContext)_localctx).left = name(0);
				setState(155);
				((CompareExprContext)_localctx).option = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & ((1L << (EQ - 110)) | (1L << (GT - 110)) | (1L << (LT - 110)) | (1L << (LTEQ - 110)) | (1L << (GTEQ - 110)) | (1L << (NEQ - 110)))) != 0)) ) {
					((CompareExprContext)_localctx).option = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(156);
				((CompareExprContext)_localctx).right = name(0);
				}
				break;
			case 2:
				_localctx = new InExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				((InExprContext)_localctx).left = name(0);
				setState(159);
				((InExprContext)_localctx).option = match(IN);
				setState(160);
				((InExprContext)_localctx).right = collection();
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

	public static class CollectionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MalSqlParserParser.LPAREN, 0); }
		public List<IdentityContext> identity() {
			return getRuleContexts(IdentityContext.class);
		}
		public IdentityContext identity(int i) {
			return getRuleContext(IdentityContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MalSqlParserParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MalSqlParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MalSqlParserParser.COMMA, i);
		}
		public CollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitCollection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitCollection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionContext collection() throws RecognitionException {
		CollectionContext _localctx = new CollectionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_collection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(LPAREN);
			setState(165);
			identity();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(166);
				match(COMMA);
				setState(167);
				identity();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
			match(RPAREN);
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

	public static class DurationExprContext extends ParserRuleContext {
		public NameContext number;
		public Token unit;
		public TerminalNode FOR() { return getToken(MalSqlParserParser.FOR, 0); }
		public TerminalNode LAST() { return getToken(MalSqlParserParser.LAST, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode MINUTE() { return getToken(MalSqlParserParser.MINUTE, 0); }
		public TerminalNode EVENTS() { return getToken(MalSqlParserParser.EVENTS, 0); }
		public DurationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_durationExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterDurationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitDurationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitDurationExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationExprContext durationExpr() throws RecognitionException {
		DurationExprContext _localctx = new DurationExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_durationExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(FOR);
			setState(176);
			match(LAST);
			setState(177);
			((DurationExprContext)_localctx).number = name(0);
			setState(178);
			((DurationExprContext)_localctx).unit = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==MINUTE || _la==EVENTS) ) {
				((DurationExprContext)_localctx).unit = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class DurationContext extends ParserRuleContext {
		public Token number;
		public Token unit;
		public TerminalNode INT() { return getToken(MalSqlParserParser.INT, 0); }
		public TerminalNode MINUTE() { return getToken(MalSqlParserParser.MINUTE, 0); }
		public TerminalNode HOUR() { return getToken(MalSqlParserParser.HOUR, 0); }
		public TerminalNode DAY() { return getToken(MalSqlParserParser.DAY, 0); }
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_duration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((DurationContext)_localctx).number = match(INT);
			setState(181);
			((DurationContext)_localctx).unit = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (MINUTE - 91)) | (1L << (HOUR - 91)) | (1L << (DAY - 91)))) != 0)) ) {
				((DurationContext)_localctx).unit = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class FilterByExprContext extends ParserRuleContext {
		public TerminalNode FILTER() { return getToken(MalSqlParserParser.FILTER, 0); }
		public TerminalNode BY() { return getToken(MalSqlParserParser.BY, 0); }
		public List<TerminalNode> ID() { return getTokens(MalSqlParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MalSqlParserParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MalSqlParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MalSqlParserParser.COMMA, i);
		}
		public FilterByExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterByExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).enterFilterByExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MalSqlParserListener ) ((MalSqlParserListener)listener).exitFilterByExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MalSqlParserVisitor ) return ((MalSqlParserVisitor<? extends T>)visitor).visitFilterByExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterByExprContext filterByExpr() throws RecognitionException {
		FilterByExprContext _localctx = new FilterByExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_filterByExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(FILTER);
			setState(184);
			match(BY);
			setState(185);
			match(ID);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(186);
				match(COMMA);
				setState(187);
				match(ID);
				}
				}
				setState(192);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return name_sempred((NameContext)_localctx, predIndex);
		case 10:
			return boolExpr_sempred((BoolExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean name_sempred(NameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean boolExpr_sempred(BoolExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u009e\u00c4\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\5\2(\n\2\3\2\5\2+\n\2\3\2\5\2.\n\2\3\2\3\2\3\3\3\3\3\3\7"+
		"\3\65\n\3\f\3\16\38\13\3\3\3\5\3;\n\3\3\4\3\4\3\5\3\5\5\5A\n\5\3\5\3\5"+
		"\3\5\5\5F\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6`\n\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bx\n\b\3\t\3\t\3\t\5\t}\n\t\3\n\3\n\3\n\3\13\3\13\3\13\5\13\u0085"+
		"\n\13\3\13\5\13\u0088\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0090\n\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\7\f\u0098\n\f\f\f\16\f\u009b\13\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00a5\n\r\3\16\3\16\3\16\3\16\7\16\u00ab\n\16\f\16"+
		"\16\16\u00ae\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\7\21\u00bf\n\21\f\21\16\21\u00c2\13\21\3\21\2"+
		"\4\n\26\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\b\4\2\u0089\u008a"+
		"\u0094\u0094\3\2\u0087\u0088\4\2\u008b\u008d\u008f\u0090\5\2pr{{~\177"+
		"\4\2]]aa\3\2]_\2\u00d0\2\"\3\2\2\2\4:\3\2\2\2\6<\3\2\2\2\b@\3\2\2\2\n"+
		"_\3\2\2\2\fo\3\2\2\2\16w\3\2\2\2\20y\3\2\2\2\22~\3\2\2\2\24\u0081\3\2"+
		"\2\2\26\u008f\3\2\2\2\30\u00a4\3\2\2\2\32\u00a6\3\2\2\2\34\u00b1\3\2\2"+
		"\2\36\u00b6\3\2\2\2 \u00b9\3\2\2\2\"#\7\3\2\2#$\5\4\3\2$%\7\7\2\2%\'\5"+
		"\20\t\2&(\5\24\13\2\'&\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)+\5\34\17\2*)\3\2"+
		"\2\2*+\3\2\2\2+-\3\2\2\2,.\5\22\n\2-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/\60"+
		"\7\2\2\3\60\3\3\2\2\2\61\66\5\b\5\2\62\63\7l\2\2\63\65\5\b\5\2\64\62\3"+
		"\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67;\3\2\2\28\66\3\2\2\2"+
		"9;\5\6\4\2:\61\3\2\2\2:9\3\2\2\2;\5\3\2\2\2<=\7\u0089\2\2=\7\3\2\2\2>"+
		"?\7\u009c\2\2?A\7m\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BE\5\n\6\2CD\7\16"+
		"\2\2DF\7\u009c\2\2EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GH\b\6\1\2HI\7e\2\2I"+
		"J\5\n\6\2JK\7f\2\2K`\3\2\2\2LM\7\u009c\2\2MN\7e\2\2NO\5\n\6\2OP\7f\2\2"+
		"P`\3\2\2\2QR\7\u009c\2\2RS\7e\2\2ST\5\n\6\2TU\7l\2\2UV\5\26\f\2VW\7f\2"+
		"\2W`\3\2\2\2XY\7\u009c\2\2YZ\7e\2\2Z[\5\26\f\2[\\\7f\2\2\\`\3\2\2\2]`"+
		"\5\16\b\2^`\5\f\7\2_G\3\2\2\2_L\3\2\2\2_Q\3\2\2\2_X\3\2\2\2_]\3\2\2\2"+
		"_^\3\2\2\2`l\3\2\2\2ab\f\n\2\2bc\t\2\2\2ck\5\n\6\13de\f\t\2\2ef\t\3\2"+
		"\2fk\5\n\6\ngh\f\b\2\2hi\t\4\2\2ik\5\n\6\tja\3\2\2\2jd\3\2\2\2jg\3\2\2"+
		"\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\13\3\2\2\2nl\3\2\2\2op\7\u009d\2\2p"+
		"\r\3\2\2\2qx\7\u009c\2\2rx\7\u0097\2\2sx\7\u0098\2\2tx\7\u0099\2\2ux\7"+
		"\u009a\2\2vx\7\u009b\2\2wq\3\2\2\2wr\3\2\2\2ws\3\2\2\2wt\3\2\2\2wu\3\2"+
		"\2\2wv\3\2\2\2x\17\3\2\2\2y|\7\u009c\2\2z{\7\16\2\2{}\7\u009c\2\2|z\3"+
		"\2\2\2|}\3\2\2\2}\21\3\2\2\2~\177\7d\2\2\177\u0080\7\u009c\2\2\u0080\23"+
		"\3\2\2\2\u0081\u0082\7\t\2\2\u0082\u0084\5\26\f\2\u0083\u0085\5 \21\2"+
		"\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0088"+
		"\5\34\17\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\25\3\2\2\2\u0089"+
		"\u008a\b\f\1\2\u008a\u008b\7e\2\2\u008b\u008c\5\26\f\2\u008c\u008d\7f"+
		"\2\2\u008d\u0090\3\2\2\2\u008e\u0090\5\30\r\2\u008f\u0089\3\2\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\u0099\3\2\2\2\u0091\u0092\f\5\2\2\u0092\u0093\7D"+
		"\2\2\u0093\u0098\5\26\f\6\u0094\u0095\f\4\2\2\u0095\u0096\7E\2\2\u0096"+
		"\u0098\5\26\f\5\u0097\u0091\3\2\2\2\u0097\u0094\3\2\2\2\u0098\u009b\3"+
		"\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\27\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009d\5\n\6\2\u009d\u009e\t\5\2\2\u009e\u009f\5\n"+
		"\6\2\u009f\u00a5\3\2\2\2\u00a0\u00a1\5\n\6\2\u00a1\u00a2\7M\2\2\u00a2"+
		"\u00a3\5\32\16\2\u00a3\u00a5\3\2\2\2\u00a4\u009c\3\2\2\2\u00a4\u00a0\3"+
		"\2\2\2\u00a5\31\3\2\2\2\u00a6\u00a7\7e\2\2\u00a7\u00ac\5\16\b\2\u00a8"+
		"\u00a9\7l\2\2\u00a9\u00ab\5\16\b\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b0\7f\2\2\u00b0\33\3\2\2\2\u00b1\u00b2\7\60\2"+
		"\2\u00b2\u00b3\7[\2\2\u00b3\u00b4\5\n\6\2\u00b4\u00b5\t\6\2\2\u00b5\35"+
		"\3\2\2\2\u00b6\u00b7\7\u0097\2\2\u00b7\u00b8\t\7\2\2\u00b8\37\3\2\2\2"+
		"\u00b9\u00ba\7\21\2\2\u00ba\u00bb\7\13\2\2\u00bb\u00c0\7\u009c\2\2\u00bc"+
		"\u00bd\7l\2\2\u00bd\u00bf\7\u009c\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c2"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1!\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\26\'*-\66:@E_jlw|\u0084\u0087\u008f\u0097\u0099\u00a4\u00ac"+
		"\u00c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}