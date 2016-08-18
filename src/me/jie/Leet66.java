package me.jie;

/**
 * Created by jie on 8/18/16.
 */
import java.util.*;
public class Leet66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0 ; i --){
            carry += digits[i];
            digits[i] = carry % 10;
            carry = carry / 10;
        }
        if(carry > 0) {
            int[] nums = new int[digits.length + 1];
            nums[0] = carry;
            for (int i = 0, j = 1; i < digits.length; i ++) {
                nums[j ++] = digits[i];
            }
            return nums;
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] n = {9,9,9,9,9,9};
        int[] ans = new Leet66().plusOne(n);
        for(Integer i : ans){
            System.out.println(i);
        }
    }
}
