package me.jie;

/**
 * Created by jie on 8/5/16.
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

public class Leet106 {
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

    public TreeNode buildTreeTwo(int[] inorder, int[] postorder){
        if(inorder.length == 0) return null;
        TreeNode root = null;
        if(inorder.length == 1) {
            root = new TreeNode(inorder[0]);
            return root;
        }
        int len = inorder.length;

        int val = postorder[len-1];
        root = new TreeNode(val);
        int i, pos;
        for(i = 0; i < len; i ++){
            if(inorder[i] == val) break;
        }
        int left = i, right = len - i - 1;
        pos = i;
        //clone arr
        int[] larr1 = new int[left];
        int[] larr2 = new int[left];
        for(i = 0; i < left; i ++){
            larr1[i] = inorder[i];
            larr2[i] = postorder[i];
        }
        int[] rarr1 = new int[right];
        int[] rarr2 = new int[right];
        for(i = 0; i < right; i ++){
            rarr1[i] = inorder[pos + 1 + i];
            rarr2[i] = postorder[pos + i];
        }
        root.left = buildTreeTwo(larr1, larr2);
        root.right = buildTreeTwo(rarr1, rarr2);
        return root;
    }
}