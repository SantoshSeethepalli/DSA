package DynamicProgramming.Striver.DP_On_SubSequences;

import java.util.*;

public class MinimumCoins {

    static final int MAX = 1000000000;

    // Memoization:
    public int findMinimumCoinsRequiredToGetTheAmount ( int[] coins, int amount){

    int[][] dp = new int[coins.length][amount + 1];

    for (int i = 0; i < coins.length; i++) {

        Arrays.fill(dp[i], -1);
    }

    int ans = findMinimumCoins(0, coins, amount, dp);

    if (ans >= MAX) return -1;

    return ans;
}

    private int findMinimumCoins ( int idx, int[] arr, int targetAmount, int[][] dp){

        if (targetAmount == 0) {
            return 0;
        }

        if (idx == arr.length || targetAmount < 0) {
            return MAX;
        }

        if (dp[idx][targetAmount] != -1) return dp[idx][targetAmount];

        int skip = findMinimumCoins(idx + 1, arr, targetAmount, dp);
        int take = 1 + findMinimumCoins(idx, arr, targetAmount - arr[idx], dp);

        dp[idx][targetAmount] = Math.min(take, skip);

        return Math.min(take, skip);
    }

    // Tabulation:
    public int findMinimumCoinsRequired(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        int MAX_VALUE = (int) 1e9;

        for(int possibleTarget = 1; possibleTarget <= amount; possibleTarget++) {

            dp[0][possibleTarget] = MAX_VALUE;

            if( possibleTarget % coins[0] == 0) {
                dp[0][possibleTarget] = possibleTarget / coins[0];
            }
        }

        for(int idx = 1; idx < n; idx++) {
            for(int possibleTarget = 0; possibleTarget <= amount; possibleTarget++) {

                int notTaken = dp[idx - 1][possibleTarget];

                int taken = MAX_VALUE;
                if(possibleTarget >= coins[idx]) {
                    taken = 1 + dp[idx][possibleTarget - coins[idx]];
                }

                dp[idx][possibleTarget] = Math.min(taken, notTaken);
            }
        }

        if(dp[n - 1][amount] >= MAX_VALUE) return -1;

        return dp[n - 1][amount];
    }
}