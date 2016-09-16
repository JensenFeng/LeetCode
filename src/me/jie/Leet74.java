package me.jie;

/**
 * Created by jie on 9/16/16.
 */
public class Leet74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int rp = 0, cp = col-1;
        while(rp < row && cp >= 0){
            if(matrix[rp][cp] == target) return true;
            if(matrix[rp][cp] > target) cp --;
            else rp ++;
        }
        return false;
    }
    public boolean bsearchMatrix(int[][] matrix, int target){
        if(matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col * row - 1;
        int rp = 0, cp = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            rp = mid / col;
            cp = mid % col;
            if(matrix[rp][cp] == target) return true;
            if(matrix[rp][cp] > target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {{1, 3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(new Leet74().bsearchMatrix(matrix, 8));
    }
}
