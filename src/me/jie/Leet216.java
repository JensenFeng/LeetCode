package me.jie;

/**
 * Created by jie on 10/2/16.
 * https://leetcode.com/problems/combination-sum-iii/
 */
import java.util.*;
public class Leet216 {
    public static void main(String[] args){
        List<List<Integer>> rst = new Leet216().combinationSum3(3, 20);
        rst.forEach(lt -> System.out.println(lt));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n >= 9 * k || n <= k) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        helper(rst, new ArrayList<>(), k, n, 0, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> cur, int k, int n,
                        int sum, int num){
        if(num > k) return;
        if(num == k && sum == n) {
            rst.add(new ArrayList<>(cur));
            return ;
        }
        int p = cur.size() > 0 ? cur.get(cur.size()-1) : 0;
        for(int i = p + 1; i <= 9; i ++){
            if(sum + i > n) return;
            cur.add(i);
            helper(rst, cur, k, n, sum + i, num + 1);
            cur.remove(cur.size()-1);
        }
    }
}
