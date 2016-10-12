package me.jie;

/**
 * Created by jie on 9/27/16.
 */
public class Leet115 {
    /*
    https://discuss.leetcode.com/topic/9488/easy-to-understand-dp-in-java
     */
    public int numDistinct(String s, String t) {
        if(s.length() == 0 && t.length() == 0) return 1;
        if(s.length() == 0 ) return 0;
//        return helper(s, 0, t, 0); //tle

        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[tlen+1][slen+1];
        for(int i = 0; i <= slen; i ++) dp[0][i] = 1;
        for(int i = 1; i <= tlen; i ++){
            for(int j = 1; j <= slen; j ++){
                dp[i][j] += dp[i][j-1];
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[tlen][slen];
    }
    private int helper(String s, int bs, String t, int bt){
        if(s.length() - bs < t.length() - bt) return 0;
        if(t.length() == bt) return 1;
        int len = helper(s, bs + 1, t, bt);
        if (s.charAt(bs) == t.charAt(bt)) {
            return len + helper(s, bs + 1, t, bt + 1);
        }else{
            return len;
        }
    }
    public static void main(String[] args){
        System.out.println(new Leet115().numDistinct("rabbbit", "rabbit"));
    }
}
