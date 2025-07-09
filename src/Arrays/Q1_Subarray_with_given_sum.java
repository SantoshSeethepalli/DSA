package Arrays;

import java.util.*;

public class Q1_Subarray_with_given_sum {
    static ArrayList<Integer> getListWithGivenIndices(int left, int right) {

        if(left > right) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();

        result.add(left + 1);
        result.add(right + 1);

        return result;
    }

    static ArrayList<Integer> getListWithDefaultReturnValue() {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(-1);

        return result;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int target) {

        int sum = 0;
        int left = 0;

        for(int right = 0; right < arr.length; right++){
            //Increment the sum with array element at right index
            sum += arr[right];

            // if sum found strictly greater than target shrink the window from left
            while(sum > target) {
                sum -= arr[left];
                left++;
            }

            // if a valid window found return this window
            if(sum == target) {
                return Q1_Subarray_with_given_sum.getListWithGivenIndices(left, right);
            }

        }

        return Q1_Subarray_with_given_sum.getListWithDefaultReturnValue();
    }
}