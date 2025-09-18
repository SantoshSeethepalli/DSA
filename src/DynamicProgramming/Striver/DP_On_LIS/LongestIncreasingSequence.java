package DynamicProgramming.Striver.DP_On_LIS;

import java.util.*;

public class LongestIncreasingSequence {

    private int findLIS(int idx, int[] arr, int lastElementIdx, int[][] dp) {

        if(idx == arr.length) return 0;

        if(dp[idx][lastElementIdx + 1] != -1) return dp[idx][lastElementIdx + 1];

        int notTake = findLIS(idx + 1, arr, lastElementIdx, dp);

        int take = Integer.MIN_VALUE;
        if(lastElementIdx == -1 || arr[idx] > arr[lastElementIdx]) {

            take = 1 + findLIS(idx + 1, arr, idx, dp);
        }

        return dp[idx][lastElementIdx + 1] = Math.max(take, notTake);
    }

    public int LIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return findLIS(0, nums, -1, dp);
    }
}
