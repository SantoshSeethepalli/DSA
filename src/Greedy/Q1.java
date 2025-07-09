package Greedy;

import java.util.*;


public class Q1 {

    public int activitySelection(int[] start, int[] finish) {

        if(start.length != finish.length) return 0;

        int n = start.length;
        List<Interval> listOfIntervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listOfIntervals.add(new Interval(start[i], finish[i]));
        }

        listOfIntervals.sort(Comparator.comparingInt(a -> a.getEndTime()));

        List<Interval> nonOverLappingActivities = new ArrayList<>();

        int lastEndTime = -1;

        for(Interval newActivity : listOfIntervals) {

            if(newActivity.getStartTime() > lastEndTime) {

                nonOverLappingActivities.add(newActivity);
                lastEndTime = newActivity.getEndTime();
            }
        }

        return nonOverLappingActivities.size();
    }
}
