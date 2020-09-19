package com.problems;

public class UniquePathsII {
    public static void main(String[] args) {
        _63_UniquePathsII obj = new _63_UniquePathsII();

        int[][] input = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println("Number of Unique Paths -> " + obj.uniquePathsWithObstacles(input));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        //IF starting cell is obstacle .i.e 1
        if(obstacleGrid[0][0] == 1)
            return 0;
        //Number of ways of reaching the starting cell
        obstacleGrid[0][0] = 1;
        //First column
        for(int i = 1; i < rows; i++){
            if(obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1){
                obstacleGrid[i][0] = 1;
            }else {
                obstacleGrid[i][0] = 0;
            }
        }
        //First Row
        for(int i = 1; i < cols; i++){
            if(obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1){
                obstacleGrid[0][i] = 1;
            }else {
                obstacleGrid[0][i] = 0;
            }
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[rows - 1][cols - 1];
    }
}
