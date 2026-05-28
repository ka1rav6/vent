package utils;

public class StringUtils {

    public static boolean isAlpha(String src){
        if (src == null || src.isEmpty())
            return false;
        return !src.toLowerCase().equals(src.toUpperCase());
    }
    public static boolean isInt(String src){
        if (src == null || src.isEmpty())
            return false;
        char c = src.charAt(0);
        return c >= '0' && c <= '9';
    }

    public static boolean isSkippable(String src){
        return (src.equals(" ") || src.equals("\n") || src.equals("\t"));
    }
}
