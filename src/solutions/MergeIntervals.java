package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] 
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: [[1,4],[4,5]] 
 * Output: [[1,5]] 
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 * 
 * 
 * @author Ellinx
 *
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        if (intervals.size()==0) {
            return ret;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start!=i2.start) {
                    return i1.start-i2.start;
                }
                return i1.start-i2.start;
            }
        });
        Interval cur = intervals.get(0);
        for (int i=1;i<intervals.size();i++) {
            if (cur.end<intervals.get(i).start) {
                ret.add(cur);
                cur = intervals.get(i);
                continue;
            }
            cur.end = Math.max(cur.end, intervals.get(i).end);
        }
        ret.add(cur);
        return ret;
    }
}
