package me.jie;

/**
 * Created by jie on 8/30/16.
 * https://leetcode.com/problems/house-robber-ii/
 */
public class Leet213 {
    /*
    https://discuss.leetcode.com/topic/14375/simple-ac-solution-in-java-in-o-n-with-explanation
     */
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        return Math.max(robNoCircle(nums, 0, len - 2), robNoCircle(nums, 1, len - 1));
    }
    private int robNoCircle(int[] nums, int lo, int hi){
        int pre = 0, cur = 0;
        while(lo <= hi){
            int tmp = cur;
            cur = pre + nums[lo];
            pre = Math.max(tmp, pre);
            lo ++;
        }
        return Math.max(pre, cur);
    }
    public static void main(String[] args){
        int[] n = {1,2 ,3, 5, 0, 6, 2, 1};
        System.out.println(new Leet213().rob(n));
    }
}
