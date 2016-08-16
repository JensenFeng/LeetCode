package me.jie;

/**
 * Created by jie on 8/15/16.
 */
public class Leet21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(0);
        helper.next = null;
        ListNode pos = helper;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pos.next = l1;
                l1 = l1.next;
            }else{
                pos.next = l2;
                l2 = l2.next;
            }
            pos = pos.next;
        }
        if(l1 != null){
            pos.next = l1;
        }
        if(l2 != null){
            pos.next = l2;
        }
        return helper.next;
    }
    private ListNode test(int[] nums){
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
        return head;
    }
    public static void main(String[] args){
        int[] n1 = {3};
        int[] n2 = {2, 4, 6, 9};
        ListNode l1 = new Leet21().test(n1);
        ListNode l2 = new Leet21().test(n2);
        ListNode pos = new Leet21().mergeTwoLists(l1, l2);
        while(pos != null){
            System.out.println(pos.val);
            pos = pos.next;
        }
    }
}
