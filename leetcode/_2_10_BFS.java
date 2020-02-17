package com.breadthfirst;
/*
 * Date - 2/10/2020 - 2/14/2020
 * 1. Number of Islands (LC# 200) M (Also DFS)
 * 2. Remove Invalid Parentheses (LC# 301) H (Also DFS)
 * 3. Perfect Squares (LC# 279) M
 * 4. Symmetric Tree (LC# 101) E (Also DFS)
 * 5. Binary Tree Right Side View (LC# 199) M
 * 6. Word Ladder (LC# 127) M
 * 7. Word Ladder II (LC# 126) H
 * 8. Binary Tree Level Order Traversal (LC# 102) M
 * 9. Binary Tree Level Order Traversal II (LC# 107) E
 * 10. Binary Tree Zigzag Level Order Traversal (LC# 103) M
 * 11. Clone Graph (LC# 133) M
 * 12. Course Schedule (LC# 207) M
 * 13. Course Schedule II (LC# 210) M
 * 14. Cut Off Trees for Golf Event (LC# 675) H
 *
 * */

import java.util.LinkedList;
import java.util.Queue;

public class _2_10_BFS {
    public static void main(String[] args){
        char[][] island  = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        _2_10_BFS obj = new _2_10_BFS();
        //int numIslandsDFS = obj.numIslandsDFS(island);
        int numIslandsBFS = obj.numIslandsBFS(island);
        System.out.println("No of Islands BFS :- "+ numIslandsBFS);
        //System.out.println("No of Islands DFS :- " + numIslandsDFS);
    }
    /*
    * LC# 200
    * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    *
    * An island is surrounded by water and is formed by connecting adjacent lands
    * horizontally or vertically.
    * You may assume all four edges of the grid are all surrounded by water.
    *
    * Example: 1
    *
    *   Input:
    *   11110
    *   11010
    *   11000
    *   00000
    *
    *   Output : 1
    *
    * Example: 2
    *
    *   Input:
    *   11000
    *   11000
    *   00100
    *   00011
    *
    *   Output: 3
    *
    * */
    /*
    * Approach# 1 Depth First Search (DFS)
    * Treat the 2d grid map as an undirected graph and there is an edge between two
    * horizontally or vertically adjacent nodes of value '1'.
    *
    * Method/Algorithm - Linear scan the 2d grid map, if a node contains a '1', then
    * it is a root node that triggers a Depth First Search. During DFS, every visited
    * node should be set as '0' to mark as visited node. Count the number of root nodes
    * that triggers DFS, this number would be the number of islands since each DFS starting
    * at some root identifies an island.
    *
    * */
    private int numIslandsDFS(char[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
        int numOfIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                //if we find value 1 - start DFS to find all 1's vertically and horizontally.
                if(grid[i][j] == '1'){
                    System.out.println("i :- " + i + " j :- " + j );
                    numOfIslands += dfs(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }
    private int dfs(char[][] grid, int i, int j){
        // i < 0 --> row number goes negative
        // i > grid.length --> row number goes beyond grid rows
        // j < 0 --> column number goes negative
        // j > grid[i].length --> column number in a row goes negative
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){
            return 0;
        }
        //mark node in grid as visited
        //Once we mark node as visited (==0) in grid, the for loop
        //in main calling function should skip visited nodes. (check done)
        grid[i][j] = '0';
        dfs(grid, i + 1, j); //--> down
        dfs(grid, i - 1, j); //--> up
        dfs(grid, i, j + 1); //--> right
        dfs(grid, i, j - 1); //--> left
        return 1;
    }
    /*
    * Time Complexity   : O(M x N) where M is number of rows and N is number of columns.
    * Space Complexity  : worst case O(M x N) in case that grid is filled with lands where
    *                     DFS goes by M x N deep.
    * */

    /*
    * Approach# 2 Breadth First Search
    *
    * */
    private int numIslandsBFS(char[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
        int[] shift = new int[] {0, 1, 0, -1, 0};
        int numOfIslands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    numOfIslands++;
                    grid[i][j] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()){
                        int[] current = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int x = current[0] + shift[k];
                            int y = current[1] + shift[k + 1];
                            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1'){
                                grid[x][y] = '0';
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}
