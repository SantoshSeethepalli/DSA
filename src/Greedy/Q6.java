package Greedy;

public class Q6 {

    // Optimal Approach:
    static String findLargestOptimal(int n, int s) {

        if(s > 9 * n) return "-1";
        if(s == 0) return (n == 1) ? "0" : "-1";

        StringBuilder number = new StringBuilder();

        for(int i = 0; i < n; i++) {

            int digit = Math.min(9, s);
            number.append(digit);
            s = s - digit;
        }

        return number.toString();
    }


    // My Approach:
    static String findLargest(int n, int s) {

        if(s > 9 * n) return "-1";
        if(s == 0 && n > 1) return new String("-1");
        if(n == 1 && s < 10) return Integer.toString(s);

        int[] arr = getLargestNumberArray(n);

        int sum = 9 * n;
        int difference = sum - s;

        getBiggestPossibleNumber(difference, arr);

        StringBuilder number = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            number.append(arr[i]);
        }

        return number.toString();
    }

    static int[] getLargestNumberArray(int n) {

        int[] number = new int[n];

        for(int i = 0; i < n; i++) {
            number[i] = 9;
        }

        return number;
    }

    static void getBiggestPossibleNumber(int reductionValue, int[] arr) {

        for(int i = arr.length - 1; i >= 0; i--) {

            if(reductionValue >= 9) {
                reductionValue -= 9;
                arr[i] = 0;
            } else {
                arr[i] -= reductionValue;
                break;
            }
        }
    }

}
