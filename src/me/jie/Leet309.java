package me.jie;

/**
 * Created by jie on 8/29/16.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Leet309 {
    /*
    https://discuss.leetcode.com/topic/30421/share-my-thinking-process
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;

//        int[] buy = new int[prices.length+1];
//        int[] sell = new int[prices.length+1];
//        buy[1] = -prices[0];
//        sell[1] = 0;
//
//        for(int i = 2; i <= prices.length; i ++){
//            buy[i] = Math.max(sell[i-2] - prices[i-1], buy[i-1]);
//            sell[i] = Math.max(buy[i-1] + prices[i-1], sell[i-1]);
//        }
//        return sell[prices.length];
        int buy = 0, sell = 0, presell = 0;
        buy = -prices[0];
        for(int i = 2; i <= prices.length; i ++){
            int prebuy = buy;
            buy = Math.max(presell - prices[i-1], buy);
            presell = sell;
            sell = Math.max(prebuy  + prices[i-1], sell);
        }
        return sell;
    }
    public static void main(String[] args){
        int[] n = {2, 5, 0, 4, 3, 5, 6};
        System.out.println(new Leet309().maxProfit(n));
    }
}
