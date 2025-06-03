package Strings;

// abccd


public class Q9_MinCharForPalindrome {

    private static int findNumberOfLettersToBeAdded(char[] arr, int left, int right, int[][] dp) {

        // check if already computed
        if(dp[left][right] != 0) {
            return dp[left][right];
        }

        // base condition
        if(left >= right) {
            return 0;
        }

        if(arr[left] == arr[right]) {
            return findNumberOfLettersToBeAdded(arr, left + 1, right - 1, dp);
        }

        // check if present in dp array use them else compute
        int afterRemoveLastCharacter = findNumberOfLettersToBeAdded(arr, left, right - 1, dp);
        int afterRemoveFirstCharacter = findNumberOfLettersToBeAdded(arr, left + 1, right, dp );

        int min = Math.min(afterRemoveFirstCharacter, afterRemoveLastCharacter);
        dp[left][right] = min + 1;

        return dp[left][right];
    }

    static int countMin(String str) {

        int length = str.length();

        if(length <= 1) {
            return 0;
        }

        int[][] dp = new int[length][length];

        return findNumberOfLettersToBeAdded(str.toCharArray(), 0, length - 1, dp);
    }
}
