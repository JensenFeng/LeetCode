package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if (nums[mid] >= nums[left] && nums[mid] < nums[right]) {
                if(nums[mid] > target) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] < nums[left]){
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    int t = mid - 1;
                    while(t >= left && nums[t] < nums[mid]) t --;
                    t = binarysearch(nums, left, t, target);
                    if(t != - 1) return t;
                    left = mid + 1;
                }
            }else{ // nums[mid] > nums[left] && > nums[right]
                if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    int t = mid + 1;
                    while(t <= right && nums[t] > nums[mid]) t ++;
                    t = binarysearch(nums, t, right, target);
                    if(t != -1) return t;
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    private int binarysearch(int[] nums, int left, int right, int target){
        if(left > right)  return -1;
        if(left == right){
            if(nums[left] == target) return left;
            else return -1;
        }
        int mid = left + (right - left) / 2;
        if(nums[mid] == target) return mid;
        int p1 = binarysearch(nums, left, mid - 1, target);
        if(p1 != -1) return p1;
        else {
            int p2 = binarysearch(nums, mid + 1, right, target);
            if(p2 != -1) return p2;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] n = {5,6,0,1,2,3,4};
        System.out.println(new Leet33().search(n, 0));
    }
}
