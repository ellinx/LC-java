package solutions;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(val);
		ListNode cur = next;
		while (cur!=null) {
			sb.append(",").append(cur.val);
			cur = cur.next;
		}
		return sb.toString();
	}
	
	public static ListNode constructFromArray(int[] nums) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int num:nums) {
			cur.next = new ListNode(num);
			cur = cur.next;
		}
		return dummy.next;
	}
	
}
