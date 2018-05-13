package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must 
 * go downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * @author Ellinx
 *
 */
public class PathSumIII {
	private int count;
    /**
     * similar to two sum solution
     * 
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root==null) {
            return 0;
        }
        helper(root, new HashMap<Integer, Integer>(), sum, 0);
        return count;
    }
    
    private void helper(TreeNode root, Map<Integer, Integer> map, int target, int sum) {
        sum += root.val;
        if (sum==target)
            count++;
        count += map.getOrDefault(sum-target, 0);
        map.put(sum, map.getOrDefault(sum,0)+1);
        if (root.left!=null)
            helper(root.left, map, target, sum);
        if (root.right!=null)
            helper(root.right, map, target, sum);
        if (map.get(sum)==1) {
            map.remove(sum);
        } else {
            map.put(sum, map.get(sum)-1);
        }
    }
}
