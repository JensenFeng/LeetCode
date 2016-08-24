package me.jie;

/**
 * Created by jie on 8/24/16.
 */
public class Leet38 {
    public String countAndSay(int n) {
        if(n == 0) return "";
        // f(n) = g(f(n-1))
        String pre = "1";
        for(int i = 2; i <= n; i ++){
            pre = getSay(pre);
        }
        return pre;
    }
    private String getSay(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char[] ss = s.toCharArray();
        for(int i = 1; i < s.length(); i ++){
            if(ss[i] == ss[i - 1]) count ++;
            else{
                sb.append(count);
                sb.append(ss[i-1]);
                count = 1;
            }
        }
        if(count != 0){
            sb.append(count);
            sb.append(ss[s.length()-1]);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Leet38().countAndSay(5));
    }
}
