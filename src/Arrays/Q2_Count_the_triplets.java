package Arrays;

import java.lang.*;
import java.util.*;

//{ Driver Code Starts.

public class Q2_Count_the_triplets {

    int countTriplet(int arr[]) {

        if(arr.length < 3) {
            return 0;
        }
        int numberOfTriplets = 0;
        Set<Integer> hashSet = new HashSet<>();

        for (int number : arr) {
            hashSet.add(number);
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i  + 1; j < arr.length; j++) {

                int tempSum = arr[i] + arr[j];

                if(hashSet.contains(tempSum)) {
                    numberOfTriplets++;
                }

                // To count only once per unique combination: (1, 2, 2, 3) -> only '1' triplet
                while(j < (arr.length - 1) && arr[j + 1] == arr[j]) {
                    j += 1;
                }
            }
            while(arr[i + 1] == arr[i]) {
                i +=  1;
            }
        }
        return numberOfTriplets;
    }
}