package me.jie;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/first-bad-version/
 */
public class Leet278 {
    boolean isBadVersion(int version){
        return version >= 1702766719;
    }
    public int firstBadVersion(int n) {
        long lo = 1, hi = n;
        while(lo < hi){
            long mid = (lo + hi) / 2;

            if(isBadVersion((int)mid)){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return (int)lo;
    }
    public void test(){
        /*
        2126753390 versions
        1702766719 is the first bad version.
         */
        System.out.println(firstBadVersion(2126753390));
    }
    public static void main(String[] args){
        new Leet278().test();
    }
}
