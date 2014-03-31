package url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Urls {

    public static void main(String[] args) {
        tryParsing("http://mit.edu/");        
        tryParsing("http://google.com/");
        tryParsing("http://didit.csail.mit.edu:4949/");
        tryParsing("http://edu/");
        tryParsing("https://mit.edu/");
        tryParsing("http://mit.edu");
    }
    
    public static void tryParsing(String string) {
        try { 
            System.out.println(parse(string)); 
        } catch (MalformedURLException e) { 
            System.err.println(e);
        }        
    }
    
    /**
     * Parse a subset of possible urls that match the following grammar:
     * <code>
     *     url ::= 'http://' hostname (':' port) '/'
     *     hostname ::= identifier '.' hostname | identifier '.' identifier
     *     port ::= [0-9]+
     *     identifier ::= [a-z]+
     * </code>
     * 
     * @param string string to parse as a url
     * @return URL object corresponding to the parsed URL
     * @throws MalformedURLException if s does not match the grammar above
     */
    public static URL parse(String string) throws MalformedURLException {
        // grammar above, boiled down to a regular expression
        String regex = "http://(([a-z]+\\.)+[a-z]+)(:([0-9]+))?/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new MalformedURLException("can't parse this URL: " + string);
        }
        // the regular expression successfully matched, so 
        // each set of parentheses in the regex becomes a matcher.group(), in order:
        String hostname = matcher.group(1);
        String lastDomainName = matcher.group(2);
        String colonPort = matcher.group(3);
        String portAlone = matcher.group(4);
        
        if (portAlone != null) {
            int port = Integer.valueOf(portAlone);
            return new URL("http", hostname, port, "/");
        } else {
            return new URL("http", hostname, "/");
        }
    }
}
