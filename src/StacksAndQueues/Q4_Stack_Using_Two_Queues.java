package StacksAndQueues;

import LinkedList.Q15_Implement_Queue_using_Linked_List;

public class Q4_Stack_Using_Two_Queues {
    Q15_Implement_Queue_using_Linked_List mainQueue = new Q15_Implement_Queue_using_Linked_List();
    Q15_Implement_Queue_using_Linked_List auxilaryQueue = new Q15_Implement_Queue_using_Linked_List();

    void push(int number) {
        mainQueue.push(number);
    }

    int pop() {
        int poppedValue = -1;
        while (!mainQueue.isEmpty()) {
            int reverseOrderElement = mainQueue.pop();
            auxilaryQueue.push(reverseOrderElement);
        }

        if(!auxilaryQueue.isEmpty()) {
            poppedValue = auxilaryQueue.pop();
        }

        while (!auxilaryQueue.isEmpty()) {
            int correctOrderElement = auxilaryQueue.pop();
            mainQueue.push(correctOrderElement);
        }

        return poppedValue;
    }

    void printStack() {
        if(mainQueue.isEmpty()) {
            return;
        }
        int val = mainQueue.pop();
        System.out.print(val + " ");

        printStack();

        mainQueue.push(val);
    }

    public static void main(String[] args) {
        Q4_Stack_Using_Two_Queues q = new Q4_Stack_Using_Two_Queues();

        q.push(1);
        q.push(3);
        q.push(4);
        System.out.print("Stack: ");
        q.printStack();
        System.out.println();
        System.out.println(q.pop());

    }
}
