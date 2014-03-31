// Generated from Markdown.g4 by ANTLR 4.0

package doc.markdown;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MarkdownListener extends ParseTreeListener {
    void enterMarkdown(MarkdownParser.MarkdownContext ctx);
    void exitMarkdown(MarkdownParser.MarkdownContext ctx);

    void enterRoot(MarkdownParser.RootContext ctx);
    void exitRoot(MarkdownParser.RootContext ctx);

    void enterNormal(MarkdownParser.NormalContext ctx);
    void exitNormal(MarkdownParser.NormalContext ctx);

    void enterItalic(MarkdownParser.ItalicContext ctx);
    void exitItalic(MarkdownParser.ItalicContext ctx);
}