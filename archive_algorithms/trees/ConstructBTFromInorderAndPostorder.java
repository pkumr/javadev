/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 */
package com.pk.algorithms.trees;

/**
 *
 * @author parveenkumar
 */
import java.util.HashMap;
public class ConstructBTFromInorderAndPostorder {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    int post_index;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.postorder = postorder;
        this.inorder = inorder;
        //post order sequence is left -> right -> root (root in end)
        //start from the last element in postorder array
        post_index = postorder.length - 1;
        //build a hashmap
        int index = 0;
        for(Integer value : inorder){
            indexMap.put(value, index++);
        }
        return helper(0, inorder.length - 1);
    }
    private TreeNode helper(int inorderLeft, int inorderRight){
        if(inorderLeft > inorderRight)
            return null;
        
        int rootVal = postorder[post_index];
        TreeNode root = new TreeNode(rootVal);
        //root is used to split inorder list into left and right subtrees
        int index = indexMap.get(rootVal);
        //Recursive call to build trees
        post_index--;
        //build right subtree
        root.right = helper(index + 1, inorderRight);
        //build left subtree
        root.left = helper(inorderLeft, index - 1);
        return root;
    }
}
