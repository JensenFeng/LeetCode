package me.jie;

import java.util.*;

/**
 * Created by jie on 8/18/16.
 */
public class Leet1 {
    /*
    hash map
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i ++){
            if(!mp.containsKey(target - nums[i])){
                mp.put(nums[i], i);
            }else{
                ans[0] = mp.get(target - nums[i]);
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
    /*
     two pointer
     */
    public int[] twosum(int[] nums, int target){
        int[] tmp = nums.clone();
        Arrays.sort(nums);
        int ans1 = 0, ans2 = 0;
        for(int i = 0, j = nums.length - 1; i < j;){
            if(nums[i] + nums[j] == target){
                ans1 = nums[i];
                ans2 = nums[j];
                break;
            }else if(nums[i] + nums[j] < target){
                i ++;
            }else{
                j --;
            }
        }
        int p1 = 0, p2 = 0;
        for(int i = 0; i < tmp.length; i ++){
            if(tmp[i] == ans1){
                p1 = i;
                ans1 = Integer.MAX_VALUE;
            }
            if(tmp[i] == ans2){
                p2 = i;
                ans2 = Integer.MAX_VALUE;
            }
        }
        return new int[]{p1,p2};
    }
    public static void main(String[] args){
        int[] n = {5,2,9,12,13};
        int[] ans = new Leet1().twosum(n, 16);
        for(Integer i : ans){
            System.out.println(i);
        }
    }
}
