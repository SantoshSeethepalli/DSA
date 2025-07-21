package DynamicProgramming.GFG;

public class FindNumberOfPaths {

    public int numberOfPaths(int rows, int coloums) {

        int[][] dp = new int[rows + 1][coloums + 1];

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= coloums; j++) {

                if(i == 1 || j == 1) {

                    dp[i][j] = 1;
                } else {

                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[rows][coloums];
    }
}
