package ellinx.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You have k lists of sorted integers in ascending order. Find the smallest
 * range that includes at least one number from each of the k lists.
 * 
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c
 * if b-a == d-c.
 * 
 * Example 1: 
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]] 
 * Output: [20,24]
 * 
 * Explanation: 
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24]. 
 * List 2: [0, 9, 12, 20], 20 is in range [20,24]. 
 * List 3: [5, 18, 22, 30], 22 is in range [20,24]. 
 * 
 * Note: 
 * 1. The given list may contain duplicates, so ascending order means >= here. 
 * 2. 1 <= k <= 3500 
 * 3. -10^5 <= value of elements <= 10^5.
 * 
 *
 */
public class SmallestRange {
	/*
	 * merge sort and then window sliding
	 */
	public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000, 100000};
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>(){
        	@Override
        	public int compare(List<Integer> l1, List<Integer> l2) {
        		int index1 = l1.get(l1.size()-2);
        		int index2 = l2.get(l2.size()-2);
        		return l1.get(index1) - l2.get(index2);
        	}
        });
        
        //[...num list...,index, num index in nums]
        for (int i=0;i<nums.size();i++) {
        	List<Integer> list = new ArrayList<Integer>(nums.get(i));
        	list.add(0);
        	list.add(i);
        	minHeap.add(list);
        }
        
        List<int[]> mergedList = new ArrayList<>();
        while (!minHeap.isEmpty()) {
        	List<Integer> list = minHeap.poll();
        	int curIndex = list.get(list.size()-2);
        	int indexInNums = list.get(list.size()-1);
        	int[] cur = {list.get(curIndex), indexInNums};
        	mergedList.add(cur);
        	if (curIndex+1<list.size()-2) {
        		list.set(list.size()-2, curIndex+1);
        		minHeap.add(list);
        	}
        }
        for (int[] arr:mergedList) {
        	System.out.print(Arrays.toString(arr)+",");
        }
        System.out.println("");
        Map<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end<mergedList.size()) {
        	int[] cur = mergedList.get(end);
        	if (map.containsKey(cur[1])) {
        		map.put(cur[1], map.get(cur[1])+1);
        		end++;
        	} else {
        		map.put(cur[1], 1);
        		while (start<=end && map.size()==nums.size()) {
        			int[] last = mergedList.get(end);
        			int[] first = mergedList.get(start);
        			if (last[0]-first[0]<res[1]-res[0]) {
        				res[0] = first[0];
        				res[1] = last[0];
        			}
        			//remove first
        			if (map.get(first[1])==1) {
            			map.remove(first[1]);
            		} else {
            			map.put(first[1], map.get(first[1])-1);
            		}
        			start++;
        		}
        		end++;
        	}
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		SmallestRange sr = new SmallestRange();
		List<List<Integer>> nums = new ArrayList<>();
		nums.add(Arrays.asList(new Integer[] { 4, 10, 15, 24, 26 }));
		nums.add(Arrays.asList(new Integer[] { 0, 9, 12, 20 }));
		nums.add(Arrays.asList(new Integer[] { 5, 18, 22, 30 }));
		int[] result = sr.smallestRange(nums);
		System.out.println(Arrays.toString(result));
	}
}
