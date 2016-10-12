package me.jie;

/**
 * Created by jie on 9/19/16.
 */
public class Leet154 {
    /*
    https://discuss.leetcode.com/topic/6468/my-pretty-simple-code-to-solve-it
    */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] > nums[left]){
                right = mid;
            }else{
                right --;
            }
        }
        return nums[left];
    }
    private int findMinOrder(int[] nums){
        int minNum = Integer.MAX_VALUE;
        for(Integer n : nums){
            minNum = Math.min(minNum, n);
        }
        return minNum;
    }
}
