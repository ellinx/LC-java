package ellinx.solutions;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 
 * Output: 1->1->2->3->4->4
 * 
 * @author Ellinx
 *
 */
public class MergeTwoSortedLists {
	//iterative
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode res = null;
        ListNode cur = null;
        
        if (l1==null && l2!=null) 
            return l2;
        if (l1!=null && l2==null) 
            return l1;
        
        while (node1!=null && node2!=null) {
            if (node1.val < node2.val) {
                ListNode node = new ListNode(node1.val);
                if (cur==null) {
                    cur = node;
                    res = node;
                } else {
                    cur.next = node;
                    cur = node;
                }
                node1 = node1.next;
            } else if (node1.val > node2.val) {
                ListNode node = new ListNode(node2.val);
                if (cur==null) {
                    cur = node;
                    res = node;
                } else {
                    cur.next = node;
                    cur = node;
                }
                node2 = node2.next;
            } else {
                ListNode node = new ListNode(node1.val);
                if (cur==null) {
                    res = node;
                    cur = node;
                    cur.next = new ListNode(node2.val);
                    cur = cur.next;
                } else {
                    cur.next = node;
                    cur = node;
                    cur.next = new ListNode(node2.val);
                    cur = cur.next;
                }
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        
        while (node1!=null) {
            cur.next = new ListNode(node1.val);
            cur = cur.next;
            node1 = node1.next;
        }
        while (node2!=null) {
            cur.next = new ListNode(node2.val);
            cur = cur.next;
            node2 = node2.next;
        }
        return res;
    }
	
	//recursive
	public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        
        if (l1.val < l2.val) {
            ListNode res = l1;
            l1.next = mergeTwoLists(l1.next, l2);
            return res;
        } else {
            ListNode res = l2;
            l2.next = mergeTwoLists(l1, l2.next);
            return res;
        }
        
    }
	
	//test
	
}
