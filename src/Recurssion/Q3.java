package Recurssion;

import java.util.*;

public class Q3 {

    private static void getCombinationSum(int startIndex, int[] arr, int target, ArrayList<ArrayList<Integer>> res, List<Integer> resBuilder) {

        if(target == 0) {

            res.add(new ArrayList<>(resBuilder));
            return;
        }

        for(int i = startIndex ; i < arr.length; i++) {

            if(i > startIndex && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;

            resBuilder.add(arr[i]);

            getCombinationSum(i + 1, arr, target - arr[i], res, resBuilder);

            resBuilder.remove(resBuilder.size() - 1);
        }
    }

    static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        getCombinationSum(0, arr, target, result, new ArrayList<>());

        return result;
    }
}
