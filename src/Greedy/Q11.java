package Greedy;

import java.util.*;

public class Q11 {

    private static int getCostWithOffer(int[] candies, int K) {

        int purchasePointer = 0;
        int offerPointer = candies.length;

        int cost = 0;

        while(purchasePointer < offerPointer) {

            cost += candies[purchasePointer];

            purchasePointer++;
            offerPointer -= K;
        }

        return cost;
    }

    static ArrayList<Integer> candyStore(int candies[], int N, int K) {

        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(candies);

        res.add(getCostWithOffer(candies, K));

        // Reverse the array:
        for(int i = 0; i < (N / 2); i++) {
            int temp = candies[i];
            candies[i] = candies[N - i - 1];
            candies[N - i - 1] = temp;
        }

        res.add(getCostWithOffer(candies, K));

        return res;
    }
}
