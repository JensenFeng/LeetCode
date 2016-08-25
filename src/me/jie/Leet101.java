package me.jie;

/**
 * Created by jie on 8/25/16.
 */
import java.util.*;
public class Leet101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> lt = new ArrayList<>();
        queue.offer(root);
        TreeNode cur;
        int curLevel = 1;
        int nextLevel = 0;
        boolean first = true;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur != null) lt.add(cur.val);
            else lt.add(-1);
            curLevel --;
            if(cur != null){
                queue.offer(cur.left);
                nextLevel ++;
            }
            if(cur != null){
                queue.offer(cur.right);
                nextLevel ++;
            }
            if(curLevel == 0){
                if(!first){
                    int len = lt.size();
                    if(len % 2 != 0) return false;
                    for(int i = 0, j = len - 1; i < j; i ++, j --){
                        if(!lt.get(i).equals(lt.get(j))) return false;
                    }
                }else{
                    first = false;
                }
                curLevel = nextLevel;
                nextLevel = 0;
                lt = new ArrayList<>();
            }
        }
        return true;
    }

    /*
    recursive
     */
    public boolean isSymmetricR(TreeNode root){
        if(root == null) return true;

        return LevelOrderTravesal(root.left, root.right);
    }
    private boolean LevelOrderTravesal(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return LevelOrderTravesal(root1.left, root2.right) && LevelOrderTravesal(root1.right, root2.left);
    }
}

