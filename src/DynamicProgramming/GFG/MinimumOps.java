package DynamicProgramming.GFG;

public class MinimumOps {

    // https://www.geeksforgeeks.org/problems/find-optimum-operation4504/1
    public int minOperation(int n) {

        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {

            int addOneWay = dp[i - 1];
            int doubleWay = (i % 2 == 0) ? dp[i / 2] : Integer.MAX_VALUE;

            dp[i] = Math.min(addOneWay, doubleWay) + 1;
        }

        return dp[n];
    }
}
