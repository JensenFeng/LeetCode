package me.jie;

/**
 * Created by jie on 9/16/16.
 */
import java.util.*;

public class Leet90 {
    /*
    https://discuss.leetcode.com/topic/22638/very-simple-and-fast-java-solution
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        backtracking(rst, new ArrayList<>(), nums, 0);
        return rst;
    }
    private void backtracking(List<List<Integer>> rst, List<Integer> cur, int[] nums,
                              int pos){
        if(pos <= nums.length){
            rst.add(new ArrayList<>(cur));
        }
        for(int i = pos; i < nums.length; i ++){
            if(i > pos && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            backtracking(rst, cur, nums, i + 1);
            cur.remove(cur.size()-1);
        }
    }
    public static void main(String[] args){
        int[] n = {1, 2, 2, 3};
        List<List<Integer>> rst = new Leet90().subsetsWithDup(n);
        rst.forEach(lt -> System.out.println(lt));
    }
}
