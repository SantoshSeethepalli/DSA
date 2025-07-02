package Hashing;

import java.util.*;

public class Q9 {

    public int longestConsecutive(int[] nums) {

        int maxLength = 0;
        Set<Integer> elements = new HashSet<>();

        for (int num : nums) elements.add(num);

        for(int num : nums) {

            if (!elements.contains(num - 1)) {

                int startingElement = num;
                int possibleMaxLength = 0;

                while(elements.contains(startingElement++)) {
                    possibleMaxLength++;
                }

                maxLength = Math.max(maxLength, possibleMaxLength);
            }
        }

        return maxLength;
    }
}
