package me.jie;

/**
 * Created by jie on 10/9/16.
 * https://leetcode.com/problems/interleaving-string/
 */
public class Leet97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        //figure out by myself
        int len1 = s1.length(), len2 = s2.length(), len = s3.length();
        if(len1 == len2 && len2 == len && len == 0) return true;
        if(len1 + len2 != len) return false;
        boolean[][][] dp = new boolean[len1+1][len2+1][len+1];
        for(int i = 0; i <= len2; i ++){
            dp[0][i][0] = true;
            if(i > 0){
                if(s2.charAt(i-1) == s3.charAt(i-1)){
                    dp[0][i][i] = true;
                }else{
                    break;
                }
            }
        }
        for(int i = 0; i <= len1; i ++){
            dp[i][0][0] = true;
            if(i > 0) {
                if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                    dp[i][0][i] = true;
                } else {
                    break;
                }
            }
        }
        char e1 = 0, e2 = 0, e = 0;
        int i, j, k;
        for(i = 1; i <= len1; i ++){
            k = i;
            e1 = s1.charAt(i-1);
            e  = s3.charAt(k-1);

            for(j = 1; j <= len2; j ++){
                e2 = s2.charAt(j-1);

                k = i + j;
                e = s3.charAt(k - 1);

                dp[i][j][k] = ((e2 == e) && dp[i][j-1][k-1]) || (e1 == e) && dp[i-1][j][k-1];

            }
        }
        return dp[len1][len2][len];
    }
    public boolean isInterleavedp(String s1, String s2, String s3) {
        /*
        https://discuss.leetcode.com/topic/3532/my-dp-solution-in-c
         */
        int len1 = s1.length(), len2 = s2.length(), len = s3.length();
        if(len1 == len2 && len2 == len && len == 0) return true;
        if(len1 + len2 != len) return false;
        boolean[][] dp = new boolean[len1+1][len2+1]; //change three dimension to 2-D

        char e1 = 0, e2 = 0, e = 0;
        int i, j, k;
        for(i = 0; i <= len1; i ++){
            if(i > 0) e1 = s1.charAt(i-1);
            for(j = 0; j <= len2; j ++){
                if(j > 0) e2 = s2.charAt(j-1);
                k = i + j;
                if(k > 0) e = s3.charAt(k - 1);
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(j == 0){
                    dp[i][j] = (e1 == e) && dp[i-1][j];
                }else if(i == 0){
                    dp[i][j] = (e2 == e) && dp[i][j-1];
                }else {
                    dp[i][j] = ((e2 == e) && dp[i][j - 1]) || (e1 == e) && dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args){
        //
        System.out.println(new Leet97().isInterleave("aabcc", "", "aadbbbaccc"));//"aa", "ab", "aaba"
    }
}
