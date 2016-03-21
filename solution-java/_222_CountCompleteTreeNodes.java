/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.
*/
public class _222_CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int h = height(root);
        return height(root.right) == h - 1) ? (1 << (h - 1)) + countNodes(root.right) : (1 << (h - 2)) + countNodes(root.left);
    }

    private int height(TreeNode p) {
        int height = 0;
        while (p != null) {
            height++;
            p = p.left;
        }
        return height;
    }
}
