package me.jie;

/**
 * Created by jie on 9/10/16.
 */
import java.util.*;

public class Leet40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> rst = new ArrayList<>();
        getCombination(rst, candidates, new ArrayList<>(), 0, target, 0);

        return rst;
    }
    private void getCombination(List<List<Integer>> rst, int[] candidates,
                                List<Integer> cur, int sum, int target, int begin){
        if(sum == target){
            rst.add(new ArrayList<>(cur));
            return;
        }
        for(int i = begin; i < candidates.length; i ++){
            if(sum + candidates[i] <= target){
                cur.add(candidates[i]);
                getCombination(rst, candidates, cur, sum + candidates[i], target, i + 1);
                cur.remove(cur.size()-1);
            }else{
                break;
            }
            while(i < candidates.length - 1 && candidates[i] == candidates[i+1]) i ++;
        }
    }
    public static void main(String[] args){
        int[] n = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> rst = new Leet40().combinationSum2(n, 8);
        rst.forEach(lt -> System.out.println(lt));
    }
}
