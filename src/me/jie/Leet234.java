package me.jie;

/**
 * Created by jie on 8/15/16.
 */
import java.util.*;
public class Leet234 {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    public class Solution {
        /*
        O(n), O(n)
         */
        public boolean isPalindrome(ListNode head) {
            if(head == null) return true;
            ListNode slow, fast;
            slow = head;
            fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow;
            Stack<Integer> stack = new Stack<>();
            slow = head;
            while(slow != mid){
                stack.push(slow.val);
                slow = slow.next;
            }
            if(fast != null){
                stack.push(mid.val);
            }
            while(!stack.empty() && mid != null){
                if(stack.pop() != mid.val) return false;
                mid = mid.next;
            }
            return true;
        }

        /*
         O(n), O(1)
         reverse half list node
         */
        public boolean isPalindromeRV(ListNode head){
            if(head == null) return true;
            ListNode slow = head, fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = head;
            while(mid.next != slow && mid.next != null) mid = mid.next;
            if(fast == null){
                fast = slow;
            }else{
                fast = slow.next;
            }
            mid.next = null;
            //reverse
            ListNode helper = new ListNode(0);
            helper.next = fast;
            ListNode pos;
            while(fast != null && fast.next != null){
                pos = fast.next;
                fast.next = pos.next;
                pos.next = helper.next;
                helper.next = pos;
            }
            slow = head; fast = helper.next;
            while(slow != null && fast != null){
                if(slow.val != fast.val) return false;
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }
    }
    private void test(){
        int[] nums = {1,4,-1,-1,4,1};

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
        System.out.println(new Solution().isPalindromeRV(head));
    }
    public static void main(String[] args){
        new Leet234().test();
    }
}
