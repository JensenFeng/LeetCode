package me.jie;

/**
 * Created by jie on 8/16/16.
 */
public class Leet160 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        int lena = 0, lenb = 0;
        while(pa != null){ lena ++; pa = pa.next; }
        while(pb != null){ lenb ++; pb = pb.next; }
        int t = lena - lenb;
        pa = headA;pb = headB;
        if(t > 0){
            while(t -- > 0) pa = pa.next;
        }else{
            while(t ++ < 0) pb = pb.next;
        }
        while(pa != null && pb != null){
            if(pa == pb) return pa;
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }

    /*
    two pointer
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        int count = 0;
        boolean flag = false;
        while(count < 2){
            while(pa != null && pb != null){
                if(pa == pb) return pa;
                pa = pa.next;
                pb = pb.next;
            }
            if(pa == null) {
                pa = headB;
                if(!flag) flag = true;
                else count ++;
            }
            if(pb == null) {
                pb = headA;
                if(!flag) flag = true;
                else count ++;
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] n1 = {1};
        int[] n2 = {2, 3, 4, 5};
        int[] n3 = {9};
        ListNode ha = new ListNode().create(n1);
        ListNode hb = new ListNode().create(n2);
        ListNode nc = new ListNode().create(n3);
        ListNode pa = ha, pb = hb;
        while(pa.next != null) pa = pa.next;
        while(pb.next != null) pb = pb.next;
        pa.next = nc;
        pb.next = nc;
        ListNode head = new Leet160().getIntersectionNode(ha, hb);
        new ListNode().print(head);
    }
}
