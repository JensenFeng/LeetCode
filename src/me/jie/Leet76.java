package me.jie;

/**
 * Created by jie on 10/3/16.
 */
import java.util.*;

public class Leet76 {
    private Map<Character, Integer> mp;
    public String minWindowError(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        //没法解决t中字符相同的问题
        mp = new HashMap<>();
        List<List<Integer>> rst = new ArrayList<>();
        for(int i = 0; i < t.length(); i ++){
            mp.put(t.charAt(i), i);
            rst.add(new ArrayList<>());
        }

        for(int i = 0; i < s.length(); i ++){
            char e = s.charAt(i);
            if(mp.containsKey(e)){
                List<Integer> lt = rst.get(mp.get(e));
                lt.add(i);
            }
        }
        int maxDis = s.length();
        int dp1 = 0, dp2 = 0;
        while(true) {
            int minp = Integer.MAX_VALUE, maxp = 0;
            int p1 = 0;
            for (int i = 0; i < t.length(); i++) {
                List<Integer> lt = rst.get(i);
                if(lt.size() > 0) {
                    int first = lt.get(0);
                    if (first < minp) {
                        minp = first;
                        p1 = i;
                    }
                    if(first > maxp){
                        maxp = first;
                    }
                }else{
                    break;
                }
            }
            if(maxp - minp < maxDis){
                maxDis = maxp - minp;
                dp1 = minp;
                dp2 = maxp;
            }
            List<Integer> lt;
            lt = rst.get(p1);
            if(lt.size() > 0) lt.remove(0);
            if(lt.size() == 0) break;
        }
        return s.substring(dp1, dp2 + 1);
    }

    /*
    https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
     */
    public String minWindow(String s, String t){
        int[] mp = new int[128];
        for(int i = 0; i < t.length(); i ++){
            mp[t.charAt(i)] ++;
        }
        int len = t.length(), begin = 0, end = 0, maxD = Integer.MAX_VALUE, head = 0;
        while(end < s.length()){
            if(mp[s.charAt(end ++)]-- > 0){
                len --;
            }
            while(len == 0){
                if(end - begin < maxD){
                    maxD = end - begin;
                    head = begin;
                }
                if(mp[s.charAt(begin ++)] ++ == 0) len ++;
            }
        }
        return maxD == Integer.MAX_VALUE? "" : s.substring(head, head + maxD);
    }
    public static void main(String[] args){
        System.out.println(new Leet76().minWindow("ADOBECEEECBANC", "ABC"));
    }
}
