package Recurssion;

import java.util.LinkedList;
import java.util.Queue;

public class Q5 {

    public int josephus(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        // Add N numbers to queue:
        for(int i = 1; i <= n; i++) queue.add(i);

        int pointer = 0;

        while(queue.size() > 1) {

            pointer++;
            int current = queue.poll();

            // If thhe current element is kth element in circular queue then remove it from queue
            if(pointer % k == 0) continue;

            // push back if its not kth element in the queue
            queue.add(current);
        }

        return !queue.isEmpty() ? queue.peek() : 0;
    }
}
