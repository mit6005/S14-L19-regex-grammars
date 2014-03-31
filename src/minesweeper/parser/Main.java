package minesweeper.parser;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;


public class Main {
 
    private static final String BOARD_3x2 =
            "3 2\n" +
            "0 0 0\n" +
            "0 1 0\n" ;
    private static final String BOARD_7x7 =
            "7 7\n" +
            "0 0 0 0 0 0 0\n" +
            "0 0 0 0 1 0 0\n" +
            "0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0\n" +
            "1 0 0 0 0 0 0\n" ;


    public static void main(String[] args) {
        int[][] bombs = parse(BOARD_3x2);
        System.out.println(Arrays.deepToString(bombs));
    }

    /**
     * @param string a Minesweeper board.  Must follow the grammar in Board.g4.
     * @return a 2D array where array[y][x] is the number of bombs in cell (x,y).
     *    *** A better design would return an object of a Board ADT rather than this low-level rep.
     */
     public static int[][] parse(String string) {
        // Create a stream of tokens using the lexer.
        CharStream stream = new ANTLRInputStream(string);
        BoardLexer lexer = new BoardLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Feed the tokens into the parser.
        BoardParser parser = new BoardParser(tokens);
        parser.reportErrorsAsExceptions();
        
        // Generate the parse tree using the starter rule.
        ParseTree tree = parser.file(); // "file" is the starter rule.
               
        
        // *** debugging option #1: print the tree to the console
//        System.err.println(tree.toStringTree(parser));

        // *** debugging option #2: show the tree in a window
//        RuleContext rootContext = (RuleContext) tree;
//        rootContext.inspect(parser);
        
        // *** debugging option #3: walk the tree with a listener
//        new ParseTreeWalker().walk(new PrintEverything(), tree);
        

        // Construct the board by walking over the parse tree with a listener.
        ParseTreeWalker walker = new ParseTreeWalker();
        MakeBoard listener = new MakeBoard();
        walker.walk(listener, tree);
        
        // return the value that the listener created
        return listener.bombs;
    }

     private static class PrintEverything extends BoardBaseListener {
         public void enterFile(BoardParser.FileContext ctx) { System.err.println("entering file"); }
         public void exitFile(BoardParser.FileContext ctx) { System.err.println("exiting file"); }
         
         public void enterBoard(BoardParser.BoardContext ctx) { System.err.println("entering board"); }
         public void exitBoard(BoardParser.BoardContext ctx) { System.err.println("exiting board"); }
         
         public void enterLine(BoardParser.LineContext ctx) { System.err.println("entering line"); }
         public void exitLine(BoardParser.LineContext ctx) { System.err.println("exiting line"); }
     }
     
     private static class MakeBoard extends BoardBaseListener {
         int[][] bombs;
         int nextY = 0;
         
         public void exitBoard(BoardParser.BoardContext ctx) { 
             int x = Integer.valueOf(ctx.x().getText());
             int y = Integer.valueOf(ctx.y().getText());
             bombs = new int[y][x];             
         }
         
         public void exitLine(BoardParser.LineContext ctx) {
             List<TerminalNode> vals = ctx.VAL();
             for (int x = 0; x < vals.size(); ++x) {
                 bombs[nextY][x] = vals.get(x).getText().equals("1") ? 1 : 0;
             }
             ++nextY;
         }
         
     }
     
}
