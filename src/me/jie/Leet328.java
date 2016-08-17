package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode even = new ListNode(0);
        even.next = head.next;

        ListNode p1 = head, p2 = even.next;
        while(p2 != null && p2.next != null){
            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }
        //merge
        p1.next = even.next;
        return head;
    }
    public static void main(String[] args){
        int[] n = {1,2,3,4,5};
        ListNode head = new ListNode().create(n);
        head = new Leet328().oddEvenList(head);
        head.print(head);
    }
}
