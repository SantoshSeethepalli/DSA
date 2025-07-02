package Hashing;

import java.util.*;

public class Q1 {
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {

        // TreeMap stores numbers in sorted order, hence chosen TreeMap.
        Map<Integer, Integer> aOneFrequencyMap = new TreeMap<>();
        
        for(int a : A1) {
            aOneFrequencyMap.put(a, aOneFrequencyMap.getOrDefault(a, 0) + 1);
        }

        int index = 0;

        // relative sort --> (A1 relative to A2)
        for(int num : A2) {

            if(aOneFrequencyMap.containsKey(num)) {

                int frequency = aOneFrequencyMap.get(num);

                while(frequency > 0) {

                    A1[index++] = num;
                    frequency--;
                }

                aOneFrequencyMap.remove(num);
            }
        }

        for (Map.Entry<Integer, Integer> entry : aOneFrequencyMap.entrySet()) {
            int leftOverNumber = entry.getKey();
            int frequency = entry.getValue();

            while(frequency > 0) {
                A1[index++] = leftOverNumber;
                frequency--;
            }

            // MISTAKE: I learned that we can modify inside a For-Each loop, and this removal is not necessary.
            // aOneFrequencyMap.remove(leftOverNumber);
        }

        return A1;
    }
}
