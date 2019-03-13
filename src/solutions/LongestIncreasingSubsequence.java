package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:
1. There may be more than one LIS combination, it is only necessary for you to return the length.
2. Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(nlogn) time complexity?
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        for (int num:nums) {
            int idx = Collections.binarySearch(seq, num);
            if (idx<0) {
                if (-idx-1==seq.size()) {
                    seq.add(num);
                } else {
                    seq.set(-idx-1, num);
                }
            }
        }
        // System.out.println(seq);
        return seq.size();
    }
	
	//test
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int result = lis.lengthOfLIS(nums);
		System.out.println(result);
	}
}
