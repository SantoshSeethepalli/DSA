package Hashing;

import java.util.*;

public class Q15 {

    public static boolean checkEqual(int[] a, int[] b) {

        if(a.length != b.length) return false;

        HashMap<Integer, Integer> firstArrayHashMap = new HashMap<>();

        for(int num :  a) {
            firstArrayHashMap.put(num, firstArrayHashMap.getOrDefault(num, 0) + 1);
        }

        for(int num : b) {
            if(!firstArrayHashMap.containsKey(num)) return false;

            firstArrayHashMap.put(num, firstArrayHashMap.get(num) - 1);

            if(firstArrayHashMap.get(num) == 0) {
                firstArrayHashMap.remove(num);
            }
        }

        return true;
    }
}
