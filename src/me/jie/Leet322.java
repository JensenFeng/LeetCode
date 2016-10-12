package me.jie;

import java.util.*;

/**
 * Created by jie on 10/10/16.
 * https://leetcode.com/problems/coin-change/
 */
public class Leet322 {

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount < 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i ++){
            for(Integer j : coins){
                if(i >= j) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1); //dp[j] = 1
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangedfs(int[] coins, int amount){
        if(coins.length == 0 || amount < 0) return -1;
        Arrays.sort(coins);
        dfs(coins, 0, amount, 0, 0);
        return ans == 0 && amount != 0 ? -1 : ans;
    }
    private int ans = 0;
    private void dfs(int[] coins, int p, int amount, int sum, int count){
        if(sum > amount) return;
        if(sum == amount){
            if(ans == 0) ans = count;
            if(count < ans) ans = count;
            return;
        }
        for(int i = p; i < coins.length; i ++){
            dfs(coins, i, amount, sum + coins[i], count + 1);
        }
    }
    public static void main(String[] args){
        int[] n = {122,112,383,404,25,368};
        System.out.println(new Leet322().coinChange(n, 1));
    }
}
