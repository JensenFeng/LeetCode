package me.jie;

/**
 * Created by jie on 9/16/16.
 */
import java.util.*;

public class Leet77 {
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        backtracking(rst, new ArrayList<>(), n, k, 0, 1);
        return rst;
    }
    private void backtracking(List<List<Integer>> rst, List<Integer> cur,
                              int n, int k, int sum, int left){
        if(sum == k){
            rst.add(new ArrayList<>(cur));
            return;
        }
        for(int i = left; i <= n; i ++){
            cur.add(i);
            backtracking(rst, cur, n, k, sum + 1, i + 1);
            cur.remove(cur.size()-1);
        }
    }
}
