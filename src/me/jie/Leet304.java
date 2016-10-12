package me.jie;

/**
 * Created by jie on 10/9/16.
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class Leet304 {
    public static void main(String[] args){
        new Leet304().test();
    }
    private void test(){
        int[][] mx = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        NumMatrix nm = new NumMatrix(mx);
        System.out.println(nm.sumRegion(0, 0, 0, 0));
        System.out.println(nm.sumRegion(0, 1, 0, 3));
        System.out.println(nm.sumRegion(2, 1, 4, 3));
        System.out.println(nm.sumRegion(1, 1, 2, 2));
        System.out.println(nm.sumRegion(1, 2, 2, 4));
    }
    public class NumMatrix {
        private int row = 0, col = 0;
        private int[][] dp;
        public NumMatrix(int[][] matrix) {
            row = matrix.length;
            if(row != 0) {
                col = matrix[0].length;
            }
            dp = new int[row+1][col+1];
            for(int i = 0; i < row; i ++){
                for(int j = 0; j < col; j ++){
                    dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
        }
    }
}
