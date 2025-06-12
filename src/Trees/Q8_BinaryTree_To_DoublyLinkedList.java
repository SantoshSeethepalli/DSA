package Trees;

public class Q8_BinaryTree_To_DoublyLinkedList {

    Node bToDLL(Node root) {
        return getDoublyLinkedList(root);
    }

    private Node getDoublyLinkedList(Node currentNode) {

        if(currentNode == null) return null;

        Node leftSubList = null;
        Node rightSubList = null;

        if(currentNode.left != null) {
            leftSubList = getDoublyLinkedList(currentNode.left);
        }
        if(currentNode.right != null) {
            rightSubList = getDoublyLinkedList(currentNode.right);
        }


        Node rightEndPointerOfLeftSubList = leftSubList;
        while(rightEndPointerOfLeftSubList != null
                && rightEndPointerOfLeftSubList.right != null) {

            rightEndPointerOfLeftSubList = rightEndPointerOfLeftSubList.right;
        }

        if(rightEndPointerOfLeftSubList != null) {

            rightEndPointerOfLeftSubList.right = currentNode;
            currentNode.left = rightEndPointerOfLeftSubList;

        } else {

            leftSubList = currentNode;
        }

        currentNode.right = rightSubList;

        if(rightSubList != null) {
            rightSubList.left = currentNode;
        }

        return leftSubList;
    }
}
