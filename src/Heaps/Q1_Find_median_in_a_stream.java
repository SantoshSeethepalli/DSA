package Heaps;

import java.util.*;

public class Q1_Find_median_in_a_stream {

    public ArrayList<Double> getMedian(final int[] arr) {
        /*
            Left Half is MaxHeap
            Right Half is MinHeap

            Rules:
            - For all values in both the heaps, leftMaxHeap <= rightMinHeap.
            - The size difference is either ZERO or ONE not more than that and leftHeap can only be big.

            Example DryRun:
            arr = {3, 4, 1, 2, 5}

            1st Itr: (Insert 3)
                leftHeap: [3]
                rightHeap: []

            2nd Itr: (Insert 4)
                leftHeap: [4, 3]  --> leftHeap: [3]
                rightHeap: []         rightHeap: [4]

            3rd Itr: (Insert 1)
                leftHeap: [3, 1]
                rightHeap: [4]

            4th Itr: (Insert 2)
                leftHeap: [3, 2, 1] --> leftHeap: [2, 1]
                rightHeap: [4]          rightHeap: [3, 4]

            5th Itr: (Insert 5)
                leftHeap: [5, 2, 1] --> leftHeap: [3, 2, 1]
                rightHeap: [3, 4]       rightHeap: [4, 5] (while loop swaps)

         */

        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

        ArrayList<Double> listOfMedians = new ArrayList<>();

        for(int num : arr) {

            leftMaxHeap.offer(num);

            // The difference in sizes = 0/1
            if(leftMaxHeap.size() >  rightMinHeap.size() + 1) {
                rightMinHeap.offer(leftMaxHeap.poll());
            }

            // to handle (leftMaxHeap <= rightMinHeap)
            if(!rightMinHeap.isEmpty() && !leftMaxHeap.isEmpty()
                    && leftMaxHeap.peek() > rightMinHeap.peek()) {

                int elementWhichShouldBeInRightHalf = leftMaxHeap.poll();
                int elementWhichShouldBeInLeftHalf = rightMinHeap.poll();

                leftMaxHeap.offer(elementWhichShouldBeInLeftHalf);
                rightMinHeap.offer(elementWhichShouldBeInRightHalf);
            }

            listOfMedians.add(getResElement(rightMinHeap, leftMaxHeap));
        }

        return listOfMedians;
    }

    private double getResElement(PriorityQueue<Integer> rightHalf, PriorityQueue<Integer> leftHalf) {

        int totalSize = rightHalf.size() + leftHalf.size();

        int max = (!leftHalf.isEmpty()) ? leftHalf.peek() : 0;
        int min = (!rightHalf.isEmpty()) ? rightHalf.peek() : 0;

        if(totalSize % 2 == 0)
            return (double) (min + max) / 2;

        else
            return max;
    }
}