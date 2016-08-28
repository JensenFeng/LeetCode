package me.jie;

import java.util.Arrays;

/**
 * Created by jie on 8/28/16.
 * https://leetcode.com/problems/next-permutation/
 */
public class Leet31 {
    /*
    https://discuss.leetcode.com/topic/15216/
    a-simple-algorithm-from-wikipedia-with-c-implementation-can-be-used-in-permutations-and-permutations-ii
     */
    /*
    https://leetcode.com/articles/next-permutation/
     */
    public void nextPermutation(int[] nums) {
        int k = -1;
        for(int i = nums.length-2; i >= 0; i --){
            if(nums[i] < nums[i+1]){
                k = i;
                break;
            }
        }
        if(k == -1){
            Arrays.sort(nums);
            return;
        }
        int l = -1;
        for(int i = nums.length-1; i > k; i --){
            if(nums[i] > nums[k]){
                l = i;
                break;
            }
        }
        int tmp = nums[k];
        nums[k] = nums[l];
        nums[l] = tmp;
        Arrays.sort(nums, k + 1, nums.length);
    }
    public static void main(String[] args){
        int[] n = {5,4,7,5,3,2};
        new Leet31().nextPermutation(n);
        for(Integer i: n)
            System.out.println(i);
    }
}
