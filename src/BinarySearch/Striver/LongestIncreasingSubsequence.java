package BinarySearch.Striver;

import java.util.*;

public class LongestIncreasingSubsequence {

    private int findLowerBoundIdx(List<Integer> arr, int element) {

        int left = 0;
        int right = arr.size();

        while(left < right) {

            int mid = (left + right) / 2;

            if(element > arr.get(mid)) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    public int LIS(int[] arr) {

        int n = arr.length;

        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        for(int i = 0 ; i < n; i++) {

            if(arr[i] > temp.get(temp.size() - 1)) {

                temp.add(arr[i]);
            } else {

                int idx = findLowerBoundIdx(temp, arr[i]);

                if(idx == temp.size()) temp.add(arr[i]);
                else temp.set(idx, arr[i]);
            }
        }

        return temp.size();
    }
}
