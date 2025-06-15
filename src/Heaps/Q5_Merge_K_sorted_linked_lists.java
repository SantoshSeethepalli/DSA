package Heaps;

import LinkedList.Node;
import java.util.*;

public class Q5_Merge_K_sorted_linked_lists {

        // Possible better code is to group the same numbers while adding into the queue:

        private void addNodesToTheHeap(Node head, PriorityQueue<Node> minHeap) {

            while(head != null) {

                Node curretNode = head;
                head = head.next;

                curretNode.next = null;

                minHeap.offer(curretNode);
            }
        }

        private Node getLinkedListFromMinHeap(PriorityQueue<Node> minHeap) {

            Node head = (!minHeap.isEmpty()) ? minHeap.poll() : null;

            if(head == null) return null;

            Node temp = head;

            while(!minHeap.isEmpty()) {

                temp.next = minHeap.poll();
                temp = temp.next;
            }

            return head;
        }

        Node mergeKLists(List<Node> arr) {

            PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt( (Node a) -> a.data) );

            for(Node node : arr) addNodesToTheHeap(node, minHeap);

            return getLinkedListFromMinHeap(minHeap);
        }
}
