package me.jie;

import java.util.*;

/**
 * Created by jie on 8/25/16.
 * https://leetcode.com/problems/path-sum/
 */
public class Leet112 {
    class TreeNodeSum {
        TreeNode node;
        int sum;

        TreeNodeSum(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
    public boolean hasPathSumIterative(TreeNode root, int sum){
        if(root == null) return false;
        Queue<TreeNodeSum> queue = new LinkedList<>();
        queue.offer(new TreeNodeSum(root, root.val));
        TreeNodeSum cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            TreeNode node = cur.node;
            if(node.left == null && node.right == null && cur.sum == sum) return true;
            if(node.left != null){
                queue.offer(new TreeNodeSum(node.left, cur.sum + node.left.val));
            }
            if(node.right != null){
                queue.offer(new TreeNodeSum(node.right, cur.sum + node.right.val));
            }
        }
        return false;
    }
    /*
    recursive
     */
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        getSum(root, 0, sum);
        return flag;
    }
    private void getSum(TreeNode root, int cur, int sum){
        if(root == null || flag) return;
        if(root.left == null && root.right == null){
            if(cur + root.val == sum){
                flag = true;
                return;
            }
        }
        getSum(root.left, cur + root.val, sum);
        getSum(root.right, cur + root.val, sum);
    }
}
