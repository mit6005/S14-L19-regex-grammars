// Generated from Html.g4 by ANTLR 4.0

package doc.html;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HtmlParser extends Parser {
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        START_ITALIC=1, END_ITALIC=2, TEXT=3;
    public static final String[] tokenNames = {
        "<INVALID>", "'<i>'", "'</i>'", "TEXT"
    };
    public static final int
        RULE_root = 0, RULE_html = 1, RULE_normal = 2, RULE_italic = 3;
    public static final String[] ruleNames = {
        "root", "html", "normal", "italic"
    };

    @Override
    public String getGrammarFileName() { return "Html.g4"; }

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

    public HtmlParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }
    public static class RootContext extends ParserRuleContext {
        public TerminalNode EOF() { return getToken(HtmlParser.EOF, 0); }
        public HtmlContext html() {
            return getRuleContext(HtmlContext.class,0);
        }
        public RootContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_root; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof HtmlListener ) ((HtmlListener)listener).enterRoot(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof HtmlListener ) ((HtmlListener)listener).exitRoot(this);
        }
    }

    public final RootContext root() throws RecognitionException {
        RootContext _localctx = new RootContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_root);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(8); html();
            setState(9); match(EOF);
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

    public static class HtmlContext extends ParserRuleContext {
        public NormalContext normal(int i) {
            return getRuleContext(NormalContext.class,i);
        }
        public List<NormalContext> normal() {
            return getRuleContexts(NormalContext.class);
        }
        public ItalicContext italic(int i) {
            return getRuleContext(ItalicContext.class,i);
        }
        public List<ItalicContext> italic() {
            return getRuleContexts(ItalicContext.class);
        }
        public HtmlContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_html; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof HtmlListener ) ((HtmlListener)listener).enterHtml(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof HtmlListener ) ((HtmlListener)listener).exitHtml(this);
        }
    }

    public final HtmlContext html() throws RecognitionException {
        HtmlContext _localctx = new HtmlContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_html);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(15);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la==START_ITALIC || _la==TEXT) {
                {
                setState(13);
                switch (_input.LA(1)) {
                case TEXT:
                    {
                    setState(11); normal();
                    }
                    break;
                case START_ITALIC:
                    {
                    setState(12); italic();
                    }
                    break;
                default:
                    throw new NoViableAltException(this);
                }
                }
                setState(17);
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

    public static class NormalContext extends ParserRuleContext {
        public TerminalNode TEXT() { return getToken(HtmlParser.TEXT, 0); }
        public NormalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_normal; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof HtmlListener ) ((HtmlListener)listener).enterNormal(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof HtmlListener ) ((HtmlListener)listener).exitNormal(this);
        }
    }

    public final NormalContext normal() throws RecognitionException {
        NormalContext _localctx = new NormalContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_normal);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(18); match(TEXT);
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

    public static class ItalicContext extends ParserRuleContext {
        public TerminalNode START_ITALIC() { return getToken(HtmlParser.START_ITALIC, 0); }
        public TerminalNode END_ITALIC() { return getToken(HtmlParser.END_ITALIC, 0); }
        public HtmlContext html() {
            return getRuleContext(HtmlContext.class,0);
        }
        public ItalicContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_italic; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof HtmlListener ) ((HtmlListener)listener).enterItalic(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof HtmlListener ) ((HtmlListener)listener).exitItalic(this);
        }
    }

    public final ItalicContext italic() throws RecognitionException {
        ItalicContext _localctx = new ItalicContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_italic);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(20); match(START_ITALIC);
            setState(21); html();
            setState(22); match(END_ITALIC);
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
        "\2\3\5\33\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\7\3\20\n"+
        "\3\f\3\16\3\23\13\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\2\6\2\4\6\b\2\2\30\2\n"+
        "\3\2\2\2\4\21\3\2\2\2\6\24\3\2\2\2\b\26\3\2\2\2\n\13\5\4\3\2\13\f\7\1"+
        "\2\2\f\3\3\2\2\2\r\20\5\6\4\2\16\20\5\b\5\2\17\r\3\2\2\2\17\16\3\2\2\2"+
        "\20\23\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\5\3\2\2\2\23\21\3\2\2\2"+
        "\24\25\7\5\2\2\25\7\3\2\2\2\26\27\7\3\2\2\27\30\5\4\3\2\30\31\7\4\2\2"+
        "\31\t\3\2\2\2\4\17\21";
    public static final ATN _ATN =
        ATNSimulator.deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    }
}