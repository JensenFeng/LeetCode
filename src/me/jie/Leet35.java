package me.jie;

/**
 * Created by jie on 8/29/16.
 * https://leetcode.com/problems/search-insert-position/
 */
public class Leet35 {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int pos = 0;
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        if(nums[left] >= target) return left;
        else return left + 1;
    }
    public static void main(String[] args){
        int[] n = {1};
        System.out.println(new Leet35().searchInsert(n, 1));
    }
}
