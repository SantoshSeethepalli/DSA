package Hashing;

import java.util.*;

public class Q5 {
    private int findNextValueIndex(int index, int[] arr, boolean searchRight) {

        int nextStep = (searchRight) ? 1 : -1;

        int initialValue = arr[index];

        while(index >= 0 && index < arr.length
                && arr[index] == initialValue) {

            index += nextStep;
        }

        return index;
    }

    private List<Integer> getQuadrupleList(int a, int b, int c, int d) {

        List<Integer> quadruple = new ArrayList<>();

        quadruple.add(a);
        quadruple.add(b);
        quadruple.add(c);
        quadruple.add(d);

        return quadruple;
    }

    public List<List<Integer>> fourSum(int[] arr, int target) {

        if(arr.length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; ) {
            for(int j = i + 1; j < arr.length; ) {

                int k = j + 1;
                int l = arr.length - 1;

                while(k < l) {

                    int sum = arr[i] + arr[j] + arr[k] + arr[l];

                    if(sum == target) {

                        res.add(getQuadrupleList(arr[i], arr[j], arr[k], arr[l]) );

                        k = findNextValueIndex(k, arr, true);
                        l = findNextValueIndex(l, arr, false);
                    } else if(sum < target) {

                        k = findNextValueIndex(k, arr, true);
                    } else {

                        l = findNextValueIndex(l, arr, false);
                    }
                }

                j = findNextValueIndex(j, arr, true);
            }

            i = findNextValueIndex(i, arr, true);
        }

        return res;
    }
}
