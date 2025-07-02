package Hashing;

import java.util.*;

public class Q10 {

    public boolean isSubset(int[] a, int[] b) {

        HashMap<Integer, Integer> hashMapOfFirstArray = new HashMap<>();

        for(int num : a) {
            hashMapOfFirstArray.put(num, hashMapOfFirstArray.getOrDefault(num, 0) + 1);
        }

        for(int num : b) {
            if (!hashMapOfFirstArray.containsKey(num)) {
                return false;
            }

            hashMapOfFirstArray.put(num, hashMapOfFirstArray.get(num) - 1);

            if (hashMapOfFirstArray.get(num) == 0) {
                hashMapOfFirstArray.remove(num);
            }
        }

        return true;
    }
}
