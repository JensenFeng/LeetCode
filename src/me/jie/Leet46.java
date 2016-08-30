package me.jie;

/**
 * Created by jie on 8/29/16.
 * https://leetcode.com/problems/permutations/
 */
import java.util.*;

public class Leet46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if(nums.length == 0) return rst;
        boolean[] mark = new boolean[nums.length];
        helper(nums, mark, rst, new ArrayList<>());
        return rst;
    }
    private void helper(int[] nums, boolean[] mark, List<List<Integer>> rst, List<Integer> cur){
        if(cur.size() == nums.length){
            rst.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(!mark[i]){
                mark[i] = true;
                cur.add(nums[i]);
                helper(nums, mark, rst, cur);
                cur.remove(cur.size()-1);
                mark[i] = false;
            }
        }
    }
}
