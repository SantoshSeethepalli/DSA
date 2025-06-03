package Arrays;

public class Q8_Inversion_of_array {
    public static int inversionCount(int arr[]) {
        return sort(arr, 0, arr.length - 1);
    }
    private static int sort(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int count = 0;

        count += sort(arr, left, mid);
        count += sort(arr, mid + 1, right);

        count += merge(arr, left, mid, right);

        return count;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] arr1 = new int[mid - left + 1];
        int[] arr2 = new int[right - mid];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[left + i];
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int arrPointer = left;

        // counter for inversion
        int count = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr[arrPointer++] = arr1[i++];
            } else {
                arr[arrPointer++] = arr2[j++];
                count += (arr1.length - i);
            }
        }

        while (i < arr1.length) {
            arr[arrPointer++] = arr1[i++];
        }

        while (j < arr2.length) {
            arr[arrPointer++] = arr2[j++];
        }

        return count;
    }
}
