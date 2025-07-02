package Hashing;

import java.util.*;

public class Q3 {

    int maxLen(int[] arr) {

        int n = arr.length;

        int sum = 0;
        int maxLength = 0;

        // PrefixSum -> Index
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        for(int rightIdx = 0; rightIdx < n; rightIdx++) {

            sum += arr[rightIdx];

            if(sum == 0) {
                maxLength = Math.max((rightIdx + 1), maxLength);
            }

            // find if the current sum is present previously as a contiguous part of array:
            if(prefixSumMap.containsKey(sum)) {
                maxLength = Math.max((rightIdx - prefixSumMap.get(sum) ), maxLength);
            } else {
                prefixSumMap.put(sum, rightIdx);
            }
        }

        return maxLength;
    }
}
