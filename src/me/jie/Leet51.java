package me.jie;

/**
 * Created by jie on 8/8/16.
 * https://leetcode.com/problems/n-queens/
 */
import java.util.*;
public class Leet51 {
    private Set<List<String>> rst;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return new ArrayList<>();
        rst = new HashSet<>();
        int[] pos = new int[n+1];
        nqueenDFS(pos, new ArrayList<>(), 1, n);

        return new ArrayList<>(rst);
    }
    private void nqueenDFS(int[] position, List<Integer> pos, int row, int n){
        if(pos.size() == n){
            StringBuilder sb ;
            List<String> lt = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                sb = new StringBuilder();
                int len = pos.get(i);
                for(int j = 1; j < len; j ++){
                    sb.append(".");
                }
                sb.append("Q");
                for(int j = len + 1; j <= n; j ++){
                    sb.append(".");
                }
                lt.add(sb.toString());
            }
            rst.add(new ArrayList<>(lt));
            return;
        }
        for(int i = 1; i <= n; i ++){
            position[row] = i;
            if(isValid(position, row)){
                pos.add(i);
                nqueenDFS(position, pos, row + 1, n);
                pos.remove(pos.size()-1);
            }
        }
    }
    private boolean isValid(int[] position, int n){
        for(int i = 1; i < n; i ++){
            int p = position[i];
            for(int j = i + 1; j <= n; j ++){
                if(position[j] == p || (Math.abs(position[j] - p) == Math.abs(j - i))){
                    return false;
                }
            }
        }
        return true;
    }

    /*
      better solution
     */
    public List<List<String>> solveNQueen(int n){
        if(n == 0) return new ArrayList<>();
        Integer[] columns = new Integer[n];
        List<Integer[]> rst = new ArrayList<>();
        placeQueen(0, columns, rst);
        List<List<String>> ans = new ArrayList<>();

        //init
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++){
            sb.append(".");
        }

        for(Integer[] it : rst){
            List<String> lt = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                char[] rows = sb.toString().toCharArray();
                rows[it[i]] = 'Q';
                lt.add(String.copyValueOf(rows));
            }
            ans.add(lt);
        }
        return ans;
    }
    private void placeQueen(int row, Integer[] columns, List<Integer[]> rst){
        if(row == columns.length){
            rst.add(columns.clone());
            return;
        }
        for(int col = 0; col < columns.length; col ++){
            if(checkValid(columns, row, col)){
                columns[row] = col;
                placeQueen(row + 1, columns, rst);
            }
        }
    }
    private boolean checkValid(Integer[] columns, int row, int col){
        /**
         * 这个部分特别好:
         * 1.不必检查是否同一行,因为递归时就是不同行的
         * 2.检查是否同一列,或对角线上
         */
        for(int r = 0; r < row; r ++){
            int c = columns[r];
            if(c == col){
                return false;
            }
            int columnDis = Math.abs(col - c);
            if(row - r == columnDis){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        List<List<String>> lt = new Leet51().solveNQueen(4);
        lt.forEach(lst -> System.out.println(lst));
    }
}
