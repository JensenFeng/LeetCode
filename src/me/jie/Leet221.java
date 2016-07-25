package me.jie;

/**
 * Created by jie on 7/24/16.
 */
public class Leet221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
//        //init
//        for(int i = 0; i < row; i ++){
//            dp[i][0] = 0;
//        }
//        for(int i = 0; i < col; i ++){
//            dp[0][i] = 0;
//        }
        int maxSquare = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                int len = dp[i][j];
                if ((matrix[i][j] - '0') == 1) {
                    dp[i+1][j+1] = 1;
                    if(len == 0){
                        int sum = dp[i + 1][j + 1] * dp[i + 1][j + 1];
                        if (sum > maxSquare) {
                            maxSquare = sum;
                        }
                        continue;
                    }
                    while(len > 0) {
                        int left = j - len;
                        int top = i - len;
                        boolean flag = true;
                        for (int k = i - 1; k >= 0 && k >= top; k--) {
                            if ((matrix[k][j] - '0') == 0) {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = j - 1; k >= 0 && k >= left; k--) {
                            if ((matrix[i][k] - '0') == 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            dp[i + 1][j + 1] = Math.max(len + 1, dp[i+1][j+1]);
                        }
                        len --;
                    }
                } else {
                    dp[i + 1][j + 1] = 0;
                }
                int sum = dp[i + 1][j + 1] * dp[i + 1][j + 1];
                if (sum > maxSquare) {
                    maxSquare = sum;
                }
            }
        }
        return maxSquare;
    }

    //better solution
    public int maxSquare(char[][] matrix){
        int row = matrix.length;
        if(row == 0){
            return 0;
        }
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int maxLen = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                    maxLen = Math.max(dp[i+1][j+1] * dp[i+1][j+1], maxLen);
                }
            }
        }
        return maxLen * maxLen;
    }
    //more better solution
    //add after
    public static void main(String[] args){
        String[] str = {"1"};
        char[][] matrix = new char[str.length][str[0].length()];
        for(int i = 0; i < str.length; i ++){
            matrix[i] = str[i].toCharArray();
        }
        System.out.println(new Leet221().maxSquare(matrix));
    }
}
