package utils;

public class StringUtils {

    public static boolean isAlpha(String src){
        return ! src.toLowerCase().equals(src.toUpperCase());
    }
    public static boolean isInt(String src){
        var c = src.codePointAt(0);
        var start =  Character.codePointOf("0");
        var end = Character.codePointOf("9");
        return c > start && c < end;
    }
    public static boolean isSkippable(String src){
        return (src.equals(" ") || src.equals("\n") || src.equals("\t"));
    }
}
