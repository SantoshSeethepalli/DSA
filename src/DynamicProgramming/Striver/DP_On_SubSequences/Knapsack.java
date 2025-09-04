package DynamicProgramming.Striver.DP_On_SubSequences;

public class Knapsack {

    // Recursion + Memoization
    public int knapsack01(int[] wt, int[] val, int n, int W) {

        int[][] dp = new int[n][W + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        return findMaxValueThatCanBeObtainedInTheKnapsack(n - 1, W, wt, val, dp);
    }
    private int findMaxValueThatCanBeObtainedInTheKnapsack(int idx, int currentWeight, int[] weights, int[] values, int[][] dp) {

        if(idx < 0 || currentWeight == 0) {
            return 0;
        }

        if(dp[idx][currentWeight] != -1) return dp[idx][currentWeight];

        int notTaken = findMaxValueThatCanBeObtainedInTheKnapsack(idx - 1, currentWeight, weights, values, dp);

        int taken = 0;
        if(currentWeight - weights[idx] >= 0) {
            taken = values[idx] + findMaxValueThatCanBeObtainedInTheKnapsack(idx - 1, currentWeight - weights[idx], weights, values, dp);
        }

        // Store in DP table
        dp[idx][currentWeight] = Math.max(taken, notTaken);

        return Math.max(taken, notTaken);
    }

    // Tabulation
    public int knapsack01_Tabulation(int[] weights, int[] values, int n, int W) {

        int[][] dp = new int[n][W + 1];

        // For the base case, add the value into the table weh the knapsack capacity is 'Greater than or Equal to' the weight.
        for(int cap = 0; cap <= W; cap++) {

            if(weights[0] <= cap) {
                dp[0][cap] = values[0];
            }
        }

        for(int i = 1; i < n; i++) {
            for(int capacity = 0; capacity <= W; capacity++) {

                int notTaken = dp[i - 1][capacity];

                int taken = 0;
                if(weights[i] <= capacity) {
                    taken = values[i] + dp[i - 1][capacity - weights[i]];
                }

                dp[i][capacity] = Math.max(taken, notTaken);
            }
        }

        return dp[n - 1][W];
    }
}
