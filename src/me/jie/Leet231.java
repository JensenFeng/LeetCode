package me.jie;

/**
 * Created by jie on 8/22/16.
 */
public class Leet231 {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n % 2 != 0) return false;
        int ans = 0;
        int len = 1;
        int t;
        while(ans < n && len <= 31){
            ans = 1 << len;
            t = ans & n;
            if(ans < n && t != 0) return false;
            len ++;
        }
        ans = ans & n;
        return ans != 0;
    }
    public boolean isPowerOfTwo2(int n){
        if(n == 1) return true;
        if(n % 2 != 0) return false;
        int count = 0;
        int num = n;
        for(int i = 0; i < 31; i ++){
            int t = n & (1 << i);
            if(t != 0) count ++;
            if(count > 1) return false;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(new Leet231().isPowerOfTwo2(100));
    }
}
