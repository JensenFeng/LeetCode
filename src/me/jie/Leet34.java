package me.jie;

/**
 * Created by jie on 8/28/16.
 * https://leetcode.com/problems/search-for-a-range/
 */
public class Leet34 {
    /*
    https://discuss.leetcode.com/topic/5891/
    clean-iterative-solution-with-two-binary-searches-with-explanation

    这个是的
     */
    public int[] searchRangeBS(int[] nums, int target){
        int[] rst = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if(nums[left] != target) return rst;
        rst[0] = left;
        right = nums.length-1;
        while(left < right){
            int mid = (left + right + 1) / 2;
            if(nums[mid] > target) right = mid - 1;
            else left = mid;
        }
        rst[1] = right;
        return rst;
    }


    //下面自己写的不太好,不是O(logN)
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int[] rst = new int[]{-1, -1};
        int left = 0, right = nums.length-1;
        boolean flag = false;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                flag = true;
                left = mid;
                right = mid;
                break;
            }
        }
        if(flag) {//&& left < nums.length  right >= 0 &&

            while (left >= 0 && nums[left] == target) left--;
            while (right < nums.length && nums[right] == target) right++;
            rst[0] = left + 1;
            rst[1] = right - 1;
        }
        return rst;
    }
}
