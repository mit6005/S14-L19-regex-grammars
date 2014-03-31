// Generated from Html.g4 by ANTLR 4.0

package doc.html;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HtmlLexer extends Lexer {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        START_ITALIC=1, END_ITALIC=2, TEXT=3;
    public static String[] modeNames = {
        "DEFAULT_MODE"
    };

    public static final String[] tokenNames = {
        "<INVALID>",
        "'<i>'", "'</i>'", "TEXT"
    };
    public static final String[] ruleNames = {
        "START_ITALIC", "END_ITALIC", "TEXT"
    };


        // This method makes the lexer or parser stop running if it encounters
        // invalid input and throw a RuntimeException.
        public void reportErrorsAsExceptions() {
            //removeErrorListeners();
            
            addErrorListener(new ExceptionThrowingErrorListener());
        }
        
        private static class ExceptionThrowingErrorListener extends BaseErrorListener {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                    Object offendingSymbol, int line, int charPositionInLine,
                    String msg, RecognitionException e) {
                throw new RuntimeException(msg);
            }
        }


    public HtmlLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }

    @Override
    public String getGrammarFileName() { return "Html.g4"; }

    @Override
    public String[] getTokenNames() { return tokenNames; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String[] getModeNames() { return modeNames; }

    @Override
    public ATN getATN() { return _ATN; }

    public static final String _serializedATN =
        "\2\4\5\27\b\1\4\2\t\2\4\3\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
        "\3\3\3\4\6\4\24\n\4\r\4\16\4\25\2\5\3\3\1\5\4\1\7\5\1\3\2\3\4>>@@\27\2"+
        "\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\3\t\3\2\2\2\5\r\3\2\2\2\7\23\3\2\2"+
        "\2\t\n\7>\2\2\n\13\7k\2\2\13\f\7@\2\2\f\4\3\2\2\2\r\16\7>\2\2\16\17\7"+
        "\61\2\2\17\20\7k\2\2\20\21\7@\2\2\21\6\3\2\2\2\22\24\n\2\2\2\23\22\3\2"+
        "\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\b\3\2\2\2\4\2\25";
    public static final ATN _ATN =
        ATNSimulator.deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    }
}