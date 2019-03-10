package solutions;

import java.util.Stack;

/**
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work.

You just need to ensure that a binary tree can be serialized to a string and 
this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Clarification: The above format is the same as how LeetCode serializes a binary tree. 
				You do not necessarily need to follow this format, so please be creative and 
				come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. 
		Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree {
	/**
	 * Thoughts:
	 * 1. preorder serialize
	 * 
	 * Time: O(n) where n is total number of nodes in the tree
	 * Space: O(n)
	 */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stk = new Stack<>();
        while (root!=null || !stk.isEmpty()) {
            if (root!=null) {
                if (sb.length()==0) {
                    sb.append(Integer.toString(root.val));
                } else {
                    sb.append(","+root.val);
                }
                stk.push(root);
                root = root.left;
            } else {
                sb.append(",#");
                root = stk.pop();
                root = root.right;
            }
        }
        sb.append(",#");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] idx = {0};
        return dfs(vals, idx);
    }
    private TreeNode dfs(String[] vals, int[] idx) {
        String s = vals[idx[0]];
        idx[0]++;
        if (s.equals("#")) {
            return null;
        }
        int val = Integer.parseInt(s);
        TreeNode ret = new TreeNode(val);
        ret.left = dfs(vals, idx);
        ret.right = dfs(vals, idx);
        return ret;
    }
    
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));