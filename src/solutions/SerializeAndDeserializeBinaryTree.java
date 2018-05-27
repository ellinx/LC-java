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
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)
            return "";
        return root.val+"?"+serialize(root.left)+":"+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0)
            return null;
        int index1 = data.indexOf("?");
        if (index1==-1)
            return new TreeNode(Integer.parseInt(data));
        int left = 0;
        int index2 = index1+1;
        while (index2<data.length()) {
            if (data.charAt(index2)=='?')
                left++;
            if (data.charAt(index2)==':') {
                if (left==0)
                    break;
                left--;
            }
            index2++;
        }
        TreeNode ret = new TreeNode(Integer.parseInt(data.substring(0,index1)));
        ret.left = deserialize(data.substring(index1+1,index2));
        ret.right = deserialize(data.substring(index2+1));
        return ret;
    }
    

 // Your Codec object will be instantiated and called as such:
 // Codec codec = new Codec();
 // codec.deserialize(codec.serialize(root));
}
