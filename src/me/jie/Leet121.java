package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int maxprofit  = 0;
        int buy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i ++){
            if(buy > prices[i]){
                buy = prices[i];
            }else if(prices[i] - buy > maxprofit){
                maxprofit = prices[i] - buy;
            }

        }
        return maxprofit;
    }
    public static void main(String[] args){
        int[] n = {1, 2, 1, 9, 8, 3};
        System.out.println(new Leet121().maxProfit(n));
    }
}
