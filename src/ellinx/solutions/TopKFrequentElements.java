package ellinx.solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * @author Ellinx
 *
 */
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = 
        		new PriorityQueue<>(
        				(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2)->
        						(e2.getValue()-e1.getValue())
        				);
        
        List<Integer> res = new ArrayList<>();
        
        for (int num : nums) {
        	if (map.containsKey(num)) {
        		map.put(num, map.get(num)+1);
        	} else {
        		map.put(num, 1);
        	}
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	maxHeap.offer(entry);
        }
        
        for (int i=0;i<k;i++) {
        	res.add(maxHeap.poll().getKey());
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		TopKFrequentElements tmp = new TopKFrequentElements();
		int[] nums = {1,1,1,2,2,3};
		List<Integer> result = tmp.topKFrequent(nums, 2);
		System.out.println(result.toString());
		
		PriorityQueue<String> minHeap = 
				new PriorityQueue<>(10, new Comparator<String>(){
					public int compare(String s1, String s2) {
						return Integer.compare(s1.length(), s2.length());
					}
				});
	}
}
