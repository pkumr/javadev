package com.breadthfirst;
/*
* Date - 2/17/2020 to 2/21/2020
* 1. Trapping Rain Water (LC# 42) H (uses Array and Stacks not BFS)
* 2. Trapping Rain Water II (LC# 407) H
* 3. Minimum Depth of Binary Tree (LC# 111) E (also DFS)
* 4. Sliding Puzzle (LC# 773) H
* 5. Pacific Atlantic Water Flow (LC# 417) M
* 6. Minesweeper (LC# 529) M (also DFS)
* 7. Surrounded Regions (LC# 130) M
* 8. Employee Importance (LC# 690) E (DFS and Union Find Too)
* 9. Shortest Path Visiting All Nodes (LC# 847) H
* 10. 01 Matrix (LC# 542) M
* 11. Rotting Oranges (LC# 994) E
* 12. Network Delay Time (LC# 743) M
* 13. All Nodes Distance K in Binary Tree (LC# 863)
* 14. Snakes and Ladders (LC# 909) M
*
* */
public class _2_17_BFS {
    public static void main(String[] args){
        int[] trapRainInput = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        _2_17_BFS obj = new _2_17_BFS();
        int outRain = obj.trapRainWaterBruteForce(trapRainInput);
        System.out.println("Trapped Water : - "+ outRain);

    }
    /*
    * LC# 42
    * Given n non-negative integers representing an elevation map where the width
    * of each bar is 1, compute how much water it is able to trap after raining.
    *
    * Example:
    *   Input : [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    *   Output: 6
    *
    * */
    /*
    * Approach# 1 Brute Force
    *
    * For each element in the array, we find the maximum level of water it can
    * trap after the rain, which is equal to the minimum of maximum height of bars
    * on both the sides minus its own height.
    *
    * Algorithm :
    *   - Initialize ans = 0
    *   - Iterate the array from left to right.
    *   - Initialize max_left = 0 and max_right = 0
    *   - Iterate from the current element to the beginning of array updating:
    *       o max_left = max(max_left, height[j])
    *   - Iterate from the current element to the end of array updating:
    *       o max_right = max(max_right, height[j])
    *   - Add min(max_left, max_right) - height[i] to ans
    *
    * */
    private int trapRainWaterBruteForce(int[] height){
        int ans = 0;
        /*
        * 6|
        * 5|
        * 4|
        * 3|                     __
        * 2|         __         |  |__    __
        * 1|   __   |  |__    __|     |__|  |__
        * 0|__|__|__|_____|__|_________________|_____________
        *  0  1  2  3  4  5  6  7  8  9  10 11 12
        *
        * Cases -
        *  i = 0,
        *  max_left = 0,
        *  max_right = 3
        *  ans = 0
        *
        *  i = 1
        *  max_left = 1
        *  max_right = 3
        *  ans = min(1, 3) - height at 1 =>1
        *  ans = 1 - 1 = 0
        *
        *  i = 2
        *  max_left = 1
        *  max_right = 3
        *  ans = min (1, 3) - height at 2 => 0
        *  ans = 1 - 0 = 1 (record)
        *
        *  i = 3
        *  max_left = 2
        *  max_right = 3
        *  ans = min (2, 3) - height at 3 => 2
        *  ans = 2 - 2 = 0
        *  ans from prev iteration - 1
        *  therefore, ans = 1
        *
        *  i = 4
        *  max_left = 2
        *  max_right = 3
        *  ans = min (2, 3) - height at 4 => 1
        *  ans = 2 - 1 = 1
        *  ans from prev iteration - 1
        *  ans = (1 + 1) = 2
        *
        *  i = 5
        *  max_left = 2,
        *  max_right = 3
        *  ans = min (2, 3) - height at 5 => 0
        *  ans = 2 - 0 = 2
        *  ans from prev iteration - 2
        *  ans = (2 + 2) = 4
        *
        *  i = 6
        *  max_left = 2
        *  max_right = 3
        *  ans = min (2, 3) - height at 6 => 1
        *  ans = 2 - 1 1
        *  ans from prev iteration - 4
        *  ans = (4 + 1) = 5
        *
        *  i = 7
        *  max_left = 3
        *  max_right = 3
        *  ans = min (3, 3) - height at 7 => 3
        *  ans = 3 - 3 = 0
        *  ans from prev iteration - 5
        *  ans = (0 + 5) = 5
        *
        *  i = 8
        *  max_left = 3
        *  max_right = 2
        *  ans = min (3, 2) - height at 8 => 2
        *  ans = 2 - 2 = 0
        *  ans from prev iteration - 5
        *  ans (0 + 5) = 5
        *
        *  i = 9
        *  max_left = 3
        *  max_right = 1
        *  ans = min (3, 1) - height at 9 => 1
        *  ans = 2 - 1 = 1
        *  ans from prev iteration - 5
        *  ans = (5 + 1) = 6
        *
        *  i = 10
        *  max_left = 3
        *  max_right = 2
        *  ans = min (3, 2) - height at 10 => 2
        *  ans = 2 - 2 = 0
        *  ans from prev iteration = 6
        *  ans = (0 + 6) = 6
        *
        *  i = 11
        *  max_left = 3
        *  max_right = 1
        *  ans  = min (3, 1) - height at 11 => 1
        *  ans = 1 - 1 = 0
        *  ans from prev iteration = 6
        *  ans = (0 + 6) = 6
        *
        *  Final Answer ==> 6
        * */
        for(int i = 0; i < height.length; i++){
            int max_left = 0, max_right = 0;
            for(int j = i; j >= 0; j--){
                max_left = Math.max(max_left, height[j]);
                //System.out.println("Left :- " + max_left);
            }
            for(int j = i ; j < height.length; j++){
                max_right = Math.max(max_right, height[j]);
                //System.out.println("Right :- " + max_right);
            }
            //System.out.println("Max Left " + max_left + " Max Right " + max_right);
            ans += Math.min(max_left, max_right) - height[i];
            System.out.println(ans);
        }
        return ans;
    }
}
