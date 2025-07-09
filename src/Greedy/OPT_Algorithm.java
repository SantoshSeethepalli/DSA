package Greedy;

import java.util.*;

public class OPT_Algorithm {

    private static int getFarthestOccurringElement(int startIdx, List<Integer> ram, int[] pages) {

        int farthestIdx = -1;
        int pageToBeRemoved = -1;

        for (int ramPage : ram) {

            int nextUseForCurrentPage = Integer.MAX_VALUE;

            for(int j = startIdx + 1; j < pages.length; j++) {

                if(pages[j] == ramPage) {
                    nextUseForCurrentPage = j;
                    break;
                }
            }

            if(nextUseForCurrentPage > farthestIdx) {
                farthestIdx = nextUseForCurrentPage;
                pageToBeRemoved = ramPage;
            }
        }

        return pageToBeRemoved;
    }

    static int pageFaults(int N, int C, int[] pages) {

        List<Integer> ram = new ArrayList<>();

        int pageFaults = 0;

        for(int i = 0; i < pages.length; i++) {

            if(ram.contains(pages[i])) continue;

            pageFaults++;

            if(ram.size() >= C) {

                int pageToBeRemoved = getFarthestOccurringElement(i, ram, pages);
                ram.remove((Integer) pageToBeRemoved);
            }

            ram.add(pages[i]);
        }

        return pageFaults;
    }
}
