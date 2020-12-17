/*
 *Level Order Traversal of BT
 */
package com.pk.algorithms.trees;

/**
 *
 * @author parveenkumar
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
    //Definition of Binary Tree Node
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        //Store output list in result variable
        List<List<Integer>> result = new ArrayList<>();
         if(root == null)
            return result;
        //Using Breath First Traversal
        //Declare a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //Declare another list of integers to store current level
            List<Integer> currentLevel = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.remove();
                currentLevel.add(currentNode.val);
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
