package LinkedList;

import java.util.HashSet;

public class Q11_Intersection_point_of_two_Linked_Lists {
    public Node findIntersection(Node head1, Node head2) {
        HashSet<Integer> set = new HashSet<>();

        while(head2 != null) {
            set.add(head2.data);
            head2 = head2.next;
        }

        Node res = new Node(0);
        Node temp = res;

        while(head1 != null) {
            int data = head1.data;

            if(set.contains(data)) {
                temp.next = new Node(data);
                temp = temp.next;
            }

            head1 = head1.next;
        }

        return res.next;
    }
}
