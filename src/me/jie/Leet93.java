package me.jie;

/**
 * Created by jie on 8/26/16.
 */
import java.util.*;

public class Leet93 {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) return new ArrayList<>();
        List<String> rst = new ArrayList<>();
        int len = s.length();
        for(int i = 0; i < 3 && i < len - 3; i ++){
            String s1 = s.substring(0, i + 1);
            if(isBeyond(s1)) continue;

            for(int j = i + 1; j < i + 4 && j < len - 2; j ++){
                String s2 = s.substring(i + 1, j + 1);
                if(isBeyond(s2)) continue;

                for(int k = j + 1; k < j + 4 && k < len - 1; k ++){
                    String s3 = s.substring(j + 1, k + 1);
                    if(isBeyond(s3)) continue;

                    if(len - k - 1 <= 0 || len - k > 4) continue;
                    String s4 = s.substring(k + 1, len);
                    if(isBeyond(s4)) continue;
                    rst.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return rst;
    }
    private boolean isBeyond(String s){
        if((s.length() > 1 && s.startsWith("0")) || Integer.parseInt(s) > 255) return false;
        return true;
    }
}
