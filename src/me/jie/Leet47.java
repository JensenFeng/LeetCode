package me.jie;

/**
 * Created by jie on 9/10/16.
 */
import java.util.*;

public class Leet47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        backtracking(nums, rst, mark, new ArrayList<>());
        return rst;
    }
    private void backtracking(int[] nums, List<List<Integer>> rst, boolean[] mark, List<Integer> cur){
        if(cur.size() == nums.length){
            rst.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(i > 0 && nums[i] == nums[i-1] && !mark[i-1]) continue;
            if(!mark[i]) {
                mark[i] = true;
                cur.add(nums[i]);
                backtracking(nums, rst, mark, cur);
                cur.remove(cur.size() - 1);
                mark[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int[] n = {1, 1, 2, 2, 3};
        List<List<Integer>> rst = new Leet47().permuteUnique(n);
        rst.forEach(lt -> System.out.println(lt));
    }
}
