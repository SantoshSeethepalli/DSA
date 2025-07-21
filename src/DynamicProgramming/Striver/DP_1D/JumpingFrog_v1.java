package DynamicProgramming.Striver.DP_1D;

public class JumpingFrog_v1 {

    public int frogJumpTabulation(int[] heights) {

        int n = heights.length;
        int[] dp = new int[n];

        for(int i = 1; i < n; i++) {

            int oneJump = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            if(i == 1) {

                dp[i] = oneJump;
                continue;
            }

            int twoJumps = dp[i - 2] + Math.abs(heights[i] - heights[ i - 2]);

            dp[i] = Math.min(oneJump, twoJumps);
        }

        return dp[n - 1];
    }

    public int frogJumpTwoVariables(int[] heights) {

        int n = heights.length;

        int prev = 0;
        int prev2 = 0;

        for(int i = 1; i < n; i++) {

            int oneJump = prev + Math.abs(heights[i] - heights[i - 1]);

            if(i == 1) {

                prev = oneJump;
                continue;
            }

            int twoJumps = prev2 + Math.abs(heights[i] - heights[ i - 2]);

            prev2 = prev;
            prev = Math.min(oneJump, twoJumps);
        }

        return prev;
    }
}
