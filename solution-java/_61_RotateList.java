/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
public class _61_RotateList {

    public ListNode rotateRight(ListNode head, int k) { 
        ListNode fast = head, slow = head;
        int len = 1;
        while (fast != null && fast.next != null) {
            len++;
            fast = fast.next;
        }
        if (len == 1 || k == 0 || (k %= len) == 0)
            return head;
        for (int i = 0; i < len - k - 1; i++) {
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }
}