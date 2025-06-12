package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q5_Level_order_traversal_in_spiral_form {

    public ArrayList<Integer> findSpiral(Node root) {

        Queue<Node> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.offer(root);

        ArrayList<Integer> levelOrderList = new ArrayList<>();

        boolean isEven = true;

        while(!levelOrderQueue.isEmpty()) {

            Queue<Node> childQueue = new LinkedList<>();

            int count = 0;

            while(!levelOrderQueue.isEmpty()) {

                Node currentNode = levelOrderQueue.poll();

                if (currentNode.left != null) childQueue.offer(currentNode.left);

                if (currentNode.right != null) childQueue.offer(currentNode.right);

                if(isEven && !levelOrderList.isEmpty()) {

                    levelOrderList.add(levelOrderList.size() - count, currentNode.data);
                    count++;
                } else {

                    levelOrderList.add(currentNode.data);
                }
            }

            while(!childQueue.isEmpty()) {
                levelOrderQueue.offer(childQueue.poll());
            }

            isEven = !isEven;
        }

        return levelOrderList;
    }
}
