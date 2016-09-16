package me.jie;

/**
 * Created by jie on 9/13/16.
 */
public class Leet55 {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int len = nums.length;
        int i = 0, pos = 0;
        while(i <= pos){
            pos = Math.max(pos, i + nums[i]);
            if(pos >= len-1) return true;
            i ++;
        }
        return pos >= len-1;
    }
    public static void main(String[] args){
        int[] n = {1, 2, 0, 0, 3, 5, 0};
        System.out.println(new Leet55().canJump(n));
    }
}
