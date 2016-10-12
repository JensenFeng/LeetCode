package me.jie;

import java.util.*;

/**
 * Created by jie on 10/2/16.
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Leet32 {
    /*https://discuss.leetcode.com/topic/7234/simple-java-solution-o-n-time-one-stack*/
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        int left = -1;
        for(int i = 0; i < s.length(); i ++){
            char e = s.charAt(i);
            switch(e){
                case '(' : stk.push(i);break;
                case ')' :{
                    if(stk.isEmpty()) left = i;
                    else{
                        stk.pop();
                        if(stk.isEmpty()) {
                            ans = Math.max(ans, i - left);
                        }
                        else{
                            ans = Math.max(ans, i - stk.peek());
                        }
                    }
                }break;
            }
        }
        return ans;
    }

    /*https://discuss.leetcode.com/topic/2426/my-dp-o-n-solution-without-using-stack*/
    public int longestValidParenthesesdp(String s){
        if(s.length() <= 1) return 0;
        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        int ans = 0;
        for(int i = 1; i < s.length(); i ++){
            if(str[i] == ')' && i - dp[i-1] - 1 >= 0 && str[i-dp[i-1]-1] == '('){
                dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0? dp[i-dp[i-1]-2] : 0);
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(new Leet32().longestValidParenthesesdp(")()(((()))"));
    }
}
