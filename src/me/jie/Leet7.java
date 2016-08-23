package me.jie;

/**
 * Created by jie on 8/23/16.
 */
public class Leet7 {
    public int reverse(int x) {
        boolean flag = false;
        if(x < 0) flag = true;
        long xx = Math.abs((long)x);
        char[] str = new char[11];
        int i = 0;
        while(xx != 0){
            str[i ++] = (char)(xx % 10 + '0');
            xx /= 10;
        }
        long ans = 0;
        int j = 0;
        while(j < i && str[j] == 0) j ++;
        while(j < i){
            ans = ans * 10 + str[j ++] - '0';
        }
        if(!flag && ans > Integer.MAX_VALUE || (flag && -ans < Integer.MIN_VALUE)){
            return 0;
        }
        int rst = (int)ans;
        return flag? -rst : rst;
    }
    /*
    better way:
    https://discuss.leetcode.com/topic/6104/my-accepted-15-lines-of-code-for-java
     */
    public static void main(String[] args){
        System.out.println(new Leet7().reverse(-2147483648));
    }
}
