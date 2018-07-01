package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 *
 */
public class LinkedListCycle {
	/**
	 * Thoughts:
	 * 1. use two pointer fast and slow
	 * 2. fast move 2 steps and slow move 1 step
	 * 3. if fast and slow meet, there is cycle
	 * 
	 * Time: O(n) where n is length of list
	 * Space: O(1)
	 */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null) {
            if (fast.next==null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                return true;
            }
        }
        return false;
    }
    
	/**
	 * Thoughts:
	 * 1. go through the list and store node already visited
	 * 2. if see node that already visited, then there is cycle
	 * 
	 * Time: O(n) where n is total number of nodes in the list
	 * Space: O(n)
	 */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }
}
