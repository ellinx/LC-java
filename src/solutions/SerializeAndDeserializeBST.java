package solutions;

/**
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same 
or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string and 
this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: 
1. Do not use class member/global/static variables to store states. 
2. Your serialize and deserialize algorithms should be stateless.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) {
            return "";
        }
        String ret = Integer.toString(root.val);
        String left = serialize(root.left);
        if (left.length()>0) {
            ret += ","+left;
        }
        String right = serialize(root.right);
        if (right.length()>0) {
            ret += ","+right;
        }
        //System.out.println(ret);
        return ret;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) {
            return null;
        }
        int l=0;
        while (l<data.length() && data.charAt(l)!=',') {
            l++;
        }
        TreeNode ret = new TreeNode(Integer.parseInt(data.substring(0,l)));
        if (l==data.length()) {
            return ret;
        }
        int idx1 = l;
        l++;
        int r = l;
        while (r<data.length()) {
            while (r<data.length() && data.charAt(r)!=',') {
                r++;
            }
            if (Integer.parseInt(data.substring(l,r))>ret.val) {
                break;
            }
            r++;
            l = r;
        }
        if (idx1+1<=l-1) {
            ret.left = deserialize(data.substring(idx1+1,l-1));
        }
        if (l<data.length()) {
            ret.right = deserialize(data.substring(l));
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

