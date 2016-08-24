package me.jie;

/**
 * Created by jie on 8/24/16.
 */
public class Leet198 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;

        int maxPos = 0, curPos = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if(i >= 2){
                if(i - maxPos > 1) {
                    dp[i] = dp[maxPos] + nums[i];
                }
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i]);
            }else{
                dp[i] = nums[i];
            }
            maxPos = curPos;
            if(dp[i] > dp[maxPos]){
                curPos = i;
            }
        }
        return dp[curPos];
    }
    public int robb(int[] nums){
        if(nums.length == 0) return 0;
        int pre = 0, cur = 0;
        for(int i = 0; i < nums.length; i ++){
            if(i % 2 == 0){
                pre = Math.max(pre + nums[i], cur);
            }else{
                cur = Math.max(cur + nums[i], pre);
            }
        }
        return Math.max(pre, cur);
    }
    public static void main(String[] args){
        int[] n = {1 ,2 ,3, 9, 8, 2, 3};
        System.out.println(new Leet198().robb(n));
    }
}
