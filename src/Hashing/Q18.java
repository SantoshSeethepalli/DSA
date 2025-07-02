package Hashing;

import java.util.*;

public class Q18 {

    public int firstElementKTime(int[] arr, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);

            if(hashMap.get(arr[i]) == k) return arr[i];
        }

        return -1;
    }
}
