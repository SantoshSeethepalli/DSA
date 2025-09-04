package Arrays;

// Kadane's Algorithm
public class Q3_Kadanes_Algorithm {
    int maxSubarraySum(int[] arr) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int idx = 0; idx < arr.length; idx++) {

            sum += arr[idx];
            maxSum = Math.max(sum, maxSum);

            if(sum < 0) {

                sum = 0;
            }
        }

        return maxSum;
    }
}

// } Driver Code Ends