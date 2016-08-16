package me.jie;

/**
 * Created by jie on 8/16/16.
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class Leet237 {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
