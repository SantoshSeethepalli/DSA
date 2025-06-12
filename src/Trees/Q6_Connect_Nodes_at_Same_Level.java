package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Q6_Connect_Nodes_at_Same_Level {

    public Node connect(Node root) {

        Queue<Node> primaryQueue = new LinkedList<>();
        primaryQueue.offer(root);

        while (!primaryQueue.isEmpty()) {

            Queue<Node> auxilaryQueue = new LinkedList<>();

            while(!primaryQueue.isEmpty()) {

                Node currentNode = primaryQueue.poll();

                if(currentNode.left != null) auxilaryQueue.offer(currentNode.left);
                if(currentNode.right != null) auxilaryQueue.offer(currentNode.right);


                if(!primaryQueue.isEmpty()) currentNode.nexRight = primaryQueue.peek();
            }

            while (!auxilaryQueue.isEmpty()) {
                primaryQueue.offer(auxilaryQueue.poll());
            }

        }

        return root;
    }
}
