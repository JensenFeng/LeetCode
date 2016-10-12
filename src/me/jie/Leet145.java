package me.jie;

/**
 * Created by jie on 7/26/16.
 */
import java.util.*;
public class Leet145 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public List<Integer> postOrderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> containsNode = new HashSet<>();
        stack.add(root);
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(!containsNode.contains(node)){
                containsNode.add(node);
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }else{
                System.out.println(node.val);
                rst.add(node.val);
                stack.pop();
            }
        }
        return rst;
    }
    public List<Integer> postOrderTrav(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode last_pop = root;
        while(!stack.empty()){
            TreeNode node = stack.peek();
            if(node.left != null && node.right != last_pop && node.left != last_pop){
                stack.push(node.left);
            }else if(node.right != null && node.right != last_pop && (node.left == null || node.left == last_pop)){
                stack.push(node.right);
            }else{
                stack.pop();
                last_pop = node;
                rst.add(node.val);
            }
        }
        return rst;
    }

    public List<Integer> postorderTraversal(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        Set<TreeNode> st = new HashSet<>();
        TreeNode cur;
        while(!stk.isEmpty()){
            cur = stk.peek();
            if (st.contains(cur)) {
                rst.add(cur.val);
                stk.pop();
            } else{
                if(cur.right == null && cur.left == null){
                    rst.add(cur.val);
                    stk.pop();
                }else {
                    if(cur.right != null){
                        stk.push(cur.right);
                    }
                    if(cur.left != null){
                        stk.push(cur.left);
                    }
                }
                st.add(cur);
            }
        }
        return rst;
    }
}
