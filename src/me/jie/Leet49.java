package me.jie;

/**
 * Created by jie on 8/21/16.
 */
import java.util.*;

public class Leet49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        List<List<String>> rst = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();
        for(int i = 0; i < strs.length; i ++){
            String s = sort(strs[i]);
            List<String> lt = new ArrayList<>();
            if(mp.containsKey(s)){
                lt = mp.get(s);
            }
            lt.add(strs[i]);
            mp.put(s, lt);
        }
        for(String s: mp.keySet()){
            rst.add(mp.get(s));
        }
        return rst;
    }
    private String sort(String s){
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return String.copyValueOf(str);
    }

}
