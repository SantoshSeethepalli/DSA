package Strings;

import java.util.HashSet;

public class Q10_LongestUniqueSubString {
    private int findMaxLength(final int l, final int r, final int maxLength) {
        int length = (r - l);

        return Math.max(maxLength, length);
    }
    public int longestUniqueSubstr(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        final char[] arr = s.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();

        int maxLength = 0;

        // pointers
        int left = 0;
        int right = 0;

        while(right < arr.length) {
            if(!hashSet.contains(arr[right])) {
                hashSet.add(arr[right]);
                right++;
            }
            else {
                maxLength = findMaxLength(left, right, maxLength);

                while(left <= right && hashSet.contains(arr[right])) {
                    hashSet.remove(arr[left]);
                    left++;
                }
            }
        }

        maxLength = findMaxLength(left, right, maxLength);

        return maxLength;
    }
}
