package DynamicProgramming.Striver.DP_On_Stocks;

public class BSS_One {

    public int stockBuySellVersionOne(int[] arr, int n) {

        int minimumInTheLeftSubArray = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int currentCost : arr) {
            if (currentCost < minimumInTheLeftSubArray) {
                minimumInTheLeftSubArray = currentCost;
                continue;
            }

            maxProfit = Math.max(maxProfit, currentCost - minimumInTheLeftSubArray);
        }

        return maxProfit;
    }
}
