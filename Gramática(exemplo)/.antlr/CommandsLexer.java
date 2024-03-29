// Generated from /home/danimag/Desktop/lfa-1819-g12/Gramática/Commands.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CommandsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, PIPE=20, NUM=21, ARG=22, IMAGE=23, NEWLINE=24, COMMENT=25, 
		WS=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "PIPE", "NUM", "ARG", "IMAGE", "NEWLINE", "COMMENT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'open'", "'save'", "'->'", "'show'", "'='", "'gray'", "'blur'", 
			"'crop'", "'zoom'", "'saturation'", "'brightness'", "'edges'", "'contrast'", 
			"'rotate'", "'scale'", "'resize'", "'extract'", "'contour'", "'difference'", 
			"'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "PIPE", "NUM", "ARG", 
			"IMAGE", "NEWLINE", "COMMENT", "WS"
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


	public CommandsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Commands.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00dd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\6\26\u00b7\n\26\r\26\16\26"+
		"\u00b8\3\27\6\27\u00bc\n\27\r\27\16\27\u00bd\3\30\3\30\6\30\u00c2\n\30"+
		"\r\30\16\30\u00c3\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u00ce\n"+
		"\32\f\32\16\32\u00d1\13\32\3\32\3\32\3\32\3\32\3\33\6\33\u00d8\n\33\r"+
		"\33\16\33\u00d9\3\33\3\33\3\u00cf\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\3\2\7\3\2\62;\5\2\62;C\\c|\5\2\60;C\\c|\4\2\f\f"+
		"\17\17\4\2\13\13\"\"\2\u00e1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3"+
		"\67\3\2\2\2\5<\3\2\2\2\7A\3\2\2\2\tD\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17"+
		"P\3\2\2\2\21U\3\2\2\2\23Z\3\2\2\2\25_\3\2\2\2\27j\3\2\2\2\31u\3\2\2\2"+
		"\33{\3\2\2\2\35\u0084\3\2\2\2\37\u008b\3\2\2\2!\u0091\3\2\2\2#\u0098\3"+
		"\2\2\2%\u00a0\3\2\2\2\'\u00a8\3\2\2\2)\u00b3\3\2\2\2+\u00b6\3\2\2\2-\u00bb"+
		"\3\2\2\2/\u00bf\3\2\2\2\61\u00c7\3\2\2\2\63\u00c9\3\2\2\2\65\u00d7\3\2"+
		"\2\2\678\7q\2\289\7r\2\29:\7g\2\2:;\7p\2\2;\4\3\2\2\2<=\7u\2\2=>\7c\2"+
		"\2>?\7x\2\2?@\7g\2\2@\6\3\2\2\2AB\7/\2\2BC\7@\2\2C\b\3\2\2\2DE\7u\2\2"+
		"EF\7j\2\2FG\7q\2\2GH\7y\2\2H\n\3\2\2\2IJ\7?\2\2J\f\3\2\2\2KL\7i\2\2LM"+
		"\7t\2\2MN\7c\2\2NO\7{\2\2O\16\3\2\2\2PQ\7d\2\2QR\7n\2\2RS\7w\2\2ST\7t"+
		"\2\2T\20\3\2\2\2UV\7e\2\2VW\7t\2\2WX\7q\2\2XY\7r\2\2Y\22\3\2\2\2Z[\7|"+
		"\2\2[\\\7q\2\2\\]\7q\2\2]^\7o\2\2^\24\3\2\2\2_`\7u\2\2`a\7c\2\2ab\7v\2"+
		"\2bc\7w\2\2cd\7t\2\2de\7c\2\2ef\7v\2\2fg\7k\2\2gh\7q\2\2hi\7p\2\2i\26"+
		"\3\2\2\2jk\7d\2\2kl\7t\2\2lm\7k\2\2mn\7i\2\2no\7j\2\2op\7v\2\2pq\7p\2"+
		"\2qr\7g\2\2rs\7u\2\2st\7u\2\2t\30\3\2\2\2uv\7g\2\2vw\7f\2\2wx\7i\2\2x"+
		"y\7g\2\2yz\7u\2\2z\32\3\2\2\2{|\7e\2\2|}\7q\2\2}~\7p\2\2~\177\7v\2\2\177"+
		"\u0080\7t\2\2\u0080\u0081\7c\2\2\u0081\u0082\7u\2\2\u0082\u0083\7v\2\2"+
		"\u0083\34\3\2\2\2\u0084\u0085\7t\2\2\u0085\u0086\7q\2\2\u0086\u0087\7"+
		"v\2\2\u0087\u0088\7c\2\2\u0088\u0089\7v\2\2\u0089\u008a\7g\2\2\u008a\36"+
		"\3\2\2\2\u008b\u008c\7u\2\2\u008c\u008d\7e\2\2\u008d\u008e\7c\2\2\u008e"+
		"\u008f\7n\2\2\u008f\u0090\7g\2\2\u0090 \3\2\2\2\u0091\u0092\7t\2\2\u0092"+
		"\u0093\7g\2\2\u0093\u0094\7u\2\2\u0094\u0095\7k\2\2\u0095\u0096\7|\2\2"+
		"\u0096\u0097\7g\2\2\u0097\"\3\2\2\2\u0098\u0099\7g\2\2\u0099\u009a\7z"+
		"\2\2\u009a\u009b\7v\2\2\u009b\u009c\7t\2\2\u009c\u009d\7c\2\2\u009d\u009e"+
		"\7e\2\2\u009e\u009f\7v\2\2\u009f$\3\2\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2"+
		"\7q\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7q\2\2\u00a5"+
		"\u00a6\7w\2\2\u00a6\u00a7\7t\2\2\u00a7&\3\2\2\2\u00a8\u00a9\7f\2\2\u00a9"+
		"\u00aa\7k\2\2\u00aa\u00ab\7h\2\2\u00ab\u00ac\7h\2\2\u00ac\u00ad\7g\2\2"+
		"\u00ad\u00ae\7t\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1"+
		"\7e\2\2\u00b1\u00b2\7g\2\2\u00b2(\3\2\2\2\u00b3\u00b4\7~\2\2\u00b4*\3"+
		"\2\2\2\u00b5\u00b7\t\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9,\3\2\2\2\u00ba\u00bc\t\3\2\2"+
		"\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be.\3\2\2\2\u00bf\u00c1\7$\2\2\u00c0\u00c2\t\4\2\2\u00c1\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6\60\3\2\2\2\u00c7\u00c8\t\5\2\2"+
		"\u00c8\62\3\2\2\2\u00c9\u00ca\7\61\2\2\u00ca\u00cb\7\61\2\2\u00cb\u00cf"+
		"\3\2\2\2\u00cc\u00ce\13\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2"+
		"\u00cf\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d2\u00d3\7\f\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\b\32\2\2"+
		"\u00d5\64\3\2\2\2\u00d6\u00d8\t\6\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dc\b\33\2\2\u00dc\66\3\2\2\2\b\2\u00b8\u00bd\u00c3\u00cf\u00d9\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}