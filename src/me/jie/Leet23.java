package me.jie;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jie on 8/15/16.
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Leet23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int len = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        ListNode p1 = (ListNode)o1;
                        ListNode p2 = (ListNode)o2;
                        return p1.val <= p2.val? -1 : 1;
                    }
                }
        );
        ListNode helper = new ListNode(0);
        helper.next = null;
        ListNode pos = helper;
        ListNode p;
        for(int i = 0; i < len; i ++){
            p = lists[i];
            if(p != null) {
                pq.offer(p);
            }
        }
        while(!pq.isEmpty()){
            pos.next = pq.peek();
            ListNode top = pq.poll();
            if(top.next != null){
                pq.offer(top.next);
            }
            pos = pos.next;
        }
        return helper.next;
    }

    public static void main(String[] args){
        int[] n1 = {1, 2, 3, 5, 7, 9};
        int[] n2 = {2, 4, 6, 8, 10};
        int[] n3 = {3, 5, 6, 7, 11};
        ListNode p1 = new ListNode().create(n1);
        ListNode p2 = new ListNode().create(n2);
        ListNode p3 = new ListNode().create(n3);
        ListNode[] lists = {p1, p2, p3};
        ListNode head = new Leet23().mergeKLists(lists);
        new ListNode().print(head);
    }
}
