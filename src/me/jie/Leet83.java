package me.jie;

/**
 * Created by jie on 8/16/16.
 */
public class Leet83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        int tmp ;
        ListNode next;
        while (cur != null){
            tmp = cur.val;
            next = cur;
            while(next.next != null && next.next.val == tmp) next = next.next;
            cur.next = next.next;
            cur = cur.next;
        }
        return head;
    }
    public ListNode deleDup(ListNode head){
        if(head == null || head.next == null) return head;
        head.next = deleDup(head.next);
        return head.val != head.next.val? head : head.next;

    }
    public static void main(String[] args){
        int[] nums = {1, 1, 2, 3, 3, 5, 5};
        ListNode head = new ListNode().create(nums);
        head = new Leet83().deleDup(head);
        new ListNode().print(head);
    }
}
