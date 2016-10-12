package me.jie;

/**
 * Created by jie on 10/4/16.
 */
import java.util.*;

public class Leet30 {
    /*
    https://discuss.leetcode.com/topic/17943/naive-c-solution-using-two-unordered_map-about-20-lines
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0 || s.length() == 0) return new ArrayList<>();

        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < words.length; i ++){
            mp.put(words[i], mp.getOrDefault(words[i], 0) + 1);
        }
        int counter = words.length, n = s.length(), len = words[0].length();
        List<Integer> rst = new ArrayList<>();
        Map<String, Integer> tmp;
        for(int i = 0; i < n - len * counter + 1; i ++){
            tmp = new HashMap<>();
            int j = 0;
            while(j < counter){
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if(mp.containsKey(word)){
                    tmp.put(word, tmp.getOrDefault(word, 0) + 1);
                    if(tmp.get(word) > mp.get(word)){
                        break;
                    }
                }else{
                    break;
                }
                j ++;
            }
            if(j == counter) rst.add(i);
        }
        return rst;
    }
    public static void main(String[] args){
        String s = "barfoobarfoothefoobarman";
        String[] words = {"foo", "bar", "the"};
        System.out.println(new Leet30().findSubstring(s, words));
    }
}
