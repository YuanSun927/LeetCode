public class _86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode smallStart = new ListNode(0);
        ListNode smallEnd = smallStart;
        ListNode largeStart = new ListNode(0);
        ListNode largeEnd = largeStart;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            if (p.val <= x) {
                smallEnd.next = p;
                smallEnd = p;
            } else {
                largeEnd.next = p;
                largeEnd = p;
            }
            p.next = null;
            p = next;
        }
        smallEnd.next = largeStart.next;
        return smallStart.next;
    }
}