public class _114_FlattenBinaryTreeToLinkedList {
    
    public void flatten(TreeNode root) {
        
    }

    private TreeNode traverse(TreeNode root) {
        if (root.left == null && right.right == null)
            return root;
        if (root.left != null)
            return traverse(root.left);
        if (root.right != null)
            return traverse(root.right);
    }
}