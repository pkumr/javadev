package com.problems;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args){
        int m = 3; //3 Cols
        int n = 2; //2 Rows
        _62_UniquePaths obj = new _62_UniquePaths();
        //USE CASE - 1
        System.out.println("Output Recursion :- " + obj.uniquePathsRecursion(m, n));
        System.out.println("Output DP :- " + obj.uniquePaths(m, n));

        //USE CASE - 2
        m = 7; n = 3;
        System.out.println("Output Recursion :- " + obj.uniquePathsRecursion(m, n));
        System.out.println("Output DP :- " + obj.uniquePaths(m, n));
    }
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsRecursion(int m, int n){
        if(m == 1 || n == 1){
            return 1;
        }
        //To such cell one could move either from the upper cell (m, n - 1),
        // or from the cell on the right (m - 1, n). That means that the total
        //number of paths to move into (m, n) cell is
        // uniquePaths(m - 1, n) + uniquePaths(m, n - 1).
        return uniquePathsRecursion(m - 1, n) + uniquePathsRecursion(m, n - 1);
    }
}
