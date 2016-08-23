package me.jie;

/**
 * Created by jie on 8/22/16.
 */
import java.util.*;

public class Leet326 {
    /*
    https://leetcode.com/articles/power-of-three/
     */
    int[] nums = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441,
            1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    private List<Integer> getThree(){
        List<Integer> lt = new ArrayList<>();
        int large = (int)(Math.pow(2, 31) - 1);
        int i = 0;
        while (true){
            double t = Math.pow(3, i ++);
            if(t <= large){
                lt.add((int)t);
            }else{
                break;
            }
        }
        return lt;
    }
    public static void main(String[] args){
        System.out.println(new Leet326().isPowerOfThree(27));
    }
}
