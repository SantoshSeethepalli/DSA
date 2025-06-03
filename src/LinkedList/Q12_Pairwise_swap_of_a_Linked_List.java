package LinkedList;

public class Q12_Pairwise_swap_of_a_Linked_List {
    public Node pairwiseSwap(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node res = head.next;

        Node previous = null;
        Node current = head;

        while(current != null && current.next != null) {
            Node nextPartOfLinkedList = current.next.next;

            Node front = current.next;
            current.next = nextPartOfLinkedList;
            front.next = current;

            if(previous != null) {
                previous.next = front;
            }

            previous = current;
            current = nextPartOfLinkedList;
        }

        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        for(int i = 2; i <= 6; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }

        head = new Q12_Pairwise_swap_of_a_Linked_List().pairwiseSwap(head);

        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }


    /*
     Input: 1 2 3 4 5 6
     Output: 2 1 4 3 6 5

     prev - null
     curr - 1
     next - 2


     2 1 4 3
     */
}
