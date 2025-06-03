package Arrays;

import java.util.Arrays;

public class Q6_Rearrange_array_alternatively {
    private static void computeNewValue(int[] arr, int i, int j, int modValue) {
        int newVale = modValue * (arr[j] % modValue) + arr[i];
        arr[i] = newVale;
    }

    public static void rearrange(int arr[]) {
        int n = arr.length;
        int modValue = Arrays.stream(arr).max().getAsInt() + 1;


        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                computeNewValue(arr, i, (n - (i / 2) - 1),  modValue);
            } else {
                computeNewValue(arr, i, (i - 1) / 2, modValue);
            }
        }

        for(int i = 0; i < n; i++) {
            arr[i] = arr[i] / modValue;
        }
    }
}
