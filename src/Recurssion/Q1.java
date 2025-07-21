package Recurssion;

import java.util.*;

public class Q1 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor) return image;

        Queue<CoOrdinates> bfsQueue = new LinkedList<>();
        bfsQueue.add(new CoOrdinates(sr, sc));

        while (!bfsQueue.isEmpty()) {

            CoOrdinates currentCoOrdinates = bfsQueue.poll();

            int x = currentCoOrdinates.getX();
            int y = currentCoOrdinates.getY();

            int currentColour = image[x][y];

            if (x + 1 < image.length && image[x + 1][y] == currentColour) {
                bfsQueue.add(new CoOrdinates(x + 1, y));
            }
            if (x - 1 >= 0 && image[x - 1][y] == currentColour) {
                bfsQueue.add(new CoOrdinates(x - 1, y));
            }

            if (y + 1 < image[0].length && image[x][y + 1] == currentColour) {
                bfsQueue.add(new CoOrdinates(x, y + 1));
            }
            if (y - 1 >= 0 && image[x][y - 1] == currentColour) {
                bfsQueue.add(new CoOrdinates(x, y - 1));
            }

            image[x][y] = newColor;
        }

        return image;
    }
}
