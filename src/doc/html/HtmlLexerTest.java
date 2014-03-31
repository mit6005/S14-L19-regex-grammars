package doc.html;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

/**
 * This is the test suite for Lexer. You should expand this file with more
 * unit tests to make sure your Lexer works correctly.
 */
public class HtmlLexerTest {

    @Test
    public void testOneToken() {
        verifyLexer("This is <i>my lexer</i> now", new String[] {"This is ", "<i>", "my lexer", "</i>", " now"});
    }
    
    public void verifyLexer(String input, String[] expectedTokens) {
        CharStream stream = new ANTLRInputStream(input);
        HtmlLexer lexer = new HtmlLexer(stream);
        lexer.reportErrorsAsExceptions();
        List<? extends Token> actualTokens = lexer.getAllTokens();
        System.err.println(actualTokens);
        
        assertEquals(expectedTokens.length, actualTokens.size());
        
        for(int i = 0; i < actualTokens.size(); i++) {
             String actualToken = actualTokens.get(i).getText();
             String expectedToken = expectedTokens[i];
             assertEquals(actualToken, expectedToken);
        }
    }

    
}