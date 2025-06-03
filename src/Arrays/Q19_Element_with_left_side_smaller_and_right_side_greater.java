package Arrays;

public class Q19_Element_with_left_side_smaller_and_right_side_greater {
    public int findElement(int[] arr) {
        int n = arr.length;;
        int[] maxFromLeft = new int[n];
        maxFromLeft[0] = arr[0];

        for(int i = 1; i < n; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], arr[i]);
        }

        int[] minFromRight = new int[n];
        minFromRight[n - 1] = arr[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            minFromRight[i] = Math.min(arr[i], minFromRight[i + 1]);
        }

        for(int i = 1; i < n - 1; i++) {
            if(minFromRight[i] == maxFromLeft[i]) {
                return arr[i];
            }
        }

        return -1;
    }
}
