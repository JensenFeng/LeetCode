package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet171 {
    public int titleToNumber(String s) {
        if(s.length() == 0) return 0;
        int len = s.length();
        int ans = 0;
        for(int i = 0; i < len; i ++){
            ans = ans * 26 + (s.charAt(i) - 'A' + 1);
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(new Leet171().titleToNumber("AZ"));
    }
}
