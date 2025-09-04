package DynamicProgramming.Striver.DP_On_Grids;

/*
Given a 2d integer array named triangle with n rows. Its first row has 1 element and each succeeding row has
one more element in it than the row above it. Return the minimum falling path sum from the first row to the last.
Movement is allowed only to the bottom or bottom-right cell from the current cell.
*/

public class TriangleMinPath {

    public int minTriangleSum(int[][] triangle) {

        int n = triangle.length;

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < (i + 1); j++) {

                int min = Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]);

                triangle[i][j] += min;
            }
        }

        return triangle[0][0];
    }
}
