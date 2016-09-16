package me.jie;

/**
 * Created by jie on 9/16/16.
 */
public class Leet79 {
    private boolean isExist = false;
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] mark = new boolean[row][col];
        int pos = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(isExist) return isExist;
                if(!mark[i][j] && word.charAt(pos) == board[i][j]){
                    mark[i][j] = true;
                    dfs(board, i, j, row, col, word, pos+ 1, mark);
                    mark[i][j] = false;
                }
            }
        }
        return isExist;
    }
    private void dfs(char[][] board, int r, int c, int row ,int col,
                     String word, int pos, boolean[][] mark){
        if(isExist) return;
        if(pos == word.length()){
            isExist = true;
            return;
        }
        int[] hor = {-1, 0, 0, 1};
        int[] ver = {0, 1, -1, 0};
        for(int i = 0; i < 4; i ++){
            int t1 = r + hor[i];
            int t2 = c + ver[i];
            if(t1 >= 0 && t1 < row && t2 >= 0 && t2 < col){
                if(!mark[t1][t2] && board[t1][t2] == word.charAt(pos)){
                    mark[t1][t2] = true;
                    dfs(board, t1, t2, row, col, word, pos + 1, mark);
                    mark[t1][t2] = false;
                }
            }
        }
    }
    public static void main(String[] args){
        String[] bd = {"ABCE","SFCS","ADEE"};
        char[][] board = new char[bd.length][bd[0].length()];
        for(int i = 0; i < bd.length; i ++){
            for(int j = 0; j < bd[0].length(); j ++){
                board[i][j] = bd[i].charAt(j);
            }
        }
        System.out.println(new Leet79().exist(board, ""));
    }
}
