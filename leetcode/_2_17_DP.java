package com.dynamicprog;
/*
* Date - 2/17/2020 to 2/21/2020
* 1. Counting Bits (LC# 338) M
* 2. Maximum Product SubArray (LC# 152) M
* 3. Minimum Cost Tree From Leaf Values (LC# 1130) M
* 4. Perfect Squares (LC# 279) M __BFS__
* 5. Minimum Path Sum (LC# 64) M
* 6. Triangle (LC# 120) M
* 7. Longest Valid Parentheses (LC# 32) M
* 8. Best Time to Buy and Sell Stock with CoolDown (LC# 309) M
* 9. Unique Binary Search Trees II (LC# 95) M
* 10. Unique Paths (LC# 62) M
* 11. Best Time to Buy and Sell Stock III (LC# 123) M
* 12. Range Sum Query - Immutable (LC# 303) E
* 13. Palindromic Substrings (LC# 647) M
* 14. Unique Paths II (LC# 63) M
*
* */
import java.util.Arrays;
public class _2_17_DP {
    /*
    * LC# 62 Medium
    *
    * A robot is located at the top-left corner of mxn grid.
    *
    * The robot can only move either down or right at any point in time. The robot is trying
    * to reach the bottom-right corner of the grid.
    * How many possible unique paths are there?
    *
    * Note: m and n will be at most 100.
    *
    * Example:
    *   Input  : m = 3 and n = 2
    *   Output : 3
    *   Explanation :
    *       From the top-left corner, there are a total of 3 ways to
    *       reach the bottom-right corner:
    *           1. Right -> Right -> Down
    *           2. Right -> Down -> Right
    *           3. Down -> Right -> Right
    * */

    /*
    * Approach# 1
    * Recursion
    *   The idea is robot can move either right or down. right movements will be in same row
    *   and down movements will be in same column.
    *   if we have m - 3 (rows) and n - 2 columns
    *
    *   And if we have to reach in second row second column => cell(1,1)
    *   cell(1,1) can be reached from row 0 and column 1 ie from cell(0, 1)
    *   or from row 1 and column 0 ie from cell (1, 0)
    *
    *   So to generalize this, cell (m, n) can be reached from either cell(m-1, n) or cell(m, n-1)
    *
    *   Now to we use recursion to achieve this.
    *
    * */
    private int uniquePathsRecursion(int m, int n){
        //if we have only one row or only one column then there is only 1 way.
        if(m == 1 || n == 1){
            return 1;
        }
        return uniquePathsRecursion(m - 1, n) + uniquePathsRecursion(m, n-1);
    }
    /*
    * Approach 2
    * Dynamic Programming
    *
    * */

    /*
    * LC# 63 Medium
    *
    * A robot is located at the top-left corner of a mxn grid.
    *
    * The robot can only move either down or right at any point in time. The robot is trying
    * to reach the bottom-right corner of the grid.
    *
    * Now consider if obstacles are added to the girds.
    * How many unique paths would be there?
    *
    * Example:
    *   Input :
    *   [
    *       [0, 0, 0],
    *       [0, 1, 0],
    *       [0, 0, 0]
    *   ]
    *   Output : 2
    *
    * Explanation:
    *   There is one obstacle in the middle of 3x3 grid above.
    *   There are two ways to reach the bottom-right corner.
    *       1. Right -> Right -> Down -> Down
    *       2. Down -> Down -> Right -> Right
    *
    *
    * */
    private int uniquePathsDP(int m, int n){
        int[][] dp = new int[m][n];
        for(int[] arr : dp)
            Arrays.fill(arr, 1);
        for(int col = 1; col < m; col++){
            for(int row = 1; row < n; row++){
                dp[col][row] = dp[col - 1][row] + dp[col][row - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    /*
    * Complexity Analysis
    *   Time complexity: O(N×M).
    *   Space complexity: O(N×M).
    * */
}
