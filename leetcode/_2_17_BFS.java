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

import java.util.*;

public class  _2_17_BFS {
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
    public static void main(String[] args){
        int[] trapRainInput = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        _2_17_BFS obj = new _2_17_BFS();
        int outRain = obj.trapRainWaterBruteForce(trapRainInput);
        //System.out.println("Trapped Water : - "+ outRain);
        //System.out.println(obj.trapRainWaterDP(trapRainInput));
        //System.out.println(obj.trapRainWaterStack(trapRainInput));
        //System.out.println(obj.trapRainWaterTwoPointers(trapRainInput));

        int[][] trapRain2 = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        System.out.println(obj.trapRainWater(trapRain2));

        //773 - Sliding Puzzle
        int[][] board = {{4,1,2},{5,0,3}};
        int moves = obj.slidingPuzzleBFS(board);
        System.out.println("Number of Moves :- "+ moves);
    }
    /*
    * LC# 42 - Hard Problem
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
            //System.out.println(ans);
        }
        return ans;
    }
    /*
    * Time complexity   : O(N Square). For each element of array, we iterate the left and right parts.
    * Space Complexity  : O(1)
    * */
    /*
    * Approach# 2 - Dynamic Programming
    *
    * In Brute force, we iterate over the left and right parts again and again
    * just to find the highest bar size up to that index.
    * But this could be stored using Dynamic Programming.
    *
    * Algorithm :
    *   - Find maximum height of bar from the left end up to an index i in the array left_max.
    *   - Find maximum height of bar from the right end up to an index i in the array right_max.
    *   - Iterate over the height array and update ans :
    *       o  Add min(left_max[i], right_max[i]) - height[i] to ans
    * */
    private int trapRainWaterDP(int[] height){
        int ans = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = height[0];
        right_max[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length - 1; i++){
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        for(int i = height.length - 2; i >= 0; i--){
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for(int i = 1; i < height.length - 1; i++){
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    /*
    * Approach# 3 - Using Stacks
    * Instead of storing the largest bar up to an index, we can use stack to keep track of the bars
    * that are bounded by longer bars and hence, may store water. Using the stack, we can do the
    * calculations in only one iteration.
    *
    * We keep a stack and iterate over the array. We add the index of the bar to the stack if bar is
    * smaller than or equal to the bar at top of stack, which means that the current bar is bounded
    * by the previous bar in the stack. if we found a bar longer than that at the top, we are sure
    * that the bar at the top of the stack is bounded by the current bar and a previous bar in the
    * stack, hence, we can pop it and add resulting trapped water into ans.
    *
    * Algorithm
    *
    * */
    private int trapRainWaterStack(int[] height){
        Stack<Integer> stack = new Stack<>();
        int water = 0, i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    // find the smaller height between the two sides
                    int minHeight = Math.min(height[stack.peek()], height[i]);
                    // calculate the area
                    water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return water;
    }
    /*
    * Approach # 4 Two Pointers
    *
    *
    * */
    private int trapRainWaterTwoPointers(int[] height){
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = 0, right_max = 0;
        while (left < right){
            if(height[left] < height[right]){
                System.out.println("Enter If (height_left < height_right)");
                System.out.println("height[left] :- " + height[left]);
                System.out.println("height[right] :- " + height[right]);
                System.out.println("left_max :- " + left_max);
                if(height[left] >= left_max){
                    left_max = height[left];
                    System.out.println("1. Assigned new left_max :- " + left_max);
                }else {
                    ans += left_max - height[left];
                    System.out.println("2. ans updated :- " + ans);
                }
                //height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
                left++;
                System.out.println();
            }else {
                //height[left] >= height[right]
                System.out.println("Enter Else (height_left >= height_right)");
                System.out.println("height[right] :- " + height[right]);
                System.out.println("height[left] :- " + height[left]);
                System.out.println("right_max :- " + right_max);
                if(height[right] >= right_max){
                    right_max = height[right];
                    System.out.println("1. Assigned new right_max :- " + right_max);
                }else {
                    ans += right_max - height[right];
                    System.out.println("2. ans updated :- " + ans);
                }
                right--;
                System.out.println();
            }
        }
        return ans;
    }

    /*
    * LC# 407
    * Given an m x n matrix of positive integers representing the height of each unit
    * cell in a 2D elevation map, compute the volume of water it is able to trap after
    * raining.
    *
    * Note : Both m and n are less than 110. the height of each unit cell is greater than
    *       0 and less than 20,000.
    *
    * Example:
    *   Given the following 3x6 height map:
    *       [
    *           [1,4,3,1,3,2],
    *           [3,2,1,3,2,4],
    *           [2,3,3,2,3,1]
    *       ]
    *
    *   Return 4.
    * */
    /*
    * Approach# 1
    * BFS and Priority Queue with heights in array
    *
    * */
    private int trapRainWater(int[][] heightMap){
        int[] shift = new int[] {0, 1, 0, -1, 0};
        int row = heightMap.length;
        int col = heightMap[0].length;
        int result = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]
        );
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            priorityQueue.offer(new int[]{i, 0, heightMap[i][0]});
            priorityQueue.offer(new int[]{i, col - 1, heightMap[i][col - 1]});
            visited[i][0] = visited[i][col - 1] = true;
        }

        for(int j = 1; j < col - 1; j++){
            priorityQueue.offer(new int[]{0, j, heightMap[0][j] });
            priorityQueue.offer(new int[]{row - 1, j, heightMap[row - 1][j]});
            visited[0][j] =  visited[row - 1][j] = true;
        }

        while (!priorityQueue.isEmpty()){
            int[] current = priorityQueue.poll();
            for(int k = 0; k < 4; k++){
                int x = current[0] + shift[k];
                int y = current[1] + shift[k + 1];
                if(x < 0 || x >= row || y < 0 || y >= col ||visited[x][y]) continue;
                result += Math.max(0, current[2] - heightMap[x][y]);
                priorityQueue.offer(new int[]{x, y, Math.max(heightMap[x][y], current[2])});
                visited[x][y] = true;
            }
        }
        return result;
    }
    /*
    * Approach# 2
    * BFS and Priority Queue with Blocks in different Class
    *
    * */
    public static class Block{
        int row;
        int col;
        int height;
        public Block(int r, int c, int h){
            this.row = r;
            this.col = c;
            this.height = h;
        }
    }
    private int trapRainWater_2(int[][] heightMap){
        if(heightMap == null || heightMap.length == 0  || heightMap[0].length == 0)
            return 0;

        int result = 0;
        int[] shift = new int[] {0, 1, 0, -1, 0};
        //Priority Queue Based on heights of blocks
        PriorityQueue<Block> priorityQueue = new PriorityQueue<>(
                1, new Comparator<Block>() {
            @Override
            public int compare(Block a, Block b) {
                return a.height - b.height;
            }
        });

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            priorityQueue.offer(new Block(i, 0, heightMap[i][0]));
            priorityQueue.offer(new Block(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for(int j = 0; j < n; j++){
            priorityQueue.offer(new Block(0, j, heightMap[0][j]));
            priorityQueue.offer(new Block(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }
        while (!priorityQueue.isEmpty()){
            Block current = priorityQueue.poll();
            for(int k = 0; k < 4; k++){
                int x = current.row + shift[k];
                int y = current.col + shift[k + 1];
                if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){
                    result += Math.max(0,current.height - heightMap[x][y]);
                    visited[x][y] = true;
                    priorityQueue.offer(new Block(x, y, Math.max(heightMap[x][y], current.height)));
                }
            }
        }
        return result;
    }
    /*
    * LC# 111 (Easy)
    * (Similar Problem for maximum - LC# 104)
    *
    * Given a binary tree, find its minimum depth.
    * The minimum depth is the number of nodes along the shortest path from the root node
    * down to the nearest leaf node.
    *
    * Note: A leaf is a node with no children
    *
    * Example :
    * Given a binary tree [3, 9, 20, null, null, 15, 7]
    *
    *     3
    *    / \
    *   9  20
    *     /  \
    *    15   7
    *
    * return its minimum depth  = 2
    *
    * */
    /*
    * Approach# 1 - Recursion & DFS
    * */
    private int minDepthRecursion(TreeNode root){
        if(root == null)
            return 0;
        if((root.left == null) && (root.right == null)){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if(root.left != null){
            minDepth = Math.min(minDepthRecursion(root.left), minDepth);
        }
        if(root.right != null){
            minDepth = Math.min(minDepthRecursion(root.right), minDepth);
        }
        return minDepth + 1;
    }
    /*
    * Approach# 2 - BFS
    *
    * */
    private int minDepthBFS(TreeNode root){
        if(root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        depth ++;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                //If a leaf is reached at any level, then depth from root to
                //first reached leaf will be minimum depth.
                if(node.left == null && node.right ==null){
                    return depth;
                }
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    /*
    * LC# 773 Hard
    *
    * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and
    * an empty squared represented by 0.
    *
    * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
    *
    * The state of the board is solved if and only if the board is
    * [[1,2,3],[4,5,0]].
    *
    * Given a puzzle board, return the least number of moves required so that the state
    * of the board is solved. If it is impossible for the state of the board to be solved,
    * return -1.
    *
    * Example: 1
    *   Input : board = [[1,2,3],[4,0,5]]
    *   Output: 1
    *   Explanation: Swap the 0 and the 5 is one move.
    *
    * Example: 2
    *   Input : board = [[1,2,3],[5,4,0]]
    *   Output: -1
    *   Explanation: No number of moves will make the board solved.
    *
    * Example: 3
    *   Input : board = [[4,1,2],[5,0,3]]
    *   Output: 5
    *   Explanation: 5 is the smallest number of moves that solve the board
    *   An Example Path:
    *       After Move 0 : [[4,1,2],[5,0,3]]
    *       After Move 1 : [[4,1,2],[0,5,3]]
    *       After Move 2 : [[0,1,2],[4,5,3]]
    *       After Move 3 : [[1,0,2],[4,5,3]]
    *       After Move 4 : [[1,2,0],[4,5,3]]
    *       After Move 5 : [[1,2,3],[4,5,0]]
    *
    * Note :
    *       board will be a 2x3 array as described above..
    *       board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5]
    *
    * */
    public static class SlidingPuzzleNode{
        int[][] board;
        String boardString;
        int zero_r;
        int zero_c;
        int depth;
        SlidingPuzzleNode(int[][] B, int r, int c, int d){
            this.board = B;
            this.boardString = Arrays.deepToString(board);
            this.zero_r = r;
            this.zero_c = c;
            this.depth = d;
        }
    }
    private int slidingPuzzleBFS(int[][] board){
        int sourceRow = 0;
        int sourceCol = 0;
        int[] shift = new int[] {0, 1, 0, -1, 0};

        search:
            for(sourceRow  = 0; sourceRow < board.length; sourceRow++){
                for(sourceCol = 0; sourceCol < board[0].length; sourceCol++){
                    if(board[sourceRow][sourceCol] == 0)
                        break search;
                }
            }

        Queue<SlidingPuzzleNode> queue = new LinkedList<>();
        SlidingPuzzleNode startNode = new SlidingPuzzleNode(board, sourceRow, sourceCol, 0);
        queue.add(startNode);

        Set<String> seen = new HashSet<>();
        seen.add(startNode.boardString);

        String target = Arrays.deepToString(new int[][]{{1, 2, 3,}, {4, 5, 0}});
        while (!queue.isEmpty()){
            SlidingPuzzleNode node = queue.remove();
            if(node.boardString.equals(target))
                return node.depth;
            for(int k = 0; k < 4; k++){
                int x = node.zero_r + shift[k];
                int y = node.zero_c + shift[k + 1];
                if(x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                //Math.abs(x - node.zero_r) + Math.abs(y - node.zero_c) != 1){
                    int[][] newBoard = new int[board.length][board[0].length];
                    int index = 0;
                    for(int[] row : node.board) {
                        newBoard[index++] = row.clone();
                    }
                    newBoard[node.zero_r][node.zero_c] = newBoard[x][y];
                    newBoard[x][y] = 0;

                    SlidingPuzzleNode n = new SlidingPuzzleNode(newBoard, x, y, node.depth + 1);
                    if(!seen.contains(n.boardString)){
                        queue.add(n);
                        seen.add(n.boardString);

                    }
                }
            }
        }
        return -1;
    }

    /*
    * LC# 417 Medium
    *
    * Given an m x n matrix of non-negative integers representing the height of
    * each unit cell in a continent, the "Pacific ocean" touches the left and
    * top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
    *
    * Water can only flow in four directions (up, down, left, or right) from a
    * cell to another one with height equal or lower.
    *
    * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
    *
    * Note:The order of returned grid coordinates does not matter.Both m and n are less than 150.
    *
    * Example:
    *
    * Given the following 5x5 matrix:
    *
    *       Pacific ~   ~   ~   ~   ~
                ~  1   2   2   3  (5) *
                ~  3   2   3  (4) (4) *
                ~  2   4  (5)  3   1  *
                ~ (6) (7)  1   4   5  *
                ~ (5)  1   1   2   4  *
                    *   *   *   *   * Atlantic

    * Return:
    *   [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
    *   (positions with parentheses in above matrix).
    * */

    /*
    * Approach# 1 DFS
    *
    * */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfsWaterFlow(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfsWaterFlow(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfsWaterFlow(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfsWaterFlow(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList( i, j));
        return res;
    }

    //int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int[] shift = new int[]{0, 1, 0, -1, 0};

    public void dfsWaterFlow(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int k = 0; k < 4; k++){
            dfsWaterFlow(matrix, visited, matrix[x][y], x+shift[k], y+shift[k+1]);
        }
    }
    /*
     * Approach# 2 BFS
     *
     * */
    public List<List<Integer>> pacificAtlanticBFS(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int n = matrix.length, m = matrix[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        //Vertical Border
        for(int i = 0; i < n; i++){
            pQueue.offer(new int[] {i, 0});
            aQueue.offer(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        //Horizontal Border
        for(int i = 0; i < m; i++){
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }
        bfsWaterFlow(matrix, pQueue, pacific);
        bfsWaterFlow(matrix, aQueue, atlantic);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }
    public void bfsWaterFlow(int[][] matrix, Queue<int[]> queue, boolean[][] visited){
        int n = matrix.length;
        int m = matrix[0].length;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for(int k = 0; k < 4; k++){
                int x = current[0] + shift[k];
                int y = current[1] + shift[k + 1];
                    if(x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && matrix[x][y] >= matrix[current[0]][current[1]]){
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
