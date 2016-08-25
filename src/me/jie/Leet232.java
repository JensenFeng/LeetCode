package me.jie;

/**
 * Created by jie on 8/25/16.
 */
import java.util.*;
public class Leet232 {


    class MyQueue {
        Stack<Integer> in, out;
        int front;
        MyQueue(){
            in = new Stack<>();
            out = new Stack<>();
            front = 0;
        }
        // Push element x to the back of queue.
        public void push(int x) {
            if(out.isEmpty())
                front = x;
            in.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            if(out.isEmpty()){
                while(!in.isEmpty()) out.push(in.pop());
            }
            out.pop();
        }

        // Get the front element.
        public int peek() {
            if(!out.isEmpty()){
                return out.peek();
            }
            return front;
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
