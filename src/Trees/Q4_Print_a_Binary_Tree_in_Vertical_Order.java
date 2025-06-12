package Trees;

import java.util.*;

public class Q4_Print_a_Binary_Tree_in_Vertical_Order {

    private static void putCurrentNodeInMap(final int currentData, final int currentIndex, Map<Integer, ArrayList<Integer>> map) {

        if(map.containsKey(currentIndex)) {
            ArrayList<Integer> list = map.get(currentIndex);

            list.add(currentData);

            map.put(currentIndex, list);
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        Map<Integer, ArrayList<Integer>> indexToLatestNodeMapper = new HashMap<>();
        Queue<DataAndNodePair> levelOrderQueue = new LinkedList<>();

        levelOrderQueue.offer(new DataAndNodePair(0, root));

        ArrayList<Integer> firstLevel = new ArrayList<>();
        firstLevel.add(root.data);

        indexToLatestNodeMapper.put(0, firstLevel);

        int minIndex = 0;
        int maxIndex = 0;

        // Loop continues until all the nodes are traversed:
        while(!levelOrderQueue.isEmpty()) {

            DataAndNodePair currentDataAndNodePair = levelOrderQueue.poll();

            // Get Node and Index form Data:
            int currentIndex = currentDataAndNodePair.index;
            Node currentNode = currentDataAndNodePair.node;

            // Put this data into the map:
            putCurrentNodeInMap(currentNode.data, currentIndex, indexToLatestNodeMapper);

            // Compute MIN, MAX indexes
            if(currentIndex < 0) minIndex = Math.min(minIndex, currentIndex);
            else maxIndex = Math.max(maxIndex, currentIndex);

            // Offer Child Nodes to the Queue:
            if(currentNode.left != null) {
                levelOrderQueue.offer(new DataAndNodePair(currentIndex - 1, currentNode.left));
            }
            if(currentNode.right != null) {
                levelOrderQueue.offer(new DataAndNodePair(currentIndex + 1, currentNode.right));
            }
        }

        ArrayList<ArrayList<Integer>> verticalOrderList = new ArrayList<>();

        for(int itr = minIndex; itr <= maxIndex; itr++) {

            ArrayList<Integer> listAtThisIndex = indexToLatestNodeMapper.get(itr);

            verticalOrderList.add(listAtThisIndex);
        }

        return verticalOrderList;
    }
}
