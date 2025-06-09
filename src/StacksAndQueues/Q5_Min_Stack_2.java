package StacksAndQueues;

import java.util.Stack;

public class Q5_Min_Stack_2 {
    Stack<Integer> minValueStack;
    Stack<Integer> dataStack;

    public Q5_Min_Stack_2() {
        minValueStack = new Stack<>();
        dataStack = new Stack<>();
    }


    public void push(int x) {
        dataStack.push(x);

        if(minValueStack.isEmpty() || x <= minValueStack.peek()) {
            minValueStack.push(x);
        }
    }

    public void pop() {

        if(dataStack.isEmpty()) return;

        int poppedValue = dataStack.pop();

        // minimumValueStack top is the top of dataStack then pop from minValueStack
        if(!minValueStack.isEmpty() && poppedValue == minValueStack.peek()) {
            minValueStack.pop();
        }
    }

    public int peek() {
        if(dataStack.isEmpty()) return -1;

        return dataStack.peek();
    }


    public int getMin() {
        if(minValueStack.isEmpty()) return -1;

        return minValueStack.peek();
    }
}
