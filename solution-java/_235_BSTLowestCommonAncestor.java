package com.yuan.leetcode;

import java.util.Stack;


/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: 
 * "The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
 * that has both v and w as descendants (where we allow a node to be a descendant of itself)."
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
 * Another example is LCA of nodes 2 and 4 is 2, 
 * since a node can be a descendant of itself according to the LCA definition.
 *
 */
public class _235_BSTLowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean isPFound = false;
        boolean isQFound = false;
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        TreeNode node = root;
        while (!(isPFound && isQFound)) {
            while (node != null) {
                if (!isPFound) {
                    stackP.push(node);
                }
                if (!isQFound) {
                    stackQ.push(node);
                }
                if (node == p) {
                    isPFound = true;
                }
                if (node == q) {
                    isQFound = true;
                }
                if (isPFound && isQFound) {
                    break;
                }
                node = node.left;
            }
            if (node == null) {
                if (!isPFound && !isQFound) {
                    stackQ.pop();
                    node = stackP.pop().right;
                } else if (!isPFound) {
                    node = stackP.pop().right;
                } else if (!isQFound) {
                    node = stackQ.pop().right;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        int pSize = stackP.size();
        int qSize = stackQ.size();
        if (pSize >= qSize) {
            for (int i = 0; i < (pSize -qSize); i++) {
                stackP.pop();
            }
        } else {
            for (int i = 0; i < (qSize -pSize); i++) {
                stackQ.pop();
            }
        }
        TreeNode ancestor = null;
        for (int i = 0; i < stackP.size(); i++) {
            if ((ancestor = stackP.pop()) == stackQ.pop()) {
                return ancestor;
            }
        }
        return ancestor;
    }
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node6.left = node2;
        node6.right = node8;
        node2.left = node0;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node8.left = node7;
        node8.right = node9;
        System.out.println(new _235_BSTLowestCommonAncestor().lowestCommonAncestor(node6, node5, node7).val);
    }
}
