package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
import java.util.*;

public class Leet201 {
    /*
    TLE
     */
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0 || n == 0) return 0;

        for(int i = m; i <= n; i ++){
            m &= i;
        }
        return m;
    }
    /*
        still TLE
     */
    public int rangeBitwiseAndBitmap(int m, int n){
        if(m == 0 || n == 0) return 0;

        if(m == n) return m;
        int[] bit = new int[33];

        int b = 1;
        int len = 1;
        //init
        for(int i = 1; i < 32; i ++){
            bit[i] = (b & n) >> (i - 1);
            b <<= 1;
            len ++;
            if(b > n) { break;}
        }
        b = 1;
        for(int i = 1; i < len; i ++) {
            if(bit[i] == 1) {
                for (int t = n - 1; t >= m; t --) {
                    bit[i] = (b & t) >> (i - 1);
                    if(bit[i] == 0) break;
                }
            }
            b <<= 1;
        }

        int ans = 0;
        for(int i = 32; i > 0; i --){
            if(bit[i] == 1) {
                ans |= (1 << (i - 1));
            }
        }
        return ans;
    }
    /*
    better idea
    https://discuss.leetcode.com/topic/12133/bit-operation-solution-java
     */
    public int rangeBitwiseAB(int m, int n){
        if(m == 0) return 0;
        int factor = 1;
        while(n > m){
            m >>= 1;
            n >>= 1;
            factor <<= 1;
        }
        return m * factor;
    }
    public static void main(String[] args){
        long t = System.currentTimeMillis();
        System.out.println(new Leet201().rangeBitwiseAB(600000000, 2147483645) +
        " " + (System.currentTimeMillis() - t));
    }
}
