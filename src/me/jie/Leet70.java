package me.jie;

/**
 * Created by jie on 8/24/16.
 */
public class Leet70 {
    public int climbStairs(int n) {
        //f(n) = f(n-1) + f(n-2)
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int priv = 1, cur = 2;
        for(int i = 3; i <= n; i ++){
            int tmp = priv + cur;
            priv = cur;
            cur = tmp;
        }
        return cur;
    }
}
