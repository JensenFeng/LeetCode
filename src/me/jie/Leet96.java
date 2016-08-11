package me.jie;

/**
 * Created by jie on 8/9/16.
 */
public class Leet96 {
    public int numTrees(int n){
        /**
         * https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i/2
         *
         *  dp: dp[n] += dp[i-1] * dp[n-i]; (i <- 1 to n)
         */
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i ++){
            for(int j = 1; j <= i; j ++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
