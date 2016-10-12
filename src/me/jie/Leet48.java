package me.jie;

/**
 * Created by jie on 9/18/16.
 * https://leetcode.com/problems/rotate-image/
 */
public class Leet48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int half = n / 2;
        for(int i = 0; i < half; i ++){
            //save dup
            int[] tmp = new int[n];
            for(int j = i; j < n-1-i; j ++){
                tmp[j] = matrix[i][j];
            }
            //four direction
            for(int j = n-1-i; j > i; j --){
                matrix[i][n-1-j] = matrix[j][i];
                matrix[j][i] = matrix[n-1-i][j];
                matrix[n-1-i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = tmp[n-1-j];
            }
        }
    }
    public static void main(String[] args){
        int[][] m = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        new Leet48().rotate(m);
        for(int i = 0; i < m.length; i ++){
            for(int j = 0; j < m.length; j ++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
