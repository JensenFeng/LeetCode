package me.jie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jie on 8/10/16.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(){}

    protected TreeNode create(int[] n){
        if(n.length == 0) return null;
        TreeNode root = new TreeNode(n[0]);
        root.left  = null;
        root.right = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 1; i < n.length && !queue.isEmpty(); i += 2){
            TreeNode p = queue.poll();

            TreeNode left = new TreeNode(n[i]);
            left.left = null;left.right = null;
            TreeNode right = null;
            if(i+1 < n.length) {
                right = new TreeNode(n[i + 1]);
                right.left = null;
                right.right = null;
            }
            p.left = left;
            p.right = right;
            queue.offer(left);
            queue.offer(right);
        }
        return root;
    }
    protected void preOrder(TreeNode root){
        if(root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    protected void inOrderPrint(TreeNode root){
        if(root == null)return;
        
        inOrderPrint(root.left);
        System.out.println(root.val);
        inOrderPrint(root.right);
    }
}