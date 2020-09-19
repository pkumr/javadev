/*
 * InOrder Traversal
 */
package com.pk.algorithms.trees;

/**
 *
 * @author parveenkumar
 * 
 * Tree Traversals
 * 1. PreOrder --> root --> left --> right
 * 2. InOrder --> left --> root --> right
 * 3. PostOrder --> left --> right --> root
 * 
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

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
    
    //Method#2 - Interative Approach
    //Stack is used in this approach
    public List<Integer> inOrderTraversalIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
