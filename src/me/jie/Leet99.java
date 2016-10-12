package me.jie;

/**
 * Created by jie on 9/18/16.
 */
import java.util.*;
public class Leet99 {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        travel(root);
        int tmp = firstEle.val;
        firstEle.val = secondEle.val;
        secondEle.val = tmp;
    }
    private TreeNode firstEle = null, secondEle = null;
    private TreeNode preEle = new TreeNode(Integer.MIN_VALUE);
    private void travel(TreeNode root){
        if(root == null) return;
        travel(root.left);

        if(firstEle == null && preEle.val >= root.val){
            firstEle = preEle;
        }
        if(firstEle != null && preEle.val >= root.val){
            secondEle = root;
        }
        preEle = root;

        travel(root.right);
    }
    /*
    https://discuss.leetcode.com/topic/9305/detail-explain-about-how-morris-traversal-finds-two-incorrect-pointer
     */
    public void recoverTreeMorris(TreeNode root){

    }
    private void inorderTraversal(TreeNode root){
        TreeNode cur = root, pre = null;
        TreeNode prep = null;
        TreeNode first = null, second = null;
        while(cur != null){
            if(cur.left == null){
                if(prep != null && prep.val > cur.val){
                    if(first == null) first = prep;
                    second = cur;
                }
                prep = cur;
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    if(prep != null && prep.val > cur.val){
                        if(first == null) first = prep;
                        second = cur;
                    }
                    prep = cur;

                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        if(first != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
