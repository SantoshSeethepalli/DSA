package LinkedList;

public class Q17_Sort012 {
    static Node segregate(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);

        Node zeroPointer = zero;
        Node onePointer = one;
        Node twoPointer = two;

        while(temp != null) {
            if(temp.data == 0) {
                zeroPointer.next = temp;
                zeroPointer = zeroPointer.next;
            } else if(temp.data == 1) {
                onePointer.next = temp;
                onePointer = onePointer.next;
            } else {
                twoPointer.next = temp;
                twoPointer = twoPointer.next;
            }

            temp = temp.next;
        }

        // move list from dummy -1 node
        zero = zero.next;
        one = one.next;
        two = two.next;


        // connect the lists
        if(one != null) {
            zeroPointer.next = one;
        } else {
            zeroPointer.next = two;
        }
        onePointer.next = two;
        twoPointer.next = null;


        // return least possible null list pointer:
        if (zero != null) {
            return zero;
        } else if (one != null) {
            return one;
        } else {
            return two;
        }
    }
}
