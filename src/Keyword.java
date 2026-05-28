import java.util.HashMap;
import java.util.Map;

public class Keyword {
    public static Map<String, TokenType> map = Map.of(
            "let", TokenType.VAR

    );
    public static boolean isKeyword(String str){
        return map.containsKey(str);
    }

}
