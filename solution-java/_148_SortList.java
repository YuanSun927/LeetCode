/*
Sort a linked list in O(n log n) time using constant space complexity.
*/
public class _148_SortList {
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        p.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}