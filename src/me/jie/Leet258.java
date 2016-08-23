package me.jie;

/**
 * Created by jie on 8/22/16.
 */
public class Leet258 {
    public int addDigits(int num) {
        if(num <= 0) return 0;
        if(num < 10) return num;
        int ans = 0;
        while(num != 0){
            ans += num % 10;
            num /= 10;
        }
        return addDigits(ans);
    }
    /*
    math:
    https://discuss.leetcode.com/topic/41017/simple-java-solution-no-recursion-loop
     */
    public int addDig(int num){
        if(num <= 0) return 0;
        if(num % 9 == 0) return 9;
        return num % 9;
    }
}
