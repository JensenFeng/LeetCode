package me.jie;

/**
 * Created by jie on 10/2/16.
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Leet10 {
    /*
    https://discuss.leetcode.com/topic/6183/my-concise-recursive-and-dp-solutions-with-full-explanation-in-c
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for(int i = 1; i <= m; i ++){
            f[i][0] = false;
        }
        //p[0, ..., j-1]
        for(int j = 1; j <= n; j ++){
            f[0][j] = j > 1 && f[0][j-2] && p.charAt(j-1) == '*';
        }
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                if(p.charAt(j-1) != '*'){
                    f[i][j] = f[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) ||
                            '.' == p.charAt(j-1));
                }else{
                    f[i][j] = (s.charAt(i-1) == p.charAt(j-2) || '.' == p.charAt(j-2)) &&
                            f[i-1][j] || f[i][j-2];
                }
            }
        }
        return f[m][n];
    }
    public static void main(String[] args){
        System.out.println(new Leet10().isMatch("abb", ".*b"));
    }
}
