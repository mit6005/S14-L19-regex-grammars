// Generated from Board.g4 by ANTLR 4.0

package minesweeper.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardParser extends Parser {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        VAL=1, INT=2, SPACE=3, NEWLINE=4;
    public static final String[] tokenNames = {
        "<INVALID>", "VAL", "INT", "' '", "NEWLINE"
    };
    public static final int
        RULE_file = 0, RULE_board = 1, RULE_line = 2, RULE_x = 3, RULE_y = 4;
    public static final String[] ruleNames = {
        "file", "board", "line", "x", "y"
    };

    @Override
    public String getGrammarFileName() { return "Board.g4"; }

    @Override
    public String[] getTokenNames() { return tokenNames; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public ATN getATN() { return _ATN; }


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

    public BoardParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }
    public static class FileContext extends ParserRuleContext {
        public LineContext line(int i) {
            return getRuleContext(LineContext.class,i);
        }
        public List<LineContext> line() {
            return getRuleContexts(LineContext.class);
        }
        public BoardContext board() {
            return getRuleContext(BoardContext.class,0);
        }
        public FileContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_file; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).enterFile(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).exitFile(this);
        }
    }

    public final FileContext file() throws RecognitionException {
        FileContext _localctx = new FileContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_file);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(10); board();
            setState(12); 
            _errHandler.sync(this);
            _la = _input.LA(1);
            do {
                {
                {
                setState(11); line();
                }
                }
                setState(14); 
                _errHandler.sync(this);
                _la = _input.LA(1);
            } while ( _la==VAL );
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

    public static class BoardContext extends ParserRuleContext {
        public TerminalNode NEWLINE() { return getToken(BoardParser.NEWLINE, 0); }
        public TerminalNode SPACE() { return getToken(BoardParser.SPACE, 0); }
        public YContext y() {
            return getRuleContext(YContext.class,0);
        }
        public XContext x() {
            return getRuleContext(XContext.class,0);
        }
        public BoardContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_board; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).enterBoard(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).exitBoard(this);
        }
    }

    public final BoardContext board() throws RecognitionException {
        BoardContext _localctx = new BoardContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_board);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(16); x();
            setState(17); match(SPACE);
            setState(18); y();
            setState(19); match(NEWLINE);
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

    public static class LineContext extends ParserRuleContext {
        public TerminalNode SPACE(int i) {
            return getToken(BoardParser.SPACE, i);
        }
        public List<TerminalNode> VAL() { return getTokens(BoardParser.VAL); }
        public TerminalNode NEWLINE() { return getToken(BoardParser.NEWLINE, 0); }
        public TerminalNode VAL(int i) {
            return getToken(BoardParser.VAL, i);
        }
        public List<TerminalNode> SPACE() { return getTokens(BoardParser.SPACE); }
        public LineContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_line; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).enterLine(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).exitLine(this);
        }
    }

    public final LineContext line() throws RecognitionException {
        LineContext _localctx = new LineContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_line);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
            setState(25);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input,1,_ctx);
            while ( _alt!=2 && _alt!=-1 ) {
                if ( _alt==1 ) {
                    {
                    {
                    setState(21); match(VAL);
                    setState(22); match(SPACE);
                    }
                    } 
                }
                setState(27);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input,1,_ctx);
            }
            setState(28); match(VAL);
            setState(29); match(NEWLINE);
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

    public static class XContext extends ParserRuleContext {
        public TerminalNode INT() { return getToken(BoardParser.INT, 0); }
        public XContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_x; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).enterX(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).exitX(this);
        }
    }

    public final XContext x() throws RecognitionException {
        XContext _localctx = new XContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_x);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(31); match(INT);
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

    public static class YContext extends ParserRuleContext {
        public TerminalNode INT() { return getToken(BoardParser.INT, 0); }
        public YContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_y; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).enterY(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof BoardListener ) ((BoardListener)listener).exitY(this);
        }
    }

    public final YContext y() throws RecognitionException {
        YContext _localctx = new YContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_y);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(33); match(INT);
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
        "\2\3\6&\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\6\2\17\n\2\r\2"+
        "\16\2\20\3\3\3\3\3\3\3\3\3\3\3\4\3\4\7\4\32\n\4\f\4\16\4\35\13\4\3\4\3"+
        "\4\3\4\3\5\3\5\3\6\3\6\3\6\2\7\2\4\6\b\n\2\2\"\2\f\3\2\2\2\4\22\3\2\2"+
        "\2\6\33\3\2\2\2\b!\3\2\2\2\n#\3\2\2\2\f\16\5\4\3\2\r\17\5\6\4\2\16\r\3"+
        "\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\3\3\2\2\2\22\23\5"+
        "\b\5\2\23\24\7\5\2\2\24\25\5\n\6\2\25\26\7\6\2\2\26\5\3\2\2\2\27\30\7"+
        "\3\2\2\30\32\7\5\2\2\31\27\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3"+
        "\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\37\7\3\2\2\37 \7\6\2\2 \7\3\2\2"+
        "\2!\"\7\4\2\2\"\t\3\2\2\2#$\7\4\2\2$\13\3\2\2\2\4\20\33";
    public static final ATN _ATN =
        ATNSimulator.deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    }
}