package me.jie;

/**
 * Created by jie on 9/29/16.
 */
public class Leet214 {
    public String shortestPalindrome(String s) {
        //TLE
        if(s.length() == 0 || isPalindrome(s)) return s;
        char[] str = s.toCharArray();
        int len = s.length() - 1;
//        StringBuilder tmp = new StringBuilder(s);
        String tmp = s;
        int left = 0;
        for(int i = len; i >= 0; i --){
//            tmp.insert(len - i, str[i]);
            String l = tmp.substring(0, left);
            tmp = l + str[i] + s;
            left ++;
            if(isPalindrome(tmp)){
                break;
            }
        }
        return tmp;
    }
    private boolean isPalindrome(String s){
        int i = 0, len = s.length() - 1;
        while(i  < len ){
            if(s.charAt(i) != s.charAt(len)) return false;
            i ++; len --;
        }
        return true;
    }

    /*
    https://discuss.leetcode.com/topic/25860/my-9-lines-three-pointers-java-solution-with-explanation
     */
    public String shortestPalindromeR(String s){
        int i = 0, end = s.length() - 1, j = end;
        char[] a = s.toCharArray();
        while(i < j){
            if(a[i] == a[j]){
                i ++; j --;
            }else{
                i = 0; end --; j = end;
            }
        }
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
    }
    public static void main(String[] args){
        System.out.println(new Leet214().shortestPalindromeR("abbacd"));
    }
}
