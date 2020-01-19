/*
 * Contruct Binary Tree From Preorder and Inorder Traversals
 */
package com.pk.algorithms.trees;

/**
 *
 * @author parveenkumar
 */
import java.util.HashMap;
public class ConstructBTFromPreorderAndInorder {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    int pre_index = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        this.inorder = inorder;
        //build a hash map
        int index = 0;
        for(Integer value : inorder){
            indexMap.put(value, index++);
        }
        return helper(0, inorder.length);
    }
    private TreeNode helper(int inorderLeft, int inorderRight){
        if(inorderLeft == inorderRight)
            return null;
        int rootVal = preorder[pre_index];
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);
        //Recursion
        pre_index++;
        //build left subtree
        root.left = helper(inorderLeft, index);
        //build right subtree
        root.right = helper(index + 1, inorderRight);
        return root;
    }
}
