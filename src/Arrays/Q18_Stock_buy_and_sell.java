package Arrays;

public class Q18_Stock_buy_and_sell {
//    int stockBuySell(int[] arr) {
//        int n = arr.length;
//
//        int costPrice = arr[0];
//        int maxProfitWithCurentStocks = 0;
//        int profit = 0;
//
//        for(int i = 1; i < n; i++) {
//            if(arr[i] < costPrice) {
//                costPrice = arr[i];
//                profit += (maxProfitWithCurentStocks);
//                maxProfitWithCurentStocks = 0;
//                continue;
//            }
//
//            int profitForSellingToday = arr[i] - costPrice;
//            maxProfitWithCurentStocks = Math.max(maxProfitWithCurentStocks, profitForSellingToday);
//        }
//
//        profit += maxProfitWithCurentStocks;
//
//        return profit;
//    }

    int stockBuySell(int[] arr) {
        int n = arr.length;
        int[] profits = new int[n]; // has profit when bought yesterday, if loss then zero
        int totalProfit = 0;

        for(int i = 1; i < n; i++) {
            int yesterdayCost = arr[i - 1];
            int todayCost = arr[i];

            if(todayCost < yesterdayCost) {
                continue;
            }
            int diff = todayCost - yesterdayCost;
            profits[i] = diff;
        }

        for(int profit : profits) {
            totalProfit += profit;
        }

        return totalProfit;
    }
}
