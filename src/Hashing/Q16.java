package Hashing;

import java.util.*;

public class Q16 {

    public String uncommonChars(String s1, String s2) {

        if(s1.equals(s2)) return "";

        int[] setOfCharactersInFirstString = new int[26];
        int[] setOfCharactersInSecondString = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            setOfCharactersInFirstString[s1.charAt(i) - 'a'] = 1;
        }

        for(int i = 0; i < s2.length(); i++) {
            setOfCharactersInSecondString[s2.charAt(i) - 'a'] = 1;
        }

        StringBuilder sortedString = new StringBuilder();

        // Looping all characters:
        for(int i = 0; i < 26; i++) {

            if(setOfCharactersInFirstString[i] == 1 && setOfCharactersInSecondString[i] == 1) continue;

            if(setOfCharactersInFirstString[i] == 1 || setOfCharactersInSecondString[i] == 1) {

                char currentCharacter = (char) (i + 97);
                sortedString.append(currentCharacter);
            }
        }

        return sortedString.toString();
    }
}
