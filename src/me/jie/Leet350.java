package me.jie;

import java.util.HashMap;

/**
 * Created by jie on 8/20/16.
 */
import java.util.*;
public class Leet350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums1.length; i ++){
            if(!mp.containsKey(nums1[i])){
                mp.put(nums1[i], 1);
            }else{
                mp.put(nums1[i], mp.get(nums1[i]) + 1);
            }
        }
        List<Integer> lt = new ArrayList<>();
        for(int i = 0; i < nums2.length; i ++){

            if(mp.containsKey(nums2[i])){
                int t = mp.get(nums2[i]);
                if(t > 0) {
                    lt.add(nums2[i]);
                    mp.put(nums2[i], t - 1);
                }
            }
        }
        int[] ans = new int[lt.size()];
        for(int i = 0; i < lt.size(); i ++){
            ans[i] = lt.get(i);
        }
        return ans;
    }
}
