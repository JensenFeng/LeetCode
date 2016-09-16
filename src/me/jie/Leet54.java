package me.jie;

/**
 * Created by jie on 9/13/16.
 */
import java.util.*;

public class Leet54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int top = 0, left = 0;
        int bottom = row, right = col;
        List<Integer> ans = new ArrayList<>();
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i ++){
                ans.add(matrix[top][i]);
            }
            top ++;
            for(int i = top; i <= bottom; i ++){
                ans.add(matrix[i][right]);
            }
            right --;
            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            }
            bottom --;
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            left ++;
        }
        return ans;
    }
}
