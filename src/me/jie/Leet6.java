package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/zigzag-conversion/
 */
import java.util.*;

public class Leet6 {

    public String convert(String s, int numRows) {
        if(s.length() == 0 || numRows == 1) return s;
        List<List<Character>> rst = new ArrayList<>();
        for(int i = 0; i < numRows; i ++){
            rst.add(new ArrayList<>());
        }

        for(int i = 0; i < s.length();) {

            // step 1:
            int j = 0;
            while (j < numRows && i < s.length()) {
                rst.get(j).add(s.charAt(i ++));
                j++;
            }

            // step 2:
            for (int k = 0; k < numRows - 2; k++) {
                rst.get(numRows - 1).add(' ');
            }
            j = numRows - 2;

            while (j > 0 && i < s.length()) {
                for(int k = 1; k < j-1; k ++){
                    rst.get(j).add(' ');
                }
                rst.get(j).add(s.charAt(i++));
                for(int k = j + 1; k < numRows - 1; k ++) {
                    rst.get(j).add(' ');
                }
                j--;
            }
            for (int k = 0; k < numRows - 2; k++) {
                rst.get(0).add(' ');
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i ++){
            List<Character> lt = rst.get(i);
            for(Character c : lt){
                if(c != ' '){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public String convert2(String s, int numRows){
        if(s.length() == 0 || numRows <= 1)  return s;
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[len] ;
        for(int i = 0; i < len; i ++){
            sb[i] = new StringBuilder();
        }
        for(int i = 0; i < len; ){

            //step1
            for(int idx = 0; idx < numRows && i < len; idx ++){
                sb[idx].append(s.charAt(i ++));
            }


            //step2: no space add
            for(int idx = numRows - 2; idx > 0 && i < len; idx --){
                sb[idx].append(s.charAt(i ++));
            }
        }
        for(int i = 1; i < len; i ++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args){
        System.out.println(new Leet6().convert2("PAHNAPLSIIGYIR", 3));
    }
}
