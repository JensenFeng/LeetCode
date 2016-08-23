package me.jie;

/**
 * Created by jie on 8/23/16.
 */
public class Leet67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len1 = a.length(), len2 = b.length();
        int i;
        int e1, e2;
        for(i = 0; i < len1 || i < len2; i ++){
            e1 = i < len1 ? a.charAt(len1 - 1 - i) - '0' : 0;
            e2 = i < len2 ? b.charAt(len2 - 1 - i) - '0' : 0;
            int t = e1 + e2 + carry;
            sb.append(t % 2);
            carry = t / 2;
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();

    }

}
