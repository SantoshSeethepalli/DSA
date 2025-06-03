package Strings;

import java.util.HashSet;

public class Q8_RemoveDuplicates {
    public String removeDups(String s) {
        StringBuilder res = new StringBuilder();
        HashSet<Character> hashSet = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(hashSet.contains(c)) {
                continue;
            }

            res.append(c);
            hashSet.add(c);
        }

        return res.toString();
    }
}
