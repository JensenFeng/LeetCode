package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[right]){
                return binarysearch(nums, left, right, target);
            }
            else  if(nums[mid] > nums[right]){
                if(target > nums[mid] || target <= nums[right]){
                    left = mid + 1;
                }else right = mid;
            }
            else if(nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else right = mid;
            }
        }
        return false;
    }
    private boolean binarysearch(int[] nums, int left, int right, int target){
        if(left > right)  return false;
        if(left == right){
            if(nums[left] == target) return true;
            else return false;
        }
        int mid = left + (right - left) / 2;
        if(nums[mid] == target) return true;

        if(binarysearch(nums, left, mid - 1, target)) return true;
        return binarysearch(nums, mid + 1, right, target);
    }

    public static void main(String[] args){
        int[] n = {1, 1, 2, 3, 5};
        System.out.println(new Leet81().search(n, 1));
    }
}
