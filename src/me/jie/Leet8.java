package me.jie;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Leet8 {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        int i = 0;
        int len = str.length();
        while(i < len && str.charAt(i) == ' ') i ++;
        char sign = 0;
        if(i < len){
            char e = str.charAt(i);
            if(e == '+' || e == '-') {
                sign = e;
                i++;
            }
        }
        int num = 0;
        int maxValue = Integer.MAX_VALUE / 10;
        while(i < len){
            char e = str.charAt(i ++);
            if(e >= '0' && e <= '9') {
                if(num > maxValue){
                    return sign == '-'?Integer.MIN_VALUE: Integer.MAX_VALUE;
                }else if(num == maxValue){
//                    if(e <= '7') ;//return -num;
                    if(e >= '8'){
                        if(sign == '-') return Integer.MIN_VALUE;
                        else return Integer.MAX_VALUE;
                    }
                }
                num = num * 10 + e - '0';
            }else break;
        }
        if(sign == '-'){
            num = -num;
        }
        return num;
    }
    public static void main(String[] args){
        System.out.println(new Leet8().myAtoi("2214748387"));
    }
}
