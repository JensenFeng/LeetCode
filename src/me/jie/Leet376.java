package me.jie;

/**
 * Created by jie on 8/8/16.
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class Leet376 {
    /*
      dp: O(n^2), O(n)
     */
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return nums.length;

        int[] dp = new int[nums.length];
        int[] sign = new int[nums.length]; //positive:1 or negitive:-1
        dp[0] = 1;
        if(nums[1] != nums[0])
            dp[1] = 2;
        else dp[1] = 1;
        if(nums[1] > nums[0]) sign[1] = 1;
        else if(nums[1] < nums[0]) sign[1] = -1;

        for(int i = 2; i < nums.length; i ++){
            for(int j = i-1; j >= 0; j --){
                if(sign[j] == 1 && nums[i] < nums[j]){
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        sign[i] = -1;
                    }
                }else if(sign[j] == -1 && nums[i] >  nums[j]){
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        sign[i] = 1;
                    }
                }else if(sign[j] == 0){
                    if(nums[i] != nums[j] && dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        if(nums[i] > nums[j]) sign[i] = 1;
                        else sign[i] = -1;
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i < nums.length; i ++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }


    /* https://leetcode.com/articles/wiggle-subsequence/
     DP:
      O(n), O(n)
     */
    public int wiggleMaxLen(int[] nums){
        if(nums.length < 2) return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] > nums[i-1]){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }else if(nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(down[nums.length-1], up[nums.length-1]);
    }
    /*
      better : O(n), O(1)
     */
    public int wiggleMaxLen2(int[] nums){
        if(nums.length < 2) return nums.length;
        int up, down;
        up = down = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] > nums[i-1]){
                up = down + 1;
            }else if(nums[i] < nums[i-1]){
                down = up + 1;
            }
        }
        return Math.max(down , up);
    }

    /*
      greedy: O(n), O(1)
     */
    public int wiggleMaxLenGD(int[] nums){
        if(nums.length < 2) return nums.length;
        int prediff = nums[1] - nums[0] ;
        int currdiff = 0;
        int count = nums[1] - nums[0] != 0 ? 2 : 1;
        for(int i = 2; i < nums.length; i ++){
            currdiff = nums[i] - nums[i-1];
            if(prediff >= 0 && currdiff < 0 ||(prediff < 0 && currdiff >= 0)){
                count ++;
                prediff = currdiff;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums = {1,1,1,17,5,10,13,15,10,5,16,8};
        System.out.println(new Leet376().wiggleMaxLength(nums));
    }
}
