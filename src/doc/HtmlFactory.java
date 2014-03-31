package doc;

import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import doc.Doc.Document;
import doc.Doc.Italic;
import doc.Doc.Sequence;
import doc.Doc.Text;
import doc.html.HtmlBaseListener;
import doc.html.HtmlLexer;
import doc.html.HtmlParser;
import doc.html.HtmlParser.HtmlContext;
import doc.html.HtmlParser.ItalicContext;
import doc.html.HtmlParser.NormalContext;
import doc.html.HtmlParser.RootContext;

public class HtmlFactory {

    public static void main(String[] args) {
        parse("This is my <i>example of italics</i>");
    }
    
    /**
     * @param html Must contain a well-formed HTML string 
     *             with text and <i> elements.  
     *             No other HTML syntax is valid.
     * @return Document representing the HTML
     */
    public static Document parse(String html) {
        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(html);
        HtmlLexer lexer = new HtmlLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Feed the tokens into the parser.
        HtmlParser parser = new HtmlParser(tokens);
        parser.reportErrorsAsExceptions();
        
        // Generate the parse tree using the starter rule.
        ParseTree tree = parser.root(); // "root" is the starter rule.
        
        // debugging option #1: print the tree to the console
        System.err.println(tree.toStringTree(parser));

        // debugging option #2: show the tree in a window
        ((RuleContext)tree).inspect(parser);

        // debugging option #3: walk the tree with a listener
        new ParseTreeWalker().walk(new HtmlListener_PrintEverything(), tree);
        
        // Finally, construct a Document value by walking over the parse tree.
        ParseTreeWalker walker = new ParseTreeWalker();
        HtmlListener_DocumentCreator listener = new HtmlListener_DocumentCreator();
        walker.walk(listener, tree);
        
        // return the Document value that the listener created
        return listener.getDocument();
    }
    
    private static class HtmlListener_DocumentCreator extends HtmlBaseListener {
        private Stack<Document> stack = new Stack<Document>();
        
        @Override
        public void exitNormal(NormalContext ctx) {
            TerminalNode token = ctx.TEXT();
            String text = token.getText();
            Document node = new Text(text);
            stack.push(node);
        }
        
        @Override
        public void exitItalic(ItalicContext ctx) {
            Document child = stack.pop();
            Document node = new Italic(child);
            stack.push(node);
        }
        
        @Override
        public void exitHtml(HtmlContext ctx) {
            Im.ImList<Document> list = Im.empty();
            int numChildren = ctx.getChildCount();
            for (int i = 0; i < numChildren; ++i) {
                list = list.cons(stack.pop());
            }
            Document node = new Sequence(list);
            stack.push(node);
        }
        
        @Override
        public void exitRoot(RootContext ctx) {
            // do nothing, because the top of the stack should have the node already in it
            assert stack.size() == 1;
        }
        
        public Document getDocument() {
            return stack.get(0);
        }
    }
    

    private static class HtmlListener_PrintEverything extends HtmlBaseListener {
        public void enterRoot(HtmlParser.RootContext ctx) { System.err.println("entering root"); }
        public void exitRoot(HtmlParser.RootContext ctx) { System.err.println("exiting root"); }

        public void enterNormal(HtmlParser.NormalContext ctx) { System.err.println("entering normal"); }
        public void exitNormal(HtmlParser.NormalContext ctx) { System.err.println("exiting normal"); }

        public void enterHtml(HtmlParser.HtmlContext ctx) { System.err.println("entering html"); }
        public void exitHtml(HtmlParser.HtmlContext ctx) { System.err.println("exiting html"); }

        public void enterItalic(HtmlParser.ItalicContext ctx) { System.err.println("entering italic"); }
        public void exitItalic(HtmlParser.ItalicContext ctx) { System.err.println("exiting italic"); }
    }
    
}
