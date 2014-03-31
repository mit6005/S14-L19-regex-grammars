// Generated from Board.g4 by ANTLR 4.0

package minesweeper.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardLexer extends Lexer {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        VAL=1, INT=2, SPACE=3, NEWLINE=4;
    public static String[] modeNames = {
        "DEFAULT_MODE"
    };

    public static final String[] tokenNames = {
        "<INVALID>",
        "VAL", "INT", "' '", "NEWLINE"
    };
    public static final String[] ruleNames = {
        "VAL", "INT", "SPACE", "NEWLINE"
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


    public BoardLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }

    @Override
    public String getGrammarFileName() { return "Board.g4"; }

    @Override
    public String[] getTokenNames() { return tokenNames; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String[] getModeNames() { return modeNames; }

    @Override
    public ATN getATN() { return _ATN; }

    public static final String _serializedATN =
        "\2\4\6\31\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\6\3\17\n\3\r"+
        "\3\16\3\20\3\4\3\4\3\5\5\5\26\n\5\3\5\3\5\2\6\3\3\1\5\4\1\7\5\1\t\6\1"+
        "\3\2\3\3\62;\32\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\3\13\3"+
        "\2\2\2\5\16\3\2\2\2\7\22\3\2\2\2\t\25\3\2\2\2\13\f\4\62\63\2\f\4\3\2\2"+
        "\2\r\17\t\2\2\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2"+
        "\21\6\3\2\2\2\22\23\7\"\2\2\23\b\3\2\2\2\24\26\7\17\2\2\25\24\3\2\2\2"+
        "\25\26\3\2\2\2\26\27\3\2\2\2\27\30\7\f\2\2\30\n\3\2\2\2\5\2\20\25";
    public static final ATN _ATN =
        ATNSimulator.deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    }
}