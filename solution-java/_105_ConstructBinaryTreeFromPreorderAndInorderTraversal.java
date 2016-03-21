/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inPosMap.put(inorder[i], i);
        }
        return buildTree(inPosMap, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> inPosMap, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (inEnd < inStart)
            return null;
        int inPos = inPosMap.get(preorder[preStart]);
        TreeNode parent = new TreeNode(preorder[preStart]);
        parent.left  = buildTree(inPosMap, preorder, preStart + 1, preStart + inPos - inStart, inorder, inStart, inPos - 1);
        parent.right = buildTree(inPosMap, preorder, preStart + inPos - inStart + 1, preEnd, inorder, inPos + 1, inEnd); 
        return parent;
    }
}