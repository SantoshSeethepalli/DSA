package Hashing;

import java.util.*;

public class Q6 {

    boolean findSwapValues(int[] a, int[] b) {

        int firstArraySum = 0;
        int secondArraySum = 0;

        Set<Integer> elementsInB = new HashSet<>();

        // Loop to compute elementsInB and sums:
        for(int number : a) {

            firstArraySum += number;
        }

        for(int number : b) {

            secondArraySum += number;
            elementsInB.add(number);
        }

        // If sums equal return true:
        if(firstArraySum == secondArraySum) return true;

        // If the sum it is not possible to find the pair:
        if((secondArraySum - firstArraySum) % 2 != 0) return false;

        int target = ((secondArraySum - firstArraySum)) / 2;
        for(int num : a) {

            if(elementsInB.contains(target + num)) return true;
        }

        return false;
    }
}
