package me.jie;

/**
 * Created by jie on 9/19/16.
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
import java.util.*;
public class Leet199 {
    public List<Integer> rightSideViewR(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        int curLevel = 1;
        int nextLevel = 0;
        while(!queue.isEmpty()){
            cur = queue.poll();
            curLevel --;
            if(cur.left != null){
                queue.offer(cur.left);
                nextLevel ++;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                nextLevel ++;
            }
            if(curLevel == 0){
                rst.add(cur.val);
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return rst;
    }

    public List<Integer> rightSideView(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> rst = new ArrayList<>();
        dfs(rst, root, 0);
        return rst;
    }
    private void dfs(List<Integer> rst, TreeNode root, int level){
        if(root == null) return;
        if(rst.size() == level){
            rst.add(root.val);
        }
        dfs(rst, root.right, level + 1);
        dfs(rst, root.left, level + 1);
    }
}
