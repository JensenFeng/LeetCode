package me.jie;

/**
 * Created by jie on 8/31/16.
 */
public class Leet53 {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int pre = 0, cur = 0;
        for(int i = 0;i < nums.length; i ++){
            cur = Math.max(pre + nums[i], nums[i]);
            sum = Math.max(sum, cur);
            pre = cur;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] n = {-2,-1,3,4,-1,1, 2};
        System.out.println(new Leet53().maxSubArray(n));
    }
}
