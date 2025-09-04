package DynamicProgramming.Striver.DP_2D;

public class Ninja {

    /*
        My Word:
            I did hesitate to initially solve this, but stick to the code and do what you feel it will work.

        Similar to the one i solved previously in the Swiggy OA(Gold digger),
        this is vertical while that is horizontal.
     */

    public int ninjaTraining(int[][] matrix) {

        int result = 0;
        int noOfDays = matrix.length;
        int[][] dp = new int[noOfDays][3];

        // Copy 1st row into the dp array - Generate Base values
        for(int j = 0; j < 3; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Start iterating from 2nd row
        for(int i = 1; i < noOfDays; i++) {

            /*
                j -> current activities loop
                k -> previous activities loop

                while standing at j ask the old days what is the best 'other' thing to do in the previous days
            */
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {

                    if(k == j) continue; // Ignore same activity

                    dp[i][j] = Math.max(dp[i][j], matrix[i][j] + dp[i - 1][k]);
                }
            }
        }

        for(int i = 0; i < 3; i++) {

            result = Math.max(result, dp[noOfDays - 1][i]);
        }

        return result;
    }
}
