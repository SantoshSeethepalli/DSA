package DynamicProgramming.Striver.DP_On_Stocks;

public class BSS_Two {

    public int stockBuySellVersionTwo(int[] arr, int n) {

        int[] profits = new int[n];

        for (int i = 1; i < n; i++) {

            int todayCost = arr[i];
            int yesterdayCost = arr[i - 1];

            if (yesterdayCost < todayCost) {
                profits[i] = todayCost - yesterdayCost;
            }
        }

        int totalProfits = 0;

        for (int profit : profits) {
            totalProfits += profit;
        }

        return totalProfits;
    }


    // Tabulation
    public int stockBuySell(int[] arr, int n) {

        int[][] dp = new int[n + 1][2];

        for(int i = n - 1; i >= 0; i--) {
            for(int stockInTransit = 0; stockInTransit <= 1; stockInTransit++) {

                int ans = 0;
                if(stockInTransit == 0) {
                    int buyToday = dp[i + 1][1] - arr[i];
                    int dontBuyToday = dp[i + 1][0]; // its zero - '0' the next day because we didn't buy today

                    ans = Math.max(buyToday, dontBuyToday);
                }

                if(stockInTransit == 1) {
                    int sellToday = dp[i + 1][0] + arr[i];
                    int dontSellToday = dp[i + 1][1];

                    ans = Math.max(sellToday, dontSellToday);
                }

                dp[i][stockInTransit] = ans;
            }
        }

        return dp[0][0];
    }
}
