package me.jie;

/**
 * Created by jie on 8/24/16.
 */
public class Leet303 {
    public class NumArray {
        int[] dp;
        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            sum(nums, nums.length);
        }

        private void sum(int[] nums, int len){
            for(int i = 0; i < len; i ++){
                dp[i + 1] = dp[i] + nums[i];
            }
        }
        public int sumRange(int i, int j) {
            if(i > j) return dp[i + 1] - dp[j];
            else return dp[j + 1] - dp[i];
        }
    }
    public void test(){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2) + " " +
        numArray.sumRange(1, 5));
    }
    public static void main(String[] args) {
        new Leet303().test();
    }

}
