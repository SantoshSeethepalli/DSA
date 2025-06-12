package Trees;

public class Q13_Diameter_of_a_Binary_Tree {

    private int MAX_DIAMETER = 0;

    int diameter(Node root) {

        findDistance(root);

        return MAX_DIAMETER;
    }

    private int findDistance(Node node) {
        if(node == null) return 0;

        if(node.left == null && node.right == null) return 1;

        int leftDistance = findDistance(node.left);
        int rightDistance = findDistance(node.right);

        // LeftDistance, RightDistance includes the edge between currentNode so no need for +1 in currentDiameter:
        // Imagine currentNode.left is leaf node then, above we are getting 1 from that function call so it is the link between currentNode and currentNode.left
        int currentDiameter = leftDistance + rightDistance;

        MAX_DIAMETER = Math.max(MAX_DIAMETER, currentDiameter);

        return Math.max(leftDistance, rightDistance) + 1;
    }
}
