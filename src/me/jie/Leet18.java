package me.jie;

/**
 * Created by jie on 8/31/16.
 */
import java.util.*;

public class Leet18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] * 4 > target || nums[nums.length-1] * 4 < target) return rst;

        for(int i = 0; i < nums.length - 3; i ++){
            int sum = target - nums[i];
            for(int j = i + 1; j < nums.length - 2; j ++){
                if(nums[j] * 3 > sum) break;
                int sm = sum - nums[j];
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    if(nums[left] + nums[right] == sm){
                        rst.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left ++;
                        left ++;
                        while(right > left && nums[right] == nums[right - 1]) right --;
                        right --;
                    }else if(nums[left] + nums[right] > sm){
                        right --;
                    }else left ++;
                }
                while(j < nums.length - 2 && nums[j] == nums[j + 1]) j ++;
            }
            while(i < nums.length - 3 && nums[i] == nums[i+1]) i ++;
        }
        return rst;
    }
    public static void main(String[] args){
        int[] n = {1,0,-1,0,-2,2, 3, 0, -2};
        List<List<Integer>> rst = new Leet18().fourSum(n, 0);
        rst.forEach(lt -> System.out.println(lt));
    }
}
