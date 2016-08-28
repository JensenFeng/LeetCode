package me.jie;

import java.util.*;

/**
 * Created by jie on 8/28/16.
 * https://leetcode.com/problems/3sum-closest/
 */
public class Leet16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);

        int dis = Integer.MAX_VALUE;
        int rst = 0;
        for(int i = 0; i <= nums.length - 3; i ++){
            int left = i + 1, right = nums.length - 1;
            int sum = 0;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < dis) {
                    dis = Math.abs(sum - target);
                    rst = sum;
                }
                if(sum == target) return target;
                else if(sum < target){
                    left ++;
                }else {
                    right --;
                }
            }
        }
        return rst;
    }
    public static void main(String[] args){
        int[] n = {-3,-2,-5,3,-4};
        System.out.println(new Leet16().threeSumClosest(n, -1));
    }
}
