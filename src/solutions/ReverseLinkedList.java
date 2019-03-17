package solutions;

public class ReverseLinkedList {
	//iterative
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    //recursive
    public ListNode reverseList2(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode next = head.next;
        if (next==null) {
            return head;
        }
        ListNode ret = reverseList(next);
        next.next = head;
        head.next = null;
        return ret;
    }
}
