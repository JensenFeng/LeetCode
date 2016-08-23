package me.jie;

/**
 * Created by jie on 8/21/16.
 */
public class Leet28 {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() == 0 || needle.length() > haystack.length()) return -1;
        int i , j;
        for(i = 0; i < haystack.length() - needle.length() + 1; i ++){
            for(j = 0; j < needle.length(); j ++){
                if(needle.charAt(j) != haystack.charAt(i + j)) break;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }
}
