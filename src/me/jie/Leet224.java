package me.jie;

import java.util.*;

/**
 * Created by jie on 8/27/16.
 * https://leetcode.com/problems/basic-calculator/
 */
public class Leet224 {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
//        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] stk ;//= new String[s.length()];
        int begin = 0, end = 0;

        int ans = 0;
        for(int i = 0; i < s.length(); i ++){
            char e = s.charAt(i);
            if(e == '(' || e == '+' || e == '-') stack.push(e+"");
            else if(e == ')'){
                //pop
                stk = new String[stack.size()];
                begin = 0; end = 0;
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    stk[end++] = stack.pop();
                }
                stack.pop(); // '('
                int tmp = Integer.parseInt(stk[--end]);
                //compute sum
                while(end > 0){
                    String ss = stk[-- end];
                    if(ss.equals("+")){
                        tmp += Integer.parseInt(stk[--end]);
                    }else if(ss.equals("-")){
                        tmp -= Integer.parseInt(stk[--end]);
                    }
                }
                stack.push(tmp+"");
            }else if(e >= '0' && e <= '9') {
                int tmp = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    tmp = tmp * 10 + (s.charAt(i++) - '0');
                }
                i --;
                stack.push(tmp + "");
            }
        }
        stk = new String[stack.size()];
        begin = 0; end = 0;
        while(!stack.isEmpty()) {
            stk[end++] = stack.pop();
        }
        if(end >= 1)
            ans = Integer.parseInt(stk[--end]);
        while(end > 0){
            String ss = stk[--end];
            if(ss.equals("+")){
                ans += Integer.parseInt(stk[--end]);
            }else if(ss.equals("-")){
                ans -= Integer.parseInt(stk[--end]);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(new Leet224().calculate("((1- 2)-3)+(6+8)"));
    }
    private int compute(String s){
        int len = s.length();
        int ans = 0;
        int i = 0;
        while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            ans = ans * 10 + (s.charAt(i ++) - '0');
        }
        char e = s.charAt(i ++);
        while(i < len){
            int tmp = 0;
            while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                tmp = tmp * 10 + (s.charAt(i ++) - '0');
            }
            if(e == '+') ans += tmp;
            else if(e == '-') ans -= tmp;
            e = s.charAt(i ++);
        }
        return ans;
    }
}
