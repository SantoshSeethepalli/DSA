package Hashing;

import java.util.*;

public class Q13 {

    public int findSubarray(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int zeroSumSubArraysCount = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if(sum == 0) zeroSumSubArraysCount++;

            if(map.containsKey(sum)) zeroSumSubArraysCount += map.get(sum);

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return zeroSumSubArraysCount;
    }
}
