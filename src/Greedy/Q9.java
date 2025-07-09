package Greedy;

public class Q9 {

    class MinHeapNode implements Comparable<MinHeapNode> {
        char data;
        int freq;
        MinHeapNode left, right;

        MinHeapNode(char data, int freq) {
            this.data = data;
            this.freq = freq;
        }

        public int compareTo(MinHeapNode other) {
            return this.freq - other.freq;
        }
    }

    String decode_file(MinHeapNode root, String encodedStr) {

        MinHeapNode currentNode = root;
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < encodedStr.length(); i++) {

            if(encodedStr.charAt(i) == '0') {

                currentNode = currentNode.left;
            } else {

                currentNode = currentNode.right;
            }

            if(currentNode.left == null && currentNode.right == null) {
                res.append(currentNode.data);
                currentNode = root;
            }
        }

        return res.toString() + '\0';
    }
}
