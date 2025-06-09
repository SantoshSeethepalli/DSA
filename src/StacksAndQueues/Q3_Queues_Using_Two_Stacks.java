package StacksAndQueues;


import java.util.Scanner;
import java.util.Stack;

public class Q3_Queues_Using_Two_Stacks {
    Stack<Integer> queueStack = new Stack<>();

    void insertAtTheBottomOfTheStack(int number) {
        if (queueStack.isEmpty()) {
            queueStack.push(number);
        } else {
            int ejectedTopElement = queueStack.pop();

            insertAtTheBottomOfTheStack(number);

            queueStack.push(ejectedTopElement);
        }
    }

    void push(int number) {
        insertAtTheBottomOfTheStack(number);
    }

    int pop() {
        if(queueStack.isEmpty()) {
            System.out.println("Stack is Empty, Push elements before Pop.");
            return -1;
        }
        return queueStack.pop();
    }

    public static void main(String[] args) {
        Q3_Queues_Using_Two_Stacks q = new Q3_Queues_Using_Two_Stacks();
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose \nPush: 1\nPop: 2\nExit: -1");
        while(true) {
            int scannedValue = scan.nextInt();

            if(scannedValue == -1) {
                System.out.println("Exiting...");
                break;
            } else if (scannedValue == 1) {
                System.out.print("Enter a number to push into stack: ");

                int number = scan.nextInt();
                q.push(number);

                System.out.println("Number pushed Successfully");
            } else {
                System.out.println("Element popped: " + q.pop());
            }

            System.out.println();
        }

    }
}
