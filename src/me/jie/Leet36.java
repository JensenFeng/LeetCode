package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet36 {
    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0) return true;
        int row = board.length;
        char[] col = new char[row];
        for(int i = 0; i < row; i ++){
            if(!checkValid(board[i])) return false;
            for(int j = 0; j < row; j ++){
                col[j] = board[j][i];
            }
            if(!checkValid(col)) return false;
        }
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                // small board
                int len = 0;
                for(int k = i; k < i + 3; k ++){
                    for(int l = j; l < j + 3; l ++){
                        col[len ++] = board[k][l];
                    }
                }
                if(!checkValid(col)) return false;
            }
        }
        return true;
    }

    private boolean checkValid(char[] nums){
        boolean[] hash = new boolean[nums.length];
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == '.') continue;
            int t = nums[i] - '1';
            if(!hash[t]){
                hash[t] = true;
            }
            else return false;
        }
        return true;
    }
    public static void main(String[] args){
        String[] str = {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",
                ".15......",".....2...",".2.9.....","..4......"};
        char[][] board = new char[str.length][str.length];
        int len = 0;
        for(String s : str){
            board[len ++] = s.toCharArray();
        }
        System.out.println(new Leet36().isValidSudoku(board));
    }
}
