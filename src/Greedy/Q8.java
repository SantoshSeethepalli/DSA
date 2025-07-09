package Greedy;

import java.util.*;

public class Q8 {

    public long minValue(List<Integer> arr1, List<Integer> arr2) {

        Collections.sort(arr1, (a, b) ->  b - a); // descending order
        Collections.sort(arr2); // ascending order

        long product = 0;

        for(int i = 0; i < arr1.size(); i++) {
            product += (long)  (arr1.get(i) * arr2.get(i));
        }

        return product;
    }
}
