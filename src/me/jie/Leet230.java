package me.jie;

/**
 * Created by jie on 8/31/16.
 */
import java.util.*;

public class Leet230 {
    /*
    better solution:
    https://discuss.leetcode.com/topic/17810/3-ways-implemented-in-java-binary-search-in-order-iterative-recursive
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();

        TreeNode cur = root;
        while(cur != null){
            stk.push(cur);
            cur = cur.left;
        }
        while(k != 0){
            cur = stk.pop();
            k --;
            if(k == 0) return cur.val;
            cur = cur.right;
            while(cur != null){
                stk.push(cur);
                cur = cur.left;
            }
        }
        return 0;
    }
}
