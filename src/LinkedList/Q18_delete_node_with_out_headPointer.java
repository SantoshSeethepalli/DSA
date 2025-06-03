package LinkedList;


// Interestingly by this we can observer that the

public class Q18_delete_node_with_out_headPointer {
    void deleteNode(Node delNode) {
        Node nextNode = delNode.next;

        // Copy next node's data into delNode
        delNode.data = nextNode.data;

        // link delNode and nextNodes next
        delNode.next = nextNode.next;

        // dereference next node
        nextNode.next = null;
    }
}
