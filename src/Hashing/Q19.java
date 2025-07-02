package Hashing;

import java.util.*;

public class Q19 {

    private void swapInMatrix(int[][] arr, int a, int b, int i, int j) {

        if(arr[a][b] > arr[i][j]) {
            int temp = arr[i][j];
            arr[i][j] = arr[a][b];
            arr[a][b] = temp;
        }
    }

    private int[][] getSortedKeyValueSets(HashMap<Integer, Integer> hashMap) {

        List<Integer> keySet = new ArrayList<>(hashMap.keySet());

        int[][] res = new int[2][2];

        // find keys
        res[0][0] = keySet.get(0);
        res[1][0] = keySet.get(1);

        // make sure first row has smallest key
        swapInMatrix(res, 0, 0, 1, 0);

        // get respective keys of each row
        res[0][1] = hashMap.get(res[0][0]);
        res[1][1] = hashMap.get(res[1][0]);

        return res;
    }

    boolean sameFreq(String s) {

        int[] freqMap = new int[26];

        for (char c : s.toCharArray()) freqMap[c - 'a']++;

        System.out.print(Arrays.toString(freqMap));

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : freqMap) {

            if (num == 0) continue;
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        if (hashMap.size() == 1) return true;
        if (hashMap.size() != 2) return false;



        int[][] sortedKeyValueSets = getSortedKeyValueSets( hashMap);

        int lowestFrequencyElements = sortedKeyValueSets[0][1];
        int highestFrequencyElements = sortedKeyValueSets[1][1];

        // Eg: aaabbbcc : [2:1, 3:2]   -> not possible
        // Eg: abcdff : [1:4, 2:1]   -> not possible
        // Eg: aabbccd : [1:1, 2:3] -> possible
        if(sortedKeyValueSets[0][1] == 1 && lowestFrequencyElements == 1) return true;

        // Eg: aaabbcc : [2:2, 3:1] -> possible
        // Eg: aaabbbcc : [2:1, 3:1] -> not possible (diff == -1)
        if(sortedKeyValueSets[1][0] - sortedKeyValueSets[0][0] == 1 && highestFrequencyElements == 1) return true;

        return false;
    }
}
