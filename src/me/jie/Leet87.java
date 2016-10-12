package me.jie;

import java.util.*;

/**
 * Created by jie on 10/8/16.
 * https://leetcode.com/problems/scramble-string/
 */
public class Leet87 {
    /*
    https://discuss.leetcode.com/topic/20094/my-c-solutions-recursion-with-cache-dp-recursion-with-cache-and-pruning-with-explanation-4ms
     */
    public boolean isScramble(String s1, String s2){
        Map<String, Boolean> mp = new HashMap<>();
        return isScramble(mp, s1, s2);
    }
    public boolean isScramble(Map<String, Boolean> mp, String s1, String s2) {
        if(s1.length() == 0) return true;
        if(s1.length() == 1) return s1.equals(s2);

        if(mp.containsKey(s1+s2)) return mp.get(s1+s2);
        boolean res = false;
        if(s1.equals(s2)) {
            res = true;
        }else {
            int len = s1.length();
            for (int i = 1; i < len; i ++) {
                String ss1 = s1.substring(0, i), sss1 = s1.substring(i, len);
                String ss2 = s2.substring(0, i), sss2 = s2.substring(i, len);
                res = isScramble(mp, ss1, ss2) && isScramble(mp, sss1, sss2);
                if(res) break;
                ss2 = s2.substring(0, len - i);
                sss2 = s2.substring(len - i, len);
                res = isScramble(mp, ss1, sss2) && isScramble(mp, sss1, ss2);
                if(res) break;
            }
        }
        mp.put(s1+s2, res);
        return res;
    }

    public boolean isScrambledp(String s1, String s2){
        if(s1.length() == 0) return true;
        if(s1.length() == 1) return s1.equals(s2);
        int size = s1.length(), i, j, k;
        boolean[][][] dp = new boolean[size+1][size][size];
        for(i = 0; i < size; i ++){
            for(j = 0; j < size; j ++){
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for(int len = 2; len <= size; len ++){
            for(i = 0; i <= size-len; i ++){
                for(j = 0; j <= size-len; j ++){
                    dp[len][i][j] = false;
                    for(k = 1; k < len && !dp[len][i][j]; k ++){
                        dp[len][i][j] = dp[k][i][j] && dp[len-k][i+k][j+k];
                        if(dp[len][i][j]) break;
                        dp[len][i][j] = dp[k][i][len-k+j] && dp[len-k][i+k][j];
                    }
                }
            }
        }
        return dp[size][0][0];
    }
    public static void main(String[] args){
        System.out.println(new Leet87().isScrambledp("abcd", "bcad"));
    }
}
