package DynamicProgramming.Striver.DP_On_SubSequences;

public class CountSubSetsWithSumK {

    private static final int MOD_VALUE = 1_000_000_007;

    // Memoization
    public int perfectSum(int[] arr, int K) {

        int[][] dp = new int[arr.length][K + 1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return getSubSetsWithSumEqualToTarget(0, arr, K, dp);
    }
    private int getSubSetsWithSumEqualToTarget(int idx, int[] arr, int target, int[][] dp) {

        if(target == 0) {
            return 1;
        }

        if(idx == arr.length) {
            return 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];

        int notTaken = getSubSetsWithSumEqualToTarget(idx + 1, arr, target, dp);

        int taken = 0;
        if(arr[idx] <= target) {
            taken = getSubSetsWithSumEqualToTarget(idx + 1, arr, target - arr[idx], dp);
        }


        int sum =  (notTaken + taken) % MOD_VALUE;

        dp[idx][target] = sum;

        return sum;
    }

    // Tabulation
    public int perfectSum_Tabulation(int[] arr, int target) {

        int n = arr.length;
        int[][] dp = new int[n][target + 1];

        dp[0][0] = 1;

        if(arr[0] <= target) dp[0][arr[0]] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= target; j++) {

                int notTaken = dp[i - 1][j];

                int taken = 0;
                if(arr[i] <= j) {
                    taken = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = (taken + notTaken) % MOD_VALUE;
            }
        }

        return dp[n - 1][target];
    }
}
