package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
Given an array nums, there is a sliding window of size k 
which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. 
Each time the sliding window moves right by one position. 
Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 

Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 */

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==0) {
            return new int[0];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        int[] ret = new int[nums.length-k+1];
        for (int i=0;i<k;i++) {
            pq.offer(new int[]{i, nums[i]});
            ret[0] = pq.peek()[1];
        }
        for (int i=k;i<nums.length;i++) {
            pq.offer(new int[]{i, nums[i]});
            while (i-pq.peek()[0]>=k) {
                pq.poll();
            }
            ret[i-k+1] = pq.peek()[1];
        }
        return ret;
    }
}
