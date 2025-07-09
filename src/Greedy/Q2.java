package Greedy;

import java.util.*;

public class Q2 {

    public int maxMeetings(int start[], int end[]) {

        if(start.length != end.length) return 0;

        int n = start.length;
        List<Interval> listOfMeetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listOfMeetings.add(new Interval(start[i], end[i]));
        }

        listOfMeetings.sort(Comparator.comparingInt(Interval::getEndTime));

        List<Interval> nonOverLappingMeetings = new ArrayList<>();

        int lastEndTime = -1;

        for(Interval i : listOfMeetings) {

            if(i.getStartTime() > lastEndTime) {

                nonOverLappingMeetings.add(i);
                lastEndTime = i.getEndTime();
            }
        }

        return nonOverLappingMeetings.size();
    }
}
