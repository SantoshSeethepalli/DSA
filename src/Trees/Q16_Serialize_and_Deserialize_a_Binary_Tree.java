package Trees;

import java.util.*;

public class Q16_Serialize_and_Deserialize_a_Binary_Tree {

    ArrayList<Integer> arr = new ArrayList<>();

    public ArrayList<Integer> serialize(Node root) {

        Queue<Node> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.offer(root);

            while (!levelOrderQueue.isEmpty()) {

                Node currentNode = levelOrderQueue.poll();

                if (currentNode != null) levelOrderQueue.offer(currentNode.left);

                if (currentNode != null) levelOrderQueue.offer(currentNode.right);

                int data = (currentNode != null) ? currentNode.data : -1;
                arr.add(data);
            }

        return arr;
    }

    public void printSerializedTree() {

        for (Integer nodeValue : arr) {
            System.out.print(nodeValue + " ");
        }
    }


    public Node deSerialize(ArrayList<Integer> arr) {

        Queue<Node> levelOrderQueue = new LinkedList<>();

        int pointer = 1;
        Node root = new Node(arr.get(pointer++));

        levelOrderQueue.offer(root);

        while(!levelOrderQueue.isEmpty()) {

            Node currentNode = levelOrderQueue.poll();

            if(arr.get(pointer) != -1) {

                Node leftNode = new Node(arr.get(pointer));
                currentNode.left = leftNode;

                levelOrderQueue.offer(leftNode);
            }

            pointer++;

            if(arr.get(pointer) != -1) {

                Node rightNode = new Node(arr.get(pointer));
                currentNode.right = rightNode;

                levelOrderQueue.offer(rightNode);
            }

            pointer++;
        }

        return root;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.right.left = new Node(4);
        a.right.right = new Node(5);

        Q16_Serialize_and_Deserialize_a_Binary_Tree q = new Q16_Serialize_and_Deserialize_a_Binary_Tree();
        q.serialize(a);

        q.printSerializedTree();
    }
}
