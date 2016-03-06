/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
public class _23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low == high)
            return lists[low];
        if (high - low == 1)
            return mergeTwoLists(lists[low], lists[high]);
        int mid = low + ((high - low) >> 2);
        ListNode l1 = mergeKLists(lists, low, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, high);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode p = l1, q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                tail.next = p;
                p = p.next;
            } else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }
        tail.next = p != null ? p : q;
        return dummy.next;
    }
}