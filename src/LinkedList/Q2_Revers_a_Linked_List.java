package LinkedList;

/*
Given the head of a linked list, the task is to reverse this list and return the reversed head.
 */

public class Q2_Revers_a_Linked_List {

    Node reverseList(Node head) {
        Node previous = null;
        Node current = head;

        while(current != null) {
            Node next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }


    Node reverseList3Pointers(Node head) {
        Node previous = null;
        Node current = head;
        Node next = head.next;

        while(current != null) {
            current.next = previous;

            previous = current;
            current = next;
            if(next.next != null) {
                next = next.next;
            }
        }
        return previous;
    }
}
