package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
2. Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counter = new HashMap<>();
        for (int num:nums) {
            counter.put(num, counter.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });
        for (int key:counter.keySet()) {
            pq.offer(new int[]{key,counter.get(key)});
            if (pq.size()>k) {
                pq.poll();
            }
        }
        List<Integer> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll()[0]);
        }
        return ret;
    }
	
	public static void main(String[] args) {
		TopKFrequentElements tmp = new TopKFrequentElements();
		int[] nums = {1,1,1,2,2,3};
		List<Integer> result = tmp.topKFrequent(nums, 2);
		System.out.println(result.toString());
	}
}
