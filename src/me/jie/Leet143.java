package me.jie;

/**
 * Created by jie on 8/16/16.
 */
public class Leet143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)return;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        //reverse the part of fast
        ListNode head2 = null;
        ListNode cur ;
        while(fast != null){
            cur = fast.next;
            fast.next = head2;
            head2 = fast;
            fast = cur;
        }
        fast = head2;
        slow = head;
        ListNode pos;
        while(slow != null && fast != null){
            pos = slow.next;
            cur = fast.next;
            slow.next = fast;
            fast.next = pos;
            slow = pos;
            fast = cur;
        }
    }
    public static void main(String[] args){
        int[] n = {1,2,3,4,5};
        ListNode head = new ListNode().create(n);
        new Leet143().reorderList(head);
        new ListNode().print(head);
    }
}
