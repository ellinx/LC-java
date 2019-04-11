package solutions;

import java.util.Stack;

/**
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stk1 = new Stack<>();
        while (l1!=null) {
            stk1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stk2 = new Stack<>();
        while (l2!=null) {
            stk2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> stk3 = new Stack<>();
        int carry = 0;
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            int sum = stk1.pop()+stk2.pop()+carry;
            stk3.push(sum%10);
            carry = sum/10;
        }
        while (!stk1.isEmpty()) {
            int sum = stk1.pop()+carry;
            stk3.push(sum%10);
            carry = sum/10;
        }
        while (!stk2.isEmpty()) {
            int sum = stk2.pop()+carry;
            stk3.push(sum%10);
            carry = sum/10;
        }
        if (carry>0) {
            stk3.push(carry);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!stk3.isEmpty()) {
            cur.next = new ListNode(stk3.pop());
            cur = cur.next;
        }
        return dummy.next;
    }
}
