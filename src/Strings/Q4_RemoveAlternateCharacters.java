package Strings;

public class Q4_RemoveAlternateCharacters {

    private String helperFunction(StringBuilder str) {

        if(str.isEmpty()) {
            return str.toString();
        }

        int initialLength = str.length();
        int i = 0;

        while(i < str.length() - 1) {
            int currentStringLength = str.length();

            while(i < (str.length() - 1) && str.charAt(i) == str.charAt(i + 1)) {
                str.deleteCharAt(i + 1);
            }

            if(str.length() < currentStringLength) {
                str.deleteCharAt(i);
            } else {
                i++;
            }
        }

        if(initialLength == str.length()) {
            return str.toString();
        }

        return helperFunction(str);
    }

    public String removeUtil(String s) {
        StringBuilder str = new StringBuilder(s);

        return helperFunction(str);
    }
}
