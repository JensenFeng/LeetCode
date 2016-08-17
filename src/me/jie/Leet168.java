package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet168 {
    public String convertToTitle(int n) {
        if(n == 0) return "";
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append((char)((n-1) % 26 + 'A'));
            n = (n-1) / 26;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        System.out.println(new Leet168().convertToTitle(52));
    }
}
