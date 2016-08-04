package me.jie;

/**
 * Created by jie on 7/30/16.
 */
import java.util.*;

public class Leet120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int len = triangle.size();// + 1;
        int[][] dp = new int[len+1][len+1];
        for(int i = 0; i < len; i ++){
            for(int j = 0; j < len; j ++)
                dp[i][j] = Integer.MAX_VALUE - 100;
        }
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 0; i < triangle.size()-1; i ++){
            for(int j = 0; j < triangle.get(i).size(); j ++){
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + triangle.get(i+1).get(j));
                dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + triangle.get(i+1).get(j+1));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < len; i ++){
            ans = Math.min(ans, dp[len-1][i]);
        }
        return ans;
    }
    //better space, but not timespace
    public int minTotal(List<List<Integer>> triangle){
        if(triangle == null) return 0;
        List<List<Integer>> rst = new ArrayList<>();
        rst.add(new ArrayList<>(triangle.get(0)));
        for(int i = 0; i < triangle.size() - 1; i ++){
            List<Integer> lt = new ArrayList<>();
            for(int j = 0; j < triangle.get(i+1).size(); j ++){
                lt.add(Integer.MAX_VALUE - 100);
            }
            for(int j = 0; j < triangle.get(i).size(); j ++){
                int t1 = lt.get(j);
                int t2 = lt.get(j+1);
                lt.remove(j);
                lt.remove(j+1 - 1);
                lt.add(j,   Math.min(t1, rst.get(i).get(j) + triangle.get(i+1).get(j)));
                lt.add(j+1, Math.min(t2, rst.get(i).get(j) + triangle.get(i+1).get(j+1)));
            }
            rst.add(lt);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < rst.get(rst.size()-1).size(); i ++){
            ans = Math.min(ans, rst.get(rst.size()-1).get(i));
        }
        return ans;
    }
    //more better: O(n)
    public int miniTotal(List<List<Integer>> triangle){
        if(triangle == null) return 0;
        int len = triangle.get(triangle.size()-1).size();
        int[] pre = new int[len];
        int[] curr = new int[len];
        for(int i = 0; i < triangle.get(triangle.size()-1).size(); i ++){
            pre[i] = Integer.MAX_VALUE - 100;
            curr[i] = Integer.MAX_VALUE - 100;
        }
        pre[0] = triangle.get(0).get(0);
        for(int i = 0; i < triangle.size() - 1; i ++){
            for(int j = 0; j < triangle.get(i).size(); j ++){
                curr[j] = Math.min(curr[j], triangle.get(i+1).get(j) + pre[j]);
                curr[j+1] = Math.min(curr[j+1], triangle.get(i+1).get(j+1) + pre[j]);
            }
            for(int j = 0; j < len; j ++){
                pre[j] = curr[j];
                curr[j] = Integer.MAX_VALUE - 100;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < len; i ++){
            ans = Math.min(ans, pre[i]);
        }
        return ans;
    }
    ///excellent
    public int minimTotal(List<List<Integer>> triangle){
        if(triangle == null) return 0;
        int len = triangle.get(triangle.size()-1).size();
        int[] dp = new int[len];
        for(int i = 0; i < triangle.get(triangle.size()-1).size(); i ++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i = triangle.size()-2; i >= 0; i --){
            for(int j = 0; j <= i; j ++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
    public static void main(String[] args){
        List<List<Integer>> lt = new ArrayList<>();
        lt.add(Arrays.asList(2));
        lt.add(Arrays.asList(3,4));
        lt.add(Arrays.asList(6,5,9));
        lt.add(Arrays.asList(4,4,8,0));
        System.out.println(new Leet120().minimTotal(lt));
    }
}
