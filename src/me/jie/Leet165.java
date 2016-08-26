package me.jie;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class Leet165 {
    public int compareVersion(String version1, String version2) {
        //if(version1.equals(version2)) return 0;

        int[] nums1 = new int[200];
        int[] nums2 = new int[200];
        int t1 = 0, t2 = 0;
        for(int i = 0; i < version1.length(); i ++){
            char e = version1.charAt(i);
            if(e != '.'){
                nums1[t1] = nums1[t1] * 10 + e - '0';
            }else{
                t1 ++;
            }
        }
        for(int i = 0; i < version2.length(); i ++){
            char e = version2.charAt(i);
            if(e != '.'){
                nums2[t2] = nums2[t2] * 10 + e - '0';
            }else{
                t2 ++;
            }
        }
        while(t1 < t2) {
            nums1[++t1] = 0;
        }
        while(t1 > t2){
            nums2[++t2] = 0;
        }
        int i;
        for(i = 0; i <= t1 && i <= t2; i ++){
            if(nums1[i] < nums2[i]) return -1;
            else if(nums1[i] > nums2[i]) return 1;
        }
        if(i <= t1) return 1;
        if(i <= t2) return -1;
        return 0;
    }
    public static void main(String[] args){
        String s1 = "1";
        String s2 = "0";
        System.out.println(new Leet165().compareVersion(s1, s2));
    }
}
