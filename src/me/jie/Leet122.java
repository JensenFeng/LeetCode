package me.jie;

/**
 * Created by jie on 7/25/16.
 */
public class Leet122 {
    //good
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int sum = 0;
        int lowBuy = 0;
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] < prices[i-1]){
                sum += prices[i-1] - prices[lowBuy];
                lowBuy = i;
            }
        }
        sum += prices[prices.length-1] - prices[lowBuy];
        return sum;
    }

    public int maxProfit2(int[] prices){
        int ans = 0;
        for(int i = 0; i < prices.length - 1; i ++){
            if(prices[i] < prices[i+1]){
                ans += prices[i + 1] - prices[i];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] prices = {3, 1, 2, 5, 0, 9, 8, 6};
        System.out.println(new Leet122().maxProfit2(prices));
    }
}
