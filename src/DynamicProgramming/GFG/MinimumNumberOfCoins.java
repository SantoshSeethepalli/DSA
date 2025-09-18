package DynamicProgramming.GFG;

public class MinimumNumberOfCoins {

    public int findMin(int amount) {

        int n = 4;
        int[] coins = {1, 2, 5, 10};


        int[][] dp = new int[n][amount + 1];

        for(int j = 0; j <= amount; j++) {

            dp[0][j] = j;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= amount; j++) {

                int skip = dp[i - 1][j];

                int pick = Integer.MAX_VALUE;
                if(j >= coins[i]) {

                    pick = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(pick, skip);
            }
        }

        return dp[n - 1][amount];
    }
}
