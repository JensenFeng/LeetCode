package me.jie;

import java.util.*;

/**
 * Created by jie on 10/11/16.
 * https://leetcode.com/problems/burst-balloons/
 */
public class Leet312 {
    /*
    TLE
     */
    public int maxCoins(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        for(Integer i : nums){
            rst.add(i);
        }
        mp = new HashMap<>();
        return dfs(rst, 0);
    }
    private static Map<List<Integer>, Integer> mp;
    private int dfs(List<Integer> rst, int sum){
        if(rst.size() == 0){
            return sum;
        }
        int len = rst.size();
        for(int i = 0; i < len; i ++){
            int tmp = rst.get(i);
            int s = 0;
            int t = tmp;
            if(i == 0){
                if(i + 1 < len){
                    t *= rst.get(i+1);
                }
                s += t;
            }else if(i == len - 1){
                s += t * rst.get(i-1);
            }else{
                s += rst.get(i-1) * t * rst.get(i+1);
            }
            rst.remove(i);
            int res = 0;
            if(mp.containsKey(rst)) {
                res = mp.get(rst);
            }else{
                res = dfs(rst, sum);
            }
            rst.add(i, tmp);
            if(mp.containsKey(rst)) {
                int v = mp.get(rst);
                if(v < res + s){
                    mp.put(new ArrayList<>(rst), res + s);
                }
            }else {
                mp.put(new ArrayList<>(rst), res + s);
            }
        }
        return mp.get(rst);
    }

    /*
    https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations
     */
    public int maxCoinsdp(int[] nums){
        int n = nums.length;
        int[] rst = new int[n + 2];
        n = 1;
        for(Integer x : nums){
            if(x > 0) rst[n++] = x;
        }
        rst[0] = rst[n++] = 1;
        int[][] dp = new int[n][n];
        for(int k = 2; k < n; k ++){
            for(int left = 0; left < n - k; left ++){
                int right = left + k;
                for(int i = left + 1; i < right; i ++){
                    dp[left][right] = Math.max(dp[left][right],
                            rst[left] * rst[i] * rst[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args){
        int[] n = {7,9,8,0,7,1,3,5,5,2,3};
        System.out.println(new Leet312().maxCoinsdp(n));
    }
}
