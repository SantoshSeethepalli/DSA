package DynamicProgramming.Striver.DP_On_SubSequences;

public class PartitionsWithGivenDifference {

    private static final int MOD_VALUE = 1_000_000_007;

    public int countPartitions(int n, int diff, int[] arr) {

        int sum = 0;
        for(int num : arr) {
            sum += num;
        }

        if((sum + diff) % 2 != 0) return 0;

        int target = (sum + diff) / 2;

        return findSubSetsWithGivenDiff(arr, target);
    }

    private int findSubSetsWithGivenDiff(int[] arr, int target) {

        int n = arr.length;
        int[][] dp = new int[n][target + 1];

        dp[0][0] = 1;

        if(arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }

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
