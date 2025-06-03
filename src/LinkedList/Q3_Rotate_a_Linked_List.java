package LinkedList;

/*
Given the head of a singly linked list, your task is to left rotate the linked list k times.
*/

public class Q3_Rotate_a_Linked_List {

    private Node getKthNode(Node head, int k, Node end) {

        if(k == 0) {
            return end;
        }

        for(int i = 1; i < k; i++) {
            head = head.next;
        }

        return head;
    }

    public Node rotate(Node head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        Node start = head;
        Node middle = null;
        Node end = head;

        Node temp = head;
        int size = 0;

        // Compute end and size
        while(temp != null) {
            size++;

            end = temp;
            temp = temp.next; // move forward
        }

        // Compute middle
        temp = head;
        middle = getKthNode(temp, k % size, end);

        // Link end and start
        end.next = start;

        head = middle.next;

        middle.next = null;

        return head;
    }
}
