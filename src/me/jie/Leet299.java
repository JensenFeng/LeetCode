package me.jie;

/**
 * Created by jie on 8/20/16.
 */
public class Leet299 {
    public String getHint(String secret, String guess) {
        if(secret.length() == 0) return "";
        int len = secret.length();
        int[] hash = new int[10];
        int bull = 0, cows = 0;
        for(int i = 0; i < len; i ++){
            if(secret.charAt(i) == guess.charAt(i)) bull ++;
            else{
                hash[secret.charAt(i) - '0'] ++;
            }
        }
        for(int i = 0; i < len ; i ++){
            if(secret.charAt(i) != guess.charAt(i)){
                int e = guess.charAt(i) - '0';
                if(hash[e] > 0){
                    cows ++;
                    hash[e] --;
                }
            }
        }
        return bull + "A" + cows + "B";
    }
}
