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
import doc.html.HtmlParser;
import doc.markdown.MarkdownBaseListener;
import doc.markdown.MarkdownLexer;
import doc.markdown.MarkdownParser;
import doc.markdown.MarkdownParser.ItalicContext;
import doc.markdown.MarkdownParser.MarkdownContext;
import doc.markdown.MarkdownParser.NormalContext;
import doc.markdown.MarkdownParser.RootContext;

public class MarkdownFactory {

    public static void main(String[] args) {
        parse("This is my _example of italics_");
    }
    
    /**
     * @param markdown Must contain a well-formed Markdown string 
     *                 with text and _ elements.  
     *                 No other Markdown syntax is valid.
     * @return Document representing the Markdown
     */
     public static Document parse(String markdown) {
        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(markdown);
        MarkdownLexer lexer = new MarkdownLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Feed the tokens into the parser.
        MarkdownParser parser = new MarkdownParser(tokens);
        parser.reportErrorsAsExceptions();
        
        // Generate the parse tree using the starter rule.
        ParseTree tree = parser.root(); // "root" is the starter rule.
       
        // debugging option #1: print the tree to the console
        System.err.println(tree.toStringTree(parser));

        // debugging option #2: show the tree in a window
        RuleContext rootContext = (RuleContext) tree;
        rootContext.inspect(parser);
        
        // debugging option #3: walk the tree with a listener
        new ParseTreeWalker().walk(new MarkdownListener_PrintEverything(), tree);
        
        // Walk the tree with the listener.
        ParseTreeWalker walker = new ParseTreeWalker();
        MarkdownListener_DocumentCreator listener = new MarkdownListener_DocumentCreator();
        walker.walk(listener, tree);
        
        // return the markup value that the listener created
        return listener.getDocument();
    }
    
    private static class MarkdownListener_DocumentCreator extends MarkdownBaseListener {
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
            TerminalNode token = ctx.TEXT();
            String text = token.getText();
            Document node = new Italic(new Text(text));
            stack.push(node);
        }
        
        @Override
        public void exitMarkdown(MarkdownContext ctx) {
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

    private static class MarkdownListener_PrintEverything extends MarkdownBaseListener {
        public void enterRoot(MarkdownParser.RootContext ctx) { System.err.println("entering root"); }
        public void exitRoot(MarkdownParser.RootContext ctx) { System.err.println("exiting root"); }

        public void enterNormal(MarkdownParser.NormalContext ctx) { System.err.println("entering normal"); }
        public void exitNormal(MarkdownParser.NormalContext ctx) { System.err.println("exiting normal"); }

        public void enterMarkdown(MarkdownParser.MarkdownContext ctx) { System.err.println("entering html"); }
        public void exitMarkdown(MarkdownParser.MarkdownContext ctx) { System.err.println("exiting html"); }

        public void enterItalic(MarkdownParser.ItalicContext ctx) { System.err.println("entering italic"); }
        public void exitItalic(MarkdownParser.ItalicContext ctx) { System.err.println("exiting italic"); }
    }
    
}
