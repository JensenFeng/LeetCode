package me.jie;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class Leet225 {
    /*
    https://leetcode.com/articles/implement-stack-using-queues/
     */

    private class MyStack {
        Queue<Integer> in, out;
        int head;
        MyStack(){
            in = new ArrayDeque<>();
//            out = new ArrayDeque<>();
//            head = 0;
        }
        // Push element x onto stack.
        public void push(int x) {
            in.offer(x);

            int size = in.size();
            while(size-- > 1){
                in.offer(in.poll());
            }
        }
        // Removes the element on top of the stack.
        public void pop() {
//            if(!in.isEmpty()) {
//                while (in.size() > 1) {
//                    out.offer(in.poll());
//                }
//                in.poll();
//                Queue<Integer> tmp = in;
//                in = out;
//                out = tmp;
//            }
            in.remove();
        }
        // Get the top element.
        public int top() {
//            while(in.size() > 1){
//                out.offer(in.poll());
//            }
            head = in.peek();
            return head;
        }
        // Return whether the stack is empty.
        public boolean empty() {
            return in.isEmpty();
        }
    }
    public void test(){
        MyStack sk = new MyStack();
        sk.push(1);
        sk.push(2);
        sk.push(3);
        sk.push(5);
        sk.push(6);

        if(!sk.empty()) sk.pop();
        System.out.println(sk.top());

        if(!sk.empty()) sk.pop();
        sk.push(4);
        System.out.println(sk.top());
        sk.pop();
        System.out.println(sk.top());
    }
    public static void main(String[] args){
        new Leet225().test();
    }
}
