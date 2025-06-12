package Trees;

public class Q2_Check_For_BST {
    public boolean isValidBST(Node root) {
        return BSTChecker(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean BSTChecker(Node root, Long min, Long max) {
        if(root == null) return true;

        if(root.data <= min || root.data >= max) return false;

        boolean isLeftSubTreeBST = BSTChecker(root.left, min, (long) root.data);
        boolean isRightSubTreeBST = BSTChecker(root.right, (long) root.data, max);

        return isLeftSubTreeBST && isRightSubTreeBST;
    }
}
