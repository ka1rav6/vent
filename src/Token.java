import java.util.ArrayList;

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
        }
        return tokens;
    }
}
