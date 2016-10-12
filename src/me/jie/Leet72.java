package me.jie;

/**
 * Created by jie on 10/8/16.
 */
public class Leet72 {
    public int minDistance(String word1, String word2) {
        //figure out by myself
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int m = word1.length(), n = word2.length();
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int[] cur = new int[m+1];
        //init
        for(int i = 0; i <= m; i ++){
            cur[i] = i;
        }
        int pre = 0;
        //d(i, j)
        for(int i = 1; i <= n; i ++){
            pre = cur[0];
            cur[0] = i;
            for(int j = 1; j <= m; j ++) {
                int tmp = cur[j];
                if (w2[i - 1] == w1[j - 1]) {
                    cur[j] = pre;
                } else {
                    cur[j] = Math.min(Math.min(pre, cur[j-1]), cur[j]) + 1;
                }
                pre = tmp;
            }
        }
        return cur[m];
    }
    public static void main(String[] args){
        String w1 = "distance",     w2 = "springbok";
        System.out.println(new Leet72().minDistance(w1, w2));
    }
}
