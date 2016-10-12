package me.jie;

/**
 * Created by jie on 10/8/16.
 * https://leetcode.com/problems/counting-bits/
 */
public class Leet338 {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        int count = 0, bound = 1 << (count+1);
        for(int i = 1; i <= num; i ++){
            if(i >= bound) {
                count ++;
                bound = 1 << (count+1);
            }

            dp[i] = dp[i - (1 << count)] + 1;
        }
        return dp;
    }
    public static void main(String[] args){
        int[] n = new Leet338().countBits(10);
        for(Integer i : n)
            System.out.println(i);
    }
}
