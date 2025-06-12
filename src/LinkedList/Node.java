package LinkedList;

public class Node {
    public int data;
    public Node next;

    public Node(int d) {
        data = d;
        next = null;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Given a number get the linkedList of each Digit as a Node:
    public static Node getLinkedList(long number) {
        Node res = new Node(-1);
        Node temp = res;

        while(number > 0) {
            int digit = (int) number % 10;
            number /= 10;

            temp.next = new Node(digit);

            temp = temp.next;
        }

        res = res.next;
        res = reverseLL(res);

        return res;
    }

    private static Node reverseLL(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

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
}