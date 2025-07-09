package Arrays;

import java.util.*;

public class Q11_Leader_in_an_array {

    static ArrayList<Integer> leaders(int[] arr) {

        ArrayList<Integer> res = new ArrayList<>();

        int n = arr.length;
        int max = arr[n - 1];
        res.add(max);

        for(int i = n - 2; i >= 0; i--) {

            if(arr[i] > max) {

                res.add(arr[i]);
                max = arr[i];
            }
        }

        return res;
    }
}