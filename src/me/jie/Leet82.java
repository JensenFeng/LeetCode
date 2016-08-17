package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode cur = helper,  pos = head.next;
        while(pos != null){
            boolean flag = false;
            while(pos != null && cur.next.val == pos.val  ) {
                flag = true;
                pos = pos.next;
            }
            if(flag) {
                cur.next = pos;
            }else{
                cur = cur.next;
            }
            if(pos != null) pos = pos.next;
        }
        return helper.next;
    }

    public static void main(String[] args){
        int[] n = {1,1,1,2,3,3,4,4,5};
        ListNode head = new ListNode().create(n);
        head = new Leet82().deleteDuplicates(head);
        new ListNode().print(head);
    }
}
