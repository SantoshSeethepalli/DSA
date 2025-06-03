package LinkedList;

class Q14_Check_if_Linked_List_is_Palindrome {

    static Node getNewReverseLL(Node head) {
        Node res = new Node(head.data);

        Node temp = head.next;

        while(temp != null) {
            Node newNode = new Node(temp.data);

            newNode.next = res;
            res = newNode;

            temp = temp.next;
        }

        return res;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node temp = head;
        Node reverseHead = getNewReverseLL(temp);

        while (head != null && reverseHead != null) {
            if (head.data != reverseHead.data) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }
}
