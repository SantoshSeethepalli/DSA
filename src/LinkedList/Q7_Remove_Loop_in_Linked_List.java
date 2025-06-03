package LinkedList;

/*
Given the head of a linked list that may contain a loop.
A loop means that the last node of the linked list is connected back to a node in the same list.
The task is to remove the loop from the linked list (if it exists).

Custom Input format:

A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to.
If pos = 0, it means the last node points to null, indicating there is no loop.

The generated output will be true if there is no loop in list and other nodes in the list remain unchanged, otherwise, false.
*/

public class Q7_Remove_Loop_in_Linked_List {

    public static void removeLoop(Node head) {
        if(head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        boolean isLoopPresent = false;

        // find if loop is present
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                isLoopPresent = true;
                break;
            }
        }

        if(isLoopPresent) {

            // find starting point of loop
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            // find node that points to start of loop
            while (fast.next != slow) {
                fast = fast.next;
            }

            fast.next = null;
        }
    }


}
