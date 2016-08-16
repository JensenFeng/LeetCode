package me.jie;

/**
 * Created by jie on 8/16/16.
 */
public class Leet147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode curr = helper;
        ListNode pos = head;
        ListNode min, minpre, p, pre;
        while(pos.next != null){
            min = pos; minpre = pos;
            p = pos.next;
            pre = pos;
            while(p != null){
                if(p.val < min.val){
                    min = p;
                    minpre = pre;
                }
                pre = p;
                p = p.next;
            }
            if(min != minpre){
                minpre.next = min.next;
                min.next = pos;
            }else{
                pos = pos.next;
            }
            curr.next = min;
            curr = curr.next;
            //pos = curr;
        }
        return helper.next;
    }
    public ListNode insertSortList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = null;
        ListNode pre = helper;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }
    public static void main(String[] args){
        int[] nums = {1,0};
        ListNode head = new ListNode().create(nums);
        head = new Leet147().insertSortList(head);
        new ListNode().print(head);
    }
}
