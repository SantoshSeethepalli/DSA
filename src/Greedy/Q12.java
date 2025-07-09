package Greedy;

import java.util.HashMap;

public class Q12 {

    public static long maxBalls(int n, int m, int[] a, int[] b) {

        int i = 0;
        int j = 0;

        int sumA = 0;
        int sumB = 0;

        long maxBalls = 0;

        while (i < n && j < m) {

            if(a[i] < b[j]) {

                sumA += a[i++];
            } else if(b[j] < a[i]) {
                sumB += b[j++];
            } else {


                maxBalls += Math.max(sumA, sumB) + a[i];

                sumA = 0;
                sumB = 0;

                i++;
                j++;
            }
        }

        while (i < n) sumA += a[i++];
        while (j < m) sumB += b[j++];

        maxBalls += Math.max(sumA, sumB);

        return maxBalls;
    }
}
