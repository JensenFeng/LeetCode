package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/word-break/
 */
import java.util.*;

public class Leet139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return true;
        if(wordDict.size() == 0) return false;
        List<String> lt = new ArrayList<>();
        for(String w: wordDict){
            lt.add(w);
        }
        mp.put("", true);
        wordDfs(s, lt);
        return mp.get(s);
    }
    private Map<String, Boolean> mp = new HashMap<>();
    private void wordDfs(String s, List<String> wordDict){
        if(mp.containsKey(s)) return;

        for (int i = 0; i < wordDict.size(); i ++) {
            String w = wordDict.get(i);
            if (s.startsWith(w)) {
                int j = w.length();
                String left = s.substring(j , s.length());
                wordDfs(left, wordDict);
                if(mp.containsKey(left)){
                    if(mp.get(left)) {
                        mp.put(s, true);
                        return;
                    }
                }
            }
        }
        mp.put(s, false);
    }

    /*
        dp: https://discuss.leetcode.com/topic/6156/java-implementation-using-dp-in-two-ways
     */
    public boolean wordBreakdp(String s, Set<String> wordDict){
        if(s.length() == 0) return true;
        if(wordDict.size() == 0) return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        //O(n^2)
//        for(int i = 1; i <= s.length(); i ++){
//            for(int j = 0; j < i; j ++){
//                if(wordDict.contains(s.substring(j, i)) && dp[j]){
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }

        //O(n * k)
        for(int i = 1; i <= s.length(); i ++){
            for(String str : wordDict){
                if(str.length() <= i){
                    if(dp[i-str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }



    public static void main(String[] args){
        String[] tmp = {"a", "aa", "ab"};
        Set<String> wd = new HashSet<>();
        for(String s: tmp){
            wd.add(s);
        }
        System.out.println(new Leet139().wordBreak("aaab", wd));
    }
}
