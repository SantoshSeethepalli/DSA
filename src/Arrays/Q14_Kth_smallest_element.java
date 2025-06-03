package Arrays;

public class Q14_Kth_smallest_element {
    private static int findSortedIndex(int numIndex, int[] arr, int start, int end) {
        int res = 0;
        int num = arr[numIndex];

        for(int i = start; i <= end; i++) {
            if(numIndex == i) continue;

            if(arr[i] < num) {
                res++;
            }
        }

        return start + res;
    }

    private static void partialSortTheArrayAroundPivot(int pivotIndex, int[] arr, int start, int end) {
        int pivot = arr[pivotIndex];

        int i = start;
        int j = pivotIndex + 1;

        while(i < pivotIndex && j <= end) {
            while(i < pivotIndex && arr[i] <= pivot) {
                i++;
            }
            while(j <= end && arr[j] > pivot) {
                j++;
            }

            if (i < pivotIndex && j <= end) {
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
    }

    private static int kthSmallestHelper(int[] arr, int start, int end, int k) {
        if(start > end) {
            return -1;
        }

        int i = start;
        int sortedIndex = findSortedIndex(i, arr, start, end);

        // Swap arr[i] and arr[sortedIndex]
        int temp = arr[sortedIndex];
        arr[sortedIndex] = arr[i];
        arr[i] = temp;

        partialSortTheArrayAroundPivot(sortedIndex, arr, start, end);

        int nThSmallestElement = sortedIndex - start + 1;

        if(nThSmallestElement == k) {
            return arr[sortedIndex];
        } else if(nThSmallestElement < k) {
            return kthSmallestHelper(arr, sortedIndex + 1, end, k - nThSmallestElement);
        }
        return kthSmallestHelper(arr, start, sortedIndex - 1, k);

    }

    public static int kthSmallest(int[] arr, int k) {
        return kthSmallestHelper(arr, 0, arr.length - 1, k);
    }
}
