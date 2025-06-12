package LinkedList;

public class DLLNode {
    public int data;
    public DLLNode next;
    public DLLNode previous;

    public DLLNode() {}

    public DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public DLLNode(int data, DLLNode next, DLLNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public static void printList(DLLNode head) {

        while (head != null) {

            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }
}
