package StacksAndQueues;

import java.util.Stack;

public class Q1_Parenthesis_Checker {

    static char getReverseBrace(char c) {

        if (c == '(') {
            return ')';

        } else if(c == '{') {
            return '}';
        }

        return ']';
    }

    static boolean isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (char currentCharacter : s.toCharArray()) {

            if (currentCharacter == '(' || currentCharacter == '{' || currentCharacter == '[') {
                stack.add(getReverseBrace(currentCharacter));

            } else {

                if (stack.isEmpty()) return false;

                char poppedCharacter = stack.pop();
                if (poppedCharacter != currentCharacter) return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(isBalanced(s));
    }
}
