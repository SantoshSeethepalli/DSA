package Hashing;

import java.util.*;

public class Q4 {

    public static ArrayList<Integer> commonElements(int[] a, int[] b) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(b);
        ArrayList<Integer> commonElements = new ArrayList<>();

        for (int key : b) {

            if (map.containsKey(key) && map.get(key) > 0) {

                commonElements.add(key);

                map.put(key, map.get(key) - 1);
            }
        }

        return commonElements;
    }
}
