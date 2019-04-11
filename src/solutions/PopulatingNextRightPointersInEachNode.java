package solutions;

/**
You are given a perfect binary tree where all leaves are on the same level, 
and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example:

          1                                1->null
        /   \                            /   \
      2      3              =>          2  -> 3 ->null
     /  \   /  \                       / \   / \
    4   5  6    7                     4 ->5->6->7->null

       (Figure A)                       (Figure B)

Explanation: Given the above perfect binary tree (Figure A), 
your function should populate each next pointer to point to its next right node, 
just like in Figure B.
 */

public class PopulatingNextRightPointersInEachNode {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
    public Node connect(Node root) {
        if (root==null) {
            return null;
        }
        Node cur = root;
        Node head = null;
        Node pre = null;
        while (cur!=null) {
            while (cur!=null && cur.left!=null) {
                if (head==null) {
                    head = cur.left;
                    cur.left.next = cur.right;
                    pre = cur.right;
                    cur = cur.next;
                    continue;
                }
                pre.next = cur.left;
                cur.left.next = cur.right;
                pre = cur.right;
                cur = cur.next;
            }
            cur = head;
            head = null;
            pre = null;
        }
        return root;
    }
}
