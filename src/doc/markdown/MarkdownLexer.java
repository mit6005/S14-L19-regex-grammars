// Generated from Markdown.g4 by ANTLR 4.0

package doc.markdown;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MarkdownLexer extends Lexer {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        TEXT=1, UNDERLINE=2;
    public static String[] modeNames = {
        "DEFAULT_MODE"
    };

    public static final String[] tokenNames = {
        "<INVALID>",
        "TEXT", "'_'"
    };
    public static final String[] ruleNames = {
        "TEXT", "UNDERLINE"
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


    public MarkdownLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }

    @Override
    public String getGrammarFileName() { return "Markdown.g4"; }

    @Override
    public String[] getTokenNames() { return tokenNames; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String[] getModeNames() { return modeNames; }

    @Override
    public ATN getATN() { return _ATN; }

    public static final String _serializedATN =
        "\2\4\4\16\b\1\4\2\t\2\4\3\t\3\3\2\6\2\t\n\2\r\2\16\2\n\3\3\3\3\2\4\3\3"+
        "\1\5\4\1\3\2\3\3aa\16\2\3\3\2\2\2\2\5\3\2\2\2\3\b\3\2\2\2\5\f\3\2\2\2"+
        "\7\t\n\2\2\2\b\7\3\2\2\2\t\n\3\2\2\2\n\b\3\2\2\2\n\13\3\2\2\2\13\4\3\2"+
        "\2\2\f\r\7a\2\2\r\6\3\2\2\2\4\2\n";
    public static final ATN _ATN =
        ATNSimulator.deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    }
}