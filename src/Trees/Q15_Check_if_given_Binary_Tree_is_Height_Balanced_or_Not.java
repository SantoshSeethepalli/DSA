package Trees;

public class Q15_Check_if_given_Binary_Tree_is_Height_Balanced_or_Not {

    // Absolute Height Difference should be '<= 1', "for all the nodes":
    private int height(Node node) {

        if(node == null) return -1;

        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public boolean isBalanced(Node root) {

        if(root == null) return true;

        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;

        int diff = Math.abs(leftHeight - rightHeight);

        if(diff <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return false;
    }
}
