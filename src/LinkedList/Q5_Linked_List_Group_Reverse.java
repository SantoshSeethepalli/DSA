package LinkedList;

/*
Given the head of two singly linked lists, return the point where these two linked lists intersect.

Note: It is guaranteed that the intersected node always exists.

Custom Input Format:

head1 contains the nodes before intersection in list1
head2 contains the nodes before intersection in list2
CommonList contains the nodes after intersection of list1 and list2.
 */

public class Q5_Linked_List_Group_Reverse {

    static Node intersectPoint_Striver(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }

        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != temp2) {

            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) {
                return temp1;
            }

            if(temp1 == null) {
                temp1 = head1;
            }
            if(temp2 == null) {
                temp2 = head2;
            }
        }
        return null;
    }

    static Node intersectPoint_Method_SymmetricY(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }

        Node temp1 = head1;
        Node temp2 = head2;

        int size1 = 0;
        int size2 = 0;

        while(temp1 != null) {
            size1++;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            size2++;
            temp2 = temp2.next;
        }
        int difference = Math.max(size1, size2) - Math.min(size1, size2);

        int i = difference;
        if(size1 > size2) {
            while(i > 0) {
                head1 = head1.next;
                i--;
            }
        } else {
            while(i > 0) {
                head2 = head2.next;
                i--;
            }
        }

        while(head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }


    // Assignment: try using hashSet: store one list at each point and compare with another list.
}
