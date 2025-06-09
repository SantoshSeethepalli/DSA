package StacksAndQueues;

import java.util.Stack;

public class Q5_Min_Stack {
    class DataAndMinValue {
        int data;
        int min;

        public DataAndMinValue(int data, int min) {
            this.data = data;
            this.min = min;
        }

        public int getData() {
            return data;
        }

        public int getMin() {
            return min;
        }
    }

    Stack<DataAndMinValue> minValueStack;
    public Q5_Min_Stack() {
        minValueStack = new Stack<>();
    }


    public void push(int x) {
        if(minValueStack.isEmpty()) {
            minValueStack.push(new DataAndMinValue(x, x));
        }

        int minimumTillNow = minValueStack.peek().getMin();
        if(x < minimumTillNow) {
            minimumTillNow = x;
        }

        minValueStack.push(new DataAndMinValue(x, minimumTillNow));
    }

    public void pop() {
        if(!minValueStack.isEmpty()) {
            minValueStack.pop();
        }
    }

    public int peek() {
        if(minValueStack.isEmpty()) return -1;
        return minValueStack.peek().getData();
    }

    public int getMin() {
        if(minValueStack.isEmpty()) return -1;
        return minValueStack.peek().getMin();
    }
}


