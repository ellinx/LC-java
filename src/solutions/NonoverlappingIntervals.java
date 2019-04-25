package solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
Given a collection of intervals, find the minimum number of intervals you need to remove 
to make the rest of the intervals non-overlapping.

Note:
1. You may assume the interval's end point is always bigger than its start point.
2. Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 

Example 1:

Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 

Example 2:

Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 

Example 3:

Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

NOTE: input types have been changed on April 15, 2019. 
Please reset to default code definition to get new method signature.
 */

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[1]!=b[1]) {
                    return a[1]-b[1];
                }
                return b[0]-a[0];
            }
        });
        if (intervals.length==0) {
            return 0;
        }
        int[] cur = intervals[0];
        int ret = 0;
        for (int i=1;i<intervals.length;i++) {
            if (intervals[i][0]<cur[1]) {
                ret++;
                continue;
            }
            cur = intervals[i];
        }
        return ret;
    }
	
	//test
	public static void main(String[] args) {
		NonoverlappingIntervals tmp = new NonoverlappingIntervals();
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		int result = tmp.eraseOverlapIntervals(intervals);
		System.out.println(result);
	}
}
