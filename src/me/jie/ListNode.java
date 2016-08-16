package me.jie;

/**
 * Created by jie on 8/15/16.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(){}

    public ListNode create(int[] nums){
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
    public void print(ListNode head){
        ListNode pos = head;
        while(pos != null){
            System.out.println(pos.val);
            pos = pos.next;
        }
    }
}
