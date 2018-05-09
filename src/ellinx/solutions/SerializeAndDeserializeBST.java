package ellinx.solutions;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 * @author Ellinx
 *
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
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left != null) {
        	sb.append(',');
        	sb.append(serialize(root.left));
        }
        if (root.right != null) {
        	sb.append(',');
        	sb.append(serialize(root.right));
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        
        int start = 0;
        int end = 0;
        int leftStart = -1;
        int rightStart = -1;
        
        while (end<data.length() && data.charAt(end)!=',') {
        	end++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, end)));
        if (end == data.length()) {
        	//only one value
        	return root;
        } else {
        	start = ++end;
        }
        
        while (end < data.length()) {
        	while (end < data.length() && data.charAt(end)!=',') {
        		end++;
        	}
        	int cur = Integer.parseInt(data.substring(start,end));
        	if (cur < root.val) {
        		//left subtree node
        		if (leftStart==-1)
        			leftStart = start;
        		
        		start = ++end;
        	} else {
        		rightStart = start;
        		break;
        	}
        }
        
        if (leftStart!=-1) {
        	int leftEnd = (rightStart==-1)?data.length():rightStart-1;
        	String leftStr = data.substring(leftStart,leftEnd);
        	root.left = deserialize(leftStr);
        }
        if (rightStart!=-1) {
        	String rightStr = data.substring(rightStart);
        	root.left = deserialize(rightStr);
        }
        
        return root;
    }
    
    //Your SerializeAndDeserializeBST object will be instantiated and called as such:
    //SerializeAndDeserializeBST codec = new Codec();
    //codec.deserialize(codec.serialize(root));
    public static void main(String[] args) {
    	SerializeAndDeserializeBST tmp = new SerializeAndDeserializeBST();
	}
    
}

