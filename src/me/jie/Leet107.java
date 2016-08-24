package me.jie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jie on 8/24/16.
 */
public class Leet107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> rst = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode pos;
        int curLevel = 1;
        int nextLevel = 0;
        List<Integer> lt = new ArrayList<>();
        while(!queue.isEmpty()){
            pos = queue.poll();
            lt.add(pos.val);
            curLevel --;
            if(pos.left != null){
                queue.add(pos.left);
                nextLevel ++;
            }
            if(pos.right != null){
                queue.add(pos.right);
                nextLevel ++;
            }
            if(curLevel == 0){
                rst.add(0, new ArrayList<>(lt));
                lt = new ArrayList<>();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return rst;
    }
}
