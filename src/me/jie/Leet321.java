package me.jie;

/**
 * Created by jie on 10/11/16.
 * https://leetcode.com/problems/create-maximum-number/
 */
public class Leet321 {

    public int[] maxNumberdp(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 + len2 < k) return new int[0];
        //if(len1 == 0) return maxNumber(nums2, nums1, k);
        String[][][] dp = new String[k+1][len1 + 1][len2 + 1];
        for(int n = 0; n <= k; n ++){
            for(int i = 0; i <= len1; i ++){
                for(int j = 0; j <= len2; j ++){
                    dp[n][i][j] = "";
                }
            }
        }

        for(int n = 1; n <= k; n ++){
            for(int i = 1; i <= len1; i ++){
                String tmp = dp[n-1][i-1][0] + "" + nums1[i-1];
                dp[n][i][0] = compare(dp[n][i][0], compare(dp[n][i-1][0], tmp));
            }
        }
        for(int n = 1; n <= k; n ++){
            for(int i = 1; i <= len2; i ++){
                String tmp = dp[n-1][0][i-1] + "" + nums2[i-1];
                dp[n][0][i] = compare(dp[n][0][i], compare(dp[n][0][i-1], tmp));
            }
        }
        for(int n = 1; n <= k; n ++){
            for(int i = 1; i <= len1; i ++){
                for(int j = 1; j <= len2; j ++){
                    //short length
                    String tmp = compare(dp[n-1][i-1][j] + "" + nums1[i-1], dp[n-1][i][j-1] + "" + nums2[j-1]);
                    if(n > 1){
                        tmp = compare(tmp, dp[n-2][i-1][j-1] + "" + Math.max(nums1[i-1], nums2[j-1]) + "" + Math.min(nums1[i-1], nums2[j-1]));
                    }
                    //same length
                    String smlen = compare(dp[n][i-1][j-1] , compare(dp[n][i][j-1], dp[n][i-1][j]));
                    String max = compare(tmp, smlen);
                    dp[n][i][j] = compare(dp[n][i][j], max);
                }
            }
        }
        String ans = "";
        for(int i = 0; i <= len1; i ++){
            for(int j = 0; j <= len2; j ++){
                ans = compare(ans, dp[k][i][j]);
            }
        }
        System.out.println(ans);
        int[] res = new int[k];
        for(int i = 0; i < k; i ++){
            res[i] = ans.charAt(i) - '0';
        }
        return res;
    }
    private String compare(String n1, String n2){
        return n1.compareTo(n2) > 0 ? n1 : n2;
    }

    /*
    https://discuss.leetcode.com/topic/32272/share-my-greedy-solution
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k){
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[k];
        for(int i = Math.max(0, k - m); i <= k && i <= n; i ++){
            int[] tmp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if(greater(tmp, ans, 0, 0)) ans = tmp;
        }
        return ans;
    }
    private int[] merge(int[] nums1, int[] nums2, int k){
        int[] ans = new int[k];
        for(int i = 0, j = 0, len = 0; len < k; len ++){
            if(greater(nums1, nums2, i, j)){
                ans[len] = nums1[i ++];
            }else{
                ans[len] = nums2[j ++];
            }
        }
        return ans;
    }
    private boolean greater(int[] nums1, int[] nums2, int i, int j){
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i ++;
            j ++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    private int[] maxArray(int[] nums, int k){
        int[] ans = new int[k];
        int len = nums.length;
        for(int i = 0, j = 0; i < len; i ++){
            while(len - i > k - j && j > 0 && ans[j-1] < nums[i]) j --;
            if(j < k) ans[j ++] = nums[i];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums1 = {8,5,9,5,1,6,9};
        int[] nums2 = {2,6,4,3,8,4,1,0,7,2,9,2,8};
        int[] res = new Leet321().maxNumber(nums1, nums2, 2);
        for(Integer i : res){
            System.out.print(i);
        }
    }
}
