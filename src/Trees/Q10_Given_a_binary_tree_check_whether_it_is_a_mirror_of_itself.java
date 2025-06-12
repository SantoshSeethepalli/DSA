package Trees;

public class Q10_Given_a_binary_tree_check_whether_it_is_a_mirror_of_itself {
    public boolean isSymmetric(Node root) {
        return findIfTreeIsSymmetric(root.left, root.right);
    }

    private boolean findIfTreeIsSymmetric(Node node1, Node node2) {

        if(node1 == null && node2 == null) return true;

        if(node1 == null || node2 == null) return false;


        if(node1.data != node2.data) return false;

        boolean leftSubTreeCheck = findIfTreeIsSymmetric(node1.left, node2.right);
        boolean rightSubTreeCheck = findIfTreeIsSymmetric(node1.right, node2.left);

        return leftSubTreeCheck && rightSubTreeCheck;
    }
}
