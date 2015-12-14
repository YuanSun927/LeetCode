/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
public class _92_ReverseLinkedListII {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n == m)
            return head;
        int index = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode interHead = null, next = null, firstEnd = dummy, secondEnd = head;
        while (p != null && index <= n) {
            if (index >= m && index <= n) {
                next = p.next;
                p.next = interHead;
                interHead = p;
                p = next;
            } else if (index == m - 1) {
                firstEnd = p;
                secondEnd = p.next;
                p = p.next;
            } else {
                p = p.next;
            }
            index++;
        }
        firstEnd.next = interHead;
        secondEnd.next = next;
        return dummy.next;
    }
}