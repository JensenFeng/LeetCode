package me.jie;

/**
 * Created by jie on 10/11/16.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Leet123 {
    public static void main(String[] args){
        int[] n = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(new Leet123().maxProfit(n));
    }
    /*
    https://discuss.leetcode.com/topic/39751/my-explanation-for-o-n-solution
     */
    public int maxProfit(int[] prices){
        if(prices.length <= 1) return 0;
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for(Integer i : prices){
            buy1 = Math.max(buy1, -i);
            sell1 = Math.max(sell1, buy1 + i);
            buy2 = Math.max(buy2, sell1 - i);
            sell2 = Math.max(sell2, buy2 + i);
        }
        return sell2;
    }
    /*
    TLE */
    public int maxProfitTLE(int[] prices) {
        if(prices.length <= 1) return 0;
        int len = prices.length;
        int ans = 0;
        for(int i = 1; i < len; i ++){
            int left = getMax(prices, 0, i + 1);
            int right = getMax(prices, i + 1, len);
            ans = Math.max(ans, left + right);
        }
        return ans;
    }
    private int getMax(int[] prices, int begin, int end){
        if(end - begin < 1) return 0;
        int max = 0;
        int buy = prices[begin];
        for(int i = begin + 1; i < end; i ++){
            if(prices[i] < buy){
                buy = prices[i];
            }else{
                max = Math.max(max, prices[i] - buy);
            }
        }
        return max;
    }
}
