/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
public class _143_ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        // 1. Find the middle of the list
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        // 2. Reverse the second half list
        ListNode p = mid.next;
        mid.next = null;
        while (p != null) {
            ListNode temp = p.next;
            p.next = mid;
            mid = p;
            p = temp;
        }

        // 3. Merge the two lists
        p = head;
        while (mid != null) {
            ListNode temp = mid.next;
            mid.next = p.next;
            p.next = mid;
            p = mid.next;
            mid = temp;
        }
    }
}