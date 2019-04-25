package solutions;

/**
Convert a BST to a sorted circular doubly-linked list in-place. 
Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:

                      4
                    /   \
                   2     5
                 /   \
                1     3

 
We want to transform this BST into a circular doubly linked list. 
Each node in a doubly linked list has a predecessor and successor. 
For a circular doubly linked list, the predecessor of the first element is the last element, 
and the successor of the last element is the first element.

         1 <-> 2 <-> 3 <-> 4 <-> 5


The figure below shows the circular doubly linked list for the BST above. 
The "head" symbol means the node it points to is the smallest element of the linked list.

 

Specifically, we want to do the transformation in place. 
After the transformation, the left pointer of the tree node should point to its predecessor, 
and the right pointer should point to its successor. 

We should return the pointer to the first element of the linked list.

The figure below shows the transformed BST. The solid line indicates the successor relationship, 
while the dashed line means the predecessor relationship.
 */

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	}
	
    public Node treeToDoublyList(Node root) {
        Node[] ret = flatten(root);
        if (ret[0]==null) {
            return null;
        }
        ret[0].left = ret[1];
        ret[1].right = ret[0];
        return ret[0];
    }
    private Node[] flatten(Node root) {
        Node[] ret = new Node[2];
        if (root==null) {
            return ret;
        }
        Node[] l = flatten(root.left);
        Node[] r = flatten(root.right);
        if (l[0]==null) {
            ret[0] = root;
        } else {
            ret[0] = l[0];
            l[1].right = root;
            root.left = l[1];
        }
        if (r[0]==null) {
            ret[1] = root;
        } else {
            ret[1] = r[1];
            root.right = r[0];
            r[0].left = root;
        }
        return ret;
    }
}
