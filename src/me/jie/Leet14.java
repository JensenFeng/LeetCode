package me.jie;

/**
 * Created by jie on 8/24/16.
 */
public class Leet14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int len = strs.length;
        int pos = 0;
        while(pos < strs[0].length()){
            for(int i = 1; i < len; i ++){
                if(pos == strs[i].length() || strs[0].charAt(pos) != strs[i].charAt(pos))
                    return strs[0].substring(0, pos);
            }
            pos ++;
        }
        return strs[0];
    }
    /*
    binary search:https://leetcode.com/articles/longest-common-prefix/
     */
    public String longestCommonPrefixBS(String[] strs){
        if(strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        //find shortest string
        for(String str : strs){
            minLen = Math.min(minLen, str.length());
        }

        int left = 1, right = minLen;
        while(left <= right){
            int mid = (left + right) / 2;
            if(allCommonPrefix(strs, mid)){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return strs[0].substring(0, (left+right)/2);
    }
    private boolean allCommonPrefix(String[] strs, int len){
        String s = strs[0].substring(0, len);
        for(int i = 1; i < strs.length; i ++){
            if(!strs[i].startsWith(s)) return false;
        }
        return true;
    }
}
