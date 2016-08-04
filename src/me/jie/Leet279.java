package me.jie;

/**
 * Created by jie on 7/29/16.
 */
import java.util.*;

public class Leet279 {
    private List<Integer> nums;
    private long[] dp;
    //not good
    public int numSquares(int n){
        dp = new long[n + 1];
        getSquaresNum(n);
        for(int i = nums.size() - 1; i >= 0; i --){
            if(nums.get(i) <= n){
                int tmp = nums.get(i);
                if (dp[n - tmp] == Integer.MAX_VALUE) {
                    squares(0, n - tmp, dp[n - tmp]);
                }
                dp[n] = Math.min(dp[n], dp[tmp] + dp[n - tmp]);
            }
        }
        return (int)dp[n];
    }
    private void squares(int count, int leftNum, long totalCount){
        if(leftNum == 0) {
            if(totalCount > count){
                totalCount = count;
            }
            return;
        }
        if(dp[leftNum] != Integer.MAX_VALUE) return;

        int i;
        for(i = nums.size() - 1; i >= 0; i --){
            if(nums.get(i) <= leftNum){
                int tmp = nums.get(i);
                if (dp[leftNum - tmp] == Integer.MAX_VALUE) {
                    squares(0, leftNum - tmp, dp[leftNum - tmp]);
                }
                dp[leftNum] = Math.min(dp[leftNum], dp[tmp] + dp[leftNum - tmp]);
            }
        }
    }
    private void getSquaresNum(int n) {
        nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                nums.add(i * i);
            } else {
                break;
            }
        }
        dp[0] = 0;
        for(int i = 1; i < n + 1; i ++){
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.size(); i++) {
            dp[nums.get(i)] = 1;
//            System.out.println(nums.get(i)); //test
        }
    }

    public int numSquaresDP(int n){
        List<Integer> squares = new ArrayList<>();
        squares.add(0);
        while(squares.size() <= n){
            int m = squares.size();
            int maxNum = Integer.MAX_VALUE;
            for(int i = 1; i * i <= m; i ++){
                maxNum = Math.min(maxNum, squares.get(m - i * i) + 1);
            }
            squares.add(maxNum);
        }
        return squares.get(squares.size()-1);
    }

    public static void main(String[] args){
        System.out.println(new Leet279().numSquares(12));
    }
}