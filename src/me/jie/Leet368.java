package me.jie;

/**
 * Created by jie on 8/23/16.
 */
import java.util.*;

public class Leet368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
            if(nums.length == 0) return new ArrayList<>();
            List[] dp = new ArrayList[nums.length];
            Arrays.sort(nums);

            List<Integer> lt ;
            int ans = 0;
            int ansLen = 0;
            for(int i = 0; i < nums.length; i ++){
                List<Integer> rst = new ArrayList<>();
                int maxLen = 0;
                for(int j = 0; j < i; j ++){
                    lt = dp[j];
                    if(nums[i] % nums[j] == 0){
                        int k = lt.size();
                        if(k > maxLen) {
                            maxLen = k;
                            rst.clear();
                            rst.addAll(dp[j]);
                        }
                    }
                }
                rst.add(nums[i]);
                if(ansLen < maxLen){
                    ansLen = maxLen;
                    ans = i;
                }
                dp[i] = new ArrayList<>(rst);
            }
            return dp[ans];
        }

    /*
    https://discuss.leetcode.com/topic/49741/easy-understood-java-dp-solution-in-28ms-with-o-n-2-time
     */
    public List<Integer> largestDivSubset(int[] nums){
        if(nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i ++){
            for(int j = i - 1; j >= 0; j --){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i ++){
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }
        List<Integer> rst = new ArrayList<>();

        rst.add(nums[maxIndex]);
        for(int i = maxIndex - 1; i >= 0; i --){
            if(nums[maxIndex] % nums[i] == 0 && dp[maxIndex] == dp[i] + 1){
                maxIndex = i;
                rst.add(nums[maxIndex]);
            }
        }
        return rst;
    }

}
