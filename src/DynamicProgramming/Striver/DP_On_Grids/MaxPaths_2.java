package DynamicProgramming.Striver.DP_On_Grids;

/*

Given an m x n 2d array named matrix, where each cell is either 0 or 1. Return the number
of unique ways to go from the top-left cell (matrix[0][0]) to the bottom-right cell (matrix[m-1][n-1]).
A cell is blocked if its value is 1, and no path is possible through that cell.
Movement is allowed in only two directions from a cell - right and bottom.
*/

public class MaxPaths_2 {

    public int uniquePathsWithObstacles(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(matrix[i - 1][j - 1] == 1) {

                    dp[i][j] = 0;
                    continue;
                }

                if(i == 1 && j == 1) continue;

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
