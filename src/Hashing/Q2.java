package Hashing;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Q2 {

    private static void sortByFrequency(int[] arr) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int a :arr) {
            freqMap.put(a, freqMap.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> {

                    int aFrequency = a.getValue();
                    int bFrequency = b.getValue();

                    if ( aFrequency == bFrequency ) return a.getKey() - b.getKey(); // ascending key order
                    else return b.getValue() - a.getValue(); // descending freq order
                });

        maxHeap.addAll(freqMap.entrySet());

        int index = 0;

        while(!maxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> current = maxHeap.poll();

            int frequency = current.getValue();


            while(frequency > 0) {
                arr[index++] = current.getKey();
                frequency--;
            }
        }
    }

    private static void printArray(int[] arr) {
        for(int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);

        int numberOfTestCases = scan.nextInt();

        for(int i = 0; i < numberOfTestCases; i++) {

            int size = scan.nextInt();

            int[] arr = new int[size];

            for(int j = 0; j < size; j++) {
                arr[j] = scan.nextInt();
            }

            sortByFrequency(arr);

            printArray(arr);
            System.out.println();
        }
    }
}
