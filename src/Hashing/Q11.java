package Hashing;

import java.util.*;

public class Q11 {

    public Pair[] allPairs(int target, int[] arr1, int[] arr2) {

        List<Pair> listOfPossiblePairFoundInBothArrays = new ArrayList<>();
        HashMap<Integer, Integer> hashMapForArrTwo = new HashMap<>();

        for(int num : arr2) {
            hashMapForArrTwo.put(num, hashMapForArrTwo.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(arr1);

        for (int num : arr1) {

            int requiredFromArrayTwo = target - num;

            if (hashMapForArrTwo.containsKey(requiredFromArrayTwo)) {

                int numberOfPairsPossible = hashMapForArrTwo.get(requiredFromArrayTwo);

                Pair foundedPair = new Pair(num, requiredFromArrayTwo);

                while(numberOfPairsPossible > 0) {

                    listOfPossiblePairFoundInBothArrays.add(foundedPair);
                    numberOfPairsPossible--;

                }
            }
        }

        return listOfPossiblePairFoundInBothArrays.toArray(new Pair[0]);
    }
}
