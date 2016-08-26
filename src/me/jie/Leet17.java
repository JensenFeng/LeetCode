package me.jie;

/**
 * Created by jie on 8/26/16.
 */
import java.util.*;

public class Leet17 {
    private final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        int len = digits.length();
        List<String> rst = new ArrayList<>();
        getDigits(digits, 0, rst, new StringBuilder());
        return rst;
    }
    private void getDigits(String digits, int cur, List<String> rst, StringBuilder sb){
        if(cur > digits.length()) return;
        if(cur == digits.length()){
            rst.add(sb.toString());
            return;
        }
        int e = digits.charAt(cur) - '0';
        String s = map[e];
        for(int i = 0; i < s.length(); i ++){
            sb.append(s.charAt(i));
            getDigits(digits, cur + 1, rst, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args){
        System.out.println(new Leet17().letterCombinations("233"));
    }
}
