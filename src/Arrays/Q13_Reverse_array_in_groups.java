package Arrays;

import java.util.ArrayList;

public class Q13_Reverse_array_in_groups {
    void reverseInGroups(ArrayList<Long> arr, int k) {
        int n = arr.size();

        for(int i = 0; i < n; i += k) {

            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while(left < right) {
                // swap arr[left], arr[right]
                long temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);

                left++;
                right--;
            }
        }
    }
}
