package ellinx.solutions;

import java.util.ArrayList;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 * Example 1:
 * Input:
 * 
 *     2
 *    / \
 *   1   3
 * 
 * Output:
 * 1
 * Example 2: 
 * Input:
 * 
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 * 
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 * @author Ellinx
 *
 */
public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        ArrayList<TreeNode> cur;
        int res=0;
        
        pre.add(root);
        while (!pre.isEmpty()) {
        	cur = new ArrayList<TreeNode>();
        	res = pre.get(0).val;
        	for (TreeNode node : pre) {
            	if (node.left != null) {
            		cur.add(node.left);
            	}
            	if (node.right != null) {
            		cur.add(node.right);
            	}
            }
        	pre = cur;
        }
        
        return res;
    }
	
	//test
	public static void main(String[] args) {
		FindBottomLeftTreeValue EBLT = new FindBottomLeftTreeValue();
		Integer[] nums = {1,2,3,4,5,6,null,7};
		BinaryTree BT = new BinaryTree(nums);
		int result = EBLT.findBottomLeftValue(BT.getRoot());
		System.out.println(result);
	}
}
