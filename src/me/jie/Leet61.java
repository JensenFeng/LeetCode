package me.jie;

/**
 * Created by jie on 8/18/16.
 */
public class Leet61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode slow = head, fast = head;
        int len = 0, tmp = k;
        while(tmp -- > 0 && fast != null){
            fast = fast.next;
            len ++;
        }
        if(fast == null){
            System.out.println(len);
            return rotateRight(head, k % len);
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newHead;
        newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
    public static void main(String[] args){
        int[] n = {1,2,3,4,5,6};
        ListNode head = new ListNode().create(n);
        head = new Leet61().rotateRight(head, 8);
        new ListNode().print(head);

    }
}
