package DynamicProgramming.Striver.DP_On_SubSequences;

import java.util.*;

public class RodCutting {

    private int findRodCuttingPrice(int idx, int remLength, int[] prices, int[][] dp) {

        if(idx == prices.length) return 0;
        if(remLength == 0) return 0;

        if(dp[idx][remLength] != -1) return dp[idx][remLength];

        int skip = findRodCuttingPrice(idx + 1, remLength, prices, dp);

        int pick = Integer.MIN_VALUE;
        if(remLength >= idx + 1) {

            pick = prices[idx] + findRodCuttingPrice(idx, remLength - (idx + 1), prices, dp);
        }

        return dp[idx][remLength] = Math.max(skip, pick);
    }

    public int RodCutting(int prices[], int n) {

        int[][] dp = new int[n][n + 1];

        for(int[] arr : dp) {

            Arrays.fill(arr, -1);
        }

        return findRodCuttingPrice(0, n, prices, dp);
    }

    public int RodCuttingTabulation(int[] prices, int n) {

        int rodLength = n;
        int[][] dp = new int[n][rodLength + 1];

        for(int length = 1; length <= rodLength; length++) {

            dp[0][length] = prices[0] + dp[0][length - 1];
        }

        for(int idx = 1; idx < n; idx++) {
            for(int length = 0; length <= rodLength; length++) {

                int noCut = dp[idx - 1][length];

                int cut = Integer.MIN_VALUE;
                if(length >= idx + 1) {

                    cut = prices[idx] + dp[idx][length - (idx + 1)];
                }

                dp[idx][length] = Math.max(cut, noCut);
            }
        }

        return dp[n - 1][rodLength];
    }
}
