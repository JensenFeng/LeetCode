package me.jie;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/valid-palindrome/
 */
public class Leet125 {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        char[] ss = s.toLowerCase().toCharArray();
        while(left <= right){
            while(left <= right && !(ss[left] >= 'a' && ss[left] <= 'z' || (ss[left] >= '0' && ss[left] <= '9'))) left ++;
            while(right >= left && !(ss[right]>= 'a' && ss[right]<= 'z' || (ss[right] >= '0' && ss[right] <= '9'))) right --;
            if(left <= right && ss[left] != ss[right]) return false;
            left ++; right --;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Leet125().isPalindrome("0p"));
    }
}
