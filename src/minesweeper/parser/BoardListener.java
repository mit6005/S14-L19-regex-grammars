// Generated from Board.g4 by ANTLR 4.0

package minesweeper.parser;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface BoardListener extends ParseTreeListener {
    void enterFile(BoardParser.FileContext ctx);
    void exitFile(BoardParser.FileContext ctx);

    void enterLine(BoardParser.LineContext ctx);
    void exitLine(BoardParser.LineContext ctx);

    void enterBoard(BoardParser.BoardContext ctx);
    void exitBoard(BoardParser.BoardContext ctx);

    void enterY(BoardParser.YContext ctx);
    void exitY(BoardParser.YContext ctx);

    void enterX(BoardParser.XContext ctx);
    void exitX(BoardParser.XContext ctx);
}