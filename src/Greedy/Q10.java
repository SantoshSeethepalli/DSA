package Greedy;

import java.util.*;

public class Q10 {

    /*
     This is my approach, this NOT GREEDY, may get weight for MST for some graphs but not for all.

                  0
                 / \
             (100)  (1)
              /       \
             1 __(3)__ 2

             in this my approach will add 1 into queue first then 2.

             which will result in answer=101 which is wrong, as 4 is the weight of MST,
             so we need to use priorityQueue(MIN_HEAP) which is based on weights(GREEDY step).
     */
    static int mySpanningTreeApproach(int V, int E, List<List<int[]>> adj) {

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int[] leastWeightedPaths = new int[V];
        Arrays.fill(leastWeightedPaths, Integer.MAX_VALUE);
        leastWeightedPaths[0] = 0;

        while(!queue.isEmpty()) {

            int currentNode = queue.poll();
            List<int[]> currentAdjacencyList = adj.get(currentNode);

            for(int[] arr : currentAdjacencyList) {

                int nextNode = arr[0];
                if(visited.contains(nextNode)) continue;

                leastWeightedPaths[nextNode] = Math.min(arr[1], leastWeightedPaths[nextNode]);
                queue.add(nextNode);
            }

            visited.add(currentNode);
        }

        return Arrays.stream(leastWeightedPaths).sum();
    }

    static int spanningTreeGreedy(int V, int E, List<List<int[]>> adj) {

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{0, 0});

        int mstWeight = 0;

        while(!queue.isEmpty()) {

            int[] top = queue.poll();

            int currentNode = top[0];
            int currentWeight = top[1];

            if(visited.contains(currentNode)) continue;

            mstWeight += currentWeight;

            for(int[] neighbour : adj.get(currentNode)) {

                if(!visited.contains(neighbour[0])) {

                    queue.offer(new int[]{neighbour[0], neighbour[1]});
                }
            }

            visited.add(currentNode);
        }

        return mstWeight;
    }
}
