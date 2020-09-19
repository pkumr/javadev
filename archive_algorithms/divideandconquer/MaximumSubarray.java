/*
 * 53 Given an integer array nums, find the contiguous subarray 
 * (containing at least one number) which has the largest sum 
 * and return its sum.
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 */
package com.pk.algorithms.divideandconquer;

/**
 *
 * @author parveenkumar
 */
public class MaximumSubarray {
    public static void main_mss(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArrayDAC(nums));
        System.out.println(new MaximumSubarray().maxSubArrayGreedy(nums));
    }
    
    //Approach 1: Divide and Conquer
    public int maxSubArrayDAC(int[] nums){
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int left, int right){
        if(left == right)
            return nums[left];
        int p = (left + right)/2;
        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);
        
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    private int crossSum(int[] nums, int left, int right, int p){
        if(left == right)
            return nums[left];
        
        int leftSubSum = Integer.MIN_VALUE;
        int rightSubSum = Integer.MIN_VALUE;
        
        int currSum = 0;
        for(int i = p; i > left - 1; i--){
            currSum += nums[i];
            leftSubSum = Math.max(leftSubSum, currSum);
        }
        
        currSum = 0;
        for(int i = p + 1; i < right + 1; i++){
            currSum += nums[i];
            rightSubSum = Math.max(rightSubSum, currSum);
        }
        return leftSubSum + rightSubSum;
    }
    //#Approach 2: Greedy
    public int maxSubArrayGreedy(int[] nums){
        //int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            System.out.print( i + " Current Sum - " + currSum);
            maxSum = Math.max(maxSum, currSum);
            System.out.println(" Max Sum - " + maxSum);
        }
        return maxSum;
    }
    //Approach 3: Dynamic Programming
    public int maxSubArrayDP(int[] nums){
        int n = nums.length;
        int maxSum = nums[0];
        for(int i = 0; i < n; i++){
            if(nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
