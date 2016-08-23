package me.jie;

/**
 * Created by jie on 8/23/16.
 */
public class Leet357 {
    /*
    TLE
     */
    public int countNumbersWithUniqueDigitsTLE(int n) {
        if(n == 0) return 1;
        int maxNum = (int)Math.pow(10, n);
        int cur = 0;
        int ans = 0;
        while(cur < maxNum){
            if(isValid(cur)) {
                ans++;
            }cur++;
        }
        return ans;
    }
    private boolean isValid(int num){
        boolean[] bits = new boolean[10];
        while(num != 0){
            int t = num % 10;
            if(bits[t]) return false;
            bits[t] = true;
            num /= 10;
        }
        return true;
    }
    /*
     Math: f(k) = 9 * 9 * 8 * - * (10 - (k - 1))
     */
    public int countNumbersWithUniqueDigits(int n){
        if(n == 0) return 1;
        if(n == 1) return 10;
        int ans = 9;
        for(int i = 9; i >= 11 - n;  i --){
            ans *= i;
        }
        return ans + countNumbersWithUniqueDigits(n - 1);
    }
    public static void main(String[] args){
        System.out.println(new Leet357().countNumbersWithUniqueDigits(3));
    }
}
