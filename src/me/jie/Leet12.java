package me.jie;

/**
 * Created by jie on 8/27/16.
 */
public class Leet12 {
    public String intToRoman(int num) {
        if(num == 0) return "";
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        if(num >= 1000){
            carry = num / 1000;
            num %= 1000;
            while(carry -- > 0){
                sb.append("M");
            }
        }
        if(num >= 500){
            if(num >= 900){
                num -= 900;
                sb.append("CM");
            }else{
                num -= 500;
                sb.append("D");
            }
        }
        if(num >= 100){
            if(num >= 400){
                num -= 400;
                sb.append("CD");
            }else{
                carry = num / 100;
                num %= 100;
                while(carry -- > 0){
                    sb.append("C");
                }
            }
        }
        if(num >= 50){
            if(num >= 90){
                num -= 90;
                sb.append("XC");
            }else{
                num -= 50;
                sb.append("L");
            }
        }
        if(num >= 10){
            if(num >= 40){
                num -= 40;
                sb.append("XL");
            }else{
                carry = num / 10;
                num %= 10;
                while(carry -- > 0){
                    sb.append("X");
                }
            }
        }
        if(num >= 5){
            if(num == 9){
                num -= 9;
                sb.append("IX");
            }else{
                num -= 5;
                sb.append("V");
            }
        }
        {
            if(num == 4){
                sb.append("IV");
            }else{
                while(num -- > 0){
                    sb.append("I");
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new Leet12().intToRoman(992));
    }
}
