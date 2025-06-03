package LinkedList;

public class Q13_Add_two_numbers_represented_by_Linked_Lists {
    static Node reverseLL(Node head) {
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

    static Node addEachNodeAndCarry(Node num1, Node num2, int carry) {
        if(num1 == null && num2 == null && carry == 0) {
            return null;
        }
        if(num1 == null && num2 == null && carry == 1) {
            return new Node(carry);
        }

        int res = carry;

        if(num1 != null) {
            res += num1.data;
            num1 = num1.next;
        }
        if(num2 != null) {
            res += num2.data;
            num2 = num2.next;
        }

        int nextCarry = 0;
        if(res >= 10) {
            nextCarry = 1;
            res = res % 10;
        }

        Node ans = new Node(res);
        ans.next = addEachNodeAndCarry(num1, num2, nextCarry);

        return ans;
    }

    static Node addTwoLists(Node num1, Node num2) {
        if(num1 == null) return num2;
        if(num2 == null) return num1;

        num1 = reverseLL(num1);
        num2 = reverseLL(num2);

        Node res = addEachNodeAndCarry(num1, num2, 0);
        res = reverseLL(res);

        while(res != null && res.data == 0) {
            res = res.next;
        }

        return res;
    }
}

//public class Q13 {
//    static int findSizeOfLL(Node head) {
//        if(head == null) {
//            return 0;
//        }
//        int size = 1;
//
//        while (head.next != null) {
//            size++;
//            head = head.next;
//        }
//
//        return size;
//    }
//
//    static Node reverseLL(Node head) {
//        if(head == null || head.next == null) {
//            return head;
//        }
//
//        Node previous = null;
//        Node current = head;
//
//        while(current != null) {
//            Node next = current.next;
//
//            current.next = previous;
//
//            previous = current;
//            current = next;
//        }
//
//        return previous;
//    }
//
//    static Node addTwoLists(Node num1, Node num2) {
//        if(num1 == null) return num2;
//        if(num2 == null) return num1;
//
//        int sizeOfNum1 = findSizeOfLL(num1);
//        int sizeOfNum2 = findSizeOfLL(num2);
//
//        if(sizeOfNum1 < sizeOfNum2) {
//            int difference = sizeOfNum2 - sizeOfNum1;
//            Node rem = new Node(0);
//            Node temp = rem;
//            for(int i = 1; i < difference; i++) {
//                temp.next = new Node(0);
//                temp = temp.next;
//            }
//
//            temp = num1;
//
//            while(temp.next != null) {
//                temp = temp.next;
//            }
//            temp.next = rem;
//        }
//        else if(sizeOfNum2 < sizeOfNum1) {
//            int difference = sizeOfNum1 - sizeOfNum2;
//            Node rem = new Node(0);
//            Node temp = rem;
//            for(int i = 1; i < difference; i++) {
//                temp.next = new Node(0);
//                temp = temp.next;
//            }
//
//            temp = num2;
//
//            while(temp.next != null) {
//                temp = temp.next;
//            }
//            temp.next = rem;
//        }
//
//        num1 = reverseLL(num1);
//        num2 = reverseLL(num2);
//
//        int carry = 0;
//        Node ans = new Node(0);
//        Node temp = ans;
//
//        while(num1 != null && num2 != null) {
//            int res = num1.data + num2.data + carry;
//
//            if(res >= 10) {
//                carry = 1;
//                res = res % 10;
//            }
//            temp.next = new Node(res);
//            temp = temp.next;
//        }
//        ans = ans.next;
//
//        ans = reverseLL(ans);
//
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        Node a = new Node(2);
//        a.next = new Node(2);
//        a.next.next = new Node(3);
//
//        Node b = new Node(2);
//        b.next = new Node(8);
//
//        Node res = addTwoLists(a, b);
//
//        while(res != null) {
//            System.out.print(res.data);
//            res = res.next;
//        }
//    }
//}
