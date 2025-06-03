package Strings;

public class Q5_isStringRotated {
    public static boolean isRotated(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() <= 2) return s1.equals(s2);

        int length = s1.length();
        String leftRotated = s1.substring(2) + s1.substring(0, 2);
        String rightRotated = s1.substring(length - 2) + s1.substring(0, length - 2);

        if(s2.equals(leftRotated) || s2.equals(rightRotated)) {
            return true;
        }
        return false;
    }
}
