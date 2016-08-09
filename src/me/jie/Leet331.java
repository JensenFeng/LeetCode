package me.jie;

import java.util.Stack;

/**
 * Created by jie on 8/8/16.
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class Leet331 {
    /**
     * use stack, but no idea
     * someone nice solution
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0) return true;
        String[] str = preorder.split(",");
        Stack<String> stk = new Stack<>();
        for(int i = 0; i < str.length; i ++){
            String curr = str[i];

            while(curr.equals("#") && !stk.empty() && stk.peek().equals("#")){
                // consecutive  #
                stk.pop();
                if(stk.empty()){
                    return false;
                }
                stk.pop();
            }
            stk.push(curr);
        }
        return stk.size() == 1 && stk.peek().equals("#");
    }
    /*
        https://discuss.leetcode.com/topic/35976/7-lines-easy-java-solution/6
     */
    public boolean isValidSer(String preorder){
        if(preorder.length() == 0) return true;
        String[] str = preorder.split(",");
        int nonleaf = 0, leaf = 0;
        int i;
        for(i = 0; i < str.length && nonleaf + 1 != leaf; i ++){
            if(str[i].equals("#")) leaf ++;
            else nonleaf ++;
        }
        return nonleaf + 1 == leaf && i == str.length;
    }
}
