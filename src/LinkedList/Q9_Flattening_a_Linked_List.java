package LinkedList;

public class Q9_Flattening_a_Linked_List {


    // function: sort given two linked lists:
    // recursive function:
    // check if next present, return if not
    // else, break into current and next pass it to sortFunction


    private FlattenLL sortLinkedList(FlattenLL firstLL, FlattenLL secondLL) {
        if (firstLL == null) return secondLL;
        if (secondLL == null) return firstLL;

        FlattenLL head;

        if (firstLL.data <= secondLL.data) {
            head = firstLL;
        } else {
            // swap first and second
            FlattenLL temp = firstLL;
            firstLL = secondLL;
            secondLL = temp;

            head = secondLL;
        }

        while (firstLL != null && secondLL != null) {
            if (firstLL.bottom != null && firstLL.bottom.data <= secondLL.data) {
                firstLL = firstLL.bottom;
            } else {
                FlattenLL remainingPartOfSecondList = secondLL.bottom;
                FlattenLL remainingPartOfFirstList = firstLL.bottom;

                firstLL.bottom = secondLL;
                secondLL.bottom = remainingPartOfFirstList;

                firstLL = secondLL;
                secondLL = remainingPartOfSecondList;
            }
        }

        return head;
    }

    FlattenLL flatten(FlattenLL root) {
        if(root == null || root.next == null) {
            return root;
        }

        FlattenLL nextRoot = root.next;

        root.next = nextRoot.next;
        nextRoot.next = null;

        root = sortLinkedList(root, nextRoot);

        return flatten(root);
    }
}
