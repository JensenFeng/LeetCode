package me.jie;

/**
 * Created by jie on 8/14/16.
 */
public class Leet344 {
    public String reverseString(String s){
        int i = 0, j = s.length()-1;
        char[] ans = s.toCharArray();
        char e;
        while(i < j){
            e = ans[i];
            ans[i] = ans[j];
            ans[j] = e;
            i ++;
            j --;
        }
        return new String(ans);
    }
    public static void main(String[] args){
        System.out.println(new Leet344().reverseString("hello"));
    }
}
