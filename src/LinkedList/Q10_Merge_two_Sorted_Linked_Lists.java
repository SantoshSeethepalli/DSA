package LinkedList;

public class Q10_Merge_two_Sorted_Linked_Lists {
    Node sortedMerge(Node firstLL, Node secondLL) {
        if (firstLL == null) return secondLL;
        if (secondLL == null) return firstLL;

        if (firstLL.data >= secondLL.data) {
            // swap first and seconf
            Node temp = firstLL;
            firstLL = secondLL;
            secondLL = temp;
        }

        Node head = firstLL;

        while (firstLL != null && secondLL != null) {
            if (firstLL.next != null && firstLL.next.data <= secondLL.data) {
                firstLL = firstLL.next;
            } else {
                Node remainingPartOfSecondList = secondLL.next;
                Node remainingPartOfFirstList = firstLL.next;

                firstLL.next = secondLL;
                secondLL.next = remainingPartOfFirstList;

                // place first and second LinkedList to their actual places
                firstLL = firstLL.next;
                secondLL = remainingPartOfSecondList;
            }
        }

        return head;
    }
}
