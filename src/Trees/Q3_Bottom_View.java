package Trees;

import java.util.*;

public class Q3_Bottom_View {

    public ArrayList<Integer> bottomView(Node root) {

        Map<Integer, Node> indexToLatestNodeMapper = new HashMap<>();
        Queue<DataAndNodePair> levelOrder = new LinkedList<>();

        levelOrder.offer(new DataAndNodePair(0, root));
        indexToLatestNodeMapper.put(0, root);

        int minIndex = 0;
        int maxIndex = 0;

        // Loop continues until all the nodes are traversed:
        while(!levelOrder.isEmpty()) {

            DataAndNodePair currentDataAndNodePair = levelOrder.poll();

            // Get Node and Index form Data:
            int currentIndex = currentDataAndNodePair.index;
            Node currentNode = currentDataAndNodePair.node;

            // Put this data into the map:
            indexToLatestNodeMapper.put(currentIndex, currentNode);

            // Compute MIN, MAX indexes
            if(currentIndex < 0) minIndex = Math.min(minIndex, currentIndex);
            else maxIndex = Math.max(maxIndex, currentIndex);

            // Offer Child Nodes to the Queue:
            if(currentNode.left != null) {
                levelOrder.offer(new DataAndNodePair(currentIndex - 1, currentNode.left));
            }
            if(currentNode.right != null) {
                levelOrder.offer(new DataAndNodePair(currentIndex + 1, currentNode.right));
            }
        }

        ArrayList<Integer> bottomView = new ArrayList<>();
        for(int itr = minIndex; itr <= maxIndex; itr++) {

            int valueOfTheNodeAtTheBottomForThisIndex = indexToLatestNodeMapper.get(itr).data;

            bottomView.add(valueOfTheNodeAtTheBottomForThisIndex);
        }

        return bottomView;
    }
}
