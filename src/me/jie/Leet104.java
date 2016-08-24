package me.jie;

/**
 * Created by jie on 8/24/16.
 */
import java.util.*;

public class Leet104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /*
    iterative
     */
    private class TreeNodeLevel{
        TreeNode node;
        int level;
        TreeNodeLevel(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    private int maxDep(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeLevel(root, 1));
        TreeNodeLevel cur;
        int ans = 0;
        while(!queue.isEmpty()){
            cur = queue.poll();
            ans = Math.max(ans, cur.level);
            if(cur.node.left != null){
                queue.add(new TreeNodeLevel(cur.node.left, cur.level + 1));
            }
            if(cur.node.right != null){
                queue.add(new TreeNodeLevel(cur.node.right, cur.level + 1));
            }
        }
        return ans;
    }
}
