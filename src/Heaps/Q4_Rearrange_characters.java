package Heaps;

import java.util.*;

public class Q4_Rearrange_characters {

    public static String rearrangeString(String s) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> (b.frequency - a.frequency));

        int halfSize = (s.length() + 1) / 2;
        int maxFrequencyEncountered = Integer.MIN_VALUE;


        int[] freqArray = new int[26];
        for(char c : s.toCharArray()) {

            freqArray[c - 'a']++;

            if(freqArray[c - 'a'] > maxFrequencyEncountered) {
                maxFrequencyEncountered = freqArray[c - 'a'];
            }
        }

        // Condition: no character should have frequency more than half.
        // If not possible, return empty String ("")
        if(maxFrequencyEncountered >  halfSize) return "";

        for(int i = 0; i < freqArray.length; i++) {

            if (freqArray[i] > 0) {
                maxHeap.offer(new Pair((char) (i + 'a'), freqArray[i]));
            }
        }

        StringBuilder res = new StringBuilder();
        Pair previouslyUsedPair = new Pair('@', -1); // Fake initialization

        while(!maxHeap.isEmpty()) {

            char currentCharacter = maxHeap.peek().c;
            int currentFrequency = maxHeap.peek().frequency;

            maxHeap.poll();

            if(previouslyUsedPair.frequency > 0) {
                maxHeap.offer(previouslyUsedPair);
            }

            res.append(currentCharacter);
            currentFrequency--;

            previouslyUsedPair = new Pair(currentCharacter, currentFrequency);
        }


        return res.toString();
    }

    static class Pair {
        char c;
        int frequency;

        public Pair(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }
}
