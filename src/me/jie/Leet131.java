package me.jie;

/**
 * Created by jie on 8/5/16.
 * https://leetcode.com/problems/palindrome-partitioning/
 */
import java.util.*;
public class Leet131 {
    /*
       backtracking
     */
    List<List<String>> rst;
    List<String> curr;
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return new ArrayList<>();
        rst = new ArrayList<>();
        curr = new ArrayList<>();
        p(s, 0);
        return rst;
    }
    private void p(String s, int begin){
        if(curr.size() > 0 && begin >= s.length()){
            rst.add(new ArrayList<>(curr));
            return;
        }
        for(int i = begin; i < s.length(); i ++) {
            if (isPalindrome(s, begin, i)) {
                if (i == begin) {
                    curr.add(Character.toString(s.charAt(i)));
                } else {
                    String sub = s.substring(begin, i + 1);
                    curr.add(sub);
                }
                p(s, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r){
        if(l == r) return true;
        for(int i = l, j = r; i < j; i ++, j --){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition2(String s) {
        List<List<String>> rst = new ArrayList<>();
        dfs(rst, new ArrayList<>(), s);
        return rst;
    }
    private void dfs(List<List<String>> rst, List<String> cur, String s){
        if(s.length() == 0) {
            rst.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 1; i <= s.length(); i ++){
            if(isPalindrome(s, 0, i-1)){
                cur.add(s.substring(0, i));
                dfs(rst, cur, s.substring(i, s.length()));
                cur.remove(cur.size()-1);
            }
        }
    }
    public static void main(String[] args){
        List<List<String>> rst = new Leet131().partition2("aabb");
        rst.forEach(lt -> System.out.println(lt));
    }
}
