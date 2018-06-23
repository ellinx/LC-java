package solutions;

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
	/**
	 * Thoughts:
	 * Go through whole list and remove node which has value val
	 * 
	 * Time: O(n) where n is length of list
	 * Space: O(1)
	 */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next!=null) {
            if (cur.next.val==val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
	
	//test
	public static void main(String[] args) {
		int[] arr = {1,2,6,3,4,5,6};
		int val = 6;
		RemoveLinkedListElements tmp = new RemoveLinkedListElements();
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int num:arr) {
			cur.next = new ListNode(num);
			cur = cur.next;
		}
		tmp.removeElements(dummy.next, val);
		System.out.println(dummy.next);
	}
}
