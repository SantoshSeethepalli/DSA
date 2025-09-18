package Arrays;

import java.util.*;

public class newQuestion_Reverse_pairs {

    public int reversePairs(int[] nums) {

        return countReversePairs(nums, 0, nums.length - 1);
    }

    private int countReversePairs(int[] arr, int left, int right) {

        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int count = 0;

        count += countReversePairs(arr, left, mid);
        count += countReversePairs(arr, mid + 1, right);

        count += countPairs(arr, left, mid, right);
        merge(arr, left, mid, right);

        return count;
    }

    private int countPairs(int[] arr, int left, int mid, int right) {

        long count = 0;
        int rightPointer = mid + 1;

        for (int leftPointer = left; leftPointer <= mid; leftPointer++) {

            while (rightPointer <= right && (long) arr[leftPointer] > 2L * arr[rightPointer]) {

                rightPointer++;
            }

            count += (rightPointer - (mid + 1));
        }

        return (int) count;
    }

    private void merge(int[] arr, int left, int mid, int right) {

        List<Integer> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {

            if (arr[i] < arr[j]) {

                temp.add(arr[i++]);
            } else {

                temp.add(arr[j++]);
            }
        }

        while (i <= mid) {

            temp.add(arr[i++]);
        }

        while (j <= right) {

            temp.add(arr[j++]);
        }

        for (int idx = left; idx <= right; idx++) {

            arr[idx] = temp.get(idx - left);
        }
    }
}
