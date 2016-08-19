package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet283 {
    public void moveZeroes(int[] nums) {
        int cur = 0, pos = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != 0) {
                if (cur != i ) {
                    nums[cur++] = nums[i];
                } else cur++;
            }
        }
        while(cur < nums.length) nums[cur ++] = 0;
    }
    public static void main(String[] args){
        int[] n = {1, 2, 0, 3, 0, 4, 0, 5, 0, 0};
        new Leet283().moveZeroes(n);
        for(Integer i : n){
            System.out.println(i);
        }
    }
}
