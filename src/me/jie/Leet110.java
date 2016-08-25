package me.jie;

/**
 * Created by jie on 8/25/16.
 */
import java.util.*;

public class Leet110 {
    /*
    bad
     */
    public boolean isBalancedB(TreeNode root) {
        if(root == null) return true;
        Map<TreeNode, Integer> mp = new HashMap<>();
        getHeight(root, mp);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            int left = 0, right = 0;
            if(cur.left != null){
                left = mp.get(cur.left);
                queue.offer(cur.left);
            }
            if(cur.right != null){
                right = mp.get(cur.right);
                queue.offer(cur.right);
            }
            if(Math.abs(left-right) > 1) return false;
        }
        return true;
    }
    public int getHeight(TreeNode root, Map<TreeNode, Integer> mp) {
        if (root == null) return 0;
        if(mp.containsKey(root)) return mp.get(root);
        int left = getHeight(root.left, mp);
        int right = getHeight(root.right, mp);
        int t = Math.max(left, right);
        mp.put(root, t + 1);
        return t + 1;
    }

    public boolean isBalanced(TreeNode root){
        return getHeight2(root) != -1;
    }
    private int getHeight2(TreeNode root){
        if(root == null) return 0;
        int left = getHeight2(root.left);
        if(left == -1) return -1;
        int right = getHeight2(root.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1 ) return -1;
        return Math.max(left, right) + 1;
    }
}
