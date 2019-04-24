package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE: input types have been changed on April 15, 2019. 
		Please reset to default code definition to get new method signature.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        if (intervals.length==0) {
            return new int[0][];
        }
        int[] cur = intervals[0];
        List<int[]> list = new ArrayList<>();
        for (int i=1;i<intervals.length;i++) {
            if (cur[1]<intervals[i][0]) {
                list.add(cur);
                cur = intervals[i];
            } else {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }
        list.add(cur);
        int[][] ret = new int[list.size()][];
        for (int i=0;i<list.size();i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
