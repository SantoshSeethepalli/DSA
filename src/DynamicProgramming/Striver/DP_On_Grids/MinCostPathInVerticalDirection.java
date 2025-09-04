package DynamicProgramming.Striver.DP_On_Grids;

/*
Given a 2d array called matrix consisting of integer values. Return the minimum path sum that
can be obtained by starting at any cell in the first row and ending at any cell in the last row.
Movement is allowed only to the bottom, bottom-right, or bottom-left cell of the current cell.
*/


public class MinCostPathInVerticalDirection {

    // This is space optimized version
    public int spaceOptimizedMinFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }

        for(int i = 1; i < m; i++) {

            int[] current = new int[n];

            for(int j = 0; j < n; j++) {

                current[j] = Integer.MAX_VALUE;

                // If left top path exists
                if(j > 0) {
                    current[j] = Math.min(current[j], dp[j - 1]);
                }

                // Just above path
                current[j] = Math.min(current[j], dp[j]);

                // If right top path exits
                if(j < n - 1) {
                    current[j] = Math.min(current[j], dp[j + 1]);
                }

                current[j] += matrix[i][j];
            }

            dp = current;
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            res = Math.min(res, dp[i]);
        }

        return res;
    }

    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {

                dp[i][j] = Integer.MAX_VALUE;

                if(j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }

                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

                if(j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                }

                dp[i][j] += matrix[i][j];
            }
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }

        return res;
    }
}
