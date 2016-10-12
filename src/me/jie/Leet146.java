package me.jie;

/**
 * Created by jie on 9/23/16.
 * https://leetcode.com/problems/lru-cache/
 */
import java.util.*;
public class Leet146 {
    public class LRUCache {
        class Node{
            int key,value;
            Node next, pre;
            Node(int key, int value){
                this.key   = key;
                this.value = value;
                next = null;
                pre = null;
            }
        }
        private Map<Integer, Node> mp;
        private int size, pos;
        private Node head, tail;
        public LRUCache(int capacity) {
            mp = new HashMap<>();
            size = capacity;
            pos = 0;
            head = null;
            tail = null;
        }

        public int get(int key) {
            if(mp.containsKey(key)) {
                Node cur = mp.get(key);
                insertTail(cur);
                return cur.value;
            }
            return -1;
        }

        public void set(int key, int value) {
            Node node;
            if(mp.containsKey(key)) {
                node = mp.get(key);
                node.value = value;
                insertTail(node);
            }else{
                node = new Node(key, value);
                mp.put(key, node);
                if (pos < size){
                    pos ++;
                    if(tail != null) {
                        tail.next = node;
                        node.pre = tail;
                    }
                    tail = node;
                }else{
                    deleteHead();
                    tail.next = node;
                    node.pre = tail;
                    tail = node;
                }
            }
            if(head == null) head = node;
        }
        private void deleteHead(){
            Node tmp = head;
            if(head != null) {
                head = head.next;
                if (head != null) head.pre = null;
                tmp.next = null;
                Node t = mp.remove(tmp.key);
            }
        }
        private void insertTail(Node cur){
            if(cur != tail){
                Node pre = cur.pre, next = cur.next;
                if(pre != null) pre.next = next;
                else {
                    head = next;
//                    if(next.next == null) next.next = cur;
                }
                if(next != null) next.pre = pre;
                tail.next = cur;
                cur.pre = tail;
                cur.next = null;
                tail = cur;
            }
        }
    }

    public void test(){
        LRUCache lc = new LRUCache(2);
//        System.out.println(lc.get(0));
//        lc.set(2, 1);
        lc.set(1, 1);
        lc.set(2, 2);
//        System.out.println(lc.get(2));
//        lc.set(1, 1);
        lc.set(3, 3);
        lc.set(4, 4);
        //lc.set(5, 5);
        System.out.println(lc.get(4));
        System.out.println(lc.get(3));
        System.out.println(lc.get(2));
        System.out.println(lc.get(1));
        lc.set(5, 5);
        System.out.println(lc.get(1));
        System.out.println(lc.get(2));
        System.out.println(lc.get(3));
        System.out.println(lc.get(4));
        System.out.println(lc.get(5));
    }
    public static void main(String[] args){
        new Leet146().test();
    }
}
