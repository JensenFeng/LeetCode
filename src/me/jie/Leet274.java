package me.jie;

import java.util.Arrays;

/**
 * Created by jie on 8/21/16.
 */
public class Leet274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        int len = citations.length;
        for(int i = len - 1; i >= 0; i --) {
            int t = citations[i];
            while (t > len - i){
                if(i > 0 && t <= citations[i - 1]) {
                    break;
                }
                t --;
            }
            if (t <= len - i) {
                ans = t;
                break;
            }
        }
        return ans;
    }
    /*
     more better solution: bucket sort
     https://discuss.leetcode.com/topic/23307/my-o-n-time-solution-use-java
     */
    public int hindex(int[] citations){
        if(citations.length == 0) return 0;
        int len = citations.length;
        int[] arr = new int[len + 1];
        for(int i = 0; i < len; i ++){
            if(citations[i] > len){
                arr[len] += 1;
            }else{
                arr[citations[i]] += 1;
            }
        }
        int ans = 0;
        for(int i = len; i >= 0; i --){
            ans += arr[i];
            if(ans >= i)
                return i; //this is point
        }
        return ans;
    }
}
