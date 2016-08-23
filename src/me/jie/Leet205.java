package me.jie;

import java.util.*;

/**
 * Created by jie on 8/19/16.
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class Leet205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0) return true;
        int len = s.length();
        Map<Character, Character> mp = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < len ; i ++){
            if(!mp.containsKey(s.charAt(i))){
                if(!set.contains(t.charAt(i))) {
                    mp.put(s.charAt(i), t.charAt(i));
                    set.add(t.charAt(i));
                }else return false;
            }else{
                if(mp.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return true;
    }
}
