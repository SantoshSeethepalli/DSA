package Trees;

import java.util.ArrayList;
import java.util.List;

public class Q1_Left_View_of_Binary_Tree {

    private void getLevelOrderList(List<List<Node>> levels) {

        int lastIndex = levels.size() - 1;
        List<Node> lastLevel = levels.get(lastIndex);

        List<Node> nextLevel = new ArrayList<>();

        for(int i = 0; i < lastLevel.size(); i++) {
            Node parent = lastLevel.get(i);

            if(parent.left != null) {
                nextLevel.add(parent.left);
            }

            if(parent.right != null) {
                nextLevel.add(parent.right);
            }
        }

        if(!nextLevel.isEmpty()) {
            levels.add(nextLevel);
            getLevelOrderList(levels);
        }
    }

    public List<Integer> leftSideView(Node root) {

        List<List<Node>> levels = new ArrayList<>();

        List<Node> firstLevel = new ArrayList<>();

        if (root != null) {

            firstLevel.add(root);
            levels.add(firstLevel);

            getLevelOrderList(levels);
        }

        List<Integer> dataVisibleFromLeftSide = new ArrayList<>();

        for (List<Node> level : levels) {

            dataVisibleFromLeftSide.add(level.get(0).data);
        }

        return dataVisibleFromLeftSide;
    }

    public List<Integer> rightSideView(Node root) {

        List<List<Node>> levels = new ArrayList<>();

        List<Node> firstLevel = new ArrayList<>();

        if (root != null) {

            firstLevel.add(root);
            levels.add(firstLevel);

            getLevelOrderList(levels);
        }

        List<Integer> dataVisibleFromRightSide = new ArrayList<>();

        for (List<Node> level : levels) {

            dataVisibleFromRightSide.add(level.get(level.size() - 1).data);
        }

        return dataVisibleFromRightSide;
    }
}
