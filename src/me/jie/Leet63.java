package me.jie;

/**
 * Created by jie on 8/8/16.
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class Leet63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length , col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i ++){
            if(obstacleGrid[i][0] != 1) dp[i][0] = 1;
            else break;
        }
        for(int j = 0; j < col; j ++){
            if(obstacleGrid[0][j] != 1) dp[0][j] = 1;
            else break;
        }
        for(int i = 1; i < row; i ++){
            for(int j = 1; j < col; j ++){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + dp[i][j-1]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[row-1][col-1];
    }
    /*
        better: O(N) space
        借鉴L62题的思路:
        1.每次更新只需要left,up位置的值
        2.对于每行第一个位置为1的话,重置0
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid){
        if(obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length , col = obstacleGrid[0].length;
        int[] dp = new int[col];
        for(int i = 0; i < col; i ++){
            if(obstacleGrid[0][i] != 1) dp[i] = 1;
            else break;
        }
        for(int i = 1; i < row; i ++){
            if(obstacleGrid[i][0] == 1) dp[0] = 0;
            for(int j = 1; j < col; j ++){
                if(obstacleGrid[i][j] != 1){
                    dp[j] += dp[j-1];
                }else{
                    dp[j] = 0;
                }
            }
        }

        return dp[col-1];
    }

    public int uniquePathsWithObstaclesTwo(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] dp = new int[col];
        for(int i = 0; i < col; i ++){
            if(obstacleGrid[0][i] != 1) dp[i] = 1;
            else break;
        }
        for(int i = 1; i < row; i ++){
            if(obstacleGrid[i][0] == 1) dp[0] = 0;
            for(int j = 1; j < col; j ++){
                if(obstacleGrid[i][j] != 1){
                    dp[j] += dp[j-1];
                }else{
                    dp[j] = 0;
                }
            }
        }
        return dp[col-1];
    }
}
