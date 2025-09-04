package DynamicProgramming.Striver.DP_On_SubSequences;

import java.util.Arrays;

public class CoinChange_Two {

    // Memoization:
    public int count(int[] coins, int N, int targetAmount) {

        int[][] dp = new int[N][targetAmount + 1];

        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return coinsCount(0, coins, targetAmount, dp);
    }

    private int coinsCount(int idx, int[] coins, int target, int[][] dp) {

        if(target == 0) {
            return 1;
        }

        if(idx == coins.length) {
            return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int skip = coinsCount(idx + 1, coins, target, dp);

        int pick = 0;
        if(target >= coins[idx]) {
            pick = coinsCount(idx, coins, target - coins[idx], dp);
        }

        dp[idx][target] = (skip + pick) % 1_000_000_007;

        return dp[idx][target];
    }

    public int countTabulation(int[] coins, int N, int targetAmount) {

        int[][] dp = new int[N][targetAmount + 1];

        // Base case
        for(int j = 0; j <= targetAmount; j++) {

            if(j % coins[0] != 0) continue;

            dp[0][j] = 1;
        }

        // Main solution
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= targetAmount; j++) {

                int skip = dp[i - 1][j];

                int pick = 0;
                if(j >= coins[i]) {
                    pick = dp[i][j - coins[i]];
                }

                dp[i][j] = (skip + pick) % 1_000_000_007;
            }
        }

        return dp[N - 1][targetAmount];
    }
}
