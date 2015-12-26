/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/
public class _25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) {
            len++;
        }
        if (len <= 1 || k == 1 || k > len)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode subHead = head, subTail = head;
        ListNode cur = head.next, next = cur != null ? cur.next : null;
        int i = 1;
        while (i < len - len % k) {
            next = cur.next;
            cur.next = subHead;
            subHead = cur;
            if ((i + 1) % k == 0) {
                tail.next = subHead;
                tail = subTail;
                subHead = next;
                subTail = next;
                if (i == len - len % k - 1 || next == null) {
                    cur = next;
                } else {
                    cur = next.next;
                }
                i += 2;
            } else {
                cur = next;
                i++;
            }
        }
        tail.next = cur;
        return dummy.next;
    }
}