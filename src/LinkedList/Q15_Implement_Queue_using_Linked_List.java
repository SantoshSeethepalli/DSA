package LinkedList;


/*
IMPORTANT NOTE:
- front { 2 -> 3 -> 4 } rear

- insert at the rear.
- remove at the front.
 */

public class Q15_Implement_Queue_using_Linked_List {
    Node front;
    Node rear;

    // Function to push an element into the queue.
    public void push(int a) {
        Node newNode = new Node(a);

        // not front == rear
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    // Function to pop front element from the queue.
    public int pop() {
        if(front == null) {
            return -1;
        }

        int popValue = front.data;
        front = front.next;

        return popValue;
    }

    public boolean isEmpty() {
        if(front == null) return true;

        return false;
    }
}
