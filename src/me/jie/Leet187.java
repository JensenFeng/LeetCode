package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
import java.util.*;

public class Leet187 {

    Solution s = new Solution();
    void test(){
        System.out.println(s.findRDS("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
    public static void main(String[] args){
        new Leet187().test();
    }
    class Solution {
        /*
          每长度为10,保存到hashmap中
         */
        public List<String> findRepeatedDnaSequences(String s) {
            if(s.length() <= 10) return new ArrayList<>();
            Set<String> mp = new HashSet<>();
            Set<String> ans = new HashSet<>();
            int len = s.length();
            for(int i = 9; i < len; i ++){
                String sub = s.substring(i - 9, i+1);
                if(mp.contains(sub)){
                    ans.add(sub);
                }else{
                    mp.add(sub);
                }
            }
            return new ArrayList<>(ans);
        }

        /*
        https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-manipulation
         use Bit Map to save memspace
         A, C, G, T: 2bit represent each element
         */
        public List<String> findRDS(String s){
            if(s.length() <= 10) return new ArrayList<>();
            Set<Integer> wd = new HashSet<>();
            Set<Integer> dupwd = new HashSet<>();
            List<String> ans = new ArrayList<>();
            char[] map = new char[26];
            map['C' - 'A'] = 1;
            map['G' - 'A'] = 2;
            map['T' - 'A'] = 3;

            int len = s.length();
            int t;
            for(int i = 0; i < len - 9; i ++){
                t = 0;
                for(int j = i; j < i + 10; j ++){
                    t <<= 2; //two bit
                    t |= map[s.charAt(j) - 'A'];
                }
                if(!wd.add(t) && dupwd.add(t)){
                    ans.add(s.substring(i, i + 10));
                }
            }
            return ans;
        }
    }
}

