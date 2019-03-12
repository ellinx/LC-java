package solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
determine if a person could attend all meetings.

Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: [[7,10],[2,4]]
Output: true
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start-b.start;
            }
        });
        for (int i=0;i<intervals.length-1;i++) {
            if (intervals[i].end>intervals[i+1].start) {
                return false;
            }
        }
        return true;
    }
}
