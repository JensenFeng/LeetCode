package me.jie;

/**
 * Created by jie on 8/21/16.
 */
public class Leet136 {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i ++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] n = {1, 2, 1 ,2 ,3};
        System.out.println(new Leet136().singleNumber(n));
    }
}
