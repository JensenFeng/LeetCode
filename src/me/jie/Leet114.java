package me.jie;

/**
 * Created by jie on 8/5/16.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Leet114 {
    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        flat(root);
    }

    private TreeNode flat(TreeNode root){
        if(root == null ) return root;
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
}
