// Generated from /home/ochibobo/Desktop/Ochibobo/Course/BaseLanguage/src/main/java/grammar/LanguageLexerRules.g4 by ANTLR 4.9.1
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexerRules extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, NUM=2, INT_TYPE=3, COMMENT=4, WS=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "NUM", "INT_TYPE", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'INT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "NUM", "INT_TYPE", "COMMENT", "WS"
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


	public LanguageLexerRules(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LanguageLexerRules.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\7\63\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\7\2\20\n\2\f\2\16\2\23\13\2\3"+
		"\3\3\3\5\3\27\n\3\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\5\3 \n\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6.\n\6\r\6\16\6/\3\6\3\6\2"+
		"\2\7\3\3\5\4\7\5\t\6\13\7\3\2\b\3\2c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\4"+
		"\2\f\f\17\17\4\2\13\f\"\"\2\67\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\3\r\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t%\3\2\2\2\13"+
		"-\3\2\2\2\r\21\t\2\2\2\16\20\t\3\2\2\17\16\3\2\2\2\20\23\3\2\2\2\21\17"+
		"\3\2\2\2\21\22\3\2\2\2\22\4\3\2\2\2\23\21\3\2\2\2\24 \7\62\2\2\25\27\7"+
		"/\2\2\26\25\3\2\2\2\26\27\3\2\2\2\27\30\3\2\2\2\30\34\t\4\2\2\31\33\t"+
		"\5\2\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35 \3\2"+
		"\2\2\36\34\3\2\2\2\37\24\3\2\2\2\37\26\3\2\2\2 \6\3\2\2\2!\"\7K\2\2\""+
		"#\7P\2\2#$\7V\2\2$\b\3\2\2\2%&\7/\2\2&\'\7/\2\2\'(\3\2\2\2()\n\6\2\2)"+
		"*\3\2\2\2*+\b\5\2\2+\n\3\2\2\2,.\t\7\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2"+
		"/\60\3\2\2\2\60\61\3\2\2\2\61\62\b\6\2\2\62\f\3\2\2\2\b\2\21\26\34\37"+
		"/\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}