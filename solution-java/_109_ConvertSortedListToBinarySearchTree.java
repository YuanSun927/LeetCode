/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public class _109_ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre != null)
            pre.next = null;
        else
            head = null;
        TreeNode parent = new TreeNode(slow.val);
        parent.left = sortedListToBST(head);
        parent.right = sortedListToBST(slow.next);
        return parent;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}