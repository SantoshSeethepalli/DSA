package Arrays;

import java.util.*;

public class Q5_Merge_two_arrays {
    public void mergeArrays(int[] a, int[] b) {
        int aPointerEnd = a.length - 1;
        int bPointerStart = 0;

        while (aPointerEnd >= 0 && bPointerStart < b.length) {

            if (a[aPointerEnd] > b[bPointerStart]) {
                swap(a, aPointerEnd, b, bPointerStart);

                aPointerEnd--;
                bPointerStart++;
            }
            else {

                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    private void swap(int[] a, int i, int[] b, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}


// a = [1, 3, 5, 6, 10, 15, 20]
// b = [0, 2, 8, 13]

/*
[1, 3, 4, 6, 10, 15, 0]     [20, 2, 8, 13]
[1, 3, 4, 6, 10, 2, 0]      [20, 15, 8, 13]
[1, 3, 4, 6, 8, 2, 0]       [20, 15, 10, 13]
Sort:
[0, 1, 2, 3, 4, 6, 8]       [8, 13, 15, 20]
*/
// } Driver Code Ends