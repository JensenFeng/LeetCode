package me.jie;

/**
 * Created by jie on 8/24/16.
 */
import java.util.*;
public class Leet20 {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            char e = s.charAt(i);
            switch(e){
                case '{' : stk.push(e);break;
                case '(' : stk.push(e);break;
                case '[' : stk.push(e);break;
                case '}' :{
                    if(stk.isEmpty() || (!stk.isEmpty() && stk.pop() != '{')) return false;
                    break;
                }
                case ')' :{
                    if(stk.isEmpty() || (!stk.isEmpty() && stk.pop()!= '(')) return false;
                    break;
                }
                case ']' :{
                    if(stk.isEmpty() || (!stk.isEmpty() && stk.pop() != '[')) return false;
                    break;
                }
            }
        }
        return stk.isEmpty();
    }
}
