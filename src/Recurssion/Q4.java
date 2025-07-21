package Recurssion;

public class Q4 {

    static int optimalKeys(int N) {

        if(N <= 6) return N;

        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++) dp[i] = i;

        for(int i = 1; i <= N; i++) {

            int multiplyer = 2;

            for(int j = i + 3; j <= N; j++) {

                dp[j] = Math.max(dp[j], dp[i] * multiplyer);
                multiplyer++;
            }
        }

        return dp[N];
    }
}
