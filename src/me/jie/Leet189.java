package me.jie;

/**
 * Created by jie on 8/18/16.
 */
public class Leet189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length-1);
    }
    private void reverseArray(int[] nums, int left, int right){
        while(left < right){
            nums[left]  = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[right] ^ nums[left];
            left ++;
            right --;
        }
    }
    public static void main(String[] args) {
        int[] n = {1,2,3,4,5,6};
        new Leet189().rotate(n, 2);
        for(Integer i : n){
            System.out.println(i);
        }
    }
}
