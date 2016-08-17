package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode scur = small, bcur = big;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                scur.next = cur;
                scur = scur.next;
            }else{
                bcur.next = cur;
                bcur = bcur.next;
            }
            cur = cur.next;
        }
        bcur.next = null;
        scur.next = big.next;
        return small.next;
    }
    public static void main(String[] args){
        int[] n = {1,3,1,2};
        ListNode head = new ListNode().create(n);
        head = new Leet86().partition(head, 2);
        new ListNode().print(head);
    }
}
