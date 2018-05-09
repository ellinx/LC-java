package ellinx.solutions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, 
 * Given [100, 4, 200, 1, 3, 2], 
 * The longest consecutive elements sequence is [1, 2, 3, 4]. 
 * Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author Ellinx
 *
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }
        
        while (!set.isEmpty()) {
            Iterator<Integer> iter = set.iterator();
            int mid = iter.next();
            int cur = mid-1;
            int left = 0;
            int right = 0;
            while (set.contains(cur)) {
                left++;
                set.remove(cur);
                cur--;
            }
            cur = mid+1;
            while (set.contains(cur)) {
                right++;
                set.remove(cur);
                cur++;
            }
            set.remove(mid);
            res = Math.max(res, left+1+right);
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int[] nums = {100, 4, 200, 1, 3, 2};
		int result = lcs.longestConsecutive(nums);
		System.out.println(result);
	}
}
