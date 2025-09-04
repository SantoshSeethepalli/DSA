package DynamicProgramming.Striver.DP_On_Grids;

/*
Given two integers m and n, representing the number of rows and columns of a 2d array named matrix.
Return the number of unique ways to go from the top-left cell (matrix[0][0]) to the bottom-right cell (matrix[m-1][n-1]).
 Movement is allowed only in two directions from a cell: right and bottom.
*/

public class MaxPaths_1 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(i == 1 || j == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
