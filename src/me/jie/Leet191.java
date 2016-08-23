package me.jie;

/**
 * Created by jie on 8/23/16.
 */
public class Leet191 {
    public int hammingWeight(int n) {
        int i = 0;
        int count = 0;
        while(i < 32){
            int t = n >> i;
            if((t & 1) == 1) count ++;
            i ++;
        }
        return count;
    }
    /*
    more better: just count 1-bits
    https://leetcode.com/articles/number-1-bits/
     */

    public static void main(String[] args){
        System.out.println(new Leet191().hammingWeight(0));
    }
}
