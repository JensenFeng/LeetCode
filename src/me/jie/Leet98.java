package me.jie;

/**
 * Created by jie on 8/4/16.
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
import java.util.*;

public class Leet98 {
    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> rst = new ArrayList<>();
        inOrderTravel(root, rst);
        for(int i = 0 ; i < rst.size()-1; i ++){
            if(rst.get(i) >= rst.get(i+1)){
                return false;
            }
        }
        return true;
    }
    //iterative
    private void InOrderTravel(TreeNode root, List<Integer> node){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> hash = new HashSet<>(); //mark
        stack.push(root);
        hash.add(root);

        TreeNode pos;
        while(!stack.empty()){
            pos = stack.peek();
            while(pos.left != null && !hash.contains(pos.left)){
                stack.push(pos.left);
                hash.add(pos.left);
                pos = pos.left;
            }
            node.add(pos.val);
            stack.pop();
            if(pos.right != null){
                stack.push(pos.right);
                hash.add(pos.right);
            }
        }

    }
    //recursive
    private void inOrderTravel(TreeNode root, List<Integer> node){
        if(root == null){
            return;
        }
        inOrderTravel(root.left, node);
        node.add(root.val);
        inOrderTravel(root.right, node);
    }

    //more better
    private boolean isValidBST(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if(min != null && root.val <= min || max != null && root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
