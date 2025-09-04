package DynamicProgramming.Striver.DP_On_Stocks;

public class BSS_Five {

    public int stockBuySell(int[] arr, int n, int fee) {

        int[][] dp = new int[n + 1][2];

        for(int i = n - 1; i >= 0; i--) {
            for(int stockInTransit = 0; stockInTransit <= 1; stockInTransit++) {

                int ans = 0;
                if(stockInTransit == 0) {
                    int buyToday = dp[i + 1][1] - arr[i];
                    int skipToday = dp[i + 1][0]; // its zero - '0' the next day becasue we didnt bought today

                    ans = Math.max(buyToday, skipToday);
                }

                if(stockInTransit == 1) {
                    int sellToday = dp[i + 1][0] + arr[i] - fee;
                    int holdBackward = dp[i + 1][1];

                    ans = Math.max(sellToday, holdBackward);
                }

                dp[i][stockInTransit] = ans;
            }
        }

        return dp[0][0];
    }
}
