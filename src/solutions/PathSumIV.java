package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * If the depth of a tree is smaller than 5, then this tree can be represented 
 * by a list of three-digits integers.
 * 
 * For each integer in this list:
 * The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 * The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
 * The units digit represents the value V of this node, 0 <= V <= 9.
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.
 * 
 * Example 1:
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation: 
 * The tree that the list represents is:
 *     3
 *    / \
 *   5   1
 * 
 * The path sum is (3 + 5) + (3 + 1) = 12.
 * Example 2:
 * Input: [113, 221]
 * Output: 4
 * Explanation: 
 * The tree that the list represents is: 
 *     3
 *      \
 *       1
 * 
 * The path sum is (3 + 1) = 4.
 *
 */
public class PathSumIV {
	/**
	 * Go through level by level and in process if there is leaves add them to final result
	 * pos's parent is (pos+1)/2
	 * 
	 * @param nums
	 * @return
	 */
	public int pathSum(int[] nums) {
        Map<Integer, Integer> cur = new HashMap<>();
        cur.put((nums[0]%100)/10,nums[0]%10);
        int level = 2;
        int index = 1;
        int ret = 0;
        while (index<nums.length) {
            Map<Integer, Integer> next = new HashMap<>();
            //catch leaves
            Set<Integer> noChild = new HashSet<Integer>(cur.keySet());
            //this is one level
            while (index<nums.length && level==nums[index]/100) {
                int pos = (nums[index]%100)/10;
                int val = nums[index]%10;
                if (noChild.contains((pos+1)/2)) {
                    noChild.remove((pos+1)/2);
                }
                if (cur.containsKey((pos+1)/2)) {
                    next.put(pos, cur.get((pos+1)/2)+val);
                }
                index++;
            }
            level++;
            if (next.size()!=0) {
            	//add leaves to final result
                for (int k:noChild) {
                    ret += cur.get(k);
                }
                cur = next;
            } else
                break;
        }
        for (int key:cur.keySet()) {
            ret += cur.get(key);
        }
        return ret;
    }
}
