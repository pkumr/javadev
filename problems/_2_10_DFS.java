package com.depthfirst;
/*
 * Date - 2/10/2020 - 2/14/2020
 * 1. Maximum Depth of Binary Tree (LC# 104) E
 * 2. Critical Connections in a Network (LC# 1192) H
 * 3. Convert Sorted Array to Binary Search Tree (LC# 108) E
 * 4. Convert Sorted List to Binary Search Tree (LC# 109) M
 * 5. Decode String (LC# 394) M
 * 6. Binary Tree Maximum Path Sum (LC# 124)
 * 7. Construct Binary Tree from PreOrder and Inorder Traversal (LC# 105) M
 * 8. Construct Binary Tree from Inorder and PostOrder Traversal (LC# 106) M
 * 9. Same Tree (LC# 100) E
 * 10. Max Area of Island (LC# 695) M
 * 11. Balanced Binary Tree (LC# 110) E
 * 12. Recover Binary Search Tree (LC# 99) H
 * 13. Binary Tree Right Side View (LC# 199) M
 * 14. Flood Fill (LC# 733) E
 *
 * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _2_10_DFS {
    /*
    * Tree Definition
    * Definition of TreeNode in Java
    * */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    /*
    * Driver Method
    * */
    public static void main(String[] args){
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(9);
        TreeNode three  = new TreeNode(20);
        TreeNode four = new TreeNode(15);
        TreeNode five = new TreeNode(7);
        one.left = two;
        one.right = three;
        two.left = null;
        two.right = null;
        three.left = four;
        three.right = five;
        _2_10_DFS obj = new _2_10_DFS();
        int depth_recursion = obj.maxDepthRecursionDFS(one);
        int depth_iterative = obj.maxDepthIterativeStack(one);
        int depth_bfs = obj.maxDepthBFS(one);
        System.out.println("Max Depth Recursion -> " + depth_recursion);
        System.out.println("Max Depth Iterative -> " + depth_iterative);
    }

    /*
    * LC# 104
    * Given a binary tree, find its maximum depth.
    *
    * The maximum depth is the number of nodes along the longest path from root node
    * down to the farthest leaf node.
    *
    * Note: A leaf is a node with no children.
    *
    * Example:  Given a binary tree [3, 9, 20, null, null, 15, 7]
    *               3
    *              / \
    *             9  20
    *               /  \
    *              15   7
    *           (nodes of 9 are represented as nulls)
    *
    *           return its depth = 3
    *
    * */

    /*
    * Approach# 1 (Recursion)
    *
    * By Definition, the maximum depth of binary tree is the maximum number of steps to reach a leaf node from
    * the root node.
    *
    * The idea would be to traverse the tree and record the maximum depth during the traversal.
    *
    * One could traverse the tree either by Depth-First-Search (DFS) or Breadth-First-Search (BFS) strategy.
    * For this problem, either way would do.
    * Following is the solution implemented with DFS and recursion.
    *
     */
    private int maxDepthRecursionDFS(TreeNode root){
        //Base Case
        if(root == null){
            return 0;
        }
        //Recursion
        else {
            //System.out.println("Value of root Before :- " + root.val);
            int left_depth = maxDepthRecursionDFS(root.left);
            int right_depth = maxDepthRecursionDFS(root.right);
            //System.out.println("Value of root After :- " + root.val);
            System.out.println("Root :- " + root.val + " Left :- " + left_depth + " Right :- " + right_depth);
            return Math.max(left_depth, right_depth) + 1;
        }
    }
    /*
    * Time Complexity   : We visit each node exactly once, thus time complexity is O(N). (N is no. of nodes)
    * Space Complexity  : In worst case, the tree can be completely unbalanced. (each node has only left child node
    *                     or only right child node, the recursion call would occur N times (height of tree).
    *                     This storage to keep the call stack would be O(N).
    *                     Best case, when tree is completely balance and height is log(N) then, space complexity
    *                     will be O(log(N)).
    * */

    /*
    * Approach# 2 : Iteration
    * We can convert above recursion into iteration, with the help of Stack. With help of stack, one could
    * mimic the behavior of function call stack that is involved int the recursion, to convert function a
    * function with iteration.
    *
    * The idea is to keep the next nodes to visit in a stack. With FILO (First In Last Out), we can get the
    * order of visit same as the one in recursion
    *
    * We start from a stack which contains the root node and the corresponding depth which is 1.
    * Then we proceed to the iterations : pop the current node out of stack
    *                                   : push the child nodes.
    * The depth is updated in each step.
    *
    * */
    private int maxDepthIterativeStack(TreeNode root){
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);
        int depth = 0;
        int current_depth = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println("Value of Node :- " + node.val);
            current_depth = depths.pop();
            depth = Math.max(depth, current_depth);
            if(node.left != null) {
                stack.add(node.left);
                depths.add(current_depth + 1);
            }
            if(node.right != null){
                stack.add(node.right);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }
    /*
    * Approach# 3 : Breath First Search
    *
    * */
    private int maxDepthBFS(TreeNode root){
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                //System.out.println("BFS Track :- " + node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
