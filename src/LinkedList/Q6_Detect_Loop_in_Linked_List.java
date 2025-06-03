package LinkedList;

/*
You are given the head of a singly linked list. Your task is to determine if the linked list contains a loop.
A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself),
rather than being null.

Custom Input format:
A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to.
If pos = 0, it means the last node points to null, indicating there is no loop.
*/

public class Q6_Detect_Loop_in_Linked_List {
    public static boolean detectLoop(Node head) {
        if(head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        /*
        before fast.next != null,
        check if fast != null
        */

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
}
