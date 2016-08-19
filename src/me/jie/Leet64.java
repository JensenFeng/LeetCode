package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet64 {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int[] dp = new int[col];
        dp[0] = grid[0][0];
        for(int i = 1; i < col; i ++){
            dp[i] = dp[i-1] + grid[0][i];
        }
        for(int i = 1; i < row; i ++){
            dp[0] += grid[i][0];
            for(int j = 1; j < col; j ++){
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
            }
        }
        return dp[col-1];
    }
    public static void main(String[] args){
        int[][] g = {{1,2,3},{4,5,6}, {7,8,9}};
        System.out.println(new Leet64().minPathSum(g));
    }
}
