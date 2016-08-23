package me.jie;

import java.util.Arrays;

/**
 * Created by jie on 8/23/16.
 */
public class Leet43 {
    /*
    O(nm)
     */
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2 + 1];
        int len = 0;
        int carry = 0;
        for(int i = len2 - 1; i >= 0; i --){
            int e = num2.charAt(i) - '0';
            len = len2 - 1 - i;
            carry = 0;
            for(int j = len1 - 1; j >= 0; j --){
                carry += (num1.charAt(j) - '0') * e + ans[len];
                ans[len ++] = carry % 10;
                carry /= 10;
            }
            if(carry != 0){
                ans[len ++] = carry % 10;
            }
        }
        for(int i = 0, j = len - 1; i <= j; i ++, j --){
            int tmp = ans[i];
            ans[i]  = ans[j];
            ans[j]  = tmp;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(; i < len; i ++){
            sb.append(ans[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Leet43().multiply("1000000", "10"));
    }
}
