/*
 * 
 */
package com.pk.algorithms.dfs;

/**
 *
 * @author parveenkumar
 */
public class MaximumDepthBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public int maximumDepthBT(TreeNode root){
        if (root == null){
            return 0;
        }
        else{
            int leftDepth = maximumDepthBT(root.left);
            int rightDepth = maximumDepthBT(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
