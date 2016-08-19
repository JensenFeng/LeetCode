package me.jie;

/**
 * Created by jie on 8/19/16.
 */
import java.util.*;
public class Leet118 {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> lt = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 1) {
            lt.add(1);
            ans.add(lt);
        }else if(numRows == 2){
            ans.addAll(generate(numRows-1));
            lt.add(1);
            lt.add(1);
            ans.add(lt);
        }else if(numRows > 2){
            List<List<Integer>> tmp = generate(numRows-1);
            ans.addAll(tmp);
            List<Integer> tlt = tmp.get(tmp.size()-1);
            lt.add(1);
            for(int i = 0; i < tlt.size()-1; i ++){
                lt.add(tlt.get(i) + tlt.get(i+1));
            }
            lt.add(1);
            ans.add(lt);
        }
        return ans;
    }
    public static void main(String[] args){
        List<List<Integer>> rst = new Leet118().generate(15);
        for(List<Integer> lt : rst){
            System.out.println(lt);
        }
    }
}
