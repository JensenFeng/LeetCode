package me.jie;

/**
 * Created by jie on 8/15/16.
 */
public class Leet19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode slow = helper, fast = helper;
        while(n-- > 0 && fast.next != null){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return helper.next;
    }

    private void test(){
        int[] nums =  {1,2,3};
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
        pos = removeNthFromEnd(head,3);
        while(pos != null){
            System.out.println(pos.val);
            pos = pos.next;
        }
    }
    public static void main(String[] args){
        new Leet19().test();
    }
}
