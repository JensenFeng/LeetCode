package me.jie;

/**
 * Created by jie on 8/19/16.
 */
import java.util.*;

public class Leet119 {
    public List<Integer> getRowR(int rowIndex) {
        if(rowIndex == 0) {
            List<Integer> rst = new ArrayList<>();
            rst.add(1);
            return  rst;
        }
        List<Integer> rst = getRow(rowIndex-1);
        rst.add(0, 1);
        if(rowIndex >= 2){
            for(int i = 0; i  < rowIndex - 1; i ++){
                int t = rst.get(i+1) + rst.get(i+2);
                rst.remove(i+1);
                rst.add(i+1, t);
            }
        }
        return rst;
    }
    //iterative
    public List<Integer> getRow(int rowIndex){
        List<Integer> rst = new ArrayList<>();
        rst.add(1);
        if(rowIndex == 0) return rst;
        for(int i = 1; i <= rowIndex; i ++){
            rst.add(0, 1);
            for(int j = 0; j < rst.size() - 2; j ++){
                int t = rst.get(j + 1) + rst.get(j + 2);
                rst.remove(j + 1);
                rst.add(j + 1, t);
            }
        }
        return rst;
    }
    public static void main(String[] args){
        System.out.println(new Leet119().getRow(3));
    }
}
