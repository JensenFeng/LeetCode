package me.jie;

import java.util.*;

/**
 * Created by jie on 8/5/16.
 */
public class Leet105 {
    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    Map<Integer, Integer> mp;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len == 0) return null;
        mp = new HashMap<>();
        for(int i = 0; i < len; i ++){
            mp.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, inorder, 0, len-1, 0, len-1);
        return root;
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int left, int right, int begin, int end){
        if(left > right || begin > end) return null;
        int pos = mp.get(preorder[left]);
        TreeNode node = new TreeNode(preorder[left]);
        node.left = buildTree(preorder, inorder, left+1, left+1+(pos-1-begin), begin, pos-1);
        node.right = buildTree(preorder, inorder, right - (end - pos - 1), right, pos + 1, end);
        return node;
    }
    //iterative, no recursive
    public TreeNode buildTree(int[] preorder, int[] inorder, boolean f){
        if(preorder.length == 0) return null;
        int len = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int index = 0;
        for(int i = 1; i < len; i ++){
            TreeNode curr = stack.peek();
            if(curr.val != inorder[index]){
                TreeNode node = new TreeNode(preorder[i]);
                curr.left = node;
                stack.push(node);
            }else{
                while(!stack.empty() && (stack.peek().val == inorder[index])){
                    curr = stack.pop();
                    index++;
                }
                if(index < len){
                    TreeNode node = new TreeNode(preorder[i]);
                    curr.right = node;
                    stack.push(node);
                }
            }
        }
        return root;
    }
}
