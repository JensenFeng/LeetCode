package me.jie;

/**
 * Created by jie on 8/15/16.
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Leet88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        m --; n --;
        while(m >= 0 && n >= 0){
            if(nums1[m] >= nums2[n]){
                nums1[len--] = nums1[m--];
            }else{
                nums1[len--] = nums2[n--];
            }
        }
        while(n >= 0){
            nums1[len --] = nums2[n--];
        }
    }
    public static void main(String[] args){
        int[] n1 = new int[20];
        n1[0] = 1;
//        n1[1] = 2;
//        n1[2] = 3;
//        n1[3] = 5;
        int[] n2 = {2 ,4 ,6};
        new Leet88().merge(n1, 1, n2, 3);
        for(int i = 0; i < 7; i ++){
            System.out.println(n1[i]);
        }
    }
}
