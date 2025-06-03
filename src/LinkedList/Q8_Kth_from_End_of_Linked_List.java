package LinkedList;

/*
Given the head of a linked list and the number k, Your task is to find the kth node from the end.
If k is more than the number of nodes, then the output should be -1.
 */

public class Q8_Kth_from_End_of_Linked_List {
    // ~O(2n)
    int getKthFromLast(Node head, int k) {
        if(head == null || k == 0) {
            return -1;
        }

        Node fast = head;
        int size = 1;

        // Compute Size
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            size += 2;
        }
        if(fast != null) {
            size++;
        }

        // find distance from start
        int count = size - k;
        if(count <= 0) return -1;

        // move temp
        Node temp = head;
        for(int i = 1; i < count; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    // O(n)
    int getDthFromLast(Node head, int d) {
        if(head == null || d == 0) {
            return -1;
        }

        Node front = head;
        Node back = head;

        // move front at k steps ahead of head
        for(int i = 1; i < d; i++) {
            front = front.next;

            // check if 'd' is larger than the size of LinkedList
            if(front == null) {
                return  -1;
            }
        }

        while(front.next != null) {
            front = front.next;
            back = back.next;
        }

        return back.data;
    }

}
