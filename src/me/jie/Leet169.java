package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet169 {
    public int majorityElement1(int[] nums) {
        if(nums.length <= 2) return nums[0];
        int len = nums.length - 1;
        boolean mark[] = new boolean[len + 1];
        int i = 0, j = len;
        while(i < j){
            if(mark[i]) {i ++; continue;}
            if(mark[j]) {j --; continue;}
            if(nums[i] != nums[j]){
                mark[i] = mark[j] = true;
            }else{
                for(int k = i + 1; k < j; k ++){
                    if(nums[k] != nums[i] && !mark[k]){
                        mark[k] = true;
                        mark[i] = true;
                        break;
                    }
                }

                for(int k = j - 1; k > i; k --){
                    if(nums[j] != nums[k] && !mark[k]){
                        mark[k] = true;
                        mark[j] = true;
                        break;
                    }
                }
            }
            i ++; j --;
        }
        for(i = 0; i <= len; i ++){
            if(!mark[i]) break;
        }
        return nums[i];
    }

    /*
    https://discuss.leetcode.com/topic/8692/o-n-time-o-1-space-fastest-solution
     */
    public int majorityElement(int[] nums){
        int major = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i ++){
            if(count == 0){
                major = nums[i];
                count ++;
            }else if(nums[i] == major){
                count ++;
            }else{
                count --;
            }
        }
        return major;
    }
    public static void main(String[] args){
        int[] n = {2,2,1,1,1,2,2};
        System.out.println(new Leet169().majorityElement(n));
    }
}
