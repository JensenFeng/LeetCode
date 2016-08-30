package me.jie;

/**
 * Created by jie on 8/5/16.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
import java.util.*;
public class Leet114 {

    public void flatten(TreeNode root) {
        flat(root);
    }

    private TreeNode flat(TreeNode root){
        if(root == null ) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        TreeNode lastLeft = left;
        if(left != null) {
            while (lastLeft.right != null) {
                lastLeft = lastLeft.right;
            }
            lastLeft.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
    }
    /*
    iterative: better way:https://discuss.leetcode.com/topic/14481/8ms-non-recursive-no-stack-c-solution
     */
    public void flattenTwo(TreeNode root){
        if(root == null)  return;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        TreeNode cur;
        while(!stk.isEmpty()){
            cur = stk.pop();
            queue.offer(cur);
            if(cur.right != null){
                stk.add(cur.right);
            }
            if(cur.left != null){
                stk.add(cur.left);
            }
        }
        TreeNode pre = queue.poll();
        while(!queue.isEmpty()){
            pre.left = null;
            pre.right = queue.peek();
            pre = queue.poll();
        }
        pre.left = null;
        pre.right = null;
    }

    /*more better
    https://discuss.leetcode.com/topic/11444/my-short-post-order-traversal-java-solution-for-share
     */
}
