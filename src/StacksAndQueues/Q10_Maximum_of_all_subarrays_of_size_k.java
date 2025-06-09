package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q10_Maximum_of_all_subarrays_of_size_k {

    static class Data {
        private final int index;
        private final int value;

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }

        // Getters
        int getIndex() {
            return index;
        }
        int getValue() {
            return value;
        }
    }

    static void addToMaxQueue(Data data, Deque<Data> maxQueue, int k) {
        // keep on Polling data from last if its value is less than current data:
        while(!maxQueue.isEmpty() && data.getValue() > maxQueue.peekLast().getValue()) {
            maxQueue.pollLast();
        }

        // add current data:
        maxQueue.addLast(data);

        // remove elements which are out of bounds:
        int windowLeftBound = data.getIndex() - k + 1;

        if(maxQueue.peekFirst().getIndex() < windowLeftBound) {
            maxQueue.pollFirst();
        }
    }

    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {

        ArrayList<Integer> maxElementsInEachKWindow = new ArrayList<>();

        Deque<Data> maxQueue = new ArrayDeque<>();

        for(int currentIndex = 0; currentIndex < arr.length; currentIndex++) {
            addToMaxQueue(new Data(currentIndex, arr[currentIndex]), maxQueue, k);

            if(!maxQueue.isEmpty() && currentIndex >= (k - 1)) {
                maxElementsInEachKWindow.add(maxQueue.peekFirst().getValue());
            }
        }

        return maxElementsInEachKWindow;
    }
}
