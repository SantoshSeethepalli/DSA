package DynamicProgramming.GFG;

import java.util.*;

public class MaximumLengthChain {

    // https://www.geeksforgeeks.org/dsa/maximum-length-chain-of-pairs-dp-20/

    public int findMaxLengthChain(Pair[] arr) {

        Arrays.sort(arr, Comparator.comparingInt(Pair::getB));

        int maxLength = 0;
        int lastEnd = arr[0].getB();

        for(int i = 1; i < arr.length; i++) {

           if(lastEnd < arr[i].getA()) {

               lastEnd = arr[i].getB();
               maxLength++;
           }
        }

        return maxLength;
    }
}
