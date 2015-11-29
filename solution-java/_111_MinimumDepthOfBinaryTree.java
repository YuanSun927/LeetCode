public class _111_MinimumDepthOfBinaryTree {

	public int minDepth(TreeNode root) {
        if (root == null)
        	return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
       	int level = 1;
        while (!queue.isEmpty()) {
        	int levelSize = queue.size();
        	for (int i = 0; i < levelSize; i++) {
        		TreeNode t = queue.remove();
        		if (t.left == null && t.right == null)
        			return level;
        		if (t.left != null)
        			queue.add(t.left);
        		if (t.right != null)
        			queue.add(t.right);
        	}
        	level++;
        }
        return level;
    }
}