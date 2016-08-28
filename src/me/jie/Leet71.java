package me.jie;

/**
 * Created by jie on 8/27/16.
 */
import java.util.*;
public class Leet71 {
    public String simplifyPath(String path) {
        if(path.length() == 0) return "";
        String[] stk = new String[path.length()];
        int begin = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = path.length();
        while(i < len){
            while(i < len && path.charAt(i) == '/') i ++;

            sb = new StringBuilder();
            while(i < len && path.charAt(i) != '/'){
                sb.append(path.charAt(i ++));
            }
            String s = sb.toString();

            if(s.equals(".")) continue;
            if(s.equals("..")){
                if(end > begin) end --;
            }
            else {
                if (sb.length() > 0) {
                    stk[end++] = sb.toString();
                }
            }
        }
        sb.delete(0, sb.length());
        sb.append("/");
        while(begin < end){
            sb.append(stk[begin ++]);
            sb.append("/");
        }
        if(sb.length() > 1) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Leet71().simplifyPath("/../foo.."));
    }
}
