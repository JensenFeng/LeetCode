package me.jie;

/**
 * Created by jie on 8/19/16.
 */
public class Leet204 {
    public int countPrimes(int n) {
        boolean[] mark = new boolean[n];
        for(int i =  2; i < n; i ++) {
            mark[i] = true;
        }
        for(int i = 2; i * i < n; i ++){
            if(!mark[i]) continue;
            for(int j = i * i; j < n; j += i){
                mark[j] = false;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i ++){
            if(mark[i]) count ++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(new Leet204().countPrimes(93735));
    }

}
