package me.jie;

/**
 * Created by jie on 8/31/16.
 */
import java.util.*;
public class Leet116 {
    public class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeLinkNode cur1, cur2;
        int LevCount = 1, nextLev = 0;
        while(!queue.isEmpty()){
            cur1 = queue.poll();
            LevCount --;
            if(cur1.left != null){
                queue.offer(cur1.left);
                nextLev ++;
            }
            if(cur1.right != null){
                queue.offer(cur1.right);
                nextLev ++;
            }
            while(LevCount > 0){
                cur2 = queue.poll();
                cur1.next = cur2;
                cur1 = cur2;
                LevCount --;
                if(cur2.left != null){
                    queue.offer(cur2.left);
                    nextLev ++;
                }
                if(cur2.right != null){
                    queue.offer(cur2.right);
                    nextLev ++;
                }
            }
            cur1.next = null;
            LevCount = nextLev;
            nextLev = 0;
        }
    }

    /*
    https://discuss.leetcode.com/topic/2202/a-simple-accepted-solution
     */
    public void connectdfs(TreeLinkNode root){
        TreeLinkNode cur;
        while(root != null){
            cur = root;
            while(cur != null && cur.left != null){
                cur.left.next = cur.right;
                cur.right.next = cur.next == null? null : cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
    }
}
