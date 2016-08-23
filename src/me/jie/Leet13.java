package me.jie;

/**
 * Created by jie on 8/22/16.
 */
public class Leet13 {
    public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        char[] str = s.toCharArray();
        int[] index = new int[26];
        //init
        index['I' - 'A'] = 1;index['V' - 'A'] = 5;
        index['X' - 'A'] = 10;index['L' - 'A'] = 50;
        index['C' - 'A'] = 100;index['D' - 'A'] = 500;
        index['M' - 'A'] = 1000;
        int ans = 0;
        for(int i = 0; i < s.length(); i ++){
            char e = str[i];
            if(i + 1 < s.length() && index[str[i+1]-'A'] > index[e-'A']){
                ans += index[str[i+1]-'A'] - index[e-'A'];
                i ++;
            }else{
                ans += index[e-'A'];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(new Leet13().romanToInt("IV"));
    }
}
