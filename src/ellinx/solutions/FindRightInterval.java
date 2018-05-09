package ellinx.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of intervals, for each of the interval i, check if there exists
 * an interval j whose start point is bigger than or equal to the end point of
 * the interval i, which can be called that j is on the "right" of i.
 * 
 * For any interval i, you need to store the minimum interval j's index, which
 * means that the interval j has the minimum start point to build the "right"
 * relationship for interval i. If the interval j doesn't exist, store -1 for
 * the interval i. Finally, you need output the stored value of each interval as
 * an array.
 * 
 * Note: You may assume the interval's end point is always bigger than its start
 * point. You may assume none of these intervals have the same start point.
 * 
 * Example 1: 
 * Input: [ [1,2] ]
 * 
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * 
 * Example 2: 
 * Input: [ [3,4], [2,3], [1,2] ]
 * 
 * Output: [-1, 0, 1]
 * Explanation: There is no satisfied "right" interval for [3,4]. For [2,3], the
 * interval [3,4] has minimum-"right" start point; For [1,2], the interval [2,3]
 * has minimum-"right" start point. 
 * 
 * Example 3: 
 * Input: [ [1,4], [2,3], [3,4] ]
 * 
 * Output: [-1, 2, -1]
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4]. For
 * [2,3], the interval [3,4] has minimum-"right" start point.
 * 
 * @author Ellinx
 *
 */
public class FindRightInterval {
	public int[] findRightInterval(Interval[] intervals) {
        List<int[]> list = new ArrayList<>();
        int[] res = new int[intervals.length];
        for (int i=0;i<intervals.length;i++) {
        	int[] tmp = {intervals[i].start, i};
        	list.add(tmp);
        }
        
        Collections.sort(list, (int[] a, int[] b)->((a[0]==b[0])?(a[1]-b[1]):(a[0]-b[0])));
        
        for (int i=0;i<list.size();i++) {
        	int cur = intervals[i].end;
        	
        	//use binary search to find the index of intervals which has min start greater than cur
        	int index = -1;
        	int start = 0;
        	int end = list.size()-1;
        	while (start<=end) {
        		if (start==end) {
        			if (cur <= list.get(start)[0]) {
        				index = list.get(start)[1];
        			}
        			break;
        		}
        		
        		int mid = start + (end-start)/2;
        		if (cur <= list.get(mid)[0]) {
        			index = list.get(mid)[1];
        			end = mid - 1;
        		} else {
        			start = mid + 1;
        		}
        	}
        	res[i] = index;
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		FindRightInterval tmp = new FindRightInterval();
		Interval[] intervals = {
				new Interval(3,4),
				new Interval(2,3),
				new Interval(1,2)
		};
		int[] result = tmp.findRightInterval(intervals);
		System.out.println(Arrays.toString(result));
	}
}
