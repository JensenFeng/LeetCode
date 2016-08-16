package me.jie;

/**
 * Created by jie on 8/15/16.
 */
public class Leet92 {

    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(head == null || head.next == null || m == n) return head;
            ListNode p1 = head, p2 = head;
            while(m -- > 1){
                p1 = p1.next;
                p2 = p2.next;
                n --;
            }
            //save the preNode before p1
            ListNode pre = head;
            while(pre.next != p1 && pre.next != null) pre = pre.next;

            ListNode tmp = null;
            while(n -- > 0){
                ListNode nextp = p2.next;
                p2.next = tmp;
                tmp = p2;
                p2 = nextp;
            }
            if(p1 != head)  {
                pre.next = tmp;
            }
            else head = tmp;
            p1.next = p2;
            return head;
        }
    }
    private void test(){
        int[] nums =  {1,2,3,4,5};
        ListNode head = null, pos = null;
        for(int i = 0; i < nums.length; i ++){
            if(i == 0){
                head = new ListNode(nums[i]);
                head.next = null;
                pos = head;
            }else{
                pos.next = new ListNode(nums[i]);
                pos = pos.next;
                pos.next = null;
            }
        }
        pos = new Solution().reverseBetween(head,3,5);
        while(pos != null){
            System.out.println(pos.val);
            pos = pos.next;
        }
    }
    public static void main(String[] args) {
        new Leet92().test();
    }
}
