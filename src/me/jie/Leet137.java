package me.jie;

import java.util.*;

/**
 * Created by jie on 8/29/16.
 * https://leetcode.com/problems/single-number-ii/
 */
public class Leet137 {
    public int singleNumberHash(int[] nums) {
        if(nums.length == 0) return 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i], 1);
            }else{
                mp.put(nums[i], 3);
            }
        }
        int ans = 0;
        for(Integer i : mp.keySet()){
            if(mp.get(i) == 1){
                ans = i;
                break;
            }
        }
        return ans;
    }
    /* Better bitwise
    https://discuss.leetcode.com/topic/11877/
    detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
     */
    /*  Easy Understand
    https://discuss.leetcode.com/topic/43166/java-o-n-easy-to-understand-solution-easily-extended-to-any-times-of-occurance
     */
    public int singleNumber(int[] nums){

        int ans = 0;
        for(int i = 0; i < 32; i ++){
            int sum = 0;
            for(int j = 0; j < nums.length; j ++){
                if(((nums[j] >> i) & 1) == 1){
                    sum ++;
                    sum %= 3;
                }
            }
            if(sum != 0){
                ans |= sum << i;
            }
        }
        return ans;
    }
}
