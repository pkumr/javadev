package com.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal{
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(){
		}
		TreeNode(int x){
			this.val = x;
		}
	}
	//BFS Approach
	public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean level = true;
		while(!queue.isEmpty()){
			int n = queue.size();
			LinkedList<Integer> sublist = new LinkedList<>();
			TreeNode curr = queue.poll();
			for(int i = 0; i < n; i++){
				if(curr.left != null)
					queue.add(curr.left);
				if(curr.right != null)
					queue.add(curr.right);
				if(level)
					sublist.add(curr.val);
				else
					sublist.addFirst(curr.val);
			}
			level = !level;
			result.add(sublist);
		}
		return result;
	}
	//DFS Approach
	private void DFS(TreeNode root, int level, List<List<Integer>> result){
		if(level >= result.size()){
			LinkedList<Integer> newLevel = new LinkedList<>();
			newLevel.add(root.val);
			result.add(newLevel);
		}else{
			if(level % 2 == 0){
				result.get(level).add(root.val);
			}else{
				result.get(level).add(0, root.val);
			}
		}
		if(root.left != null) DFS(root.left, level + 1, result);
		if(root.right != null) DFS(root.right, level + 1, result);
	}
	public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root){
		if(root == null)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		DFS(root, 0, result);
		return result;
	}
}
