package me.jie;

/**
 * Created by jie on 8/24/16.
 */
import java.util.*;

public class Leet144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        TreeNode cur;
        while(!stk.isEmpty()){
            cur = stk.pop();
            rst.add(cur.val);

            if(cur.right != null){
                stk.push(cur.right);
            }
            if(cur.left != null){
                stk.push(cur.left);
            }
        }
        return rst;
    }
    public List<Integer> preorderTraver(TreeNode root){
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stk.isEmpty()){
            if(cur != null){
                rst.add(cur.val);
                stk.push(cur.right);
                cur = cur.left;
            }else{
                cur = stk.pop();
            }
        }
        return rst;
    }
}
