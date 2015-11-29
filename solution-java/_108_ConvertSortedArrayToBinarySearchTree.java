/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/
public class _108_ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int low, int high) {
        if (high < low)
            return null;
        int half = low + ((high - low) >> 1);
        TreeNode root = new TreeNode(nums[half]);
        TreeNode left = buildTree(nums, low, half - 1);
        TreeNode right = buildTree(nums, half + 1, high);
        root.left = left;
        root.right = right;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}