package com.problems;

public class BurstBalloonsDP {
    public static void main(String[] args){
        int[] input = {3, 1, 5, 8};
        System.out.println("Output:- " + new _312_BurstBalloons().maxCoins(input));
    }
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];

        System.arraycopy(nums, 0, new_nums, 1, nums.length);

        new_nums[0] = new_nums[n - 1] = 1;

        // dp will store the results of our calls
        int[][] dp = new int[n][n];

        // iterate over dp and incrementally build up to dp[0][n-1]
        for (int left = n-2; left > -1; left--)
            for (int right = left+2; right < n; right++) {
                for (int i = left + 1; i < right; ++i)
                    // same formula to get the best score from (left, right) as before
                    dp[left][right] = Math.max(dp[left][right],
                            new_nums[left] * new_nums[i] * new_nums[right]
                                    + dp[left][i] + dp[i][right]);
            }
        return dp[0][n - 1];
    }
}
