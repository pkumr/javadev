/*
 * InOrder Traversal
 */
package com.pk.algorithms.trees;

/**
 *
 * @author parveenkumar
 */
import java.util.List;
import java.util.ArrayList;

public class BinaryTreeInOrderTraversal {
     //Definition of Binary Tree Node
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    //Method#1 - Recursive Approach
    public List<Integer> inOrderTraversalRecursive(TreeNode root){
        List<Integer> result = new ArrayList<>();
        helperRecursive(result, root);
        return result;
    }
    public void helperRecursive(List<Integer> result, TreeNode root){
        if(root != null){
            if(root.left != null){
                helperRecursive(result, root.left);
            }
            result.add(root.val);
            if(root.right != null){
                helperRecursive(result, root.right);
            }
        }
    }
}
