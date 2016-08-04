package me.jie;

/**
 * Created by jie on 7/30/16.
 */
public class Leet200 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
//        boolean[][] marked = new boolean[rows][cols];//this doesn't need
        int ans = 0;
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if( grid[i][j] == '1'){
                    ans ++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }
        grid[row][col] = '0';
        int[][] pos = {{0, 0, -1, 1}, {-1, 1, 0, 0}};
        for(int i = 0; i <= 3; i ++){
            int x = row + pos[0][i];
            int y = col + pos[1][i];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
            if(grid[x][y] == '1' ){
                dfs(grid, x, y);
            }
        }
    }
    public static void main(String[] args){
        String[] str = {"11000", "11000", "00100", "00011"};
        char[][] grid = new char[str.length][];
        for(int i = 0; i < str.length; i ++){
            grid[i] = str[i].toCharArray();
        }
        System.out.println(new Leet200().numIslands(grid));
    }

}
