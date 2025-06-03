package LinkedList;
/*
IMPORTANT NOTE:
- Top { 3rdEntry -> 2ndEntry -> 1stEntry }

- Top lies at the start, add at the head
 */

public class Q16_Implement_Stack_using_Linked_List {
    Node top;
    void push(int a) {
        Node newNode = new Node(a);

        if(top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if(top == null) return -1;

        int popValue = top.data;

        top = top.next;

        return popValue;
    }
}
