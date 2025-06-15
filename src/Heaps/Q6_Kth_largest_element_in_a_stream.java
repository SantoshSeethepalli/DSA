package Heaps;

import java.util.PriorityQueue;

public class Q6_Kth_largest_element_in_a_stream {

    private static int getKthLargestElement(PriorityQueue<Integer> heap, int k, int counter) {

        int current = (!heap.isEmpty()) ? heap.poll() : -1;

        counter++;

        if(counter == k) {
            heap.offer(current);
            return current;
        }

        int res = getKthLargestElement(heap, k, counter + 1);

        heap.offer(current);

        return res;
    }

    static int[] kthLargestRecursively(int k, int[] arr, int n) {

        if(k <= 1) return arr;

        int[] res = new int[n];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        for(int i = 0; i < n; i++) {

            maxHeap.offer(arr[i]);

            if(maxHeap.size() >= k) {
                res[i] = getKthLargestElement(maxHeap, k, 0);
            } else {
                res[i] = -1;
            }
        }

        return res;
    }

    static int[] kthLargest(int k, int[] arr, int n) {
        if(k <= 1) return arr;

        int[] res = new int[n];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {

            minHeap.offer(arr[i]);

            if(minHeap.size() > k) minHeap.poll();


            if(minHeap.size() >= k) res[i] = minHeap.peek();
            else res[i] = -1;
        }

        return res;
    }
}
