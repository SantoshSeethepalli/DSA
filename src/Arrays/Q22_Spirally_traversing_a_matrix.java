package Arrays;

import java.util.ArrayList;

public class Q22_Spirally_traversing_a_matrix {
    public static ArrayList<Integer> spirallyTraverse(int[][] arr) {
        int left = 0;
        int right = arr[0].length - 1;
        int top = 0;
        int bottom = arr.length - 1;

        ArrayList<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                res.add(arr[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                res.add(arr[i][right]);
            }
            right--;

            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(arr[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    res.add(arr[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}
