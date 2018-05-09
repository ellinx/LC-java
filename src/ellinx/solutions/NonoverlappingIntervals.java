package ellinx.solutions;

import java.util.Arrays;

/**
 * Given a collection of intervals, find the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 * 
 * Note: You may assume the interval's end point is always bigger than its start
 * point. Intervals like [1,2] and [2,3] have borders "touching" but they don't
 * overlap each other. 
 * 
 * Example 1: 
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * 
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are
 * non-overlapping. 
 * 
 * Example 2: 
 * Input: [ [1,2], [1,2], [1,2] ]
 * 
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals
 * non-overlapping. 
 * 
 * Example 3: 
 * Input: [ [1,2], [2,3] ]
 * 
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * 
 * @author Ellinx
 *
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class NonoverlappingIntervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
        //find max non-overlapping intervals
		int noOverlapping = 0;
		if (intervals.length==0) return 0;
		
		Arrays.sort(intervals, (Interval a, Interval b)->(a.end-b.end));
		Interval cur = intervals[0];
		noOverlapping++;
		for (int i=1;i<intervals.length;i++) {
			if (cur.end <= intervals[i].start) {
				cur = intervals[i];
				noOverlapping++;
			}
		}
		return intervals.length - noOverlapping;
    }
	
	//test
	public static void main(String[] args) {
		NonoverlappingIntervals tmp = new NonoverlappingIntervals();
		Interval[] intervals = {
				new Interval(1,2),
				new Interval(2,3),
				new Interval(3,4),
				new Interval(1,3)
		};
		int result = tmp.eraseOverlapIntervals(intervals);
		System.out.println(result);
	}
}
