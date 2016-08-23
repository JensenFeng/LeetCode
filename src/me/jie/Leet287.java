package me.jie;

/**
 * Created by jie on 8/22/16.
 */
public class Leet287 {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0 )return 0;

        return binsearch(nums, 0, nums.length - 1);
    }
    /*
    https://discuss.leetcode.com/topic/25580/two-solutions-with-explanation-o-nlog-n-and-o-n-time-o-1-space-without-changing-the-input-array
     */
    private int binsearch(int[] nums, int lo, int hi){
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] <= mid) count ++;
            }
            if(count > mid) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    /**
     https://discuss.leetcode.com/topic/25913/
     my-easy-understood-solution-with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanation
     */
    private int twopointer(int[] nums, int lo, int hi){
        // see up url
        return 0;
    }
    public static void main(String[] args){
        int[] n = {1, 2, 1, 3, 5};
        System.out.println(new Leet287().findDuplicate(n));
    }
}
