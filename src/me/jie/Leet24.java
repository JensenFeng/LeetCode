package me.jie;

/**
 * Created by jie on 8/16/16.
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Leet24 {
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = null;
        ListNode cur = helper, pos = head;
        while(pos != null) {
            ListNode tmp = pos.next;

            if(tmp != null) {
                cur.next = tmp;
                pos.next = tmp.next;
                tmp.next = pos;
            }
            cur = pos;
            pos = pos.next;
        }
        return helper.next;
    }
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode cur = head.next;
        head.next = cur.next;
        cur.next = head;
        head.next = swapPairs(head.next);
        return cur;
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode().create(nums);
        head = new Leet24().swapPairs(head);
        new ListNode().print(head);
    }
}
