package Strings;

import java.lang.invoke.StringConcatFactory;

public class Q3_LongestPalindrome {
    private static int findPalindromicLength(char[] arr, int leftIndex, int rightIndex) {
        int res = 0;

        while(leftIndex >= 0 && rightIndex < arr.length) {
            if(arr[leftIndex] == arr[rightIndex]) {
                res++;
                leftIndex--;
                rightIndex++;
            } else {
                break;
            }
        }
        return res;
    }

    static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        String longestPalindromicString = "";

        for(int i = 0; i < arr.length - 2; i++) {
            if(arr[i] == arr[i + 1]) {
                int length = Q3_LongestPalindrome.findPalindromicLength(arr, i, i + 1);
                int start = i - length + 1;
                int end = i + length + 1;

                String temp = s.substring(start, end);

                if(temp.length() > longestPalindromicString.length()) {
                    longestPalindromicString = temp;
                }
            }

            if(arr[i] == arr[i + 2]) {
                int length = Q3_LongestPalindrome.findPalindromicLength(arr, i, i + 2);
                int start = i - length + 1;
                int end = i + 1 + length;

                String temp = s.substring(start, end);

                if(temp.length() > longestPalindromicString.length()) {
                    longestPalindromicString = temp;
                }
            }
        }

        return longestPalindromicString;
    }
}
