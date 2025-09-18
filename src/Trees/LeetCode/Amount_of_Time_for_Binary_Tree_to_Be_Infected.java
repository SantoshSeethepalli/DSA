package Trees.LeetCode;

import Trees.Node;
import java.util.*;

public class Amount_of_Time_for_Binary_Tree_to_Be_Infected {

    // https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

    private void findTheChildParentHashMap(Node root, HashMap<Node, Node> map) {

        if(root.left == null && root.right == null) {
            return;
        }

        if(root.left != null) {

            map.put(root.left, root);
            findTheChildParentHashMap(root.left, map);
        }

        if(root.right != null) {

            map.put(root.right, root);
            findTheChildParentHashMap(root.right, map);
        }
    }

    private Node findTargetNode(Node root, int start) {

        if(root == null) {
            return null;
        }

        if(root.data == start) {
            return root;
        }

        Node findtargetInLeftSubTree = findTargetNode(root.left, start);
        if(findtargetInLeftSubTree != null) {

            return findtargetInLeftSubTree;
        }

        Node findtargetInRightSubTree = findTargetNode(root.right, start);

        return findtargetInRightSubTree;
    }

    private int findMaxDepth(Node root, HashMap<Node, Node> map, HashSet<Node> set) {
        if(root == null) {
            return 0;
        }

        int depthTowardsParent = 0;
        int depthLeftSubTree = 0;
        int depthRightSubTree = 0;

        if(root.left != null && !set.contains(root.left)) {

            set.add(root.left);
            depthLeftSubTree = 1 + findMaxDepth(root.left, map, set);
        }

        if(root.right != null && !set.contains(root.right)) {

            set.add(root.right);
            depthRightSubTree = 1 + findMaxDepth(root.right, map, set);
        }

        if(map.containsKey(root) && !set.contains(map.get(root))) {

            set.add(map.get(root));
            depthTowardsParent = 1 + findMaxDepth(map.get(root), map, set);
        }

        return Math.max(depthTowardsParent, Math.max(depthLeftSubTree, depthRightSubTree));
    }

    public int amountOfTime(Node root, int start) {

        HashMap<Node, Node> map = new HashMap<>();
        HashSet<Node> set = new HashSet<>();

        findTheChildParentHashMap(root, map);

        Node targetNode = findTargetNode(root, start);
        set.add(targetNode);

        return findMaxDepth(targetNode, map, set);
    }
}
