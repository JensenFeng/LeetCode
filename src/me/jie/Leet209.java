package me.jie;

import java.util.Arrays;

/**
 * Created by jie on 8/21/16.
 */
public class Leet209 {
    /*
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int len = nums.length;
        int ans = Integer.MAX_VALUE ;
        int tmp, pre = 0,  prej = 0;
        for(int i = 0; i < len; i ++){
            tmp = pre;
            int j;
            for(j = prej; j < len; j ++){
                tmp += nums[j];
                if(tmp >= s){
                    break;
                }
            }
            pre = tmp - nums[i] - nums[j];
            prej = j;
            if(j - i + 1 < ans && tmp >= s) {
                ans = j - i + 1;
                //System.out.println(tmp + " " + ans);
            }
            if(j == len) break;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
