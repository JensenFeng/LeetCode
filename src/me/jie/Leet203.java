package me.jie;

/**
 * Created by jie on 8/16/16.
 */
public class Leet203 {
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null) return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode cur = helper;
        while( cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return helper.next;
    }
    public ListNode removeElements(ListNode head, int val){
        if(head == null) return null;
        if(head.val == val) return removeElements(head.next, val);
        head.next = removeElements(head.next, val);
        return head;
    }
    public static void main(String[] args){
        int[] nums = {2,2, 1, 2, 3, 4, 5};
        ListNode head = new ListNode().create(nums);
        head = new Leet203().removeElements(head, 2);
        new ListNode().print(head);
    }
}
