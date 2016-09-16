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

    //O(1) space
    public void setZeroes1(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        boolean rowZero = false; //each row first element is zero or not
        boolean colZero = false; //same as each col
        for(int i = 0; i < row; i ++){
            if(matrix[i][0] == 0){
                rowZero = true;
                break;
            }
        }
        for(int i = 0; i < col; i ++){
            if(matrix[0][i] == 0){
                colZero = true;
                break;
            }
        }
        //check other element
        for(int i = 1; i < row; i ++){
            for(int j = 1; j < col; j ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //change to zero
        for(int i = 1; i < row; i ++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < col; j ++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < col; i ++){
            if(matrix[0][i] == 0){
                for(int j = 0; j < row; j ++){
                    matrix[j][i] = 0;
                }
            }
        }
        //first element
        if(rowZero){
            for(int i = 0; i < row; i ++){
                matrix[i][0] = 0;
            }
        }
        if(colZero){
            for(int i = 0; i < col; i ++){
                matrix[0][i] = 0;
            }
        }
    }

    public void setZeroesTwo(int[][] matrix) {
        if(matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for(int i = 0; i < col; i ++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        for(int i = 0; i < row; i ++){
            if(matrix[i][0] == 0) { firstCol = true; break;}
        }
        for(int i = 1; i < row; i ++){
            for(int j = 1; j < col; j ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < row; i ++){
            if(matrix[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < col; j ++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < row; i ++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow){
            for(int i = 0; i < col; i ++){
                matrix[0][i] = 0;
            }
        }
        if(firstCol){
            for(int i = 0; i < row; i ++){
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
//        for(int i = 0; i < matrix.length; i ++){
//            for(int j = 0; j < matrix[0].length; j ++){
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
        new Leet73().setZeroesTwo(matrix);
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
