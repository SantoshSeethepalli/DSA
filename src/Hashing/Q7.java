package Hashing;

import java.util.*;

public class Q7 {

    ArrayList<Integer> countDistinct(int arr[], int k) {

        ArrayList<Integer> distinctElementsInEachWindow = new ArrayList<>();

        if(k > arr.length) return distinctElementsInEachWindow;

        int left = 0;
        int right = 0;

        Map<Integer, Integer> windowElements = new HashMap<>();

        while(right < arr.length) {

            windowElements.put(arr[right], windowElements.getOrDefault(arr[right], 0) + 1);
            right++;

            if(right >= k) {

                int numberOfDistinctElementsInWindow = windowElements.size();
                distinctElementsInEachWindow.add(numberOfDistinctElementsInWindow);

                int windowLeftNeighbour = arr[left];
                windowElements.put(windowLeftNeighbour, windowElements.get(windowLeftNeighbour) - 1);

                if(windowElements.get(windowLeftNeighbour) == 0) {
                    windowElements.remove(windowLeftNeighbour);
                }

                left++;
            }
        }

        return distinctElementsInEachWindow;
    }
}
