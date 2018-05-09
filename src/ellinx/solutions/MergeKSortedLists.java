package ellinx.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * @author Ellinx
 *
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode cur = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val-b.val;
            }
        });
        
        for (ListNode list:lists) {
            if (list!=null)
                pq.add(list);

        }
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (cur==null) {
                cur = node;
                head = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
            node = node.next;
            if (node!=null) {
                pq.add(node);
            }
        }
        return head;
    }
}
