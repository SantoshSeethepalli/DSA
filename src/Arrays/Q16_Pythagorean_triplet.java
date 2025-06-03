package Arrays;

import java.util.HashSet;

public class Q16_Pythagorean_triplet {
    boolean pythagoreanTriplet(int[] arr) {
        HashSet<Integer> squaredValues = new HashSet<>();

        for(int num : arr) {
            squaredValues.add(num * num);
        }

        for(int i = 0; i < arr.length - 1; i++) {
            int aSquare = arr[i] * arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                int bSquare = arr[j] * arr[j];

                int cSquare = aSquare + bSquare;

                if(squaredValues.contains(cSquare)) {
                    return true;
                }
            }
        }

        return false;
    }
}
