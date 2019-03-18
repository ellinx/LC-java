package solutions;

import java.util.ArrayList;
import java.util.List;

/**
Given a singly linked list, determine if it is a palindrome.

Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        //System.out.println(list);
        int l=0, r=list.size()-1;
        while (l<r) {
            if (list.get(l).intValue()!=list.get(r).intValue()) {
                //System.out.println(l+","+r);
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    //test
    public static void main(String[] args) {
    	PalindromeLinkedList pll = new PalindromeLinkedList();
    	int[] nums = {-129,-129};
    	ListNode head = ListNode.constructFromArray(nums);
    	boolean result = pll.isPalindrome(head);
    	System.out.println(result);
	}
}
