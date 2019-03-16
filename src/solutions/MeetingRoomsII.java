package solutions;

import java.util.Arrays;

/**
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        for (int i=0;i<n;i++) {
            starts[i] = intervals[i].start;
        }
        Arrays.sort(starts);
        int[] ends = new int[n];
        for (int i=0;i<n;i++) {
            ends[i] = intervals[i].end;
        }
        Arrays.sort(ends);
        int cur=0, ret=0;
        int i1=0, i2=0;
        while (i1<n) {
            if (starts[i1]==ends[i2]) {
                i1++;
                i2++;
            } else if (starts[i1]<ends[i2]) {
                cur++;
                ret = Math.max(ret, cur);
                i1++;
            } else {
                cur--;
                i2++;
            }
        }
        return ret;
    }
}
