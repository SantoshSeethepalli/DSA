package DynamicProgramming.Striver.DP_On_SubSequences;

public class MinimumSubsetSumDifference {
    private int findTotalSum(int[] arr) {

        int sum = 0;
        for(int a : arr) {
            sum += a;
        }

        return sum;
    }

    private boolean[][] constructDpTable(int[] arr, int n, int target) {

        boolean[][] dp = new boolean[n][target + 1];

        dp[0][0] = true;
        if(arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= target; j++) {

                boolean notTaken = dp[i - 1][j]; // upper result

                boolean taken = false;
                if(j >= arr[i]) {
                    taken = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = (taken || notTaken);
            }
        }

        return dp;
    }

    public int minDifference(int[] arr, int n) {

        int totalSum = findTotalSum(arr);
        int midSum = totalSum / 2;

        boolean[][] dp = constructDpTable(arr, n, midSum);

        int minDifference = Integer.MAX_VALUE;

        for(int i = 0; i <= midSum; i++) {

            if(!dp[n - 1][i]) continue;

            int currentDifference = Math.abs(i - (totalSum - i));

            minDifference = Math.min(minDifference, currentDifference);
        }

        return minDifference;
    }
}
