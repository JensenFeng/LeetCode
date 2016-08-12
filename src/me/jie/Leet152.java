package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class Leet152 {

    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i ++){
            int min1 = nums[i] * mindp[i-1], max1 = nums[i] * maxdp[i-1];
            maxdp[i] = Math.max(nums[i], Math.max(min1, max1));
            mindp[i] = Math.min(nums[i], Math.min(min1, max1));
            ans = Math.max(ans, maxdp[i]);
        }
        return ans;
    }

    //better space complexity

    public int maxProductDP(int[] nums){
        if(nums.length == 0) return 0;
        int max = nums[0], min = nums[0];
        int ans = nums[0];
        int tmp;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] >= 0){
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            }else {
                tmp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], tmp * nums[i]);
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }




    public static void main(String[] args){
        int[] nums = {-1,0};
        System.out.println(new Leet152().maxProductDP(nums));
    }
}
