package me.jie;

/**
 * Created by jie on 10/8/16.
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Leet300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i ++){
            dp[i] = 1;
            for(int j = 0; j < i; j ++){
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    /*
    https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation
     */
    public int lengthOfLISNlogN(int[] nums){
        int[] tail = new int[nums.length];
        int size = 0;
        for(Integer n : nums){
            int i = 0, j = size;
            while(i != j){
                int m = (i + j) / 2;
                if(tail[m] < n){
                    i = m + 1;
                }else{
                    j = m;
                }
            }
            tail[i] = n;
            if(i == size) size ++;
        }
        return size;
    }
    public static void main(String[] args){
        int[] n = {10,9,2,5,3,7,101,18};
        System.out.println(new Leet300().lengthOfLISNlogN(n));
    }
}
