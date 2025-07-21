package DynamicProgramming.Striver.DP_1D;

import java.util.*;

public class MaximumSumOfNonAdjacentElements {


    private int findMaxNonAdjacentSum(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) {
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + findMaxNonAdjacentSum(nums, idx + 2, dp);
        int skip = findMaxNonAdjacentSum(nums, idx + 1, dp);

        dp[idx] = Math.max(pick, skip);

        return dp[idx];
    }
    public int memoizationApproach(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        findMaxNonAdjacentSum(nums, 0, dp);

        return dp[0];
    }

    public int tabulationApproach(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n + 2];

        for(int i = n - 1; i >= 0; i--) {

            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
