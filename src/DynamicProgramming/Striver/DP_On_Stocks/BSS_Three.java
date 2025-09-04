package DynamicProgramming.Striver.DP_On_Stocks;

import java.util.*;

public class BSS_Three {


    // 4, 2, 7, 1, 11, 5

    // Recursion + memoization
    private int versionThreeHelperFunction(int[] arr, int idx, int canBuy, int capacity, int[][][] dp) {

        if (capacity == 0 || idx == arr.length) return 0;
        if (dp[idx][canBuy][capacity] != -1) return dp[idx][canBuy][capacity];

        int answer = 0;

        if (canBuy == 1) {

            // buy today -> what is the profit if bought with todays price
            int buyToday = versionThreeHelperFunction(arr, idx + 1, 0, capacity, dp) - arr[idx];
            int skipToday = versionThreeHelperFunction(arr, idx + 1, 1, capacity, dp);

            answer = Math.max(buyToday, skipToday);

        } else {

            int sellToday = versionThreeHelperFunction(arr, idx + 1, 1, capacity - 1, dp) + arr[idx];
            int holdToday = versionThreeHelperFunction(arr, idx + 1, 0, capacity, dp);

            answer = Math.max(sellToday, holdToday);
        }

        dp[idx][canBuy][capacity] = answer;

        return answer;
    }
    public int stockBuySellVersionThree(int[] arr, int n) {

        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return versionThreeHelperFunction(arr, 0, 1, 2, dp);
    }



    // Tabulation
    public int stockBuySell(int[] arr, int n) {

        int[][][] dp = new int[n + 1][2][3];

        for(int i = n - 1; i >= 0; i--) {
            for(int stockInTransit = 0; stockInTransit < 2; stockInTransit++) {
                for(int cap = 1; cap <= 2; cap++) {

                    int ans = 0;

                    if(stockInTransit == 0) {

                        int buyStockToday = dp[i + 1][1][cap] - arr[i];
                        int skipToday = dp[i + 1][0][cap];

                        ans = Math.max(buyStockToday, skipToday);
                    }

                    if(stockInTransit == 1) {
                        int sellToday = dp[i + 1][0][cap - 1] + arr[i];
                        int holdNextMax = dp[i + 1][1][cap];

                        ans = Math.max(sellToday, holdNextMax);
                    }

                    dp[i][stockInTransit][cap] = ans;
                }
            }
        }

        return dp[0][0][2];
    }

}
