/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/
public class _64_MinimumPathSum {
	public int minPathSum(int[][] grid){
		//Create a 2-D dp array to sum the result
		int[][] dp = new int[grid.length][grid[0].length];
		//we will sum up the values and store in dp array
		//we start from grid[0][0]
		//we can move either right or down
		//so if we consider value at grid[2][2] = 1, to reach here, either we can come from
		//grid[2][1] = 2 or grid[1][2] = 1, 1 is minimum so, we should come from the top
		//the above scenario work when we can move between row and columns
		//what if we are at grid[0][j] = we can only move right
		//and what if we are at grid[i][0] = we can only move down

		//For simplicity, lets fill first element with grid value at begining
		dp[0][0] = grid[0][0];
		//now lets handle case when we are at first row, we can move to right only
		//this means to get sum at next right, we have to use j-1 (previous column) value
		for(int j = 1; j < grid[0].length; j++){
			dp[0][j] = grid[0][j] + dp[0][j - 1];
		}
		//now for first column and all the row values in first column
		for(int i = 1; i < grid.length; i++){
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}
		//now hanlde the genarl case (take minimum of left or up) to move to right or down
		for(int  i = 1; i < grid.length; i++){
			for(int j = 1; j < grid[0].length; j++){
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		//finally we have result available in bottom right cell of dp array
		return dp[grid.length - 1][grid[0].length - 1];
	}
}