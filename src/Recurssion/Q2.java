package Recurssion;

import java.util.*;

public class Q2 {

    private int findNumberOfPaths(int i, int j, final int rows, final int coloums, HashMap<String, Integer> dp) {

        if(i > rows || j > coloums) return 0;

        if (i == rows && j == coloums) return 1;

        String key = i + " " + j;

        if(dp.containsKey(key)) return dp.get(key);

        int numberOfPaths = findNumberOfPaths(i + 1, j, rows, coloums, dp) + findNumberOfPaths(i, j + 1, rows, coloums, dp);

        dp.put(key, numberOfPaths);

        return numberOfPaths;
    }

    public int numberOfPaths(int rows, int coloums) {
        return findNumberOfPaths(1, 1, rows, coloums, new HashMap<>());
    }
}
