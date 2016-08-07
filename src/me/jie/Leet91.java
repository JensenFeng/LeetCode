package me.jie;


/**
 * Created by jie on 8/4/16.
 * https://leetcode.com/problems/decode-ways/
 */
public class Leet91 {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.contains("00")) return 0;
        int[] dp = new int[s.length()];
        int t, pre;
        for(int i = 0; i < s.length(); i ++){
            if(i >= 2) {
                t = s.charAt(i) - '0';
                pre = s.charAt(i-1) - '0';
                if(pre == 0){
                    dp[i] = dp[i-1];
                }else {
                    if(t == 0){
                        t += pre * 10;
                        if(t <= 26){
                            dp[i] = dp[i-2];
                        }else{
                            dp[i] = 0;
                        }
                    }else {
                        t += pre * 10;
                        if (t <= 26) {
                            dp[i] = dp[i - 1] + dp[i - 2];
                        } else {
                            dp[i] = dp[i - 1];
                        }
                    }
                }
            }else if(i < 1){
                t = s.charAt(0)-'0';
                if(t == 0) {
                    dp[i] = 0;
                    break;
                }
                dp[i] = 1;
            }else if(i < 2){
                t = s.charAt(i)-'0';
                pre = s.charAt(i-1) -'0';
                if(t == 0){
                    dp[i] = (pre*10+t <= 26)? 1: 0;
                }else {
                    t += pre * 10;
                    if (t <= 26) {
                        dp[i] = 2;
                    } else {
                        dp[i] = 1;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
    //better way
    public int numDecoding(String s){
        if(s.length() == 0) return 0;
        if(s.contains("00")) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) == '0'? 0 : 1;
        for(int i = n - 2; i >= 0; i --){
            if(s.charAt(i) == '0') continue;
            dp[i] = ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) ? dp[i+1] + dp[i+2] : dp[i+1];
        }
        return dp[0];
    }
    public static void main(String[] args){
        System.out.println(new Leet91().numDecodings("10"));
    }

}
