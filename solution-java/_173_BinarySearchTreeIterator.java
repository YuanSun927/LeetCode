/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

public class _173_BinarySearchTreeIterator {

    private TreeNode cur;
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        cur = root;
        if (root != null)
            stack.push(root);
        while (cur != null && cur.left != null) {
            cur = cur.left;
            stack.push(cur);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        if (cur == null || stack.isEmpty())
            return -1;
        TreeNode temp = stack.pop();
        if (temp.right != null) {
            stack.push(temp.right);
            cur = temp.right;
            while (cur != null && cur.left != null) {
                cur = cur.left;
                stack.push(cur);
            }
        } else {
            cur = stack.isEmpty() ? null : stack.peek();
        }
        return temp.val;
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */