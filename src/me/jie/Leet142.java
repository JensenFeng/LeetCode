package me.jie;

/**
 * Created by jie on 8/16/16.
 */
public class Leet142 {
    /*
    https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow != fast) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        int[] n = {1,2,3};
        int[] cycle = {5,6,7};
        ListNode head = new ListNode().create(n);
        ListNode cy = new ListNode().create(cycle);
        ListNode pos = cy;
        while(pos.next != null){
            pos = pos.next;
        }
        pos.next = cy;
        pos = head;
        while(pos.next != null){
            pos = pos.next;
        }
        pos.next = cy;
        head = new Leet142().detectCycle(head);
        //new ListNode().print(head); //cycle
    }
}
