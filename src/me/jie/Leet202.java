package me.jie;

/**
 * Created by jie on 8/20/16.
 */
public class Leet202 {
    public boolean isHappy(int n) {
        if(n == 1 || n == 7) return true;
        if(n < 10) return false;
        int ans = 0, t;
        while(n != 0){
            t = n % 10;
            ans += t * t;
            n /= 10;
        }
        return isHappy(ans);
    }
}
