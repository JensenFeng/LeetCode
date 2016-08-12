package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/word-break-ii/
 */
import java.util.*;

public class Leet140 {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        backtracking(s, wordDict, ans);
        return ans;
    }
    private Map<String, List<String>> mp = new HashMap<>();
    private void backtracking(String s, Set<String> wordDict, List<String> rst){
        if(s.length() == 0){
            mp.put("", new ArrayList<>());
            return;
        }
        if(mp.containsKey(s)){
            rst.addAll(mp.get(s));
            return;
        }

        for(String str: wordDict){
            if(s.startsWith(str)){
                String left = s.substring(str.length(), s.length());
                List<String> lst = new ArrayList<>();
                backtracking(left, wordDict, lst);
                if(lst.size() > 0) {
                    for (String t : lst) {
                        rst.add(str + " " + t);
                    }
                }
                else if(lst.size() == 0 && left.length() == 0){
                    rst.add(str);
                }
            }
        }
        mp.put(s, rst);
    }

    public static void main(String[] args){
        String[] tmp = {"a","abc","b","cd"};
        Set<String> wd = new HashSet<>();
        for(String s: tmp){
            wd.add(s);
        }
        List<String> rst = new Leet140().wordBreak("abcd", wd);
        System.out.println(rst);
    }
}
