package me.jie;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/length-of-last-word/
 */
public class Leet58 {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int len = 0;
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' ') i --;
        for(; i >= 0; i --){
            char e = s.charAt(i);
            if(e != ' ') {
                len ++;
            }else break;
        }
        return len;
    }
}
