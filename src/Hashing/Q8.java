package Hashing;

import java.util.*;

public class Q8 {

    public boolean canPair(List<Integer> arr, int k) {

        if(arr.size() % 2 == 1) return false;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;

        for(int num : arr) {

            int reminder = num % k;

            if(!hashMap.containsKey(reminder)) {
                hashMap.put(reminder, hashMap.getOrDefault(reminder, 0) + 1);
            } else {
                count++;
                hashMap.remove(reminder);
            }
        }

        if(count != arr.size() / 2) return false;

        return true;
    }
}
