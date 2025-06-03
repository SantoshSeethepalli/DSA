package Sortings;

import java.util.Arrays;

public class MergeSortAlgorithm {
    public static void sort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] arr1 = new int[mid - left + 1];
        int[] arr2 = new int[right - mid];

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[left + i];
        }

        for(int i = mid + 1; i <= right; i++) {
            arr2[i - mid - 1] = arr[i];
        }

        int n = arr1.length;
        int m = arr2.length;;

        int i = 0;
        int j = 0;
        int arrPointer = left;

        while (i < n && j < m) {
            if(arr1[i] > arr2[j]) { // sorting order
                arr[arrPointer++] = arr1[i++];
            } else {
                arr[arrPointer++] = arr2[j++];
            }
        }

        while (i < n) {
            arr[arrPointer++] = arr1[i++];
        }

        while (j < m) {
            arr[arrPointer++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3};

        MergeSortAlgorithm.sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}