package LinkedList;

/*
Given the head a linked list, the task is to reverse every k node in the linked list.
If the number of nodes is not a multiple of k then the left-out nodes in the end,
should be considered as a group and must be reversed.
*/

public class Q4_Reverse_a_Linked_List_in_groups_of_given_size {
    public static Node reverseKGroup(Node head, int k) {
        if(head == null) {
            return null;
        }

        int count = 0;
        Node previous = null;
        Node current = head;

        while(count < k && current != null) {
            count++;

            Node next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        head.next = reverseKGroup(current, k);

        return previous;
    }
}
