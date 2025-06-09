package StacksAndQueues;

import java.util.*;

public class Q2_Next_Greater_Element {
    // Optimized approach using stack
    public ArrayList<Integer> optimizedNextLargerElement(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> nextLargerElementToTheRightList = new ArrayList<>();
        Stack<Integer> localMaxFromRight = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!localMaxFromRight.isEmpty() && arr[i] >= localMaxFromRight.peek()) {
                localMaxFromRight.pop();
            }

            int nextLargerElementToTheRight = -1;
            if (!localMaxFromRight.isEmpty()) {
                nextLargerElementToTheRight = localMaxFromRight.peek();
            }

            nextLargerElementToTheRightList.add(nextLargerElementToTheRight);

            localMaxFromRight.add(arr[i]);
        }

        Collections.reverse(nextLargerElementToTheRightList);

        return nextLargerElementToTheRightList;
    }

    // Brute-Force
    public ArrayList<Integer> nextLargerElement(int[] arr) {

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            int val = arr[i];

            for (int j = i; j < arr.length; j++) {
                if (arr[j] > val) {
                    val = arr[j];
                    break;
                }
            }

            if (val == arr[i]) {
                val = -1;
            }
            res.add(val);
        }

        return res;
    }
}

