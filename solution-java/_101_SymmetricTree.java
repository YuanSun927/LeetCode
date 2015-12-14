/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/
public class _101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        if (!(root.left != null && root.right != null && root.left.val == root.right.val))
            return false;
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        lStack.push(root.left);
        rStack.push(root.right);
        while(!lStack.isEmpty() && !rStack.isEmpty()) {
            TreeNode lNode = lStack.pop();
            TreeNode rNode = rStack.pop();
            if (lNode.val != rNode.val)
                return false;
            if (lNode.left != null && rNode.right != null) {
                lStack.push(lNode.left);
                rStack.push(rNode.right);
            } else if (lNode.left != rNode.right) {
                return false;
            }
            if (lNode.right != null && rNode.left != null) {
                lStack.push(lNode.right);
                rStack.push(rNode.left);
            } else if (lNode.right != rNode.left) {
                return false;
            }
        }
        return lStack.isEmpty() && rStack.isEmpty();
    }
}