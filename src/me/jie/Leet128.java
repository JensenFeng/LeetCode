package me.jie;

import java.util.*;

/**
 * Created by jie on 9/18/16.
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class Leet128 {
    /*
    https://discuss.leetcode.com/topic/6148/my-really-simple-java-o-n-solution-accepted
     */
    public int longestConsecutive(int[] nums) {
        int len = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(Integer n : nums){
            if(mp.containsKey(n)) continue;
            int left = mp.containsKey(n-1)? mp.get(n-1) : 0;
            int right = mp.containsKey(n+1)? mp.get(n+1): 0;
            int sum = right + left + 1;
            mp.put(n, sum);
            mp.put(n-left, sum);
            mp.put(n+right, sum);
            len = Math.max(len , sum);
        }
        return len;
    }
}
