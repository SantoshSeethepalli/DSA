package Greedy;

import java.util.*;

public class Q3 {

    private static final char EMPTY_CHAR = (char) 123;

    private int getIntValue(char c) {
        return (c - 'a');
    }

    private char[] getSwappableCharacters(char[] dp, char[] arr) {

        char[] res = new char[2];

        for (int i = 0; i < dp.length; i++) {

            if (dp[i] != EMPTY_CHAR && dp[i] != arr[i]) {
                return new char[]{dp[i], arr[i]};
            }
        }
        return null;
    }

    private int[] getFirstOccurrenceIndexArray(char[] arr) {

        int[] hashArray = new int[26];

        Arrays.fill(hashArray, -1);

        for (int i = arr.length - 1; i >= 0; i--) {
            hashArray[arr[i] - 'a'] = i;
        }

        return hashArray;
    }

    private char[] getDpArray(char[] arr) {

        int n = arr.length;
        char[] dp = new char[n];

        char minSofar = EMPTY_CHAR;

        // Compute first occurrence of each character:
        int[] firstOccuranceIndexArray = getFirstOccurrenceIndexArray(arr);

        for (int currentIdx = n - 1; currentIdx >= 0; currentIdx--) {

            int currentCharacterValue = getIntValue(arr[currentIdx]);

            if (firstOccuranceIndexArray[currentCharacterValue] ==  currentIdx && arr[currentIdx] < minSofar)  {
                minSofar = arr[currentIdx];
            }

            if(arr[currentIdx] >= minSofar) dp[currentIdx] = minSofar;

            else dp[currentIdx] = EMPTY_CHAR;
        }

        return dp;
    }

    String chooseandswap(String s) {

        char[] arr = s.toCharArray();
        char[] dp = getDpArray(arr);

        char[] swappableCharacters = getSwappableCharacters(dp, arr);

        if(swappableCharacters == null) return s;

        for (int i = 0; i < arr.length; i++) {

            char currentChar = arr[i];

            if (arr[i] == swappableCharacters[0]) arr[i] = swappableCharacters[1];
            else if (arr[i] == swappableCharacters[1]) arr[i] = swappableCharacters[0];
        }
        return new String(arr);
    }
}
