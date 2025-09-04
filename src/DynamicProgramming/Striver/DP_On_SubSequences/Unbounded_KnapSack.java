package DynamicProgramming.Striver.DP_On_SubSequences;

public class Unbounded_KnapSack {
    public int unboundedKnapsack(int[] wt, int[] val, int N, int W) {

        int[][] dp = new int[N][W + 1];

        for(int weight = 0; weight <= W; weight++) {

            int frequencyAllowed = weight / wt[0];

            dp[0][weight] = val[0] * frequencyAllowed;
        }

        for(int idx = 1; idx < N; idx++) {
            for(int weight = 0; weight <= W; weight++) {

                int skip = dp[idx - 1][weight];

                int pick = 0;
                if(weight >= wt[idx]) {
                    pick = val[idx] + dp[idx][weight - wt[idx]];
                }

                dp[idx][weight] = Math.max(pick, skip);
            }
        }

        return dp[N - 1][W];
    }
}
