package me.jie;

/**
 * Created by jie on 8/21/16.
 */
import java.util.*;

public class Leet94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        set.add(root);
        TreeNode tmp;
        while(!stk.isEmpty()){
            tmp = stk.pop();
            //System.out.println(tmp.val);
            if (tmp.right != null && !set.contains(tmp.right)) {
                stk.push(tmp.right);
                set.add(tmp.right);
            }
            stk.push(tmp);
            if (tmp.left != null && !set.contains(tmp.left)) {
                stk.push(tmp.left);
                set.add(tmp.left);
            }else{
                rst.add(tmp.val);
                stk.pop();
            }
        }
        return rst;
    }

    /*
    nice solution: move pointer like list
     */
    public List<Integer> inorderTrav(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        while(node != null || !stk.isEmpty()){
            while(node != null){
                stk.push(node);
                node = node.left;
            }
            node = stk.pop();
            rst.add(node.val);
            node = node.right;
        }
        return rst;
    }
}