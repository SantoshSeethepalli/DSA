package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Q17_Chocolate_Distribution_Problem {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i + m - 1 < arr.size(); i++) {
            int currentIndex = i;
            int lastIndex = i + m - 1;

            int currentValue = arr.get(currentIndex);
            int lastValue = arr.get(lastIndex);

            int difference = lastValue - currentValue;

            minDiff = Math.min(minDiff, difference);
        }

        return minDiff;
    }
}
