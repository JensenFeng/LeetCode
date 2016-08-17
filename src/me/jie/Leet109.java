package me.jie;

/**
 * Created by jie on 8/17/16.
 */
public class Leet109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null){
            TreeNode root = new TreeNode(head.val);
            root.left = null;
            root.right= null;
            return root;
        }
        ListNode slow = head, fast = head.next, pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        if(pre != null)
            pre.next = null;
        else head = null;

        TreeNode root = new TreeNode(slow.val);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(fast);

        root.left = left;
        root.right = right;
        return root;
    }
    public static void main(String[] args){
        int[] n = {1,2,3};
        ListNode head = new ListNode().create(n);
        TreeNode root = new Leet109().sortedListToBST(head);
        new TreeNode().inOrderPrint(root);
    }
}
