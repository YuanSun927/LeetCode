/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
public class _110_BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
    	if (root == null)
    		return true;
    	return depth(root) != -1;
    }

    private int depth(TreeNode root) {
    	if (root.left == null && root.right == null)
    		return 1;
    	int lDepth = 0;
    	int rDepth = 0;
    	if (root.left != null)
    		lDepth = depth(root.left);
    	if (root.right != null)
    		rDepth = depth(root.right);
    	if (lDepth == -1 || rDepth == -1)
    	    return -1;
    	if (Math.abs(lDepth - rDepth) > 1)
    		return -1;
    	else
    		return Math.max(lDepth, rDepth) + 1;
    }
}
