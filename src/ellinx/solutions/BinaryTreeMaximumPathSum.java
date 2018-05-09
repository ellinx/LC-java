package ellinx.solutions;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 
 *    1 
 *   / \
 *  2   3 
 *  
 * Return 6.
 * 
 *
 */
public class BinaryTreeMaximumPathSum {
	int maxSum;
	
	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		maxDown(root);
        return maxSum;
    }
	
	private int maxDown(TreeNode root) {
		int res = 0;
		if (root == null) 
			return res;
		
		int left = Math.max(0, maxDown(root.left));
		int right = Math.max(0, maxDown(root.right));
		maxSum = Math.max(maxSum, left+right+root.val);
		return Math.max(left, right)+root.val;
	}
	
	//test
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
		
	}
}
