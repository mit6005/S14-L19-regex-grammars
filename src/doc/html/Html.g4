grammar Html;

// This puts "package markup.html;" at the top of the output Java files.
@header {
package doc.html;
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
 *   *** Antlr requires tokens to be CAPITALIZED, like START_ITALIC, END_ITALIC, and TEXT.
 */
START_ITALIC : '<i>' ;
END_ITALIC   : '</i>' ;
TEXT      : ~[<>]+ ;

// here are some ways to generalize, so that we recognize <I> and <b> and <strong> too
// START_TAG : '<[A-Za-z]+>' ;
// END_TAG   : '</[A-Za-z]+>' ;

/*
 * These are the parser rules. They define the structures used by the parser.
 *    *** Antlr requires grammar nonterminals to be lowercase, like html, normal, and italic.
 */
root : html EOF ;
html : ( normal | italic ) * ;
normal : TEXT ;
italic : START_ITALIC html END_ITALIC ;
