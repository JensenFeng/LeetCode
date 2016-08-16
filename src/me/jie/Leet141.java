package me.jie;

/**
 * Created by jie on 8/16/16.
 */
public class Leet141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            if(fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
