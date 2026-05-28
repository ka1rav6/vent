import java.util.ArrayList;

import static utils.StringUtils.*;

public class Token {
    public String value;
    public TokenType type;


    public Token(String val, TokenType Type){
        this.value = val;
        this.type = Type;
    }

    public static ArrayList<Token> tokenise(String sourceCode){
        ArrayList<Token> tokens = new ArrayList<>();
        String[] src = sourceCode.split("");
        // splitting on every character
        int i = 0;
        while (i < src.length){
            if (src[i].equals("("))
                tokens.add(new Token(src[i++], TokenType.OPEN_PAREN));
            else if (src[i].equals(")"))
                tokens.add(new Token(src[i++], TokenType.CLOSE_PAREN));
            else if (src[i].equals("+") || src[i].equals("-") || src[i].equals("*") || src[i].equals("/") )
                tokens.add(new Token(src[i++], TokenType.BINARY_OPERATOR));
            else if (src[i].equals("="))
                tokens.add(new Token(src[i++], TokenType.EQUALS));
            else {
                // handle multicharacter tokens
                if (isInt(src[i])){
                    var num = "";
                    while (i < src.length && isInt(src[i]))
                        num += src[i++];
                    tokens.add(new Token(num, TokenType.NUMBER));
                }
                else if (isAlpha(src[i])){
                    var str = "";
                    while (i < src.length && isAlpha(src[i]))
                        str += src[i++];
                    // check if str is an identifier or a keyword
                    var type = TokenType.IDENTIFIER;
                    if (Keyword.isKeyword(str))
                        type = TokenType.KEYWORD;
                    tokens.add(new Token(str, type));
                }
                else if(isSkippable(src[i]))
                    i++;
                else {
                    System.out.println("Unrecognised Character found: " + src[i]);
                    System.exit(1);
                }
        }
        return tokens;
        }
    }
}
