// Generated from D:/School/kwartiel 3/Compilers en operating systems/DutchJava2\DutchJava.g4 by ANTLR 4.7

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DutchJavaParser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, OF = 14, EN = 15, GELIJKAAN = 16, NIETGELIJKAAN = 17,
            GROTERDAN = 18, KLEINERDAN = 19, GROTERGELIJK = 20, KLEINERGELIJK = 21, MINUS = 22,
            PLUS = 23, KEER = 24, GEDEELDDOOR = 25, MODULO = 26, PLUSIS = 27, MINIS = 28, KEERIS = 29,
            GEDEELDDOORIS = 30, SEMICOL = 31, KENTOE = 32, HAAKOPEN = 33, HAAKSLUIT = 34, GEEFTERUG = 35,
            DATATYPE = 36, INT = 37, FLOAT = 38, BOOLEAN = 39, STRING = 40, ID = 41, COMMENT = 42,
            SPACE = 43;
    public static final int
            RULE_parse = 0, RULE_blok = 1, RULE_statement = 2, RULE_read_statement = 3,
            RULE_print_statement = 4, RULE_als_statement = 5, RULE_zolang_statement = 6,
            RULE_voor_statement = 7, RULE_declarering = 8, RULE_toekenning = 9, RULE_toekenningWithMethod = 10,
            RULE_verandering = 11, RULE_veranderingWithMethod = 12, RULE_conditie_block = 13,
            RULE_stat_blok = 14, RULE_func_stat_blok = 15, RULE_methodeAANROEP = 16,
            RULE_methodeUITVOERING = 17, RULE_argument = 18, RULE_argument_uitvoering = 19,
            RULE_argument_type = 20, RULE_expressie = 21, RULE_value_expressie = 22,
            RULE_atom = 23;
    public static final String[] ruleNames = {
            "parse", "blok", "statement", "read_statement", "print_statement", "als_statement",
            "zolang_statement", "voor_statement", "declarering", "toekenning", "toekenningWithMethod",
            "verandering", "veranderingWithMethod", "conditie_block", "stat_blok",
            "func_stat_blok", "methodeAANROEP", "methodeUITVOERING", "argument", "argument_uitvoering",
            "argument_type", "expressie", "value_expressie", "atom"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0114\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\2\3\3\7\3=\n\3\f\3\16\3@\13" +
                    "\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3" +
                    "\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6" +
                    "\3\6\3\6\5\6f\n\6\3\7\3\7\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\3\7\3\7\5\7" +
                    "s\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t}\n\t\3\t\3\t\3\t\3\t\3\t\3\t" +
                    "\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f" +
                    "\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20" +
                    "\3\20\3\21\3\21\3\21\5\21\u00a8\n\21\3\21\5\21\u00ab\n\21\3\21\5\21\u00ae" +
                    "\n\21\3\21\3\21\3\22\3\22\3\22\5\22\u00b5\n\22\3\22\3\22\3\22\3\23\3\23" +
                    "\3\23\3\23\3\23\5\23\u00bf\n\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00c7" +
                    "\n\24\f\24\16\24\u00ca\13\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00d2" +
                    "\n\25\f\25\16\25\u00d5\13\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3" +
                    "\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00eb" +
                    "\n\27\f\27\16\27\u00ee\13\27\3\30\3\30\3\30\3\30\5\30\u00f4\n\30\3\30" +
                    "\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0101\n\30\f\30" +
                    "\16\30\u0104\13\30\3\31\3\31\3\31\5\31\u0109\n\31\3\31\3\31\3\31\3\31" +
                    "\3\31\3\31\3\31\5\31\u0112\n\31\3\31\2\4,.\32\2\4\6\b\n\f\16\20\22\24" +
                    "\26\30\32\34\36 \"$&(*,.\60\2\t\3\2\'+\3\2\24\27\3\2\22\23\3\2\32\34\3" +
                    "\2\30\31\3\2\35 \3\2\16\17\2\u0124\2\65\3\2\2\2\4>\3\2\2\2\6O\3\2\2\2" +
                    "\bQ\3\2\2\2\ne\3\2\2\2\fg\3\2\2\2\16t\3\2\2\2\20x\3\2\2\2\22\u0085\3\2" +
                    "\2\2\24\u0089\3\2\2\2\26\u008f\3\2\2\2\30\u0094\3\2\2\2\32\u0099\3\2\2" +
                    "\2\34\u009d\3\2\2\2\36\u00a0\3\2\2\2 \u00a4\3\2\2\2\"\u00b1\3\2\2\2$\u00b9" +
                    "\3\2\2\2&\u00c8\3\2\2\2(\u00d3\3\2\2\2*\u00d9\3\2\2\2,\u00db\3\2\2\2." +
                    "\u00f3\3\2\2\2\60\u0111\3\2\2\2\62\64\5$\23\2\63\62\3\2\2\2\64\67\3\2" +
                    "\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\5\4\3\29" +
                    ":\7\2\2\3:\3\3\2\2\2;=\5\6\4\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2" +
                    "?\5\3\2\2\2@>\3\2\2\2AP\5\b\5\2BP\5\22\n\2CP\5\n\6\2DP\5\f\7\2EP\5\20" +
                    "\t\2FP\5\16\b\2GP\5\"\22\2HP\5\24\13\2IP\5\26\f\2JP\5\30\r\2KP\5\32\16" +
                    "\2LM\5.\30\2MN\7!\2\2NP\3\2\2\2OA\3\2\2\2OB\3\2\2\2OC\3\2\2\2OD\3\2\2" +
                    "\2OE\3\2\2\2OF\3\2\2\2OG\3\2\2\2OH\3\2\2\2OI\3\2\2\2OJ\3\2\2\2OK\3\2\2" +
                    "\2OL\3\2\2\2P\7\3\2\2\2QR\7+\2\2RS\7\3\2\2ST\7&\2\2TU\7$\2\2UV\7!\2\2" +
                    "V\t\3\2\2\2WX\7\4\2\2XY\7+\2\2Yf\7!\2\2Z[\7\4\2\2[\\\7*\2\2\\f\7!\2\2" +
                    "]^\7\4\2\2^_\5.\30\2_`\7!\2\2`f\3\2\2\2ab\7\4\2\2bc\5,\27\2cd\7!\2\2d" +
                    "f\3\2\2\2eW\3\2\2\2eZ\3\2\2\2e]\3\2\2\2ea\3\2\2\2f\13\3\2\2\2gh\7\5\2" +
                    "\2hm\5\34\17\2ij\7\6\2\2jl\5\34\17\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3" +
                    "\2\2\2nr\3\2\2\2om\3\2\2\2pq\7\7\2\2qs\5\36\20\2rp\3\2\2\2rs\3\2\2\2s" +
                    "\r\3\2\2\2tu\7\b\2\2uv\5,\27\2vw\5\36\20\2w\17\3\2\2\2xy\7\t\2\2y|\7#" +
                    "\2\2z}\5\24\13\2{}\5\30\r\2|z\3\2\2\2|{\3\2\2\2}~\3\2\2\2~\177\5,\27\2" +
                    "\177\u0080\7!\2\2\u0080\u0081\5.\30\2\u0081\u0082\7$\2\2\u0082\u0083\3" +
                    "\2\2\2\u0083\u0084\5\36\20\2\u0084\21\3\2\2\2\u0085\u0086\7&\2\2\u0086" +
                    "\u0087\7+\2\2\u0087\u0088\7!\2\2\u0088\23\3\2\2\2\u0089\u008a\7&\2\2\u008a" +
                    "\u008b\7+\2\2\u008b\u008c\7\"\2\2\u008c\u008d\5.\30\2\u008d\u008e\7!\2" +
                    "\2\u008e\25\3\2\2\2\u008f\u0090\7&\2\2\u0090\u0091\7+\2\2\u0091\u0092" +
                    "\7\"\2\2\u0092\u0093\5\"\22\2\u0093\27\3\2\2\2\u0094\u0095\7+\2\2\u0095" +
                    "\u0096\7\"\2\2\u0096\u0097\5.\30\2\u0097\u0098\7!\2\2\u0098\31\3\2\2\2" +
                    "\u0099\u009a\7+\2\2\u009a\u009b\7\"\2\2\u009b\u009c\5\"\22\2\u009c\33" +
                    "\3\2\2\2\u009d\u009e\5,\27\2\u009e\u009f\5\36\20\2\u009f\35\3\2\2\2\u00a0" +
                    "\u00a1\7\n\2\2\u00a1\u00a2\5\4\3\2\u00a2\u00a3\7\13\2\2\u00a3\37\3\2\2" +
                    "\2\u00a4\u00a5\7\n\2\2\u00a5\u00a7\5\4\3\2\u00a6\u00a8\7%\2\2\u00a7\u00a6" +
                    "\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00ab\7+\2\2\u00aa" +
                    "\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00ae\7!" +
                    "\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af" +
                    "\u00b0\7\13\2\2\u00b0!\3\2\2\2\u00b1\u00b2\7+\2\2\u00b2\u00b4\7#\2\2\u00b3" +
                    "\u00b5\5&\24\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2" +
                    "\2\2\u00b6\u00b7\7$\2\2\u00b7\u00b8\7!\2\2\u00b8#\3\2\2\2\u00b9\u00ba" +
                    "\7&\2\2\u00ba\u00bb\7\f\2\2\u00bb\u00bc\7+\2\2\u00bc\u00be\7#\2\2\u00bd" +
                    "\u00bf\5(\25\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2" +
                    "\2\2\u00c0\u00c1\7$\2\2\u00c1\u00c2\5 \21\2\u00c2%\3\2\2\2\u00c3\u00c4" +
                    "\5*\26\2\u00c4\u00c5\7\r\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c7" +
                    "\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2" +
                    "\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\5*\26\2\u00cc\'\3\2\2\2\u00cd\u00ce" +
                    "\7&\2\2\u00ce\u00cf\5*\26\2\u00cf\u00d0\7\r\2\2\u00d0\u00d2\3\2\2\2\u00d1" +
                    "\u00cd\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2" +
                    "\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7&\2\2\u00d7" +
                    "\u00d8\5*\26\2\u00d8)\3\2\2\2\u00d9\u00da\t\2\2\2\u00da+\3\2\2\2\u00db" +
                    "\u00dc\b\27\1\2\u00dc\u00dd\5\60\31\2\u00dd\u00ec\3\2\2\2\u00de\u00df" +
                    "\f\7\2\2\u00df\u00e0\t\3\2\2\u00e0\u00eb\5,\27\b\u00e1\u00e2\f\6\2\2\u00e2" +
                    "\u00e3\t\4\2\2\u00e3\u00eb\5,\27\7\u00e4\u00e5\f\5\2\2\u00e5\u00e6\7\21" +
                    "\2\2\u00e6\u00eb\5,\27\6\u00e7\u00e8\f\4\2\2\u00e8\u00e9\7\20\2\2\u00e9" +
                    "\u00eb\5,\27\5\u00ea\u00de\3\2\2\2\u00ea\u00e1\3\2\2\2\u00ea\u00e4\3\2" +
                    "\2\2\u00ea\u00e7\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec" +
                    "\u00ed\3\2\2\2\u00ed-\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\b\30\1\2" +
                    "\u00f0\u00f1\7\30\2\2\u00f1\u00f4\5.\30\7\u00f2\u00f4\5\60\31\2\u00f3" +
                    "\u00ef\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u0102\3\2\2\2\u00f5\u00f6\f\b" +
                    "\2\2\u00f6\u00f7\t\5\2\2\u00f7\u0101\5.\30\t\u00f8\u00f9\f\6\2\2\u00f9" +
                    "\u00fa\t\6\2\2\u00fa\u0101\5.\30\7\u00fb\u00fc\f\5\2\2\u00fc\u00fd\t\7" +
                    "\2\2\u00fd\u0101\5.\30\6\u00fe\u00ff\f\4\2\2\u00ff\u0101\t\b\2\2\u0100" +
                    "\u00f5\3\2\2\2\u0100\u00f8\3\2\2\2\u0100\u00fb\3\2\2\2\u0100\u00fe\3\2" +
                    "\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103" +
                    "/\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0108\7#\2\2\u0106\u0109\5,\27\2\u0107" +
                    "\u0109\5.\30\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2" +
                    "\2\2\u010a\u010b\7$\2\2\u010b\u0112\3\2\2\2\u010c\u0112\7\'\2\2\u010d" +
                    "\u0112\7(\2\2\u010e\u0112\7)\2\2\u010f\u0112\7+\2\2\u0110\u0112\7*\2\2" +
                    "\u0111\u0105\3\2\2\2\u0111\u010c\3\2\2\2\u0111\u010d\3\2\2\2\u0111\u010e" +
                    "\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\61\3\2\2\2\27\65" +
                    ">Oemr|\u00a7\u00aa\u00ad\u00b4\u00be\u00c8\u00d3\u00ea\u00ec\u00f3\u0100" +
                    "\u0102\u0108\u0111";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'< ('", "'schrijf '", "'als'", "'alsanders'", "'anders'", "'zolang'",
            "'voor'", "'{'", "'}'", "'functie'", "','", "'--'", "'++'", null, null,
            "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'-'", "'+'", "'*'", "'/'",
            "'%'", null, null, null, null, "';'", null, "'('", "')'", "'geefterug'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, "OF", "EN", "GELIJKAAN", "NIETGELIJKAAN", "GROTERDAN", "KLEINERDAN",
            "GROTERGELIJK", "KLEINERGELIJK", "MINUS", "PLUS", "KEER", "GEDEELDDOOR",
            "MODULO", "PLUSIS", "MINIS", "KEERIS", "GEDEELDDOORIS", "SEMICOL", "KENTOE",
            "HAAKOPEN", "HAAKSLUIT", "GEEFTERUG", "DATATYPE", "INT", "FLOAT", "BOOLEAN",
            "STRING", "ID", "COMMENT", "SPACE"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public DutchJavaParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String getGrammarFileName() {
        return "DutchJava.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ParseContext parse() throws RecognitionException {
        ParseContext _localctx = new ParseContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_parse);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(51);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 0, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(48);
                                methodeUITVOERING();
                            }
                        }
                    }
                    setState(53);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 0, _ctx);
                }
                setState(54);
                blok();
                setState(55);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BlokContext blok() throws RecognitionException {
        BlokContext _localctx = new BlokContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_blok);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(60);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(57);
                                statement();
                            }
                        }
                    }
                    setState(62);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_statement);
        try {
            setState(77);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(63);
                    read_statement();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(64);
                    declarering();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(65);
                    print_statement();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(66);
                    als_statement();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(67);
                    voor_statement();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(68);
                    zolang_statement();
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(69);
                    methodeAANROEP();
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(70);
                    toekenning();
                }
                break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(71);
                    toekenningWithMethod();
                }
                break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(72);
                    verandering();
                }
                break;
                case 11:
                    enterOuterAlt(_localctx, 11);
                {
                    setState(73);
                    veranderingWithMethod();
                }
                break;
                case 12:
                    enterOuterAlt(_localctx, 12);
                {
                    setState(74);
                    value_expressie(0);
                    setState(75);
                    match(SEMICOL);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Read_statementContext read_statement() throws RecognitionException {
        Read_statementContext _localctx = new Read_statementContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_read_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(79);
                match(ID);
                setState(80);
                match(T__0);
                setState(81);
                match(DATATYPE);
                setState(82);
                match(HAAKSLUIT);
                setState(83);
                match(SEMICOL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Print_statementContext print_statement() throws RecognitionException {
        Print_statementContext _localctx = new Print_statementContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_print_statement);
        try {
            setState(99);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                case 1:
                    _localctx = new SchrijfIdContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(85);
                    match(T__1);
                    setState(86);
                    match(ID);
                    setState(87);
                    match(SEMICOL);
                }
                break;
                case 2:
                    _localctx = new SchrijfStringContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(88);
                    match(T__1);
                    setState(89);
                    match(STRING);
                    setState(90);
                    match(SEMICOL);
                }
                break;
                case 3:
                    _localctx = new SchrijfValExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(91);
                    match(T__1);
                    setState(92);
                    value_expressie(0);
                    setState(93);
                    match(SEMICOL);
                }
                break;
                case 4:
                    _localctx = new SchrijfExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(95);
                    match(T__1);
                    setState(96);
                    expressie(0);
                    setState(97);
                    match(SEMICOL);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Als_statementContext als_statement() throws RecognitionException {
        Als_statementContext _localctx = new Als_statementContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_als_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(101);
                match(T__2);
                setState(102);
                ((Als_statementContext) _localctx).cond_block = conditie_block();
                setState(107);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__3) {
                    {
                        {
                            setState(103);
                            match(T__3);
                            setState(104);
                            conditie_block();
                        }
                    }
                    setState(109);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(112);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__4) {
                    {
                        setState(110);
                        match(T__4);
                        setState(111);
                        stat_blok();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Zolang_statementContext zolang_statement() throws RecognitionException {
        Zolang_statementContext _localctx = new Zolang_statementContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_zolang_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(114);
                match(T__5);
                setState(115);
                expressie(0);
                setState(116);
                stat_blok();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Voor_statementContext voor_statement() throws RecognitionException {
        Voor_statementContext _localctx = new Voor_statementContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_voor_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(118);
                match(T__6);
                {
                    setState(119);
                    match(HAAKOPEN);
                    setState(122);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case DATATYPE: {
                            setState(120);
                            ((Voor_statementContext) _localctx).toek = toekenning();
                        }
                        break;
                        case ID: {
                            setState(121);
                            ((Voor_statementContext) _localctx).verand = verandering();
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(124);
                    expressie(0);
                    setState(125);
                    match(SEMICOL);
                    setState(126);
                    value_expressie(0);
                    setState(127);
                    match(HAAKSLUIT);
                }
                setState(129);
                stat_blok();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DeclareringContext declarering() throws RecognitionException {
        DeclareringContext _localctx = new DeclareringContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_declarering);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(131);
                match(DATATYPE);
                setState(132);
                match(ID);
                setState(133);
                match(SEMICOL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ToekenningContext toekenning() throws RecognitionException {
        ToekenningContext _localctx = new ToekenningContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_toekenning);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(135);
                match(DATATYPE);
                setState(136);
                match(ID);
                setState(137);
                match(KENTOE);
                setState(138);
                ((ToekenningContext) _localctx).expr = value_expressie(0);
                setState(139);
                match(SEMICOL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ToekenningWithMethodContext toekenningWithMethod() throws RecognitionException {
        ToekenningWithMethodContext _localctx = new ToekenningWithMethodContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_toekenningWithMethod);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(141);
                match(DATATYPE);
                setState(142);
                match(ID);
                setState(143);
                match(KENTOE);
                setState(144);
                ((ToekenningWithMethodContext) _localctx).expr = methodeAANROEP();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VeranderingContext verandering() throws RecognitionException {
        VeranderingContext _localctx = new VeranderingContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_verandering);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(146);
                ((VeranderingContext) _localctx).id = match(ID);
                setState(147);
                match(KENTOE);
                setState(148);
                ((VeranderingContext) _localctx).expr = value_expressie(0);
                setState(149);
                match(SEMICOL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VeranderingWithMethodContext veranderingWithMethod() throws RecognitionException {
        VeranderingWithMethodContext _localctx = new VeranderingWithMethodContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_veranderingWithMethod);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(151);
                ((VeranderingWithMethodContext) _localctx).id = match(ID);
                setState(152);
                match(KENTOE);
                setState(153);
                ((VeranderingWithMethodContext) _localctx).expr = methodeAANROEP();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Conditie_blockContext conditie_block() throws RecognitionException {
        Conditie_blockContext _localctx = new Conditie_blockContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_conditie_block);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(155);
                ((Conditie_blockContext) _localctx).expr = expressie(0);
                setState(156);
                ((Conditie_blockContext) _localctx).sBlock = stat_blok();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Stat_blokContext stat_blok() throws RecognitionException {
        Stat_blokContext _localctx = new Stat_blokContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_stat_blok);
        try {
            _localctx = new StatementBlokContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(158);
                match(T__7);
                setState(159);
                blok();
                setState(160);
                match(T__8);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Func_stat_blokContext func_stat_blok() throws RecognitionException {
        Func_stat_blokContext _localctx = new Func_stat_blokContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_func_stat_blok);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(162);
                match(T__7);
                setState(163);
                blok();
                setState(165);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == GEEFTERUG) {
                    {
                        setState(164);
                        match(GEEFTERUG);
                    }
                }

                setState(168);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ID) {
                    {
                        setState(167);
                        match(ID);
                    }
                }

                setState(171);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == SEMICOL) {
                    {
                        setState(170);
                        match(SEMICOL);
                    }
                }

                setState(173);
                match(T__8);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MethodeAANROEPContext methodeAANROEP() throws RecognitionException {
        MethodeAANROEPContext _localctx = new MethodeAANROEPContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_methodeAANROEP);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(175);
                match(ID);
                setState(176);
                match(HAAKOPEN);
                setState(178);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << STRING) | (1L << ID))) != 0)) {
                    {
                        setState(177);
                        argument();
                    }
                }

                setState(180);
                match(HAAKSLUIT);
                setState(181);
                match(SEMICOL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MethodeUITVOERINGContext methodeUITVOERING() throws RecognitionException {
        MethodeUITVOERINGContext _localctx = new MethodeUITVOERINGContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_methodeUITVOERING);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(183);
                match(DATATYPE);
                setState(184);
                match(T__9);
                setState(185);
                match(ID);
                setState(186);
                match(HAAKOPEN);
                setState(188);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DATATYPE) {
                    {
                        setState(187);
                        argument_uitvoering();
                    }
                }

                setState(190);
                match(HAAKSLUIT);
                setState(191);
                func_stat_blok();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArgumentContext argument() throws RecognitionException {
        ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_argument);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(198);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(193);
                                argument_type();
                                setState(194);
                                match(T__10);
                            }
                        }
                    }
                    setState(200);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
                }
                setState(201);
                argument_type();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Argument_uitvoeringContext argument_uitvoering() throws RecognitionException {
        Argument_uitvoeringContext _localctx = new Argument_uitvoeringContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_argument_uitvoering);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(209);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(203);
                                match(DATATYPE);
                                setState(204);
                                argument_type();
                                setState(205);
                                match(T__10);
                            }
                        }
                    }
                    setState(211);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
                }
                setState(212);
                match(DATATYPE);
                setState(213);
                argument_type();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Argument_typeContext argument_type() throws RecognitionException {
        Argument_typeContext _localctx = new Argument_typeContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_argument_type);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(215);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << STRING) | (1L << ID))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressieContext expressie() throws RecognitionException {
        return expressie(0);
    }

    private ExpressieContext expressie(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpressieContext _localctx = new ExpressieContext(_ctx, _parentState);
        ExpressieContext _prevctx = _localctx;
        int _startState = 42;
        enterRecursionRule(_localctx, 42, RULE_expressie, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    _localctx = new AtomCondExprContext(_localctx);
                    _ctx = _localctx;
                    _prevctx = _localctx;

                    setState(218);
                    atom();
                }
                _ctx.stop = _input.LT(-1);
                setState(234);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 15, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(232);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
                                case 1: {
                                    _localctx = new VergelijkingExprContext(new ExpressieContext(_parentctx, _parentState));
                                    ((VergelijkingExprContext) _localctx).leftExpr = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expressie);
                                    setState(220);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(221);
                                    ((VergelijkingExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GROTERDAN) | (1L << KLEINERDAN) | (1L << GROTERGELIJK) | (1L << KLEINERGELIJK))) != 0))) {
                                        ((VergelijkingExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(222);
                                    ((VergelijkingExprContext) _localctx).rightExpr = expressie(6);
                                }
                                break;
                                case 2: {
                                    _localctx = new GelijkheidExprContext(new ExpressieContext(_parentctx, _parentState));
                                    ((GelijkheidExprContext) _localctx).leftExpr = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expressie);
                                    setState(223);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(224);
                                    ((GelijkheidExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == GELIJKAAN || _la == NIETGELIJKAAN)) {
                                        ((GelijkheidExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(225);
                                    ((GelijkheidExprContext) _localctx).rightExpr = expressie(5);
                                }
                                break;
                                case 3: {
                                    _localctx = new EnenExprContext(new ExpressieContext(_parentctx, _parentState));
                                    ((EnenExprContext) _localctx).leftExpr = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expressie);
                                    setState(226);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(227);
                                    match(EN);
                                    setState(228);
                                    ((EnenExprContext) _localctx).rightExpr = expressie(4);
                                }
                                break;
                                case 4: {
                                    _localctx = new OfofExprContext(new ExpressieContext(_parentctx, _parentState));
                                    ((OfofExprContext) _localctx).leftExpr = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expressie);
                                    setState(229);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(230);
                                    match(OF);
                                    setState(231);
                                    ((OfofExprContext) _localctx).rightExpr = expressie(3);
                                }
                                break;
                            }
                        }
                    }
                    setState(236);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 15, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final Value_expressieContext value_expressie() throws RecognitionException {
        return value_expressie(0);
    }

    private Value_expressieContext value_expressie(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        Value_expressieContext _localctx = new Value_expressieContext(_ctx, _parentState);
        Value_expressieContext _prevctx = _localctx;
        int _startState = 44;
        enterRecursionRule(_localctx, 44, RULE_value_expressie, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(241);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case MINUS: {
                        _localctx = new MinusExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(238);
                        match(MINUS);
                        setState(239);
                        value_expressie(5);
                    }
                    break;
                    case HAAKOPEN:
                    case INT:
                    case FLOAT:
                    case BOOLEAN:
                    case STRING:
                    case ID: {
                        _localctx = new AtomValueExprContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(240);
                        atom();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(256);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 18, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(254);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                                case 1: {
                                    _localctx = new KeerGddModExprContext(new Value_expressieContext(_parentctx, _parentState));
                                    ((KeerGddModExprContext) _localctx).leftExpr = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_value_expressie);
                                    setState(243);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(244);
                                    ((KeerGddModExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEER) | (1L << GEDEELDDOOR) | (1L << MODULO))) != 0))) {
                                        ((KeerGddModExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(245);
                                    ((KeerGddModExprContext) _localctx).rightExpr = value_expressie(7);
                                }
                                break;
                                case 2: {
                                    _localctx = new PlusMinExprContext(new Value_expressieContext(_parentctx, _parentState));
                                    ((PlusMinExprContext) _localctx).leftExpr = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_value_expressie);
                                    setState(246);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(247);
                                    ((PlusMinExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == MINUS || _la == PLUS)) {
                                        ((PlusMinExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(248);
                                    ((PlusMinExprContext) _localctx).rightExpr = value_expressie(5);
                                }
                                break;
                                case 3: {
                                    _localctx = new IsRekenExprContext(new Value_expressieContext(_parentctx, _parentState));
                                    ((IsRekenExprContext) _localctx).leftExpr = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_value_expressie);
                                    setState(249);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(250);
                                    ((IsRekenExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSIS) | (1L << MINIS) | (1L << KEERIS) | (1L << GEDEELDDOORIS))) != 0))) {
                                        ((IsRekenExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(251);
                                    ((IsRekenExprContext) _localctx).rightExpr = value_expressie(4);
                                }
                                break;
                                case 4: {
                                    _localctx = new MinminPlusPlusExprContext(new Value_expressieContext(_parentctx, _parentState));
                                    ((MinminPlusPlusExprContext) _localctx).leftExpr = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_value_expressie);
                                    setState(252);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(253);
                                    ((MinminPlusPlusExprContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == T__11 || _la == T__12)) {
                                        ((MinminPlusPlusExprContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                }
                                break;
                            }
                        }
                    }
                    setState(258);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 18, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final AtomContext atom() throws RecognitionException {
        AtomContext _localctx = new AtomContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_atom);
        try {
            setState(271);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case HAAKOPEN:
                    _localctx = new AtomexpressieContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(259);
                    match(HAAKOPEN);
                    setState(262);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                        case 1: {
                            setState(260);
                            expressie(0);
                        }
                        break;
                        case 2: {
                            setState(261);
                            value_expressie(0);
                        }
                        break;
                    }
                    setState(264);
                    match(HAAKSLUIT);
                }
                break;
                case INT:
                    _localctx = new AtomIntContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(266);
                    match(INT);
                }
                break;
                case FLOAT:
                    _localctx = new AtomFloatContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(267);
                    match(FLOAT);
                }
                break;
                case BOOLEAN:
                    _localctx = new AtomBooleanContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(268);
                    match(BOOLEAN);
                }
                break;
                case ID:
                    _localctx = new AtomIdContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(269);
                    match(ID);
                }
                break;
                case STRING:
                    _localctx = new AtomStringContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(270);
                    match(STRING);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 21:
                return expressie_sempred((ExpressieContext) _localctx, predIndex);
            case 22:
                return value_expressie_sempred((Value_expressieContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expressie_sempred(ExpressieContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 5);
            case 1:
                return precpred(_ctx, 4);
            case 2:
                return precpred(_ctx, 3);
            case 3:
                return precpred(_ctx, 2);
        }
        return true;
    }

    private boolean value_expressie_sempred(Value_expressieContext _localctx, int predIndex) {
        switch (predIndex) {
            case 4:
                return precpred(_ctx, 6);
            case 5:
                return precpred(_ctx, 4);
            case 6:
                return precpred(_ctx, 3);
            case 7:
                return precpred(_ctx, 2);
        }
        return true;
    }

    public static class ParseContext extends ParserRuleContext {
        public ParseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BlokContext blok() {
            return getRuleContext(BlokContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(DutchJavaParser.EOF, 0);
        }

        public List<MethodeUITVOERINGContext> methodeUITVOERING() {
            return getRuleContexts(MethodeUITVOERINGContext.class);
        }

        public MethodeUITVOERINGContext methodeUITVOERING(int i) {
            return getRuleContext(MethodeUITVOERINGContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parse;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterParse(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitParse(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor) return ((DutchJavaVisitor<? extends T>) visitor).visitParse(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BlokContext extends ParserRuleContext {
        public BlokContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_blok;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterBlok(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitBlok(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor) return ((DutchJavaVisitor<? extends T>) visitor).visitBlok(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StatementContext extends ParserRuleContext {
        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Read_statementContext read_statement() {
            return getRuleContext(Read_statementContext.class, 0);
        }

        public DeclareringContext declarering() {
            return getRuleContext(DeclareringContext.class, 0);
        }

        public Print_statementContext print_statement() {
            return getRuleContext(Print_statementContext.class, 0);
        }

        public Als_statementContext als_statement() {
            return getRuleContext(Als_statementContext.class, 0);
        }

        public Voor_statementContext voor_statement() {
            return getRuleContext(Voor_statementContext.class, 0);
        }

        public Zolang_statementContext zolang_statement() {
            return getRuleContext(Zolang_statementContext.class, 0);
        }

        public MethodeAANROEPContext methodeAANROEP() {
            return getRuleContext(MethodeAANROEPContext.class, 0);
        }

        public ToekenningContext toekenning() {
            return getRuleContext(ToekenningContext.class, 0);
        }

        public ToekenningWithMethodContext toekenningWithMethod() {
            return getRuleContext(ToekenningWithMethodContext.class, 0);
        }

        public VeranderingContext verandering() {
            return getRuleContext(VeranderingContext.class, 0);
        }

        public VeranderingWithMethodContext veranderingWithMethod() {
            return getRuleContext(VeranderingWithMethodContext.class, 0);
        }

        public Value_expressieContext value_expressie() {
            return getRuleContext(Value_expressieContext.class, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Read_statementContext extends ParserRuleContext {
        public Read_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public TerminalNode DATATYPE() {
            return getToken(DutchJavaParser.DATATYPE, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_read_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterRead_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitRead_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitRead_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Print_statementContext extends ParserRuleContext {
        public Print_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Print_statementContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_print_statement;
        }

        public void copyFrom(Print_statementContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SchrijfStringContext extends Print_statementContext {
        public SchrijfStringContext(Print_statementContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode STRING() {
            return getToken(DutchJavaParser.STRING, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterSchrijfString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitSchrijfString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitSchrijfString(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SchrijfExprContext extends Print_statementContext {
        public SchrijfExprContext(Print_statementContext ctx) {
            copyFrom(ctx);
        }

        public ExpressieContext expressie() {
            return getRuleContext(ExpressieContext.class, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterSchrijfExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitSchrijfExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitSchrijfExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SchrijfValExprContext extends Print_statementContext {
        public SchrijfValExprContext(Print_statementContext ctx) {
            copyFrom(ctx);
        }

        public Value_expressieContext value_expressie() {
            return getRuleContext(Value_expressieContext.class, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterSchrijfValExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitSchrijfValExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitSchrijfValExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SchrijfIdContext extends Print_statementContext {
        public SchrijfIdContext(Print_statementContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterSchrijfId(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitSchrijfId(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitSchrijfId(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Als_statementContext extends ParserRuleContext {
        public Conditie_blockContext cond_block;

        public Als_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<Conditie_blockContext> conditie_block() {
            return getRuleContexts(Conditie_blockContext.class);
        }

        public Conditie_blockContext conditie_block(int i) {
            return getRuleContext(Conditie_blockContext.class, i);
        }

        public Stat_blokContext stat_blok() {
            return getRuleContext(Stat_blokContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_als_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAls_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAls_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitAls_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Zolang_statementContext extends ParserRuleContext {
        public Zolang_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressieContext expressie() {
            return getRuleContext(ExpressieContext.class, 0);
        }

        public Stat_blokContext stat_blok() {
            return getRuleContext(Stat_blokContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_zolang_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterZolang_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitZolang_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitZolang_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Voor_statementContext extends ParserRuleContext {
        public ToekenningContext toek;
        public VeranderingContext verand;

        public Voor_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Stat_blokContext stat_blok() {
            return getRuleContext(Stat_blokContext.class, 0);
        }

        public TerminalNode HAAKOPEN() {
            return getToken(DutchJavaParser.HAAKOPEN, 0);
        }

        public ExpressieContext expressie() {
            return getRuleContext(ExpressieContext.class, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        public Value_expressieContext value_expressie() {
            return getRuleContext(Value_expressieContext.class, 0);
        }

        public TerminalNode HAAKSLUIT() {
            return getToken(DutchJavaParser.HAAKSLUIT, 0);
        }

        public ToekenningContext toekenning() {
            return getRuleContext(ToekenningContext.class, 0);
        }

        public VeranderingContext verandering() {
            return getRuleContext(VeranderingContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_voor_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterVoor_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitVoor_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitVoor_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DeclareringContext extends ParserRuleContext {
        public DeclareringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DATATYPE() {
            return getToken(DutchJavaParser.DATATYPE, 0);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_declarering;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterDeclarering(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitDeclarering(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitDeclarering(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ToekenningContext extends ParserRuleContext {
        public Value_expressieContext expr;

        public ToekenningContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DATATYPE() {
            return getToken(DutchJavaParser.DATATYPE, 0);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public TerminalNode KENTOE() {
            return getToken(DutchJavaParser.KENTOE, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        public Value_expressieContext value_expressie() {
            return getRuleContext(Value_expressieContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_toekenning;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterToekenning(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitToekenning(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitToekenning(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ToekenningWithMethodContext extends ParserRuleContext {
        public MethodeAANROEPContext expr;

        public ToekenningWithMethodContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DATATYPE() {
            return getToken(DutchJavaParser.DATATYPE, 0);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public TerminalNode KENTOE() {
            return getToken(DutchJavaParser.KENTOE, 0);
        }

        public MethodeAANROEPContext methodeAANROEP() {
            return getRuleContext(MethodeAANROEPContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_toekenningWithMethod;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterToekenningWithMethod(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitToekenningWithMethod(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitToekenningWithMethod(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VeranderingContext extends ParserRuleContext {
        public Token id;
        public Value_expressieContext expr;

        public VeranderingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode KENTOE() {
            return getToken(DutchJavaParser.KENTOE, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public Value_expressieContext value_expressie() {
            return getRuleContext(Value_expressieContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_verandering;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterVerandering(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitVerandering(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitVerandering(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VeranderingWithMethodContext extends ParserRuleContext {
        public Token id;
        public MethodeAANROEPContext expr;

        public VeranderingWithMethodContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode KENTOE() {
            return getToken(DutchJavaParser.KENTOE, 0);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public MethodeAANROEPContext methodeAANROEP() {
            return getRuleContext(MethodeAANROEPContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_veranderingWithMethod;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterVeranderingWithMethod(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitVeranderingWithMethod(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitVeranderingWithMethod(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Conditie_blockContext extends ParserRuleContext {
        public ExpressieContext expr;
        public Stat_blokContext sBlock;

        public Conditie_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressieContext expressie() {
            return getRuleContext(ExpressieContext.class, 0);
        }

        public Stat_blokContext stat_blok() {
            return getRuleContext(Stat_blokContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditie_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterConditie_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitConditie_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitConditie_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Stat_blokContext extends ParserRuleContext {
        public Stat_blokContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Stat_blokContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_stat_blok;
        }

        public void copyFrom(Stat_blokContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class StatementBlokContext extends Stat_blokContext {
        public StatementBlokContext(Stat_blokContext ctx) {
            copyFrom(ctx);
        }

        public BlokContext blok() {
            return getRuleContext(BlokContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterStatementBlok(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitStatementBlok(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitStatementBlok(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Func_stat_blokContext extends ParserRuleContext {
        public Func_stat_blokContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BlokContext blok() {
            return getRuleContext(BlokContext.class, 0);
        }

        public TerminalNode GEEFTERUG() {
            return getToken(DutchJavaParser.GEEFTERUG, 0);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_func_stat_blok;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterFunc_stat_blok(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitFunc_stat_blok(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitFunc_stat_blok(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MethodeAANROEPContext extends ParserRuleContext {
        public MethodeAANROEPContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public TerminalNode HAAKOPEN() {
            return getToken(DutchJavaParser.HAAKOPEN, 0);
        }

        public TerminalNode HAAKSLUIT() {
            return getToken(DutchJavaParser.HAAKSLUIT, 0);
        }

        public TerminalNode SEMICOL() {
            return getToken(DutchJavaParser.SEMICOL, 0);
        }

        public ArgumentContext argument() {
            return getRuleContext(ArgumentContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_methodeAANROEP;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterMethodeAANROEP(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitMethodeAANROEP(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitMethodeAANROEP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MethodeUITVOERINGContext extends ParserRuleContext {
        public MethodeUITVOERINGContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DATATYPE() {
            return getToken(DutchJavaParser.DATATYPE, 0);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        public TerminalNode HAAKOPEN() {
            return getToken(DutchJavaParser.HAAKOPEN, 0);
        }

        public TerminalNode HAAKSLUIT() {
            return getToken(DutchJavaParser.HAAKSLUIT, 0);
        }

        public Func_stat_blokContext func_stat_blok() {
            return getRuleContext(Func_stat_blokContext.class, 0);
        }

        public Argument_uitvoeringContext argument_uitvoering() {
            return getRuleContext(Argument_uitvoeringContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_methodeUITVOERING;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterMethodeUITVOERING(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitMethodeUITVOERING(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitMethodeUITVOERING(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ArgumentContext extends ParserRuleContext {
        public ArgumentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<Argument_typeContext> argument_type() {
            return getRuleContexts(Argument_typeContext.class);
        }

        public Argument_typeContext argument_type(int i) {
            return getRuleContext(Argument_typeContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_argument;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterArgument(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitArgument(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitArgument(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Argument_uitvoeringContext extends ParserRuleContext {
        public Argument_uitvoeringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> DATATYPE() {
            return getTokens(DutchJavaParser.DATATYPE);
        }

        public TerminalNode DATATYPE(int i) {
            return getToken(DutchJavaParser.DATATYPE, i);
        }

        public List<Argument_typeContext> argument_type() {
            return getRuleContexts(Argument_typeContext.class);
        }

        public Argument_typeContext argument_type(int i) {
            return getRuleContext(Argument_typeContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_argument_uitvoering;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterArgument_uitvoering(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitArgument_uitvoering(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitArgument_uitvoering(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Argument_typeContext extends ParserRuleContext {
        public Argument_typeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STRING() {
            return getToken(DutchJavaParser.STRING, 0);
        }

        public TerminalNode INT() {
            return getToken(DutchJavaParser.INT, 0);
        }

        public TerminalNode FLOAT() {
            return getToken(DutchJavaParser.FLOAT, 0);
        }

        public TerminalNode BOOLEAN() {
            return getToken(DutchJavaParser.BOOLEAN, 0);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_argument_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterArgument_type(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitArgument_type(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitArgument_type(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressieContext extends ParserRuleContext {
        public ExpressieContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressieContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_expressie;
        }

        public void copyFrom(ExpressieContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class VergelijkingExprContext extends ExpressieContext {
        public ExpressieContext leftExpr;
        public Token op;
        public ExpressieContext rightExpr;

        public VergelijkingExprContext(ExpressieContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressieContext> expressie() {
            return getRuleContexts(ExpressieContext.class);
        }

        public ExpressieContext expressie(int i) {
            return getRuleContext(ExpressieContext.class, i);
        }

        public TerminalNode KLEINERGELIJK() {
            return getToken(DutchJavaParser.KLEINERGELIJK, 0);
        }

        public TerminalNode GROTERGELIJK() {
            return getToken(DutchJavaParser.GROTERGELIJK, 0);
        }

        public TerminalNode KLEINERDAN() {
            return getToken(DutchJavaParser.KLEINERDAN, 0);
        }

        public TerminalNode GROTERDAN() {
            return getToken(DutchJavaParser.GROTERDAN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterVergelijkingExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitVergelijkingExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitVergelijkingExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class OfofExprContext extends ExpressieContext {
        public ExpressieContext leftExpr;
        public ExpressieContext rightExpr;

        public OfofExprContext(ExpressieContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode OF() {
            return getToken(DutchJavaParser.OF, 0);
        }

        public List<ExpressieContext> expressie() {
            return getRuleContexts(ExpressieContext.class);
        }

        public ExpressieContext expressie(int i) {
            return getRuleContext(ExpressieContext.class, i);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterOfofExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitOfofExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitOfofExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class GelijkheidExprContext extends ExpressieContext {
        public ExpressieContext leftExpr;
        public Token op;
        public ExpressieContext rightExpr;

        public GelijkheidExprContext(ExpressieContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressieContext> expressie() {
            return getRuleContexts(ExpressieContext.class);
        }

        public ExpressieContext expressie(int i) {
            return getRuleContext(ExpressieContext.class, i);
        }

        public TerminalNode GELIJKAAN() {
            return getToken(DutchJavaParser.GELIJKAAN, 0);
        }

        public TerminalNode NIETGELIJKAAN() {
            return getToken(DutchJavaParser.NIETGELIJKAAN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterGelijkheidExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitGelijkheidExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitGelijkheidExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EnenExprContext extends ExpressieContext {
        public ExpressieContext leftExpr;
        public ExpressieContext rightExpr;

        public EnenExprContext(ExpressieContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode EN() {
            return getToken(DutchJavaParser.EN, 0);
        }

        public List<ExpressieContext> expressie() {
            return getRuleContexts(ExpressieContext.class);
        }

        public ExpressieContext expressie(int i) {
            return getRuleContext(ExpressieContext.class, i);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterEnenExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitEnenExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitEnenExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AtomCondExprContext extends ExpressieContext {
        public AtomCondExprContext(ExpressieContext ctx) {
            copyFrom(ctx);
        }

        public AtomContext atom() {
            return getRuleContext(AtomContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAtomCondExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAtomCondExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitAtomCondExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Value_expressieContext extends ParserRuleContext {
        public Value_expressieContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Value_expressieContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_value_expressie;
        }

        public void copyFrom(Value_expressieContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class KeerGddModExprContext extends Value_expressieContext {
        public Value_expressieContext leftExpr;
        public Token op;
        public Value_expressieContext rightExpr;

        public KeerGddModExprContext(Value_expressieContext ctx) {
            copyFrom(ctx);
        }

        public List<Value_expressieContext> value_expressie() {
            return getRuleContexts(Value_expressieContext.class);
        }

        public Value_expressieContext value_expressie(int i) {
            return getRuleContext(Value_expressieContext.class, i);
        }

        public TerminalNode KEER() {
            return getToken(DutchJavaParser.KEER, 0);
        }

        public TerminalNode GEDEELDDOOR() {
            return getToken(DutchJavaParser.GEDEELDDOOR, 0);
        }

        public TerminalNode MODULO() {
            return getToken(DutchJavaParser.MODULO, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterKeerGddModExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitKeerGddModExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitKeerGddModExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MinminPlusPlusExprContext extends Value_expressieContext {
        public Value_expressieContext leftExpr;
        public Token op;

        public MinminPlusPlusExprContext(Value_expressieContext ctx) {
            copyFrom(ctx);
        }

        public Value_expressieContext value_expressie() {
            return getRuleContext(Value_expressieContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterMinminPlusPlusExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitMinminPlusPlusExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitMinminPlusPlusExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IsRekenExprContext extends Value_expressieContext {
        public Value_expressieContext leftExpr;
        public Token op;
        public Value_expressieContext rightExpr;

        public IsRekenExprContext(Value_expressieContext ctx) {
            copyFrom(ctx);
        }

        public List<Value_expressieContext> value_expressie() {
            return getRuleContexts(Value_expressieContext.class);
        }

        public Value_expressieContext value_expressie(int i) {
            return getRuleContext(Value_expressieContext.class, i);
        }

        public TerminalNode KEERIS() {
            return getToken(DutchJavaParser.KEERIS, 0);
        }

        public TerminalNode GEDEELDDOORIS() {
            return getToken(DutchJavaParser.GEDEELDDOORIS, 0);
        }

        public TerminalNode MINIS() {
            return getToken(DutchJavaParser.MINIS, 0);
        }

        public TerminalNode PLUSIS() {
            return getToken(DutchJavaParser.PLUSIS, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterIsRekenExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitIsRekenExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitIsRekenExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MinusExprContext extends Value_expressieContext {
        public MinusExprContext(Value_expressieContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MINUS() {
            return getToken(DutchJavaParser.MINUS, 0);
        }

        public Value_expressieContext value_expressie() {
            return getRuleContext(Value_expressieContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterMinusExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitMinusExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitMinusExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PlusMinExprContext extends Value_expressieContext {
        public Value_expressieContext leftExpr;
        public Token op;
        public Value_expressieContext rightExpr;

        public PlusMinExprContext(Value_expressieContext ctx) {
            copyFrom(ctx);
        }

        public List<Value_expressieContext> value_expressie() {
            return getRuleContexts(Value_expressieContext.class);
        }

        public Value_expressieContext value_expressie(int i) {
            return getRuleContext(Value_expressieContext.class, i);
        }

        public TerminalNode PLUS() {
            return getToken(DutchJavaParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(DutchJavaParser.MINUS, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterPlusMinExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitPlusMinExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitPlusMinExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AtomValueExprContext extends Value_expressieContext {
        public AtomValueExprContext(Value_expressieContext ctx) {
            copyFrom(ctx);
        }

        public AtomContext atom() {
            return getRuleContext(AtomContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAtomValueExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAtomValueExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitAtomValueExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AtomContext extends ParserRuleContext {
        public AtomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public AtomContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_atom;
        }

        public void copyFrom(AtomContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class AtomIdContext extends AtomContext {
        public AtomIdContext(AtomContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ID() {
            return getToken(DutchJavaParser.ID, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAtomId(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAtomId(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor) return ((DutchJavaVisitor<? extends T>) visitor).visitAtomId(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AtomIntContext extends AtomContext {
        public AtomIntContext(AtomContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode INT() {
            return getToken(DutchJavaParser.INT, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAtomInt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAtomInt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitAtomInt(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AtomBooleanContext extends AtomContext {
        public AtomBooleanContext(AtomContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode BOOLEAN() {
            return getToken(DutchJavaParser.BOOLEAN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAtomBoolean(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAtomBoolean(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitAtomBoolean(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AtomStringContext extends AtomContext {
        public AtomStringContext(AtomContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode STRING() {
            return getToken(DutchJavaParser.STRING, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAtomString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAtomString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitAtomString(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AtomexpressieContext extends AtomContext {
        public AtomexpressieContext(AtomContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode HAAKOPEN() {
            return getToken(DutchJavaParser.HAAKOPEN, 0);
        }

        public TerminalNode HAAKSLUIT() {
            return getToken(DutchJavaParser.HAAKSLUIT, 0);
        }

        public ExpressieContext expressie() {
            return getRuleContext(ExpressieContext.class, 0);
        }

        public Value_expressieContext value_expressie() {
            return getRuleContext(Value_expressieContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAtomexpressie(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAtomexpressie(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitAtomexpressie(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AtomFloatContext extends AtomContext {
        public AtomFloatContext(AtomContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode FLOAT() {
            return getToken(DutchJavaParser.FLOAT, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).enterAtomFloat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DutchJavaListener) ((DutchJavaListener) listener).exitAtomFloat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof DutchJavaVisitor)
                return ((DutchJavaVisitor<? extends T>) visitor).visitAtomFloat(this);
            else return visitor.visitChildren(this);
        }
    }
}