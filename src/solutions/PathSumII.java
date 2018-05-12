package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 * 
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 
 * @author Ellinx
 *
 */
public class PathSumII {
	/**
	 * DFS search each root->leaf path
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root==null)
            return ret;
        dfs(root, sum, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ret) {
        if (root.left==null && root.right==null) {
            if (sum==root.val) {
                list.add(root.val);
                ret.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (root.left!=null)
            dfs(root.left, sum, list, ret);
        if (root.right!=null)
            dfs(root.right, sum, list, ret);
        list.remove(list.size()-1);
    }
}
