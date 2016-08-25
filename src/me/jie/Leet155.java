package me.jie;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/min-stack/
 */
import java.util.*;
public class Leet155 {

    public class MinStack {
        Stack<Integer> in, minNum;
        int min;
        /** initialize your data structure here. */
        public MinStack() {
            in = new Stack<>();
            minNum = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            in.push(x);
            if(!minNum.isEmpty()){
                if(x < min) min = x;
            }else min = x;
            minNum.push(min);
        }

        public void pop() {
            in.pop();
            minNum.pop();
            if(!minNum.isEmpty()) min = minNum.peek();
        }

        public int top() {
            return in.peek();
        }

        public int getMin() {
            return minNum.peek();
        }
    }

    public void test(){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(3);
        obj.push(-3);
        System.out.println(obj.getMin());
        System.out.println(obj.top());

        obj.pop();
        System.out.println(obj.getMin());
    }

    public static void main(String[] args){
        new Leet155().test();
    }
}
