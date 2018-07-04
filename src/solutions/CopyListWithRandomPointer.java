package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author Ellinx
 *
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> copied = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur1 = head;
        RandomListNode cur2 = dummy;
        while (cur1!=null) {
            cur2.next = new RandomListNode(cur1.label);
            copied.put(cur1,cur2.next);
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        cur1 = head;
        cur2 = dummy.next;
        while (cur1!=null) {
            if (cur1.random!=null) {
                cur2.random = copied.get(cur1.random);
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return dummy.next;
    }
}
