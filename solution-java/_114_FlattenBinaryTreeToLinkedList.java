public class _114_FlattenBinaryTreeToLinkedList {
    
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        if (left == null)
            return;
        root.right = left;
        root.left = null;
        while (left.right != null)
            left = left.right;
        left.right = right;
    }

}