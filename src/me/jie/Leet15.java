package me.jie;

/**
 * Created by jie on 8/21/16.
 */
import java.util.*;
public class Leet15 {
    /*
    https://discuss.leetcode.com/topic/8107/share-my-ac-c-solution-around-50ms-o-n-n-with-explanation-and-comments
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3 ) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length-1] < 0) return new ArrayList<>();
        if(nums[0] == 0 && nums[nums.length - 1] == 0) {
            rst.add(Arrays.asList(0 ,0, 0));
            return rst;
        }
        for(int i = 0; i < nums.length - 2; i ++) {

            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum < target){
                    left ++;
                }else if(sum > target){
                    right --;
                }else{
                    rst.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;
                    while(left < right && nums[left] == nums[left - 1]) left ++;
                    while(right > left && nums[right] == nums[right + 1]) right --;
                }
            }
            while(i < nums.length - 2 && nums[i] == nums[i + 1]) i ++;
        }

        return new ArrayList<>(rst);
    }
    public static void main(String[] args){
        int[] n = {0,-4,-5,3,1,3,4,2,-5,2,4,2,-5};
        System.out.println(new Leet15().threeSum(n));
    }
}
