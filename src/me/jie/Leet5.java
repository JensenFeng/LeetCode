package me.jie;

/**
 * Created by jie on 8/27/16.
 */
public class Leet5 {
    /*
    https://leetcode.com/articles/longest-palindromic-substring/
     */
    private int maxLen = 1, start = 0;
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int len = s.length();
        int begin = 0;
        while(begin < len){
            isPalindrome(s, begin, begin);
            isPalindrome(s, begin, begin + 1);
            begin ++;
        }
        System.out.println(maxLen);
        return s.substring(start, start + maxLen);
    }
    private void isPalindrome(String s, int lo, int hi){
        while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
            lo --; hi ++;
        }
        if(hi - lo - 1 > maxLen){
            start = lo + 1;
            maxLen = hi - lo - 1;
        }
    }
    public static void main(String[] args){
        String s = "aaaaaaa";
        System.out.println(new Leet5().longestPalindrome(s));
    }
}
