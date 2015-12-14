public class _147_InsertionSortList {
    
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        ListNode next = head.next;
        head.next = null;
        while ((cur = next) != null) {
            next = cur.next;
            if (cur.val < head.val) {
                cur.next = head;
                head = cur;
            } else {
                ListNode p = head;
                while (p.next != null && p.next.val <= cur.val) {
                    p = p.next;
                }
                p.next = cur;
                cur.next = p.next;
            }
        }
        return head;
    }
}