package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * Return the length of the shortest, non-empty, contiguous subarray of A with
 * sum at least K.
 * 
 * If there is no non-empty subarray with sum at least K, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1], K = 1 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: A = [1,2], K = 4 
 * Output: -1
 * 
 * Example 3:
 * 
 * Input: A = [2,-1,2], K = 3 
 * Output: 3
 * 
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 50000 
 * -10 ^ 5 <= A[i] <= 10 ^ 5 
 * 1 <= K <= 10 ^ 9
 * 
 * 
 * @author Ellinx
 *
 */
public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int[] sum = new int[A.length];
        int total = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i]>=K) {
                return 1;
            }
            total += A[i];
            sum[i] = total;
        }
        Deque<Integer> d = new ArrayDeque<>();
        int ret = Integer.MAX_VALUE;
        for (int i=0;i<sum.length;i++) {
            if (sum[i]>=K) {
                ret = Math.min(ret,i+1);
            }
            while (!d.isEmpty() && sum[i]-sum[d.peekFirst()]>=K) {
                ret = Math.min(ret, i-d.pollFirst());
            }
            while (!d.isEmpty() && sum[i]<=sum[d.peekLast()]) {
                d.pollLast();
            }
            d.offerLast(i);
        }
        if (ret==Integer.MAX_VALUE) {
            return -1;
        }
        return ret;
    }
}
