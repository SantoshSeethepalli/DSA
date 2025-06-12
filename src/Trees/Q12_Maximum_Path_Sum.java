package Trees;

public class Q12_Maximum_Path_Sum {

    private int MAX_SUB_PATH_SUM = Integer.MIN_VALUE;

    int maxPathSum(Node root) {

        int sum = getSumInThePath(root);

        if(root.left == null || root.right == null) {
            MAX_SUB_PATH_SUM = Math.max(MAX_SUB_PATH_SUM, sum);
        }

        return MAX_SUB_PATH_SUM;
    }

    private int getSumInThePath(Node node) {

        if(node == null) return 0;

        if(node.left == null && node.right == null) return node.data;

        int leftSubTreeSum = getSumInThePath(node.left);
        int rightSubTreeSum = getSumInThePath(node.right);

        int subPathSum = leftSubTreeSum + rightSubTreeSum + node.data;

        if(node.left != null && node.right != null) {
            MAX_SUB_PATH_SUM = Math.max(MAX_SUB_PATH_SUM, subPathSum);
            return Math.max(leftSubTreeSum, rightSubTreeSum) + node.data;
        }

        if(node.left == null) return rightSubTreeSum + node.data;

        return leftSubTreeSum + node.data;
    }
}
