package DynamicProgramming.Striver.DP_1D;

public class JumpingFrog_v2 {

    public int frogJump(int[] heights, int k) {

        int n = heights.length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {

            int min = Integer.MAX_VALUE;

            for(int j = i + 1; j <= i + k && j < n; j++) {

                int jumpCost = dp[j - i] + Math.abs(heights[j] - heights[i]);
                min = Math.min(min, jumpCost);
            }

            dp[i] = min;
        }

        return dp[n - 1];
    }
}
