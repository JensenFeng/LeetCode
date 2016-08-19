package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet162 {
    /*
    better solution
    https://discuss.leetcode.com/topic/5724/find-the-maximum-by-binary-search-recursion-and-iteration
     */
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }else
                high = mid;
        }
        return low;
    }

    public int findPeakElement2(int[] nums){
        if(nums.length <= 1) return 0;
        return binsearch(nums, 0, nums.length - 1);
    }
    private int binsearch(int[] nums, int left, int right){
        if(left > right) return -1;
        int mid = (left + right) / 2;
        if(mid > 0 && mid < nums.length - 1){
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
        }else if(mid == 0){
            if(nums[mid] > nums[mid + 1]) return mid;
        }else if(mid == nums.length - 1){
            if(nums[mid] > nums[mid - 1]) return mid;
        }
        int p1 = binsearch(nums, left, mid - 1);
        if(p1 == -1) {
            p1 = binsearch(nums, mid + 1, right);
        }
        return p1;
    }
    public static void main(String[] args){
        int[] n = {3, 4, 3, 2, 1};
        System.out.println(new Leet162().findPeakElement2(n));
    }
}
