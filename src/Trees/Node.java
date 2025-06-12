package Trees;

import java.util.ArrayList;

public class Node {
    int data;
    Node left;
    Node right;
    Node nexRight;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}