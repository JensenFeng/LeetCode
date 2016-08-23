package me.jie;

import java.util.*;

/**
 * Created by jie on 8/21/16.
 */
public class Leet290 {
    public boolean wordPattern(String pattern, String str) {

        String[] strings = str.split(" ");
        if(strings.length != pattern.length()) return false;
        //init
        Map<Character, String> mp = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < pattern.length(); i ++){
            char e = pattern.charAt(i);
            if(!mp.containsKey(e)){
                if(!set.contains(strings[i])) {
                    mp.put(e, strings[i]);
                    set.add(strings[i]);
                }
                else return false;
            }else{
                if( !mp.get(e).equals(strings[i])) return false;
            }
        }
        return true;
    }
}
