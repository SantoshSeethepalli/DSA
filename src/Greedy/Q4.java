package Greedy;

import java.util.Arrays;

public class Q4 {

    static int toyCount(int N, int K, int[] arr) {

        Arrays.sort(arr);
        int count = 0;

        for(int i = 0; i < N; i++) {

            if(arr[i] > K) break;

            K = K - arr[i];
            count++;
        }

        return count;
    }
}
