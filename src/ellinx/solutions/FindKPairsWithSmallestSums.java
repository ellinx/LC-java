package ellinx.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1: Given nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Return: [1,2],[1,4],[1,6]
 * 
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6] 
 * 
 * Example 2: Given nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Return: [1,1],[1,1]
 * 
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3] 
 * 
 * Example 3: Given nums1 = [1,2], nums2 = [3], k = 3
 * Return: [1,3],[2,3]
 * 
 * All possible pairs are returned from the sequence: [1,3],[2,3]
 * 
 * @author Ellinx
 *
 */
public class FindKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length==0 || nums2.length==0) return res;
        
        PriorityQueue<int[]> minHeap = 
        		new PriorityQueue<>(
        				(int[] x, int[] y)->(x[2]-y[2])
        				);
        
        for (int i=0;i<nums1.length;i++) {
        	int[] tmp = new int[3];
        	tmp[0] = i;
        	tmp[1] = 0;
        	tmp[2] = nums1[i]+nums2[0];
        	minHeap.offer(tmp);
        }
        
        while (!minHeap.isEmpty()) {
        	int[] entry = minHeap.poll();
        	int[] pair = {nums1[entry[0]], nums2[entry[1]]};
        	res.add(pair);
        	
        	if (res.size()==k) break;
        	
        	entry[1]++;
        	if (entry[1]<nums2.length) {
        		entry[2] = nums1[entry[0]] + nums2[entry[1]];
        		minHeap.offer(entry);
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		FindKPairsWithSmallestSums tmp = new FindKPairsWithSmallestSums();
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		List<int[]> result = tmp.kSmallestPairs(nums1, nums2, 9);
		for (int i=0;i<result.size();i++) {
			System.out.println(Arrays.toString(result.get(i)));
		}
	}
}
