package me.jie;

/**
 * Created by jie on 8/26/16.
 * https://leetcode.com/problems/generate-parentheses/
 */
import java.util.*;

public class Leet22 {
    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<>();
        List<String> rst = new ArrayList<>();
        backtracking(n, 0, 0, rst, "");
        return rst;
    }
    private void backtracking(int n ,int left, int right, List<String> rst, String s){
        if(left == n && right == n){
            rst.add(s);
            return ;
        }
        if(left < n){
            backtracking(n, left + 1, right, rst, s + "(");
        }
        if(right < n && right < left){
            backtracking(n, left, right + 1, rst, s + ")");
        }
    }
    public static void main(String[] args){
        System.out.println(new Leet22().generateParenthesis(3));
    }
}
