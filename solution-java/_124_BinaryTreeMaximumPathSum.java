/*
124. Binary Tree Maximum Path Sum My Submissions Question
Total Accepted: 61080 Total Submissions: 264938 Difficulty: Hard
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node
in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/
public class _124_BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode p, int[] max) {
        if (p == null)
            return 0;
        int leftMax = Math.max(maxPathSum(p.left, max), 0);
        int rightMax = Math.max(maxPathSum(p.right, max), 0);
        max[0] = Math.max(max[0], p.val + leftMax + rightMax);
        return p.val + Math.max(leftMax, rightMax);
    }
}