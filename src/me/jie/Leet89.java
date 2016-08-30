package me.jie;

/**
 * Created by jie on 8/29/16.
 * https://leetcode.com/problems/gray-code/
 */
import java.util.*;
public class Leet89 {
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<>();
        if(n == 0){
            rst.add(0);
            return rst;
        }
        if(n == 1){
            rst.add(0);
            rst.add(1);
            return rst;
        }
        rst = grayCode(n-1);
        int len = rst.size();
        for(int i = len - 1; i >= 0;  i --){
            rst.add(rst.get(i) | (1 << (n-1)));
        }
        return rst;
    }
}
