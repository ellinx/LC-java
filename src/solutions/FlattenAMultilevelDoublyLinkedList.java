package solutions;

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	}
	
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        Node pre = dummy;
        Stack<Node> stk = new Stack<>();
        while (true) {
            while (pre.next!=null) {
                // System.out.println(pre.val);
                Node cur = pre.next;
                if (cur.child==null) {
                    pre = cur;
                    continue;
                }
                stk.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                pre = cur;
            }
            if (stk.isEmpty()) {
                break;
            }
            pre.next = stk.pop();
            if (pre.next!=null) {
                pre.next.prev = pre;
            }
        }
        return dummy.next;
    }
}
