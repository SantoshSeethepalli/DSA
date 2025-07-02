package Hashing;

import java.util.*;

public class Q17 {

    public static String smallestWindow(String s1, String s2) {
        if (s1.length() < s2.length()) return "";

        HashMap<Character, Integer> targetMap = new HashMap<>();

        for (char c : s2.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int startIndex = -1;
        int countForTargetCharacters = 0;
        int minLength = Integer.MAX_VALUE;

        HashMap<Character, Integer> windowMap = new HashMap<>();

        for(int end = 0; end < s1.length(); end++) {

            char endCharacter = s1.charAt(end);
            windowMap.put(endCharacter, windowMap.getOrDefault(endCharacter, 0) + 1);

            if(targetMap.containsKey(endCharacter) && windowMap.get(endCharacter) <= targetMap.get(endCharacter)) {
                countForTargetCharacters++;
            }

            while(start <= end && countForTargetCharacters == s2.length()) {

                // adjust minLength
                if ((end - start + 1) < minLength) {
                    minLength = (end - start + 1);
                    startIndex = start;
                }

                char startCharacter = s1.charAt(start);
                windowMap.put(startCharacter, windowMap.get(startCharacter) - 1);
                if(targetMap.containsKey(startCharacter) &&
                        windowMap.get(startCharacter) < targetMap.get(startCharacter)) {
                    countForTargetCharacters--;
                }

                start++;
            }
        }

        return (startIndex == -1) ? "" : s1.substring(startIndex, startIndex + minLength);
    }
}
