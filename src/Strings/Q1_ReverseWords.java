package Strings;

public class Q1_ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();

        if(s.isEmpty()) {
            return "";
        }

        int length = s.length();

        char[] arr = s.toCharArray();

        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for(int i = length - 1; i >= 0; i--) {
            if(arr[i] == ' ') {
                if(temp.length() != 0) {
                    temp.reverse();

                    res.append(temp);
                    res.append(" ");

                    temp = new StringBuilder();
                }
            } else {
                temp.append(arr[i]);
            }
        }
        if(temp.length() != 0) {
            temp.reverse();
            res.append(temp);
        }

        return res.toString();
    }
}
