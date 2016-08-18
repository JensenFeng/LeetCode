package me.jie;

/**
 * Created by jie on 8/18/16.
 */
import java.util.*;
public class Leet217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i ++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] n = {1,1,1,2};
        System.out.println(new Leet217().containsDuplicate(n));
    }
}
