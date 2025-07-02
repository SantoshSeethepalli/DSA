package Hashing;

import java.util.*;

public class Q14 {

    public static int minIndexChar(String s1, String s2) {

        int minimumCommonIndex = -1;

        if(s1 == null || s2 == null) return minimumCommonIndex;

        Set<Character> setOfCharacterInSecondString = new HashSet<>();

        for(char c : s2.toCharArray()) {
            setOfCharacterInSecondString.add(c);
        }

        for(int i = 0; i < s1.length(); i++) {
            char currentCharacter = s1.charAt(i);

            if(setOfCharacterInSecondString.contains(currentCharacter)) {
                minimumCommonIndex = i;
                break;
            }
        }

        return minimumCommonIndex;
    }

}
