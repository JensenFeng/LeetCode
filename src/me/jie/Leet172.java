package me.jie;

/**
 * Created by jie on 8/22/16.
 */
public class Leet172 {
    /*
    TLE
     */
    public int trailingZeroes(int n) {
        if(n < 5) return 0;
        if(n == 5) return 1;
        int ans = 0;
        while(n > 0){
            if(n % 5 == 0) {
                ans ++;
                int cn = n / 5;
                while(cn % 5 == 0){
                    ans ++;
                    cn /= 5;
                }
            }
            n --;
        }
        return ans;
    }
    /*
    https://discuss.leetcode.com/topic/6513/simple-c-c-solution-with-detailed-explaination
     */
    public int trailZero(int n){
        if(n < 5) return 0;
        int ans = 0;
        for(long  i = 5; n / i > 0; i *= 5){
            ans += (n / i);
        }
        return ans;
    }

    public static void main(String[] args){
    }
}
