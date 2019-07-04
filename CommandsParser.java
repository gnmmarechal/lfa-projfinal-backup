// Generated from Commands.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CommandsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, ID=28, LETTER=29, NUM=30, IMAGE=31, COMMENT=32, 
		WS=33;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_instruction = 2, RULE_block = 3, 
		RULE_assignment = 4, RULE_writing = 5, RULE_operation = 6, RULE_forcycle = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "instruction", "block", "assignment", "writing", 
			"operation", "forcycle"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "'='", "'('", "')'", "'save'", "'show'", "'gray'", 
			"'blur'", "'crop'", "'zoom'", "'brightness'", "'edges'", "'contrast'", 
			"'rotate'", "'scale'", "'resize'", "'extract'", "'contour'", "'difference'", 
			"'for'", "'<'", "'>'", "'=='", "'++'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ID", "LETTER", "NUM", "IMAGE", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "Commands.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CommandsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CommandsParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << ID))) != 0)) {
				{
				{
				setState(16);
				statement();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
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

	public static class StatementContext extends ParserRuleContext {
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForcycleContext forcycle() {
			return getRuleContext(ForcycleContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				instruction();
				setState(25);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				block();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				forcycle();
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

	public static class InstructionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				assignment();
				}
				break;
			case T__4:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				writing();
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

	public static class BlockContext extends ParserRuleContext {
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
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__1);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << ID))) != 0)) {
				{
				{
				setState(36);
				statement();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(T__2);
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
		public List<TerminalNode> ID() { return getTokens(CommandsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CommandsParser.ID, i);
		}
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(ID);
				setState(45);
				match(T__3);
				setState(46);
				match(IMAGE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(ID);
				setState(48);
				match(T__3);
				setState(49);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(ID);
				setState(51);
				match(T__3);
				setState(52);
				writing();
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

	public static class WritingContext extends ParserRuleContext {
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public WritingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterWriting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitWriting(this);
		}
	}

	public final WritingContext writing() throws RecognitionException {
		WritingContext _localctx = new WritingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_writing);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__4);
				setState(56);
				writing();
				setState(57);
				match(T__5);
				}
				break;
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				operation();
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

	public static class OperationContext extends ParserRuleContext {
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
	 
		public OperationContext() { }
		public void copyFrom(OperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GrayContext extends OperationContext {
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public GrayContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterGray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitGray(this);
		}
	}
	public static class RotateContext extends OperationContext {
		public TerminalNode NUM() { return getToken(CommandsParser.NUM, 0); }
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public RotateContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterRotate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitRotate(this);
		}
	}
	public static class BrightnessContext extends OperationContext {
		public TerminalNode NUM() { return getToken(CommandsParser.NUM, 0); }
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public BrightnessContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterBrightness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitBrightness(this);
		}
	}
	public static class ResizeContext extends OperationContext {
		public List<TerminalNode> NUM() { return getTokens(CommandsParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(CommandsParser.NUM, i);
		}
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public ResizeContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterResize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitResize(this);
		}
	}
	public static class ScaleContext extends OperationContext {
		public TerminalNode NUM() { return getToken(CommandsParser.NUM, 0); }
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public ScaleContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterScale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitScale(this);
		}
	}
	public static class ExtractContext extends OperationContext {
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public ExtractContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterExtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitExtract(this);
		}
	}
	public static class DifferenceContext extends OperationContext {
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CommandsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CommandsParser.ID, i);
		}
		public List<TerminalNode> IMAGE() { return getTokens(CommandsParser.IMAGE); }
		public TerminalNode IMAGE(int i) {
			return getToken(CommandsParser.IMAGE, i);
		}
		public DifferenceContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitDifference(this);
		}
	}
	public static class SaveImageContext extends OperationContext {
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public SaveImageContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterSaveImage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitSaveImage(this);
		}
	}
	public static class EdgesContext extends OperationContext {
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public EdgesContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterEdges(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitEdges(this);
		}
	}
	public static class ContrastContext extends OperationContext {
		public TerminalNode NUM() { return getToken(CommandsParser.NUM, 0); }
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public ContrastContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterContrast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitContrast(this);
		}
	}
	public static class CropContext extends OperationContext {
		public List<TerminalNode> NUM() { return getTokens(CommandsParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(CommandsParser.NUM, i);
		}
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public CropContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterCrop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitCrop(this);
		}
	}
	public static class ContourContext extends OperationContext {
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public ContourContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterContour(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitContour(this);
		}
	}
	public static class ShowImageContext extends OperationContext {
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public ShowImageContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterShowImage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitShowImage(this);
		}
	}
	public static class BlurContext extends OperationContext {
		public TerminalNode NUM() { return getToken(CommandsParser.NUM, 0); }
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public BlurContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterBlur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitBlur(this);
		}
	}
	public static class ZoomContext extends OperationContext {
		public TerminalNode NUM() { return getToken(CommandsParser.NUM, 0); }
		public WritingContext writing() {
			return getRuleContext(WritingContext.class,0);
		}
		public TerminalNode ID() { return getToken(CommandsParser.ID, 0); }
		public TerminalNode IMAGE() { return getToken(CommandsParser.IMAGE, 0); }
		public ZoomContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterZoom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitZoom(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operation);
		int _la;
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				_localctx = new SaveImageContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(T__6);
				setState(66);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(63);
					writing();
					}
					break;
				case ID:
					{
					setState(64);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(65);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__7:
				_localctx = new ShowImageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(T__7);
				setState(72);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(69);
					writing();
					}
					break;
				case ID:
					{
					setState(70);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(71);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__8:
				_localctx = new GrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(T__8);
				setState(78);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(75);
					writing();
					}
					break;
				case ID:
					{
					setState(76);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(77);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__9:
				_localctx = new BlurContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(T__9);
				setState(81);
				match(NUM);
				setState(85);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(82);
					writing();
					}
					break;
				case ID:
					{
					setState(83);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(84);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__10:
				_localctx = new CropContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				match(T__10);
				setState(88);
				match(NUM);
				setState(89);
				match(NUM);
				setState(90);
				match(NUM);
				setState(91);
				match(NUM);
				setState(95);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(92);
					writing();
					}
					break;
				case ID:
					{
					setState(93);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(94);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__11:
				_localctx = new ZoomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(97);
				match(T__11);
				setState(98);
				match(NUM);
				setState(102);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(99);
					writing();
					}
					break;
				case ID:
					{
					setState(100);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(101);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__12:
				_localctx = new BrightnessContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				match(T__12);
				setState(105);
				match(NUM);
				setState(109);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(106);
					writing();
					}
					break;
				case ID:
					{
					setState(107);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(108);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__13:
				_localctx = new EdgesContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(111);
				match(T__13);
				setState(115);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(112);
					writing();
					}
					break;
				case ID:
					{
					setState(113);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(114);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__14:
				_localctx = new ContrastContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(117);
				match(T__14);
				setState(118);
				match(NUM);
				setState(122);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(119);
					writing();
					}
					break;
				case ID:
					{
					setState(120);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(121);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__15:
				_localctx = new RotateContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(124);
				match(T__15);
				setState(125);
				match(NUM);
				setState(129);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(126);
					writing();
					}
					break;
				case ID:
					{
					setState(127);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(128);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__16:
				_localctx = new ScaleContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(131);
				match(T__16);
				setState(132);
				match(NUM);
				setState(136);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(133);
					writing();
					}
					break;
				case ID:
					{
					setState(134);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(135);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__17:
				_localctx = new ResizeContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(138);
				match(T__17);
				setState(139);
				match(NUM);
				setState(140);
				match(NUM);
				setState(144);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(141);
					writing();
					}
					break;
				case ID:
					{
					setState(142);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(143);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__18:
				_localctx = new ExtractContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(146);
				match(T__18);
				setState(150);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(147);
					writing();
					}
					break;
				case ID:
					{
					setState(148);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(149);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__19:
				_localctx = new ContourContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(152);
				match(T__19);
				setState(156);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(153);
					writing();
					}
					break;
				case ID:
					{
					setState(154);
					match(ID);
					}
					break;
				case IMAGE:
					{
					setState(155);
					match(IMAGE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__20:
				_localctx = new DifferenceContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(158);
				match(T__20);
				setState(162);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
					{
					setState(159);
					writing();
					}
					break;
				case ID:
				case IMAGE:
					{
					{
					setState(160);
					_la = _input.LA(1);
					if ( !(_la==ID || _la==IMAGE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(161);
					_la = _input.LA(1);
					if ( !(_la==ID || _la==IMAGE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class ForcycleContext extends ParserRuleContext {
		public Token op;
		public Token increment;
		public List<TerminalNode> LETTER() { return getTokens(CommandsParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(CommandsParser.LETTER, i);
		}
		public List<TerminalNode> NUM() { return getTokens(CommandsParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(CommandsParser.NUM, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForcycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forcycle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterForcycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitForcycle(this);
		}
	}

	public final ForcycleContext forcycle() throws RecognitionException {
		ForcycleContext _localctx = new ForcycleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forcycle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__21);
			setState(167);
			match(T__4);
			setState(168);
			match(LETTER);
			setState(169);
			match(T__3);
			setState(170);
			match(NUM);
			setState(171);
			match(T__0);
			setState(172);
			match(LETTER);
			setState(173);
			((ForcycleContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
				((ForcycleContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(174);
			match(NUM);
			setState(175);
			match(T__0);
			setState(176);
			match(LETTER);
			setState(177);
			((ForcycleContext)_localctx).increment = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
				((ForcycleContext)_localctx).increment = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(178);
			match(T__5);
			setState(179);
			block();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00b8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2"+
		"\f\2\16\2\27\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3 \n\3\3\4\3\4\5\4$\n"+
		"\4\3\5\3\5\7\5(\n\5\f\5\16\5+\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\68\n\6\3\7\3\7\3\7\3\7\3\7\5\7?\n\7\3\b\3\b\3\b\3\b\5\bE\n"+
		"\b\3\b\3\b\3\b\3\b\5\bK\n\b\3\b\3\b\3\b\3\b\5\bQ\n\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bX\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bb\n\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bi\n\b\3\b\3\b\3\b\3\b\3\b\5\bp\n\b\3\b\3\b\3\b\3\b\5\bv\n\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b}\n\b\3\b\3\b\3\b\3\b\3\b\5\b\u0084\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u008b\n\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0093\n\b\3\b\3\b"+
		"\3\b\3\b\5\b\u0099\n\b\3\b\3\b\3\b\3\b\5\b\u009f\n\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00a5\n\b\5\b\u00a7\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\5\4\2\36\36!!\3\2\31\33"+
		"\3\2\34\35\2\u00e2\2\25\3\2\2\2\4\37\3\2\2\2\6#\3\2\2\2\b%\3\2\2\2\n\67"+
		"\3\2\2\2\f>\3\2\2\2\16\u00a6\3\2\2\2\20\u00a8\3\2\2\2\22\24\5\4\3\2\23"+
		"\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27"+
		"\25\3\2\2\2\30\31\7\2\2\3\31\3\3\2\2\2\32\33\5\6\4\2\33\34\7\3\2\2\34"+
		" \3\2\2\2\35 \5\b\5\2\36 \5\20\t\2\37\32\3\2\2\2\37\35\3\2\2\2\37\36\3"+
		"\2\2\2 \5\3\2\2\2!$\5\n\6\2\"$\5\f\7\2#!\3\2\2\2#\"\3\2\2\2$\7\3\2\2\2"+
		"%)\7\4\2\2&(\5\4\3\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2"+
		"\2+)\3\2\2\2,-\7\5\2\2-\t\3\2\2\2./\7\36\2\2/\60\7\6\2\2\608\7!\2\2\61"+
		"\62\7\36\2\2\62\63\7\6\2\2\638\7\36\2\2\64\65\7\36\2\2\65\66\7\6\2\2\66"+
		"8\5\f\7\2\67.\3\2\2\2\67\61\3\2\2\2\67\64\3\2\2\28\13\3\2\2\29:\7\7\2"+
		"\2:;\5\f\7\2;<\7\b\2\2<?\3\2\2\2=?\5\16\b\2>9\3\2\2\2>=\3\2\2\2?\r\3\2"+
		"\2\2@D\7\t\2\2AE\5\f\7\2BE\7\36\2\2CE\7!\2\2DA\3\2\2\2DB\3\2\2\2DC\3\2"+
		"\2\2E\u00a7\3\2\2\2FJ\7\n\2\2GK\5\f\7\2HK\7\36\2\2IK\7!\2\2JG\3\2\2\2"+
		"JH\3\2\2\2JI\3\2\2\2K\u00a7\3\2\2\2LP\7\13\2\2MQ\5\f\7\2NQ\7\36\2\2OQ"+
		"\7!\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2Q\u00a7\3\2\2\2RS\7\f\2\2SW\7 \2"+
		"\2TX\5\f\7\2UX\7\36\2\2VX\7!\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\u00a7"+
		"\3\2\2\2YZ\7\r\2\2Z[\7 \2\2[\\\7 \2\2\\]\7 \2\2]a\7 \2\2^b\5\f\7\2_b\7"+
		"\36\2\2`b\7!\2\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2b\u00a7\3\2\2\2cd\7\16\2"+
		"\2dh\7 \2\2ei\5\f\7\2fi\7\36\2\2gi\7!\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2"+
		"\2i\u00a7\3\2\2\2jk\7\17\2\2ko\7 \2\2lp\5\f\7\2mp\7\36\2\2np\7!\2\2ol"+
		"\3\2\2\2om\3\2\2\2on\3\2\2\2p\u00a7\3\2\2\2qu\7\20\2\2rv\5\f\7\2sv\7\36"+
		"\2\2tv\7!\2\2ur\3\2\2\2us\3\2\2\2ut\3\2\2\2v\u00a7\3\2\2\2wx\7\21\2\2"+
		"x|\7 \2\2y}\5\f\7\2z}\7\36\2\2{}\7!\2\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2"+
		"}\u00a7\3\2\2\2~\177\7\22\2\2\177\u0083\7 \2\2\u0080\u0084\5\f\7\2\u0081"+
		"\u0084\7\36\2\2\u0082\u0084\7!\2\2\u0083\u0080\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0082\3\2\2\2\u0084\u00a7\3\2\2\2\u0085\u0086\7\23\2\2\u0086"+
		"\u008a\7 \2\2\u0087\u008b\5\f\7\2\u0088\u008b\7\36\2\2\u0089\u008b\7!"+
		"\2\2\u008a\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\u00a7\3\2\2\2\u008c\u008d\7\24\2\2\u008d\u008e\7 \2\2\u008e\u0092\7 "+
		"\2\2\u008f\u0093\5\f\7\2\u0090\u0093\7\36\2\2\u0091\u0093\7!\2\2\u0092"+
		"\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\u00a7\3\2"+
		"\2\2\u0094\u0098\7\25\2\2\u0095\u0099\5\f\7\2\u0096\u0099\7\36\2\2\u0097"+
		"\u0099\7!\2\2\u0098\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2"+
		"\2\2\u0099\u00a7\3\2\2\2\u009a\u009e\7\26\2\2\u009b\u009f\5\f\7\2\u009c"+
		"\u009f\7\36\2\2\u009d\u009f\7!\2\2\u009e\u009b\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009d\3\2\2\2\u009f\u00a7\3\2\2\2\u00a0\u00a4\7\27\2\2\u00a1"+
		"\u00a5\5\f\7\2\u00a2\u00a3\t\2\2\2\u00a3\u00a5\t\2\2\2\u00a4\u00a1\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6@\3\2\2\2\u00a6F\3\2"+
		"\2\2\u00a6L\3\2\2\2\u00a6R\3\2\2\2\u00a6Y\3\2\2\2\u00a6c\3\2\2\2\u00a6"+
		"j\3\2\2\2\u00a6q\3\2\2\2\u00a6w\3\2\2\2\u00a6~\3\2\2\2\u00a6\u0085\3\2"+
		"\2\2\u00a6\u008c\3\2\2\2\u00a6\u0094\3\2\2\2\u00a6\u009a\3\2\2\2\u00a6"+
		"\u00a0\3\2\2\2\u00a7\17\3\2\2\2\u00a8\u00a9\7\30\2\2\u00a9\u00aa\7\7\2"+
		"\2\u00aa\u00ab\7\37\2\2\u00ab\u00ac\7\6\2\2\u00ac\u00ad\7 \2\2\u00ad\u00ae"+
		"\7\3\2\2\u00ae\u00af\7\37\2\2\u00af\u00b0\t\3\2\2\u00b0\u00b1\7 \2\2\u00b1"+
		"\u00b2\7\3\2\2\u00b2\u00b3\7\37\2\2\u00b3\u00b4\t\4\2\2\u00b4\u00b5\7"+
		"\b\2\2\u00b5\u00b6\5\b\5\2\u00b6\21\3\2\2\2\30\25\37#)\67>DJPWahou|\u0083"+
		"\u008a\u0092\u0098\u009e\u00a4\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}