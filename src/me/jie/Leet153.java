package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet153 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            if(nums[low] <= nums[high]) break;
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }
}
