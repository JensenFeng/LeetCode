package me.jie;

/**
 * Created by jie on 8/22/16.
 */
public class Leet263 {
    /*
    https://discuss.leetcode.com/topic/21785/2-4-lines-every-language
     */
    public boolean isUgly(int num){
        if(num <= 0) return false;
        for(int i = 2; i < 6; i ++){
            while(num % i == 0){
                num /= i;
            }
        }
        return num == 1;
    }

    /*
    TLE
     */
    public boolean isUglytle(int num) {
        if(num <= 0) return false;
        if(num <= 3) return true;
        if(num % 2 != 0 && num % 3 != 0 && num % 5 != 0) return false;
        int i;
        for(i = 7 ; i <= num / 2 ; i += 2){
            if(isPrime(i)){
                System.out.println(i);
                if(num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isPrime(int n){
        int sq = (int)Math.sqrt(n);
        if(n % 2 == 0) return false;
        for(int i = 3; i <= sq; i += 2){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(new Leet263().isUgly(937351770));
    }
}
