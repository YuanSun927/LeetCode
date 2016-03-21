/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
public class _98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode p, Integer min, Integer max) {
        if (p == null)
            return true;
        return (min == null || p.val > min) && (max == null || p.val < max)
                && isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode prev = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            if (prev != null && prev.val >= node.val)
                return false;
            prev = node;
            p = node.right;
        }
        return true;
    }

    // Morris
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && prev.val >= cur.val)
                    return false;
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur) {
                    node = node.right;
                }
                if (node.right == null) {
                    node.right = cur;
                    cur = cur.left;
                } else {
                    if (prev != null && prev.val >= cur.val)
                        return false;
                    node.right = null;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        return true;
    }
}