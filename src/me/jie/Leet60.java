package me.jie;

/**
 * Created by jie on 9/10/16.
 */
import java.util.*;
public class Leet60 {
    /*
     TLE
     */
    public String getPermutation(int n, int k) {
        if(k == 0 || k > totalNum(n)) return "";
        int i, sum = 1;
        for(i = 2; i <= n; i ++){
            if(k > sum){
                sum *= i;
            }else break;
        }
        if(k <= sum) i --;
        StringBuilder sb = new StringBuilder();
        for(int j = 1; j <= n - i; j ++){
            sb.append(j);
        }
        List<List<Integer>> rst = new ArrayList<>();
        boolean[] mark = new boolean[n+1];
        getPerm(i, n - i + 1, n, rst, new ArrayList<>(), mark);
        for(Integer l : rst.get(k-1))
            sb.append(l);
        return sb.toString();
    }
    private void getPerm(int n, int begin, int end, List<List<Integer>> rst, List<Integer> cur, boolean[] mark){
        if(cur.size() == n){
            rst.add(new ArrayList<>(cur));
            return;
        }
        for(int i = begin; i <= end; i ++){
            if(!mark[i]){
                mark[i] = true;
                cur.add(i);
                getPerm(n, begin, end, rst, cur, mark);
                cur.remove(cur.size()-1);
                mark[i] = false;
            }
        }
    }
    private int totalNum(int n){
        if(n == 0) return 1;
        int tmp = n;
        while(-- n > 0){
            tmp *= n;
        }
        return tmp;
    }

    /*
    https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n
     */

    public String getPermutationIter(int n, int k){
        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i ++){
            factorial[i] = factorial[i-1] * i;
            nums.add(i);
        }
        k --;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i ++){
            int index = k / factorial[n-i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[n-i];
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Leet60().getPermutationIter(9, 94626));
    }
}
