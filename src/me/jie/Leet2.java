package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int add = 0, t ;
        ListNode p1 = l1, p2 = l2;
        while(p1.next != null && p2.next != null){
            t = p1.val + p2.val + add;
            p1.val = t % 10;
            add = t / 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        t = p1.val + p2.val + add;
        p1.val = t % 10 ;
        add = t / 10;

        if(p2.next != null) {
            p1.next = p2.next;
        }
        if(p1.next != null) {
            while (p1.next != null && add != 0) {
                t = p1.next.val + add;
                p1.next.val = t % 10;
                add = t / 10;
                p1 = p1.next;
            }
        }
        if (add != 0) {
            ListNode tmp = new ListNode(add);
            p1.next = tmp;
            tmp.next = null;
        }

        return l1;
    }
    public static void main(String[] args){
        int[] n1 = {9,9,9};
        int[] n2 = {1,9,9};
        ListNode l1 = new ListNode().create(n1);
        ListNode l2 = new ListNode().create(n2);
        l1 = new Leet2().addTwoNumbers(l1, l2);
        new ListNode().print(l1);

    }
}
