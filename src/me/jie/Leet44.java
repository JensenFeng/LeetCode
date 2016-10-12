package me.jie;

/**
 * Created by jie on 10/10/16.
 */
public class Leet44 {
    public static void main(String[] args){
        System.out.println(new Leet44().isMatchdp(
                "abefcdgiescdfimde",
                "ab*cd?i*de"));
    }
    private boolean flag;
    public boolean isMatch(String s, String p) {
        flag = false;
        helper(s, 0, p, 0);
        return flag;
    }
    private void helper(String s, int sp, String p, int pp){
        if(flag) return;
        if(sp == s.length()){
            flag = true;
            for(int i = pp; i < p.length(); i ++){
                if(p.charAt(i) != '*'){
                    flag = false;
                    break;
                }
            }
            return;
        }
        if(pp == p.length()) return;
        char e = p.charAt(pp);
        if(e == '?'){
            helper(s, sp + 1, p, pp + 1);
        }else if(e == '*'){
            int len = p.length();
            while(pp + 1 < len && p.charAt(pp + 1) == '*') pp ++;
                // ' '
                helper(s, sp, p, pp + 1);
                // one
                helper(s, sp + 1, p, pp + 1);
                // many
                helper(s, sp + 1, p, pp);
        }else{
            if(e != s.charAt(sp)) return;
            helper(s, sp + 1, p, pp + 1);
        }
    }

    public boolean isMatchdp(String s, String p){
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
//        boolean[] dp = new boolean[len2+1];
        dp[0][0] = true;
        for(int i = 1; i <= len2; i ++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = true;
            }else{
                break;
            }
        }
        for(int i = 1; i <= len1; i ++){
            char e1 = s.charAt(i-1);
            for(int j = 1; j <= len2; j ++){
                char e2 = p.charAt(j-1);
                if(e2 == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if(e2 == '?' || e1 == e2){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[len1][len2];
    }
}
