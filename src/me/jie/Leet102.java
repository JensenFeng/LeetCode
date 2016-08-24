package me.jie;

/**
 * Created by jie on 8/24/16.
 */
import java.util.*;

public class Leet102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
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
                rst.add(new ArrayList<>(lt));
                lt = new ArrayList<>();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return rst;
    }
}
