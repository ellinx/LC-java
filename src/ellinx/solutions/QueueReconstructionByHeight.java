package ellinx.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note: The number of people is less than 1,100.
 * 
 * Example
 * 
 * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * @author Ellinx
 *
 */
public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		List<int[]> ans = new ArrayList<>();
		if (people.length==0) return new int[0][];
		
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        		(a,b)->( (a[0]!=b[0])?(b[0]-a[0]):(a[1]-b[1]) ));
        
        for (int[] person : people) {
        	maxHeap.add(person);
        }
        
        int maxHeight = maxHeap.peek()[0];
        while (!maxHeap.isEmpty() && maxHeap.peek()[0] == maxHeight) {
        	int[] tmp = maxHeap.poll();
        	ans.add(tmp);
        }
        
        while (!maxHeap.isEmpty()) {
        	int[] tmp = maxHeap.poll();
        	ans.add(tmp[1], tmp);
        }
        
        int[][] res = new int[people.length][];
        for (int i=0;i<res.length;i++) {
        	res[i] = ans.get(i);
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		QueueReconstructionByHeight tmp = new QueueReconstructionByHeight();
		int[][] people = {
				{7,0},
				{4,4},
				{7,1},
				{5,0},
				{6,1},
				{5,2}
		};
		int[][] result = tmp.reconstructQueue(people);
		for (int[] sub : result) 
			System.out.println(Arrays.toString(sub));
	}
}
