package Trees;

public class Q11_Height_of_Binary_Tree {

    int height(Node node) {
        if(node == null) return -1;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
