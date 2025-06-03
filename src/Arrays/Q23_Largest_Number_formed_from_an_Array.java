package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Q23_Largest_Number_formed_from_an_Array {
    private void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    String findLargest(int[] arr) {

        int n = arr.length;
        List<String> strArray = new ArrayList<>();
        long sum = 0;

        for(int num : arr) {
            strArray.add(Integer.toString(num));
            sum += (long) num;
        }

        if(sum == 0) {
            return "0";
        }

        strArray.sort((a, b) -> (b + a).compareTo(a + b));

        StringBuilder res = new StringBuilder();

        for(String s : strArray) {
            res.append(s);
        }

        return res.toString();
    }
}
