package me.jie;

/**
 * Created by jie on 8/31/16.
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class Leet238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] out = new int[len];
        out[0] = 1;
        for(int i = 1; i < len; i ++){
            out[i] = nums[i-1] * out[i-1];
        }

        int last = 1;
        out[len-1] = out[len-1] * last;
        for(int i = nums.length - 2; i >= 0; i --){
            last = nums[i+1] * last;
            out[i] *= last;
        }

        return out;
    }
    public static void main(String[] args){
        int[] n = {1, 2, 3, 4, 1, 2};
        for(int i : new Leet238().productExceptSelf(n)){
            System.out.println(i);
        }
    }
}
