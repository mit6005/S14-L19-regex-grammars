// Generated from Html.g4 by ANTLR 4.0

package doc.html;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface HtmlListener extends ParseTreeListener {
    void enterRoot(HtmlParser.RootContext ctx);
    void exitRoot(HtmlParser.RootContext ctx);

    void enterNormal(HtmlParser.NormalContext ctx);
    void exitNormal(HtmlParser.NormalContext ctx);

    void enterHtml(HtmlParser.HtmlContext ctx);
    void exitHtml(HtmlParser.HtmlContext ctx);

    void enterItalic(HtmlParser.ItalicContext ctx);
    void exitItalic(HtmlParser.ItalicContext ctx);
}