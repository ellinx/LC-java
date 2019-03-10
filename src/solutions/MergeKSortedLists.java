package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
Merge k sorted linked lists and return it as one sorted list. 
Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    class Pair {
        int index;
        ListNode node;
        
        public Pair(int index, ListNode node) {
            this.index = index;
            this.node = node;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.node.val-b.node.val;
            }
        });
        for (int i=0;i<lists.length;i++) {
            if (lists[i]!=null) {
                pq.offer(new Pair(i,lists[i]));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            cur.next = temp.node;
            cur = cur.next;
            if (temp.node.next!=null) {
                pq.offer(new Pair(temp.index, temp.node.next));
            }
        }
        return dummy.next;
    }
}
