package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ellinx
 *
 */
public class BinaryTree {
	private TreeNode root;
	private int depth;
	
	public BinaryTree(Integer[] nums) {
		root = new TreeNode(nums[0]);
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		int index = 1;
		int level = 0;
		nodes.add(root);
		
		while (index<nums.length) {
			ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
			for (TreeNode node : nodes) {
				if (index<nums.length) {
					if (nums[index] != null) {
						node.left = new TreeNode(nums[index]);
					}
					index++;
				}
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				
				if (index<nums.length) {
					if (nums[index] != null) {
						node.right = new TreeNode(nums[index]);
					}
					index++;
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}
			nodes = nextLevel;
			level++;
		}
		depth = level;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void print() {
		List<List<TreeNode>> BFS = BFS();
		for (List<TreeNode> level : BFS) {
			for (TreeNode node : level) {
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<TreeNode>> BFS() {
		ArrayList<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
		ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
		ArrayList<TreeNode> cur;
		
		pre.add(root);
		while (!pre.isEmpty()) {
			cur = new ArrayList<TreeNode>();
			for (TreeNode node : cur) {
				if (node.left != null) {
					cur.add(node.left);
				}
				if (node.right != null) {
					cur.add(node.right);
				}
			}
			res.add(pre);
			pre = cur;
		}
		return res;
	}
}
