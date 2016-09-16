package me.jie;

import java.util.*;

/**
 * Created by jie on 9/16/16.
 */
public class Leet78 {
    public List<List<Integer>> subsets(int[] nums) {
//        if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        for(int i = 0; i <= nums.length; i ++){
            backtracking(rst, new ArrayList<>(), nums, i, 0, 0);
        }
        return rst;
    }
    private void backtracking(List<List<Integer>> rst, List<Integer> cur,
                              int[] n, int k, int sum, int left){
        if(sum == k){
            rst.add(new ArrayList<>(cur));
            return;
        }
        int len = n.length;
        for(int i = left; i < len; i ++){
            cur.add(n[i]);
            backtracking(rst, cur, n, k, sum + 1, i + 1);
            cur.remove(cur.size()-1);
        }
    }
    //bitmap
}
