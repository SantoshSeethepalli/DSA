package Arrays;

public class Q20_Convert_array_into_Zig_Zag_fashion {
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void zigZag(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n - 1; i++) {

            // even index should be less than surrounding odd indexes.
            if(i % 2 == 0) {
                if(arr[i] > arr[i + 1]) {  // if decreasing -- swap
                    swap(arr, i, i + 1);
                }
            }
            else {
                if(arr[i] < arr[i + 1]) { // if increasing -- swap
                    swap(arr, i, i + 1);
                }
            }
        }
    }
}
