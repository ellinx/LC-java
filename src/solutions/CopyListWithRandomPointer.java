package solutions;

import java.util.HashMap;
import java.util.Map;

/**

A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.

Return a deep copy of the list.

Example 1:

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.

Note:
1. You must return the copy of the given head as a reference to the cloned list.
 */

public class CopyListWithRandomPointer {
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	}
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node();
        Node cur1 = dummy;
        Node cur2 = head;
        while (cur2!=null) {
            cur1.next = new Node(cur2.val, null, null);
            map.put(cur2, cur1.next);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur1 = dummy.next;
        cur2 = head;
        while (cur1!=null) {
            cur1.random = map.getOrDefault(cur2.random, null);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return dummy.next;
    }
}
