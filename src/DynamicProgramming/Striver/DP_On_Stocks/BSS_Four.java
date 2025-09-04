package DynamicProgramming.Striver.DP_On_Stocks;

public class BSS_Four {

    public int stockBuySell(int[] arr, int n, int k) {

        int[][][] dp = new int[n + 1][2][k + 1];

        for(int i = n - 1; i >= 0; i--) {
            for(int stockInTransit = 0; stockInTransit <= 1; stockInTransit++) {
                for(int cap = 1; cap <= k; cap++) {

                    int ans = 0;

                    if(stockInTransit == 0) {
                        int buyToday = dp[i + 1][1][cap] - arr[i];
                        int skipToday = dp[i + 1][0][cap];

                        ans = Math.max(buyToday, skipToday);
                    }

                    if(stockInTransit == 1) {
                        int sellToday = dp[i + 1][0][cap - 1] + arr[i];
                        int carryBackward = dp[i + 1][1][cap];

                        ans = Math.max(sellToday, carryBackward);
                    }

                    dp[i][stockInTransit][cap] = ans;
                }
            }
        }

        return dp[0][0][k];
    }
}
