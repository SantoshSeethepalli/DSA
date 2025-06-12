package Trees;

public class Q7_Lowest_Common_Ancestor {

    Node LCA(Node root, final Node n1, final Node n2) {

        if(root == null) return null;
        if(n1 == null || n2 == null) return null;

        if(root == n1 || root == n2) return root;

        // If Root is the root node and n1 and n2 lies in different Sub-Trees(Left & Right):
        if(root.data < n1.data && root.data > n2.data) return root;
        if(root.data > n1.data && root.data < n2.data) return root;

        if(root.data > n1.data) {
            return LCA(root.left, n1, n2);
        }

        return LCA(root.right, n1, n2);
    }
}
