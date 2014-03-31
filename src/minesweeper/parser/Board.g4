grammar Board;

// This puts a package statement at the top of the output Java files.
@header {
package minesweeper.parser;
}

// This adds code to the generated lexer and parser. Do not change these lines.
@members {
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
}

/*
 * These are the lexical rules. They define the tokens used by the lexer.
 *   *** Antlr requires tokens to be CAPITALIZED.
 */
VAL : '0' | '1' ;
INT : [0-9]+ ;
SPACE : ' ' ;
NEWLINE : '\r'? '\n' ;

/*
 * These are the parser rules. They define the structures used by the parser.
 *    *** Antlr requires grammar nonterminals to be lowercase.
 */
file : board line+ ;
board : x SPACE y NEWLINE ;
line : (VAL SPACE)* VAL NEWLINE ;
x : INT ;
y : INT ;

