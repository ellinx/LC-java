package ellinx.solutions;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 1. The left subtree of a node contains only nodes with keys less than the node's key. 
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key. 
 * 3. Both the left and right subtrees must also be binary search trees. 
 * 
 * Example 1: 
 * 		2 
 * 	   / \ 
 * 	  1   3 
 * Binary tree [2,1,3], return true. 
 * 
 * Example 2: 
 * 		1 
 * 	   / \ 
 * 	  2   3 
 * Binary tree [1,2,3], return false.
 * 
 * @author Ellinx
 *
 */
public class ValidateBST {
	/*recursive*/
	public boolean isValidBST(TreeNode root) {
        if (root==null)
        	return true;
        
        TreeNode[] pre = new TreeNode[1];
        return inorderCheck(root, pre);
    }
	private boolean inorderCheck(TreeNode root, TreeNode[] pre) {
		//left child
		if (root.left!=null) {
			if (!inorderCheck(root.left, pre))
				return false;
		}
		
		//root
		if (pre[0]!=null) {
			if (pre[0].val >= root.val) {
				return false;
			}
		}
		pre[0] = root;
		
		//right child
		if (root.right!=null) {
			if (!inorderCheck(root.right, pre))
				return false;
		}
		
		return true;
	}
	
	/*iterative*/
	public boolean isValidBST2(TreeNode root) {
		if (root==null)
			return true;
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;

		while (root!=null || !stack.empty()) {
			while (root!=null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			if (pre!=null) {
				if (pre.val >= root.val) {
					return false;
				}
			}
			pre = root;
			root = root.right;
		}
		return true;
	}
	
	
	//test
	public static void main(String[] args) {

	}
}
