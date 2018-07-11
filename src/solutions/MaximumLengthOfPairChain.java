package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion.
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * Example 1:
 * 
 * Input: [[1,2], [2,3], [3,4]] 
 * Output: 2 
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 
 * Note:
 * 
 * The number of given pairs will be in the range [1, 1000].
 * 
 * @author Ellinx
 *
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[1]!=b[1]) {
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        });
        for (int[] pair:pairs) {
            pq.offer(pair);
        }
        int ret = 0;
        if (pq.isEmpty()) {
            return ret;
        }
        int[] pre = pq.poll();
        ret++;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (pre[1]>=cur[0]) {
                continue;
            }
            ret++;
            pre = cur;
        }
        return ret;
    }
}
