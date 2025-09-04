package DynamicProgramming.Striver.DP_On_Grids;

public class CheryPickup_2 {

    public int cherryPickup(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][][] dp = new int[n][m][m];

        for(int leftRobo = 0; leftRobo < m; leftRobo++) {
            for(int rightRobo = 0; rightRobo < m; rightRobo++) {

                if(leftRobo == rightRobo) {

                    dp[n - 1] [leftRobo][rightRobo] = matrix[n - 1][leftRobo];
                    continue;
                }

                dp[n - 1] [leftRobo][rightRobo] = matrix[n - 1][leftRobo] + matrix[n - 1][rightRobo];
            }
        }

        for(int row = n - 2; row >= 0; row--) {
            for(int leftRobo = 0; leftRobo < m; leftRobo++) {
                for(int rightRobo = 0; rightRobo < m; rightRobo++) {

                    dp[row][leftRobo][rightRobo] += matrix[row][leftRobo];

                    if(leftRobo != rightRobo) {
                        dp[row][leftRobo][rightRobo] += matrix[row][rightRobo];
                    }
                    
                    int maximumNextPick = Integer.MIN_VALUE;
                    
                    for(int leftShift = -1; leftShift <= 1; leftShift++) {
                        for(int rightShift = -1; rightShift <= 1; rightShift++) {

                            int nextLeftPickPosition = leftRobo + leftShift;
                            int nextRightPickPosition = rightRobo + rightShift;

                            if(nextLeftPickPosition >= m || nextLeftPickPosition < 0 ||
                                    nextRightPickPosition >= m || nextRightPickPosition < 0) {
                                continue;
                            }

                            maximumNextPick = Math.max(maximumNextPick, dp[row + 1][nextLeftPickPosition][nextRightPickPosition]);
                        }
                    }

                    dp[row][leftRobo][rightRobo] += maximumNextPick;
                }
            }
        }

        return dp[0][0][m - 1];
    }
}
