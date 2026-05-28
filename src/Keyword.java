import java.util.HashMap;
import java.util.Map;

public class Keyword {
    public static Map<String, TokenType> map = new Map.of(
            "let", TokenType.VAR

    );
    public static boolean isKeyword(String str){
        return map.containsKey(str);
    }

}
