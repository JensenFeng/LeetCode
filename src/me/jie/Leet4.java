package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class Leet4 {

/*
  time complexity should be O(log(m + n))

 */
 class Solution {
    /*
    https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        int mini = 0, maxi = m, halfLen = (m + n + 1) / 2;
        int i , j;
        double ans = 0;
        while(mini <= maxi){
            i = (mini + maxi) / 2;
            j = halfLen - i;
            if(i > 0 && j < n && nums1[i-1] > nums2[j]){
                maxi = i - 1;
            }else if(i < m && j > 0 && nums1[i] < nums2[j-1]){
                mini = i + 1;
            }else{
//            if(i == 0 || j == n || nums1[i-1] <= nums2[j] &&
//                    j == 0 || i == m || nums1[i] >= nums2[j-1]){
                //perfect i
                int maxofLeft, minofRight;
                if(i == 0) maxofLeft = nums2[j-1];
                else if(j == 0) maxofLeft = nums1[i-1];
                else maxofLeft = Math.max(nums1[i-1], nums2[j-1]);

                if((m + n) % 2 == 1){
                    ans = maxofLeft * 1.0;
                    return ans;
                }
                if(i == m) minofRight = nums2[j];
                else if(j == n) minofRight = nums1[i];
                else minofRight = Math.min(nums1[i], nums2[j]);
                ans = (maxofLeft * 1.0 + minofRight * 1.0) / 2;

                break;
            }
        }
        return ans;
    }
}

}