package me.jie;

/**
 * Created by jie on 8/27/16.
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
import java.util.*;
public class Leet151 {
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        List<String> words = new ArrayList<>();
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < len){
            sb = new StringBuilder();
            while(i < len && s.charAt(i) == ' ') i ++;

            while(i < len && s.charAt(i) != ' '){
                sb.append(s.charAt(i ++));
            }
            if(sb.length() > 0) words.add(sb.toString());
        }
        sb = new StringBuilder();
        i = words.size()-1;
        while(i >= 0){
            sb.append(words.get(i));
            sb.append(" ");
            i --;
        }
        if(sb.length() > 0)  sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Leet151().reverseWords(" 123 rty "));
    }
}
