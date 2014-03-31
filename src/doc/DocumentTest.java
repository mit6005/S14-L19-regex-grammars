package doc;

import org.junit.Assert;
import org.junit.Test;

import doc.Doc.CantRepresentException;
import doc.Doc.Document;

public class DocumentTest {

    @Test
    public void testParseHtml() {
        verifyHtmlParseAndUnparse("This is <i>some</i> doc", true);
        verifyHtmlParseAndUnparse("no italics here", false);
        verifyHtmlParseAndUnparse("<i></i>", true);
        verifyHtmlParseAndUnparse("<i>Here is <i></i> nested italics</i>", true);
    }
    
    private void verifyHtmlParseAndUnparse(String html, boolean hasItalics) {
        Document doc = Doc.parseHtml(html);
        Assert.assertEquals(hasItalics, doc.containsItalic());
        try {
            String outputHtml = doc.toHtml();
            Assert.assertEquals(html, outputHtml);        
        } catch (CantRepresentException e) {
            Assert.fail();
        }
    }

    @Test
    public void testParseMarkdown() {
        verifyMarkdownParseAndUnparse("This is _some_ markdown", true);
        verifyMarkdownParseAndUnparse("No italic in here", false);
        verifyMarkdownParseAndUnparse("_ _", true);
    }

    private void verifyMarkdownParseAndUnparse(String markdown, boolean hasItalics) {
        Document doc = Doc.parseMarkdown(markdown);
        Assert.assertEquals(hasItalics, doc.containsItalic());
        try {
            String outputMarkdown = doc.toMarkdown();
            Assert.assertEquals(markdown, outputMarkdown);        
        } catch (CantRepresentException e) {
            Assert.fail();
        }
    }


}
