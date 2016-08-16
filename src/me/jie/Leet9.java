package me.jie;

/**
 * Created by jie on 8/15/16.
 * https://leetcode.com/problems/palindrome-number/
 */
public class Leet9 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        int[] map = new int[12];
        int len = 0;
        while(x != 0){
            map[len ++] = x % 10;
            x /= 10;
        }
        for(int i = 0, j = len - 1; i < j; i ++, j --){
            if(map[i] != map[j]) return false;
        }
        return true;
    }
    public boolean isPalin(int x){
        if(x < 0)return false;
        int y = x;
        int rev = 0;
        while(y != 0){
            rev = rev * 10 + y % 10;
            y /= 10;
        }
        return x == rev;
    }
    public static void main(String[] args){
        System.out.println(new Leet9().isPalin(121));
    }
}
