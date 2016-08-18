package me.jie;

/**
 * Created by jie on 8/18/16.
 */

public class Leet138 {
    class RandomListNode {
             int label;
             RandomListNode next, random;
             RandomListNode(int x) { this.label = x; }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode cur = head, pos = head;
        //copy val
        while(pos != null){
            pos = cur.next;
            RandomListNode tmp = new RandomListNode(cur.label);
            cur.next = tmp;
            tmp.next = pos;
            cur = pos;
        }
        //copy random pointer
        cur = head; pos = head;
        while(pos != null){
            pos = cur.next.next;
            if(cur.random != null) cur.next.random = cur.random.next;
            else cur.next.random = null;
            cur = pos;
        }
        //split copy node
        cur = head; pos = head;
        RandomListNode newhead = cur.next;
        RandomListNode ccur = cur.next;
        while(pos != null){
            pos  = cur.next.next;
            ccur = cur.next;
            cur.next = pos;
            if(pos != null) ccur.next = pos.next;
            else ccur.next = null;
            cur = pos;
        }
        return newhead;
    }
}
