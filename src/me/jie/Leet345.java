package me.jie;

/**
 * Created by jie on 8/14/16.
 */
public class Leet345 {
    public String reverseVowels(String s) {
        int i = 0, j = s.length()-1;
        char[] str = s.toCharArray();
        char e;
        while(i < j){
            while(!vowel(str[i]) && i < j) i ++;
            while(!vowel(str[j]) && i < j) j --;
            e = str[i];
            str[i] = str[j];
            str[j] = e;
            i ++;
            j --;
        }
        return new String(str);
    }
    private boolean vowel(char e){
        boolean flag = false;
        switch (e){
            case 'a': {flag = true; break;}
            case 'e': {flag = true; break;}
            case 'i': {flag = true; break;}
            case 'o': {flag = true; break;}
            case 'u': {flag = true; break;}
            case 'A': {flag = true; break;}
            case 'E': {flag = true; break;}
            case 'I': {flag = true; break;}
            case 'O': {flag = true; break;}
            case 'U': {flag = true; break;}
        }
        return flag;
    }
    public static void main(String[] args){
        System.out.println(new Leet345().reverseVowels("leetcode"));
    }
}

