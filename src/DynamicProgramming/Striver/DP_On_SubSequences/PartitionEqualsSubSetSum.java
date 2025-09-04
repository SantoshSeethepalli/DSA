package DynamicProgramming.Striver.DP_On_SubSequences;

public class PartitionEqualsSubSetSum {
    private boolean subSetSumEqualsK(int[] arr, int target) {

        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];

        dp[0][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++) {
            for(int k = 0; k <= target; k++) {

                boolean notTaken = dp[i- 1][k];
                boolean taken = (k >= arr[i]) && dp[i - 1][k - arr[i]];

                dp[i][k] = (taken || notTaken);
            }
        }

        return dp[n - 1][target];
    }

    public boolean equalPartition(int n, int[] arr) {

        int sum = 0;
        for(int num : arr) {
            sum += num;
        }

        if(sum % 2 != 0) return false;

        return subSetSumEqualsK(arr, sum / 2);
    }
}
