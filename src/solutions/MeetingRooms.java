package solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * Example 1:
 * 
 * Input: [[0,30],[5,10],[15,20]] 
 * Output: false
 * 
 * Example 2:
 * 
 * Input: [[7,10],[2,4]] 
 * Output: true
 * 
 * 
 * @author Ellinx
 *
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start!=i2.start) {
                    return i1.start-i2.start;
                }
                return i1.end-i2.end;
            }
        });
        for (int i=1;i<intervals.length;i++) {
            if (intervals[i-1].end>intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}
