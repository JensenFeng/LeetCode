package me.jie;

import java.util.*;

/**
 * Created by jie on 8/19/16.
 */
public class Leet349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> lt = new ArrayList<>();
        for(int i = 0 ,j = 0; i < nums1.length && j < nums2.length; ){
            if(nums1[i] == nums2[j]){
                if(lt.size() == 0 || (lt.size() > 0 && lt.get(lt.size() - 1) != nums1[i])) {
                    lt.add(nums1[i]);
                }
                i ++;
                j ++;
            }else if(nums1[i] < nums2[j]){
                i ++;
            }else{
                j ++;
            }
        }
        int[] ans = new int[lt.size()];
        for(int i = 0; i < lt.size(); i ++){
            ans[i] = lt.get(i);
        }
        return ans;
    }
}
