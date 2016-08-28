package me.jie;

/**
 * Created by jie on 8/28/16.
 */
public class Leet29 {
    /*
    https://discuss.leetcode.com/topic/15568/detailed-explained-8ms-c-solution
     */
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if(dividend < 0 ^ divisor < 0) sign = -1;
        long dvd = Math.abs((long)dividend);
        long dvr = Math.abs((long)divisor);
        if(dvd < dvr) return 0;
        int rst = 0;
        while(dvr <= dvd){
            long tmp = dvr, mul = 1;
            while(dvd > (tmp << 1)){
                tmp <<= 1;
                mul <<= 1;
            }
            dvd -= tmp;
            rst += mul;
        }
        return sign == -1 ? -rst : rst;
    }
    public static void main(String[] args){
        long t1 = System.currentTimeMillis();
        System.out.println(new Leet29().divide(155, 3)
            + "  " + (System.currentTimeMillis() - t1)
        );
    }
}
