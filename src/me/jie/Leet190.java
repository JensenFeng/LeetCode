package me.jie;

/**
 * Created by jie on 8/24/16.
 */
public class Leet190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        long bit = 1;
        long ans = 0;
        for(int i = 0; i < 32; i ++){
            ans = (ans << 1) + ((int)(n & bit) == 0 ? 0 : 1);
            bit <<= 1;
        }
        return (int)ans;
    }

    public static void main(String[] args){
        System.out.println(new Leet190().reverseBits(1));
    }
}
