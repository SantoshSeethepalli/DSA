package Arrays;

public class Q10_Equilibrium_point {
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0;
        int sumTillNow = 0;

        for(int num : arr) {
            totalSum += num;
        }

        for(int i = 1; i < arr.length; i++) {
            sumTillNow += arr[i - 1];

            int remSum = totalSum - arr[i] - sumTillNow;

            if(remSum == sumTillNow) { return i; }
        }

        return -1;
    }
}
