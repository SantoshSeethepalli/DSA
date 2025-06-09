package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class Q9_Rotten_Oranges {
    class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    Queue<Location> rottenOranges;

    private Queue<Location> getRottenOrangesQueue(int[][] map) {

        Queue<Location> rottenOranges = new LinkedList<>();

        for(int x = 0; x < map.length; x++) {
            for(int y = 0; y < map[0].length; y++) {

                if(map[x][y] == 2) {
                    rottenOranges.add(new Location(x, y));
                }
            }
        }

        return  rottenOranges;
    }

    private void makeOrangeRotten(int[][] map, int x, int y) {
        final int leftWall = -1;
        final int topWall = -1;
        final int rightWall = map[0].length;
        final int bottomWall = map.length;

        if(x > leftWall && x < rightWall && y > topWall && y < bottomWall) {
            if(map[x][y] == 1) {
                map[x][y] = 2;
                rottenOranges.add(new Location(x, y));
            }
        }
    }

    private void makeNeighbourOrangesRotten(int[][] map, Location rottenOrange) {

        int x = rottenOrange.getX();
        int y = rottenOrange.getY();

        makeOrangeRotten(map, x - 1, y);
        makeOrangeRotten(map, x + 1, y);
        makeOrangeRotten(map, x, y + 1);
        makeOrangeRotten(map, x, y - 1);
    }

    public int orangesRotting(int[][] map) {

        rottenOranges = getRottenOrangesQueue(map);

        while(!rottenOranges.isEmpty()) {
            makeNeighbourOrangesRotten(map, rottenOranges.poll());
        }

        for(int x = 0; x < map.length; x++) {
            for(int y = 0; y < map[0].length; y++) {

                if(map[x][y] == 1) {
                    return -1;
                }
            }
        }


        return 1;
    }
}
