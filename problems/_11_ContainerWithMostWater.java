package com.interview.goog.arraystring;
/*
* First Commit - 26-Jan-2020
* Second Commit - 17-Apr-2020
*
*
* */
public class _11_ContainerWithMostWater {

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Brute Force:- " + new _11_ContainerWithMostWater().maxAreaBruteForce(height));
        System.out.println("Two Pointers:- " + new _11_ContainerWithMostWater().maxAreaTwoPointers(height));
    }
    //Brute Force Approach - O(N-Square) Time
    public int maxAreaBruteForce(int[] height){
        int max_area = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                int min = Math.min(height[i], height[j]);
                max_area = Math.max(max_area, min * (j - i ));
            }
        }
        return max_area;
    }
    //Two Pointer Approach - O(N) Time
    public int maxAreaTwoPointers(int[] height){
        int left = 0;
        int right = height.length - 1;
        int max_area = 0;
        while (left < right){
            max_area = Math.max( max_area, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max_area;
    }

    //***********************____START_____LastCommit_26-Jan-2020****************
    public int maxArea(int[] height) {
        //Two Pointer Approach
        int maxarea = 0; //return variable
        int l = 0; // left (first) pointer
        int r = height.length - 1; //right (2nd) pointer
        //1. increase left and decrease right by 1 each time and
        //2. calculate the area between left and right and update in return variable
        //3. with each iteration check if we get more value of area then previous,
        // update return variable
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else {
                r--;
            }
        }
        return maxarea;
    }
    //***********************____END_____LastCommit_26-Jan-2020****************
}
