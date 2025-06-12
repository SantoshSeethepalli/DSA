package Trees;

public class Q14_Number_of_leaf_nodes {

    private int NUMBER_OF_LEAVES = 0;

    int countLeaves(Node node) {

        findNumberOfLeaves(node);

        return NUMBER_OF_LEAVES;
    }

    private void findNumberOfLeaves(Node root) {

        if(root.left == null && root.right == null) {

            NUMBER_OF_LEAVES += 1;
            return;
        }

        if(root.left != null) findNumberOfLeaves(root.left);

        if(root.right != null) findNumberOfLeaves(root.right);
    }
}
