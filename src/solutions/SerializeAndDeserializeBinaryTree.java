package solutions;

/**
 * 
 * Serialization is the process of converting a data structure or object 
 * into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later 
 * in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and 
 * this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * 
 * You may serialize the following tree:
 * 
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * @author Ellinx
 *
 */
public class SerializeAndDeserializeBinaryTree {
	/**
	 * Thoughts:
	 * 1. preorder serualize
	 * 
	 * Time: O(n) where n is total number of nodes in the tree
	 * Space: O(n)
	 */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) {
            return "#";
        }
        return Integer.toString(root.val)+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] start = {0};
        return helper(data, start);
    }

    private TreeNode helper(String s, int[] start) {
        int end = s.indexOf(',',start[0]);
        if (end==-1) {
            String valStr = s.substring(start[0]);
            if (valStr.equals("#")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(valStr));
        }
        String valStr = s.substring(start[0],end);
        if (valStr.equals("#")) {
            start[0] = end+1;
            return null;
        }
        start[0] = end+1;
        TreeNode ret = new TreeNode(Integer.parseInt(valStr));
        ret.left = helper(s, start);
        ret.right = helper(s, start);
        return ret;
    }
    

 // Your Codec object will be instantiated and called as such:
 // Codec codec = new Codec();
 // codec.deserialize(codec.serialize(root));
}
