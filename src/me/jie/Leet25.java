package me.jie;

/**
 * Created by jie on 8/18/16.
 */
public class Leet25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        ListNode fast = head;
        int len = 0;
        while(fast != null){
            fast = fast.next;
            len ++;
        }
        if(k > len) return head;
        if(k == len) return reverse(head);

        ListNode helper = new ListNode(0);
        ListNode hp = helper;
        fast = head;
        ListNode last = head, next;
        int tmp;
        while(fast != null){
            tmp = 1;
            while(tmp ++ < k && fast != null) fast = fast.next;
            if(fast == null) {
                hp.next = last;
                break;
            }
            next = fast.next;

            //init reverse pointer
            fast.next = null;
            hp.next = reverse(last);

            hp = last;
            last = next;
            fast = next;
        }
        return helper.next;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode cur = head, pre = null, pos;
        while(cur != null){
            pos = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pos;
        }
        return pre;
    }
    public static void main(String[] args){
        int[] n = {1,2,3,4,5,6,7};
        ListNode head = new ListNode().create(n);
        head = new Leet25().reverseKGroup(head, 3);
        new ListNode().print(head);
    }
}
