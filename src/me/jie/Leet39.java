package me.jie;

/**
 * Created by jie on 8/21/16.
 */
import java.util.*;
public class Leet39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> rst = new ArrayList<>();
        backtracking(candidates, target, rst, new ArrayList<>(), 0, 0);
        return rst;
    }
    private void backtracking(int[] cand, int target, List<List<Integer>> rst, List<Integer> lt, int sum, int pos){
        if(sum == target){
            rst.add(new ArrayList(lt));
            return;
        }
        for(int i = pos; i < cand.length; i ++){
            if(sum + cand[i] <= target) {
                lt.add(cand[i]);
                backtracking(cand, target, rst, lt, sum + cand[i], i);
                lt.remove(lt.size() - 1);
            }else break;
        }
    }
}
