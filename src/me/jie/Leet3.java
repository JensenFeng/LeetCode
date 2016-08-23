package me.jie;

/**
 * Created by jie on 8/22/16.
 */
public class Leet3 {
    //O(n^2)
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int[] hash = new int[128];
        int ans = 0;
        int pos = 0;
        while(pos < s.length()) {
            for (int j = 0; j < 128; j++) {
                hash[j] = 0;
            }
            int i;
            for (i = pos; i < s.length(); i ++) {
                if (hash[s.charAt(i)] != 0) {
                    break;
                }
                hash[s.charAt(i)] = 1;
            }
            if(ans < i - pos) ans = i - pos;
            pos ++;
        }
        return ans;
    }
    /*
    https://leetcode.com/articles/longest-substring-without-repeating-characters/
    better: hashtable save the position
     */
    public int lengthOfLongestSubString(String s){
        if(s.length() == 0) return 0;
        int[] pos = new int[128]; //save each char position
        int ans = 0;
        for(int i = 0, j = 0; i < s.length(); i ++){
            j = Math.max(pos[s.charAt(i)], j);
            ans = Math.max(ans, i - j + 1);
            pos[s.charAt(i)] = i + 1; //update new pos
        }
        return ans;
    }
}
