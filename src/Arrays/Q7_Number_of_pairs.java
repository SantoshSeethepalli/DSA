package Arrays;

import java.util.Arrays;

public class Q7_Number_of_pairs {
    private static int findIndexGreaterThanGivenValue(final double[] arr, final double val) {
        int left = 0;
        int right = arr.length - 1;
        double epsilon = 1e-9;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (arr[mid] - val >= -epsilon) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static long countPairs(int x[], int y[], int M, int N) {
        long count = 0;
        double[] arr = new double[x.length];
        double[] brr = new double[y.length];

        for (int i = 0; i < M; i++) {
            arr[i] = Math.log10(x[i]) / x[i];
        }

        for (int j = 0; j < N; j++) {
            brr[j] = Math.log10(y[j]) / y[j];
        }

        Arrays.sort(brr);

        for (double xValue : arr) {
            count += findIndexGreaterThanGivenValue(brr, xValue);;
        }
        return count;
    }
}
