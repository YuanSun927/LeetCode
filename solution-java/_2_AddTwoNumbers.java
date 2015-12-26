/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
public class _2_AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int carry = 0;
        ListNode p = l1, q = l2;
        ListNode res = new ListNode(0);
        ListNode tail = res;
        int a = 0, b = 0;
        while (p != null || q != null) {
            carry += p == null ? 0 : p.val;
            carry += q == null ? 0 : q.val;
            ListNode newNode = new ListNode(carry % 10);
            carry /= 10;
            tail.next = newNode;
            tail = newNode;
            p = p == null ? p : p.next;
            q = q == null ? q : q.next;
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return res.next;
    }
}