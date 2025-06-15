package Heaps;

import java.util.*;

public class Q2_HeapSort {
    public void heapSort(int[] arr) {

        PriorityQueue<Integer> heapForSorting = new PriorityQueue<>();

        for(int number : arr) {
            heapForSorting.offer(number);
        }

        int idx = 0;

        while(!heapForSorting.isEmpty()) {
            arr[idx++] = heapForSorting.poll();
        }
    }
}
