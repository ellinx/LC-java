package ellinx.solutions;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example 
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 
 * Return: 1 --> 2--> 3 --> 4 --> 5
 * 
 * @author Ellinx
 *
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = null;
        if (head==null) return newHead;
        ListNode pre = null;
        ListNode cur = head;
        
        while (cur!=null) {
        	if (newHead==null) {
        		if (cur.val==val) {
        			pre = cur;
        			cur = cur.next;
        		} else {
        			newHead = cur;
        			pre = cur;
        			cur = cur.next;
        		}
        	} else {
        		if (cur.val==val) {
        			pre.next = cur.next;
        			cur = cur.next;
        		} else {
        			pre = cur;
        			cur = cur.next;
        		}
        	}
        }
        return newHead;
    }
	
	//test
	public static void main(String[] args) {
		RemoveLinkedListElements tmp = new RemoveLinkedListElements();
		
	}
}
