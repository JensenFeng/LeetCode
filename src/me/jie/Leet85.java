package me.jie;

/**
 * Created by jie on 7/24/16.
 * Hard:https://leetcode.com/problems/maximal-rectangle/
 */

public class Leet85 {
    /*
    https://discuss.leetcode.com/category/93/maximal-rectangle
     */
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;

        int col = matrix[0].length;
        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];
        for(int i = 0; i < col; i ++){
            right[i] = col;
        }
        int ans = 0;
        for(int i = 0; i < row; i ++){
            int lf = 0, rg = col;

            for(int j = 0; j < col; j ++){
                if(matrix[i][j] == '1') height[j] ++;
                else height[j] = 0;
            }
            //left to right
            for(int j = 0; j < col; j ++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j], lf);
                }else{
                    left[j] = 0; lf = j + 1;
                }
            }

            //right to left
            for(int j = col-1; j >= 0; j --){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j], rg);
                }else{
                    right[j] = col; rg = j;
                }
            }

            //compute area
            for(int j = 0; j < col; j ++){
                ans = Math.max(ans, (right[j] - left[j]) * height[j]);
            }
        }
        return ans;
    }
}
