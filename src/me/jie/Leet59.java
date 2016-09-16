package me.jie;

/**
 * Created by jie on 9/13/16.
 */
public class Leet59 {
    public int[][] generateMatrix(int n) {
        if(n == 0) return new int[][]{};
        int[][] mx = new int[n][n];
        int len = n * n;
        int count = 0;
        int top = 0, left = 0;
        int bottom = n - 1, right = n - 1;
        while(count < len){
            for(int i = left; i <= right; i ++){
                mx[top][i] = ++count;
            }
            top ++;
            for(int i = top; i <= bottom; i ++){
                mx[i][right] = ++count;
            }
            right --;
            if(top <= bottom){
                for(int i = right; i >= left; i --){
                    mx[bottom][i] = ++count;
                }
            }
            bottom --;
            if(left <= right){
                for(int i = bottom; i >= top; i --){
                    mx[i][left] = ++count;
                }
            }
            left ++;
        }
        return mx;
    }
    public static void main(String[] args){
        int[][] mx = new Leet59().generateMatrix(2);
    }
}
