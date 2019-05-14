/**
 Serialization is the process of converting a data structure or object into a sequence of bits
 so that it can be stored in a file or memory buffer,
 or transmitted across a network connection link to be reconstructed later
 in the same or another computer environment.

 Design an algorithm to serialize and deserialize an N-ary tree.
 An N-ary tree is a rooted tree in which each node has no more than N children.
 There is no restriction on how your serialization/deserialization algorithm should work.

 You just need to ensure that an N-ary tree can be serialized to a string and
 this string can be deserialized to the original tree structure.

 For example, you may serialize the following 3-ary tree

                            1
                         /  |   \
                        3   2    4
                       / \
                      5   6

 as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format,
 so please be creative and come up with different approaches yourself.



 Note:
 1. N is in the range of [1, 1000]
 2. Do not use class member/global/static variables to store states.
    Your serialize and deserialize algorithms should be stateless.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class SerializAndDeserializeNaryTree {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root==null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder(Integer.toString(root.val));
        if (root.children==null || root.children.size()==0) {
            sb.append(",0");
            return sb.toString();
        }
        sb.append(","+Integer.toString(root.children.size()));
        for (int i=0;i<root.children.size();i++) {
            sb.append(","+serialize(root.children.get(i)));
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        //System.out.println(data);
        if (data.equals("#")) {
            return null;
        }
        String[] nums = data.split(",");
        int[] idx = {0};
        return dfs(nums,idx);
    }
    private Node dfs(String[] nums, int[] idx) {
        Node ret = new Node(Integer.parseInt(nums[idx[0]]), new ArrayList<Node>());
        idx[0]++;
        int total = Integer.parseInt(nums[idx[0]]);
        idx[0]++;
        for (int i=0;i<total;i++) {
            ret.children.add(dfs(nums,idx));
        }
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));