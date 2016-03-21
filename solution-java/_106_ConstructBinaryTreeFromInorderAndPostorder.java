/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public class _106_ConstructBinaryTreeFromInorderAndPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inPosMap.put(inorder[i], i);
        }
        return buildTree(inPosMap, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> inPosMap, int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inEnd < inStart)
            return null;
        int inPos = inPosMap.get(postorder[postEnd]);
        TreeNode parent = new TreeNode(postorder[postEnd]);
        parent.left  = buildTree(inPosMap, inorder, inStart, inPos - 1, postorder, postStart, postStart + inPos - inStart - 1);
        parent.right = buildTree(inPosMap, inorder, inPos + 1, inEnd, postorder, postStart + inPos - inStart, postEnd - 1);
        return parent;
    }
}