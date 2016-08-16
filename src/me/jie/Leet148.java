package me.jie;

/**
 * Created by jie on 8/15/16.
 * https://leetcode.com/problems/sort-list/
 */
public class Leet148 {
    /*
      TLE: O(n^2)
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pos = head;
        while(pos.next != null){
            ListNode tmp = pos.next, minp = pos;
            while(tmp != null){
                if(tmp.val < minp.val){
                    minp = tmp;
                }
                tmp = tmp.next;
            }
            int t = pos.val;
            pos.val = minp.val;
            minp.val = t;
            pos = pos.next;
        }
        return head;
    }

    /*
      O(nlg(n)), O(n)
     */
    public ListNode QsortList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = QsortList(slow.next);
        slow.next = null;
        return mergeList(QsortList(head), second);
    }
    private ListNode mergeList(ListNode first, ListNode second){
        ListNode helper = new ListNode(0);
        helper.next = null;
        ListNode p = helper;
        while(first != null && second != null){
            if(first.val <= second.val){
                p.next = first;
                first = first.next;
            }else{
                p.next = second;
                second = second.next;
            }
            p = p.next;
        }
        if(first != null){
            p.next = first;
        }
        if(second != null){
            p.next = second;
        }
        return helper.next;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,5,6,0};

        ListNode t = new ListNode();
        ListNode head = t.create(nums);
        head = new Leet148().sortList(head);
        t.print(head);

    }
}
