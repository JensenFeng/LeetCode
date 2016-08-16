package me.jie;

/**
 * Created by jie on 8/15/16.
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Leet206 {
    public class Solution {
        //iterative
        public ListNode reverseList(ListNode head) {
            ListNode helper = new ListNode(0);
            helper.next = head;
            ListNode pos = head;
            ListNode nextp = head;
            while(pos != null && pos.next != null){
                nextp = pos.next;
                pos.next = nextp.next;
                nextp.next = helper.next;
                helper.next = nextp;
            }
            return helper.next;
        }
        //recursive
        public ListNode reverseListRS(ListNode head){
            if(head == null || head.next == null) return head;
            ListNode nextp = head.next;
            ListNode rev = reverseListRS(nextp);
            head.next.next = head;
            head.next = null;
            return rev;
        }
    }

    private void test(){
        int[] nums =  {1,2,3,5,6,8,9};
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
        pos = new Solution().reverseListRS(head);
        while(pos != null){
            System.out.println(pos.val);
            pos = pos.next;
        }
    }
    public static void main(String[] args){
        new Leet206().test();
    }
}
