package me.jie;

/**
 * Created by jie on 8/18/16.
 */
public class Leet26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int len = nums.length;
        int cur = 0, pre = 0;
        while(cur < len){
            while(cur < len && nums[pre] == nums[cur]) cur ++;
            if(cur < len){
                nums[++ pre] = nums[cur ++];
            }
        }
        return ++ pre;
    }
    public static void main(String[] args){
        int[] n = {1,2};
        int len = new Leet26().removeDuplicates(n);
        for(int i = 0; i < len; i ++){
            System.out.println(n[i]);
        }
    }
}
