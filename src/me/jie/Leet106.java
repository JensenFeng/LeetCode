package me.jie;

/**
 * Created by jie on 8/5/16.
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

public class Leet106 {
    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(len == 0) return null;
        TreeNode root = buildTree(inorder, 0, len-1, postorder, 0, len-1);
        return root;
    }
    private TreeNode buildTree(int[] inorder,int left, int right, int[] postorder, int begin, int end){
        if(left > right || begin > end){
            return null;
        }
        if(left == right){
            TreeNode node = new TreeNode(inorder[left]);
            return node;
        }
        int val = postorder[end];
        int i;
        for(i = left; i <= right; i ++){
            if(inorder[i] == val){
                break;
            }
        }
        TreeNode node = new TreeNode(inorder[i]);
        node.left = buildTree(inorder, left, i - 1, postorder, begin, begin+(i-1-left));
        node.right = buildTree(inorder, i + 1, right, postorder, end-right+i, end-1);
        return node;
    }

}