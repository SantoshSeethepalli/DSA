package Greedy;

import java.util.*;

public class Q5 {

    static int pageFaults(int N, int C, int[] pages) {

        if(pages.length <= C) return pages.length;

        LinkedHashSet<Integer> cache = new LinkedHashSet<>();
        int pageFaults = 0;

        for (int page : pages) {

            if (cache.contains(page)) {

                cache.remove(page);
                cache.add(page);
            } else {

                pageFaults++;
                while(cache.size() >= C) {

                    Iterator<Integer> it = cache.iterator();
                    cache.remove(it.next());
                }

                cache.add(page);
            }
        }

        return pageFaults;
    }
}
