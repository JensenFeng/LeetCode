package me.jie;

/**
 * Created by jie on 8/9/16.
 */
public class Leet62 {
    public int uniquePaths(int m, int n){
        if(m == 0) return 0;

        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for(int i = 0; i < m; i ++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i ++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * better space usage
     * https://discuss.leetcode.com/topic/15265/0ms-5-lines-dp-solution-in-c-with-explanations/2
     */
    public int uniquePaths2(int m, int n){
        if(m == 0) return 0;
        int[] pre = new int[n];
        int[] curr = new int[n];
        for(int i = 0; i < n; i ++){
            pre[i] = 1;
            curr[i] = 1;
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                curr[j] = curr[j-1] + pre[j];
            }
            for(int j = 0; j < n; j ++){
                pre[j] = curr[j];
            }
        }
        return pre[n-1];
    }

    /**
     * more better: O(n) space
     *
     */
    public int uniquePaths3(int m, int n){
        if(m == 0) return 0;
        if(m > n) return uniquePaths3(n, m);
        int[] curr = new int[n];
        for(int i = 0; i < n; i ++){
            curr[i] = 1;
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                curr[j] += curr[j-1];
            }
        }
        return curr[n-1];
    }

    public int uniquePathsTwo(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0; i < n; i ++) dp[i] = 1;
        for(int i = 1; i < m; i ++){
            dp[0] = 1;
            for(int j = 1; j < n; j ++){
                dp[j] = dp[j-1] +  dp[j];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        System.out.println(new Leet62().uniquePathsTwo(3,3));
    }
}
