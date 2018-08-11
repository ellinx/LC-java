package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        int[][] ret = new int[people.length][2];
        List<int[]> q = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0]!=b[0]) {
                    return b[0]-a[0];
                }
                return a[1]-b[1];
            }
        });
        for (int[] each:people) {
            q.add(each[1], each);
        }
        for (int i=0;i<q.size();i++) {
            ret[i] = q.get(i);
        }
        return ret;
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
