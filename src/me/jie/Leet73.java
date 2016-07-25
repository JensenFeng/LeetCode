package me.jie;

/**
 * Created by jie on 7/25/16.
 */
import java.util.*;
public class Leet73 {

    //O(m+n) space
    public void setZeroes(int[][] matrix){
        if(matrix.length == 0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i = 0; i < rows.size(); i ++){
            int tmprow = rows.get(i);
            for(int j = 0; j < col; j ++){
                matrix[tmprow][j] = 0;
            }
        }
        for(int i = 0; i < cols.size(); i ++){
            int tmpcol = cols.get(i);
            for(int j = 0; j < row; j ++){
                matrix[j][tmpcol] = 0;
            }
        }
    }


    public static void main(String[] args){
        int[][] matrix = {{0,1}, {1, 1}};
        new Leet73().setZeroes(matrix);
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
