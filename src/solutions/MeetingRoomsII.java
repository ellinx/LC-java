package solutions;

import java.util.Arrays;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * Input: [[0, 30],[5, 10],[15, 20]] 
 * Output: 2
 * 
 * Example 2:
 * 
 * Input: [[7,10],[2,4]] 
 * Output: 1
 * 
 * 
 * @author Ellinx
 *
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i=0;i<intervals.length;i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i1 = 0, i2 = 0;
        int ret = 0, cur = 0;
        while (i1<starts.length) {
            if (starts[i1]==ends[i2]) {
                i1++;
                i2++;
            } else if (starts[i1]<ends[i2]) {
                i1++;
                cur++;
                ret = Math.max(ret, cur);
            } else {
                i2++;
                cur--;
            }
        }
        return ret;
    }
}
