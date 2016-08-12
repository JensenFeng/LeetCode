package me.jie;

/**
 * Created by jie on 8/10/16.
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
import java.util.*;

public class Leet166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        String s = ftd((Math.abs((long)numerator)), Math.abs((long)denominator));
        if(numerator < 0 && denominator > 0 || (numerator > 0 && denominator < 0)){
            return "-" + s;
        }else if(numerator < 0 && denominator < 0){
            return s;
        }
        return s;
    }

    private String ftd(long numerator, long denominator){
        List<Long> mark = new ArrayList<>();
        boolean flag = true;
        if(numerator < denominator){
            flag = false;
            numerator *= 10;
        }
        while(true){
            if(mark.contains(numerator)){
                break;
            }
            mark.add(numerator);
            boolean exist = false;
            while(numerator < denominator){
                numerator *= 10;
                if(!mark.contains(numerator)){
                    mark.add(numerator);
                }else{
                    exist = true;
                    break;
                }
            }
            if(exist) break;
            numerator %= denominator;
            numerator *= 10;
            if(numerator == 0){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        if(!flag) {
            sb.append(0);
            sb.append(".");
        }else{
            begin ++;
            sb.append(mark.get(0) / denominator);
            if(mark.size() > 1) sb.append(".");
        }

        if(numerator == 0){
            for(int i = begin; i < mark.size(); i ++){
                sb.append(mark.get(i) / denominator);
            }
        }else{
            int pos = mark.indexOf(numerator);
            if(pos >= 0) {
                for (int i = begin; i < pos; i++) {
                    sb.append(mark.get(i) / denominator);
                }
                sb.append("(");
                for (int i = pos; i < mark.size(); i++) {
                    sb.append(mark.get(i) / denominator);
                }
                sb.append(")");
            }
        }

        return sb.toString();
    }

    /*
       Better idea
       https://discuss.leetcode.com/topic/7876/my-clean-java-solution
     */

    public String fractionDecimal(int num, int den){
        if(den == 0) return "";
        if(num == 0) return "0";
        StringBuilder rst = new StringBuilder();
        Map<Long, Integer> mp = new HashMap<>();
        if((num > 0) ^ (den > 0)){
            rst.append("-");
        }
        long n = Math.abs((long)num);
        long d = Math.abs((long)den);

        rst.append(n / d);
        n %= d;
        if(n == 0)
            return rst.toString();
        rst.append(".");
        mp.put(n, rst.length());
        while(n != 0){
            n *= 10;
            rst.append(n / d);
            n %= d;
            if (mp.containsKey(n)) {
                int pos = mp.get(n);
                rst.insert(pos, "(");
                rst.append(")");
                break;
            }else{
                mp.put(n, rst.length());
            }
        }
        return rst.toString();
    }
    public static void main(String[] args){
        System.out.println(new Leet166().fractionDecimal(1, -2147483648));
    }
}
